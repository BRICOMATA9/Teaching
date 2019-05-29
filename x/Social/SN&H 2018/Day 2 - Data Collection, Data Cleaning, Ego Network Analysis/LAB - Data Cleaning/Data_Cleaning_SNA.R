###########################################################
#    ************************************************     #
#    Social Networks and Health Training Program 2018     #
#    ************************************************     #
###########################################################

#**************************************************************************#                            
#From Raw Data to Network Objects: Data Cleaning for Social Network Analysis
#**************************************************************************#

#Author: Maria Cristina Ramos - Duke University

##################################################################
# INTRODUCTION: DATA CLEANING FOR SOCIAL NETWORKS ANALYSIS (SNA) # 
##################################################################

#Start by clearing old data
rm(list = ls())

#Running a command line in R: place cursor in line and ctrl+enter (non MAC), cmd+enter(MAC) no need to highlight. You will move to next line of code.
#If you do not want to move down a line alt+enter
#If you want to execute just a piece of the line, highlight only that piece
#and ctrl+enter
#use # for commenting
#to comment more than one line at a time, highlight the code, ctrl+shift+C at #the same time.

#Data cleaning for SNA: planning and executing a series of tasks 
#that transform raw data into objects that SNA tools will be able 
#to analyze. 

#Statnet and igraph are commonly used network analysis tools for R.  
#SNA using statnet or igraph often starts with the creation of a
#network object from scratch. 

#NOTE: statnet and igraph are incompatible. You cannot use both statnet and 
#igraph at the same time. If you want to use both of them, you have to do it 
#sequentially. Unload one so that you can load the other.
#to unload them use detach(package:statnet) or detach(package:igraph) 

#This tutorial uses statnet. The data cleaning process is essentially the 
#same for both statnet and igraph. 
#IMPORTANT: load statnet library(statnet) only once you are ready 
#to construct a network object. Otherwise it will mess up with some
#data inspection functions.

#To create a network object with statnet, we need our data to be
#in a certain format. 

#There are four possible formats from which statnet can construct a 
#network:

# - Adjacency matrix
m <- matrix(rbinom(25,1,0.5),5,5)
colnames(m) <- c("Jim", "Molly", "Liann", "Jo", "Jaemin")
rownames(m) <- colnames(m)
diag(m) <- 0
m

# - Edgelist 
elData<-data.frame(
  from_id=c("1","2","3","1","3","1","2"),
  to_id=c("1", "1", "1", "2", "2", "3", "3"),
  myEdgeWeight=c(1, 2, 1, 2, 5, 3, 9.5),
  stringsAsFactors=FALSE
)
elData

# - Incidence matrix
inci<-matrix(c(1,1,0,0, 0,1,1,0, 1,0,1,0),ncol=3,byrow=FALSE)
rownames(inci) <- c("Jim", "Molly","Dana", "Liann")
colnames(inci) <- c("e1", "e2","e3")
inci

# - Bipartite network
m <- matrix(rbinom(25,1,0.5),5,5)
rownames(m) <- c("Jim", "Molly", "Liann", "Jo", "Jaemin")
colnames(m) <- c("Baseball club", "Chorus", "Volunteering", "Debate club", "Writing group")
diag(m) <- 0
m

#plus list of nodes with attributes (features such as gender, race, etc.)

#This workshop outlines a series of systematic steps to reduce the 
#uncertainty that often comes with working with R and make the 
#process easier! 

#From paralyzed to deliberate!

################
# THE PROCESS  # 
################

#1. Inspect/Evaluate Raw Data
#2. Make a Plan
#3. Construct Network Object
#4. Check your Work 

###########################################
#   PHASE 1: INSPECT/EVALUATE YOUR DATA   #
###########################################

# Goal: identify your data manipulation needs.

# a) Identify useful bits for network objects 
#   - What pieces will be the node ids?
#   - What pieces can be node attributes?
#   - What pieces will be the edges?
#   - What pieces can be edge attributes?   

# b) Identify issues we have to deal with  
#   - Issues at the observation level
#        -Extreme, nonsensical, and/or missing values. 
#   - Issues at the structure level
#        - Unnecesary columns: columns that do not contain useful info for 
#          our analysis.
#        - Preview rows (Qualtrics): apparent responses that are actually
#          you testing the survey. 
#        - Rows/columns in the wrong format: columns that should be rows,
#          rows that should be columns. Columns that should be combined, etc.      

# TIP: Don't start manipulating (moving, joining, etc.) anything until you 
# took a good look at your data. Get a good sense of what you have first.                 
#In the long run, it will be more efficient.

###########################################
#         PHASE 2: MAKE A PLAN            #
###########################################

#   Goal: come up with a task or series of tasks to solve each issue. No code
#   involved yet, just your plan. This will make the subsequent coding tasks
#   way easier.

# a) Plan changes at the observation level
#     - Remove missing values? Impute missing values? Recode? 
#       This decision depends on the source of the problem (e.g. a coding 
#       error versus a truly extreme value).

# b) Plan tasks for restructuring the dataset 
#     - First we need to choose the type of input structure for 
#        network objects:
#           - Adjacency matrix
#           - Edgelist 
#           - Incidence Matrix
#           - Bipartite Network
#           - + Nodelist

#     - Then, describe series of tasks to restructure your current 
#       dataset into the network object input (your roadmap) 

###########################################
#   PHASE 3: CONSTRUCT NETWORK OBJECT     #
###########################################

# Goal: Implement your plan

# You implement your plan by finding a function that will 
# do one or more of the tasks in your plan. 

# KEY: Having ALREADY identified the type of object/data 
# you need to manipulate and what task you want to do with 
# it will make it easy to find a suitable function for your tasks. 

#For example, I want to combine columns. Object: columns; task: combine 
#Having identified these I can now google for a function that combines columns.
#I can now go look in a package created to manipulate columns.
#Before I was just paralized not knowing what to do.               

# There are packages for specific types of objects/data 
# (e.g. stringr for strings, tidyr for rows and columns)

# Where can you find suitable functions for your tasks?

#a) Cheat sheets!

#     https://www.rstudio.com/resources/cheatsheets/ 
#     see also our dropbox folder for relevant cheat sheets

#     Advantages of cheat sheets:
#       - You build familiarity with the package.
#       - They have visuals! Easy to see what the function will do. 
#       - Quick, big picture of what is available. 
# 
# b) Package vignettes or manuals

#vignette(package = "dplyr") #list of topics for which there are vignettes about dplyr
#vignette("dplyr", package = "dplyr") #first argument "dplyr" was listed as Introduction to dplyr in the list of topics, so we call for it. 

#     https://cran.r-project.org/web/packages/network/network.pdf
#     this is the package we will use to create our network object.

# c) Googling it

#################################
#   PHASE 4: CHECK YOUR WORK    #
#################################

# Goal: Make sure the new network object **makes sense**

#Look at basic descriptives of the network and see if they fit with
#what we know about our raw data. 

#Now let's go through each phase in more detail by working with an example.  

#############################################
#   EXAMPLE: DATAMED - Nomination Network   #
#############################################

#Installing and loading packages
#install.packages("openxlsx") #I think this one you have to install.
#either comment or remove the line of code that installs a package right 
#after installing it.
library(openxlsx)
library (dplyr)
library (tidyr)
library(stringr)

#Importing Data
#This is a synthetic (fake) dataset I created for the purposes of this lab.
#We have two files. The first file contains responses to a 
#qualtrics survey. The second file is a person codebook. 

#"Respondents" are medical professionals and were asked to list up to ten
#other professionals with whom they discuss professional matters. 

#File 1: Field data from Qualtrics
setwd("/Users/mariacristinaramos/Dropbox/Ongoing Projects/RA for Jim/Data Cleaning Workshop/")
list.files() #this lets you see what's in your working directory
datamed <- read.xlsx("datamed_raw.xlsx")

#File 2: Person Codebook
pcode <- read.xlsx("datamed_raw.xlsx", sheet = 2)

##################################
#   PHASE 1: INSPECT YOUR DATA   #
##################################

#2 Steps
#Step 1. Understand the Structure
#Step 2. Understand at the Observation level

#1. Understand the Structure of your Data
#########################################

#a) Check the class of the dataset. 
class(datamed)
class(pcode)
#You can use class with any type of R object
#Most data come in tabular format, but still it is good to check.

#We can already see that we have more nodes in our person codebook (225)
#than responses to the survey (217). 

#b) view the column names to get a first sense of what you have. 
names(datamed)
names(pcode)
#RED FLAG: some of the column names are not very informative.

#We look at the survey and find out that
#Q32 = R's Name
#Q33 = R's Last Name
#Q.1 - Q.10 = R's Nominees 
#Q34 = R's Gender
#Q35 = R's Age
#Q36 = R's Area within Medicine
#Q37 = R's Hospital Affiliation

#c) See a compact summary of the data
str(datamed)
glimpse(datamed) #dplyr's version of str()
str(pcode)
#str stands for structure

#The str() function tells you the dimensions of the data. 
#In addition, the str () function tells you the class and 
#first observations of each variable.

#The str() function is particularly useful to identify bits of
#information you can use in your analysis. 
#In conjunction with your codebook or survey, you can identify 
#variables that contain information that we can use for 
#constructing our network. 

#str() is also useful to identify NAs
#Note R encodes missing values as NAs. Look for other common 
#missing values encodings in your data (-1, 9999, N/A).

#RED FLAGS: 
#unnecessary columns
#previews in Distribution Channel. 
#R's name and last name in different columns.
#R's name and last name (IDs) are strings, nominee IDs are numbers
#NAs in attribute variables 

#d) look the first and last rows 

#head() lets you look the first rows of a dataframe.
head(datamed) #first 6 rows (6 rows is the default)
#head(datamed, n=10)#first 10 rows. The n= tells R how many rows
#you would like to see
head(pcode)

#tail() lets you look at the last rows of the dataframe
tail(datamed) #last 6 rows
#tail(datamed, n=10) # set it to show you the last 10 rows.
tail(pcode)

#these functions let you see your dataset without 
#clutering the console. This is useful to detect
#whether your dataset is sorted in a particular way and to get a 
#deeper understanding of what each variable contains. 

#NOTICE: fewer NAs in attribute vars in tail. Could it be that those previews 
#are the NAs?

#e) Summary of the distribution of each variable
summary(datamed)

#For numeric variables, this means looking at means, 
#quartiles (including the median), and extreme values. 

#Summary will produce different summaries 
#depending on whether you are dealing with a character
#or factor variable. 

##Summary helps reveal unusual or 
#extreme values, missing values, special characters,etc. 
#Summary tells you the number of NAs in each variable 
#in the dataset.

#Also useful for assessing whether you will have enough
#variation in some variable to effectively use it as 
#an attribute for your network objects


#RED FLAG: If we know the max. node_id is 227, we shouldn't have values  
#greater than 227 in the nominations. However, we see that Q.1 has
#a max value of 609. 

#2. Look more closely at Observations
#####################################

#Should do this for each var of interest

#a) Tables for each variable of interest

#Important to find unusual observations, special characters, NAs, and
#variation in categories to see which attributes could be more distinguishing #features. 

#simple table
table(datamed$DistributionChannel)
#we have 5 preview observations

table(datamed$Q34, useNA="ifany") 
#IMPORTANT: $ selects a specific variable from the dataset. 
#useNA="ifany" includes NAs in your table

table(datamed$Q36, useNA = "ifany")
#RED FLAG: those Unknowns in Q36... 11 Unknowns

table(datamed$Q37, useNA="ifany")
#RED FLAG: only 3 people from City Hospital. Probably not a great distinguishing  
#attribute. 

#crosstab
with(datamed, table(Q36, Q37, useNA = "ifany"))

#b) Visualization 
hist(datamed$Q35)#histogram
boxplot(datamed$Q35) #boxplots are good for detecting outliers.

#ok. There are outliers. How do we find them?
which.max(datamed$Q35) #Which row contains the max value for Q35

which(datamed$Q35>60) #which rows contain values above 60 for Q35?

#see if we have any NAs in our person code
sum(is.na(pcode))

#We have looked at our data. 
#Now we have a sense of the data structure and the issues we need to deal #with. 
#We have a better sense of what variables will be useful to keep for our #network objects,how we should name those variables, and whether we have #missing data issues we should deal with. 

####################################
#   PHASE 2: MAKE A PLAN   #
####################################

#Remember: no code involved, just the plan. 

#A. Plan for dealing with unusual observations
##############################################

#When dealing with unusual values in your data, 
#you often must decide if they are just extreme or erroneous. 

#1. Remove preview observations and keep observations with NAs
#in attribute vars.

#2. Remove the 609 in Q.1

#3. Turn the "Unknown"s in Q36 into NAs

#B. Plan for constructing network
#################################

#1. Choose the type of input structure for network objects: 
#It seems like the easiest option is to go for an edgelist. This 
#might vary according to dataset.
#2. Describe series of tasks to restructure your current dataset into the network
#object input (your pseudo code):

#A. Fixing Node-id
#*****************

#Start by fixing the node_id issue since we will use that info in both our 
#node list and edgelist

#Step 1. Join name and last name in pcode file.
#Step 2. Join Q32 and Q33 (R's name and last name). 
#In this way we can match the two datasets with R's complete name.
#Step 3. Replace ID in our new nodelist dataframe with code from pcode. 

#B. Constructing nodelist
#************************

#Step 1. Create nodelist dataframe. 
#Step 2. Store new id, gender, area, and age cols in new dataframe.
#Step 3. Rename cols in nodelist dataframe 

#C. Constructing edgelist
#******************************

#Step 1. Create edgelist dataframe. 
#Step 2. Store new id and nominations in new dataframe.
#Step 3. move nominations from wide to long format
#Step 4. Remove NAs
#Step 5. Rename cols sender and target.

#3. Create network object using our nodelist and edgelist
#as input

#4. Add attributes

##########################################
#   PHASE 3: CONSTRUCT NETWORK OBJECTS   #
##########################################

#Every task you do follows the same process of data cleaning
#but in a small scale: you look at your data, you make a plan, you implement #it, and look again to check.

#1. Remove preview observations
names(datamed)
edgedata<- filter(datamed,DistributionChannel!="preview")
head(edgedata)#no more previews. Always, always check what you did.

#2. Remove the 609 in Q.1
edgedata$Q.1[edgedata$Q.1==609] <- NA
summary(edgedata)

#3. Turn the "Unknown"s in Q36 into NAs
edgedata$Q36[edgedata$Q36=="Unknown"] <- NA
table(edgedata$Q36, useNA = "ifany")

#A. Fixing Node-id
#*****************

#Step 1. Join name and last name in nodelist file.
#a useful function to join the contents of multiple columns?
#?unite
#TIP: use ?functionname when you know of a function that might work, 
#but you are not sure of what its arguments are

head(pcode)
pcode<- unite(pcode, "name", name:last_name, sep=" ", remove=TRUE)
head(pcode)

length(unique(pcode$name))#because we have 227 unique names, we 
#know no names were repeated

#sep="" very important. Tells R what should be between the pieces you 
#will unite
#Remove: whether the original columns you united should be removed or not. 

#Step 2. Join Q32 and Q33 (R's name and last name). 
str(datamed)
edgedata<- unite(edgedata,"name",Q32:Q33, sep=" ", remove=TRUE)
head(edgedata)

#Step 3. match name in new dataframe with name from node file. 
edgedata<- right_join(pcode,edgedata, by="name")
head(edgedata)
pcode[pcode$node_id==95,] #looking at whether 95 corresponds to Marilyn
#Hulett in the node file to see if our matching worked correctly.  

#We could have done this more efficiently by doing Step 2 and 3 together
#with pipes:
#edgedata<- unite(edgedata,"name",Q32:Q33, sep=" ", remove=TRUE)%>%
#right_join(pcode,edgedata, by="name")

#pipes are distinctive of dplyr. So you need to install the package. We did
#that at the beginning of the code.
#Pipes *pass* whatever is on the left to the right. This is different from #the usual R logic that goes from right to left.

#Usual R logic: a <- select(b,1:10) a equals a selection of b, its columns #from 1 to 10
#Pipes: a <- b%>%select(1:10). a equals: take b then select its columns 
#from 1 to 10.

#TIP: verbalizing your code can help. 

#B. Constructing nodelist
#************************
#Step 1. Create nodelist dataframe by joining our person codebook with the
#dataframe containing the attribute information. We need to fully join our 
#datasets instead of only using our datamed dataset because the datamed dataset
#does not contain all the nodes since not everyone replied to the survey. 
#Step 2. Store new id, gender, area, and age cols in new dataframe.
#Step 3. Rename cols in nodelist dataframe 
str(edgedata)

nodelist <- full_join(pcode,edgedata, by="node_id")%>%
  select(node_id, Q34:Q36)%>%
  rename(gender=Q34, age=Q35, area=Q36)

head(nodelist)

dim(na.omit(nodelist)) #To figure out from how many people you are missing 
#at least one attribute. 

#C. Constructing Edge list
#******************************

#Step 1. Create edgelist dataframe. 
#Step 2. Store new id and nominations in 
#new dataframe.
#Step 3. move nominations from wide to long format
#Step 4. Remove NAs
#Step 5. Rename sender and target.
str(edgedata)
edgedata <- select(edgedata, node_id, Q.1:Q.10)%>%
  gather(label, target, Q.1:Q.10, na.rm=TRUE)%>%
  select(-label)%>%
  rename(sender=node_id)%>%
  arrange(sender)
head(edgedata)

#### new steps (select) came given the function we used, but 
#having a plan made it easier to move forward

#3. Create network object using our nodelist edgelist
#as input
library(statnet)
mednet <- network.initialize(227, directed = TRUE)#network initialize
#is very useful to make sure you include isolates.
mednet <- network.edgelist(edgedata, mednet)
mednet<-network.edgelist(edgedata,network.initialize(227),ignore.eval=FALSE)

#4.Add node attributes

# Note: order of attributes you add must match vertex ids
# otherwise the attribute will get assigned to the wrong vertex

#This is how we see vertex names
mednet %v% "vertex.names"
#yep, in the correct order.

mednet %v% "gender" <- nodelist$gender
mednet %v% "age" <- nodelist$age
mednet %v% "area" <- nodelist$area

##################################
#   PHASE 4: CHECK YOUR WORK   #
##################################

#quick check
mednet
dim(edgedata)
#same number of edges

#checking attributes
summary.network(mednet)

#Now compare distributions of vertex atttributes 
head(nodelist)
#gender
table(datamed$Q34)
#area
table(datamed$Q36)
#age
hist(datamed$Q35)

plot(mednet)
#Do we see isolates?
#Does it make sense?

###########################################
#     TIPS: WHEN SOMETHING DOESN'T WORK   #
###########################################

#1. Try to understand the error message or look for clues in it.
#2. google the error.
#3. use help to see if the arguments you used are not right or not in the 
#right format
#4. use the package manual. toy examples and make substitutions until you 
#find what the function didn't like

#For more information
#?network #for information about creating networks using the network package. 
#?attribute.methods #for information about setting, modifying, or deleting network, vertex, or edge attributes. 

```

