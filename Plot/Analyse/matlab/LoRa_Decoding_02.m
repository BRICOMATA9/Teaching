%%
% Decoding LoRa
%%

clear all; close all; clc;

SF = 8;  % Spreading Factor
BW = 125000; %125kHz
Fs = 4*125000;
num_samples = Fs*(2^SF)/BW/2;


%Preamble Generation
inverse = 0;
preamble_len = 1;
for i = 1:preamble_len
    [out_preamble] = LoRa_Modulation(SF,BW,Fs,num_samples,0,inverse);
    outp((i-1)*num_samples+1 : i*num_samples) = out_preamble;
end

%Sync Symble Generation
inverse = 1;
sync_len = 0;
for i = 1:sync_len
    [out_sync] = LoRa_Modulation(SF,BW,Fs,num_samples,32,inverse);
    outp = [outp out_sync];
end

%Symble Generation
inverse = 0;
total_sym = 1;
symbols = [150,32,80,320,640,200,300,567,100,50,400,222,666,444,777,555,111,999,525,455,345,456,34,678,234,672,123,67,382,588,200,300,1000,100,...
           50,400,222,666,444,777,555,111,999,525,455,345,456,34,678,234,500,400,600,800,700,200,300,1000,100,50,400,222,666,444,777,555,111,999,...
           525,455,345,456,34,678,234,672,123,67,382,588,200,300,1000,100,50,400,222,666,444,777,555,111,999,525,455,345,456,34,678,234];
for i = 1:total_sym
    [out_sym] = LoRa_Modulation(SF,BW,Fs,num_samples,symbols(i),inverse);
    outp = [outp out_sym];
end


% Reverse chirp generation
inverse = 1;
[out_reverse] = LoRa_Modulation(SF,BW,Fs,num_samples,0,inverse);

% Multiplying with the reverse chirp 
for n = 1:2
    decoded_out((n-1)*num_samples + 1 : n*num_samples) = (outp((n-1)*num_samples + 1 : n*num_samples).*out_reverse);
end

% Calculation the FFT

samp_time = 0:1:2*num_samples-1;
plot(samp_time,outp);

k=1;
for m = 1:1:2
    FFT_out(m,:) = abs((fft(decoded_out((m-1)*num_samples + 1 : m*num_samples))));

    %plot(samp_time,FFT_out); hold on;
end

samples = num_samples/4;
%spectrogram(decoded_out,samples,samples-1,samples,Fs,'yaxis');
title('LoRa Symble Decoding [8 preamble, 2 Sync, 15 Symbols]');
grid on;

