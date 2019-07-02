%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% LoRa Simulator                     %
% Sakshama Ghoslya                   %
% Research Assistant, IIT Hyderabad  %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%
clear all; close all; clc;

%% Cockpit of the simulator

SF = 10;                     % Spreading Factor from 7 to 12 
BW = 125000;                 % 125kHz
Fs = 125000;                 % Sampling Frequency
preamble_len = 8;            % Preamble length
sync_len = 2;                % Sync length
total_sym = 10;              % total symbols excluding preamble and sync from 1:100
SNR_dB = 20:1:21;             % SNR in DB
SNR = 10.^(SNR_dB/10);       % SNR
BER = zeros(1,length(SNR_dB));
num_samples = Fs*(2^SF)/BW;  % Number of samples
                             % 100 symbols to test the simulation :: choose 'total_sym'
symbols = [5,100,500,555,1000,200,300,567,100,50,400,222,666,444,777,555,111,999,525,455,345,456,34,678,234,672,123,67,382,588,200,300,1000,100,...
           50,400,222,666,444,777,555,111,999,525,455,345,456,34,678,234,500,400,600,800,700,200,300,1000,100,50,400,222,666,444,777,555,111,999,...
           525,455,345,456,34,678,234,672,123,67,382,588,200,300,1000,100,50,400,222,666,444,777,555,111,999,525,455,345,456,34,678,234];
       
lora_total_sym = preamble_len + sync_len + total_sym; % Total transmitted symbols


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
for i = 1:total_sym
    [out_sym] = LoRa_Modulation(SF,BW,Fs,num_samples,symbols(i),inverse);
    outp = [outp out_sym];
end

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
         data_received(k) = c-1;
         k = k+1;
    end

end
%% Plotting 

% Plotting the Spectrogram of Transmitted signal
figure(1);
samples = num_samples/8;
title('Transmitted LoRa symbols');
spectrogram(outp,samples,samples-1,samples*2,Fs,'yaxis');

% Plotting the Spectrogram of Transmitted signal
figure(2);
samples = num_samples/4;
title('Decoded LoRa symbols');
spectrogram(decoded_out,samples,samples-1,samples,Fs,'yaxis');

% Plotting the received frequencies
figure(3);
samp_time = 0:1:num_samples-1;
title('FFT of received LoRa symbols');
for m = 1:1:lora_total_sym
    plot(samp_time,FFT_out(m,:)); hold on;
end
grid on;
