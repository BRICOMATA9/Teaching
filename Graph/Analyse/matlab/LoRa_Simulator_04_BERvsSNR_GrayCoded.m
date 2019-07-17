%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% LoRa Simulator                     %
% Sakshama Ghoslya                   %
% Research Assistant, IIT Hyderabad  %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%
clear all; close all; clc;

%% Cockpit of the simulator

SF = 8;                      % Spreading Factor from 7 to 12 
BW = 125000;                 % 125kHz
Fs = 125000;                 % Sampling Frequency
preamble_len = 8;            % Preamble length
sync_len = 2;                % Sync length
total_bits = SF*10;          % total bits to be transmitted in LoRa message
SNR_dB = -40:1:00;           % SNR in DB
SNR = 10.^(SNR_dB/10);       % SNR
Total_iterations = 500;
BER = zeros(Total_iterations,length(SNR_dB));

num_samples = Fs*(2^SF)/BW;  % Number of samples

   

%% Random Number Generation
[Input_sample_Bi, input_len] = LoRa_random_number_generation(total_bits,SF); 

rand_num_matrix = reshape(Input_sample_Bi, SF, input_len);

% Binary to Gray Conversion
Input_sample_gray = binary2gray(rand_num_matrix);

% Binary to Decimal conversion
Input_sample = bi2de(Input_sample_gray','left-msb')';

lora_total_sym = preamble_len + sync_len + input_len;  % Total transmitted symbols


%% Preamble Generation
inverse = 0;
for i = 1:preamble_len
    [out_preamble] = LoRa_Modulation(SF,BW,Fs,num_samples,0,inverse);
    outp((i-1)*num_samples+1 : i*num_samples) = out_preamble;
end

%% Sync Symble Generation
inverse = 1;
for i = 1:sync_len
    [out_sync] = LoRa_Modulation(SF,BW,Fs,num_samples,32,inverse);
    outp = [outp out_sync];
end

%% Symble Generation
inverse = 0;
for i = 1:input_len
    [out_sym] = LoRa_Modulation(SF,BW,Fs,num_samples,Input_sample(i),inverse);
    outp = [outp out_sym];
end

for ite = 1:1:Total_iterations
    
        for snr = 1:1:length(SNR_dB)
            %% AWGN Channel
            out_channel = awgn(outp,SNR_dB(snr),'measured');

            %% Reverse chirp generation for receiver
            inverse = 1;
            [out_reverse] = LoRa_Modulation(SF,BW,Fs,num_samples,0,inverse);
            % Multiplying with the reverse chirp 
            for n = 1:1:lora_total_sym
                decoded_out((n-1)*num_samples + 1 : n*num_samples) = (out_channel((n-1)*num_samples + 1 : n*num_samples).*out_reverse);
            end

            %% Calculating FFT
            for m = 1:1:lora_total_sym
                FFT_out(m,:) = abs((fft(decoded_out((m-1)*num_samples + 1 : m*num_samples))));
            end

            %% Decoding the received data
            k=1;
            for m = preamble_len+sync_len+1:1:lora_total_sym
                [r,c] = max(FFT_out(m,:));
                data_received_De(k) = c-1;
                k = k+1;
            end
    
            % Decimal to Binary Conversion
            data_received_bin = de2bi(data_received_De,SF,'left-msb')';
            % Gray to Binary Conversion
            data_received_gray = gray2binary(data_received_bin);
            % Matrix to array conversion
            data_received = reshape(data_received_gray,total_bits,1);
            
            
    
            %% BER Calculation
            BER(ite,snr) = sum(abs(data_received - Input_sample_Bi))/total_bits;
        end
        
end

Avg_BER = mean(BER);   % Average BER over all the iterations

%% Plotting 
% Plotting the BER vs SNR curve
semilogy(SNR_dB,Avg_BER,'-*b');
title('BER vs SNR');
xlabel('SNR (Signal to Noise ratio in dB)');
ylabel('BER (Bit Error Rate)');
grid on;
