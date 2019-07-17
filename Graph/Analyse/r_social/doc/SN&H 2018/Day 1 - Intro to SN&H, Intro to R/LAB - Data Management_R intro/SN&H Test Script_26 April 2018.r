#Social Networks and Health Test Script
#Jonathan H. Morgan and Brian Aaronson
#26 April 2018

#The purpose of this script is to verify that you have the priveleges and packages necessary to fully participate in the SN&H Labs.

###############################
#   LOADING NEEDED PACKAGES   #
###############################

#Installing any packages you do not already have that you will need for the labs.
list.of.packages <- c("statnet", "igraph", "RSiena", "EpiModel", "netdiffuseR", "sna", "ergm", "coda", "lattice", "plyr", "dplyr", "tidyr", "magrittr",
                      "mosaic", "tidyverse", "ggplot2", "ggnetwork", "visNetwork", "GGally", "ggraph", "networkD3", "ndtv", "amen", "knitr")

new.packages <- list.of.packages[!(list.of.packages %in% installed.packages()[,"Package"])]
if(length(new.packages)) install.packages(new.packages)

#####################################
#   PERFORMING THE DIAGNOSTIC TEST  #
#####################################

#Loading statnet to conduct the test
library("statnet")

#Loading the Florentine Families data set
data(flo) 

#Creating a network
nflo<-network(flo,directed=FALSE) 

#Visualizing the data to confirm I have successfully completed the test.
gplot(nflo)

#########################
#   ASSESSING RESULTS   #
#########################

#If you see a network in the plots window, this test has been successful.

#If not, copy and paste the log in the console screen and send it SN&H staff member: snhtrain@soc.duke.edu 
#We can, then, help you identify the problem and resolve it.