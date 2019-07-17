%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                                          %
% Author : Sakshama Ghoslya                %
%          IIT Hyderabad, Hyderabad, India %
% Email  : sakshama.ghosliya@gmail.com     %
%                                          %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


clear all; close all; clc;

SF = 8;  % Spreading Factor
BW = 125000; %125kHz
Fs = (10^6);
num_samples = Fs*(2^SF)/BW;


%Preamble Generation
inverse = 0;
preamble_len = 8;
for i = 1:preamble_len
    [out_preamble] = LoRa_Modulation(SF,BW,Fs,num_samples,0,inverse);
    outp((i-1)*num_samples+1 : i*num_samples) = out_preamble;
end

%Sync Symble Generation
inverse = 1;
sync_len = 2;
for i = 1:sync_len
    [out_sync] = LoRa_Modulation(SF,BW,Fs,num_samples,32,inverse);
    outp = [outp out_sync];
end

%Symble Generation
inverse = 0;
total_sym = 5;
symbols = [1,11,123,13,55];
for i = 1:total_sym
    [out_sym] = LoRa_Modulation(SF,BW,Fs,num_samples,symbols(i),inverse);
    outp = [outp out_sym];
end
%}
samp_fft = Fs*(-num_samples/2 : num_samples/2-1)/num_samples;
samp_time = 1:1:num_samples*15;

for m = 1:15 
    FFT_out((m-1)*num_samples + 1 : m*num_samples) = abs(fftshift(fft(outp((m-1)*num_samples + 1 : m*num_samples))));
end
samples = num_samples/8;
%spectrogram(outp,samples,samples-1,samples*2,Fs,'yaxis');
title('LoRa Symbles [8 preamble, 2 Sync, 5 Symbols]');
plot(samp_time,FFT_out);
grid on;

