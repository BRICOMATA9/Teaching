#!/bin/bash
for a in *.dat ; do 
  mv "$a" "${a%.dat}".jpg
done
