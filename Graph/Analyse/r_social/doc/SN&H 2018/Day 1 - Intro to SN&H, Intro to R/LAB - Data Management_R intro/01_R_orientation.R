#R Orientation 
#Author: Jonathan H. Morgan
#Based in Part on Jake Fisher's introduction to R: https://dnac.ssri.duke.edu/r-labs/2017/01_data_management.php
#9 May 2018

###################################
#   STARTING FROM A CLEAR SLATE   #
###################################

#Remove: Removes objects from memory
rm(list = ls())

#Garbage Collection: Frees up memory, but preserves variables created in previous steps
gc()

#######################################
#   INSTALLING AND LOADING PACKAGES   #
#######################################

#R is a modular language. 
#The intuition is that you have in memory only what you need to perform the analysis tasks specified in the script. 
#Consequently, we need to load the packages we will be using during our analyses each time we run a new instance of R.

#Installing a Package
    #Installing a package multiple times can result in R being unable to read the package files.
    #Consequently, if you are uncertain whether a particular package is installed on you machine,
    #use the search window in the Packages tab to check.
    install.packages("readr")

#Reading a Package
library(readr)        #Import csv and other delimited files
library(haven)        #Import SPSS, SAS, or Stata files
library(magrittr)     #Supports pipe (%>%) commands that allow you to perform multiple operations with one statement
library(dplyr)        #Manipulate data
library(tidyr)        #Additional functions for manipulating data
library(ggplot2)      #Visualizing data
library(statnet)      #Network Analysis Software
library(ggnetwork)    #Network Visualization

##################################
#   DATA AND OBJECT TYPES IN R   #
##################################

# R is an object-oriented language, which puts it somewhere between statistical
# computing languages such as SAS, Stata, or SPSS, and object-oriented programming
# languages such as Python or Java.  
# We will focus mainly on using R for statistical computing, but 
# I will demonstrate one instance where writing a simple function is quite useful for importing large data sets.

#DATA TYPES
    #Logical:  TRUE or FALSE
    #Integer:  1, 2, 3, 4, ...
    #Numeric:  1.2, 3.5, 5.5, 0, -1
    #Complex:  1 + 2i (imaginary numbers)
    #Character:  "Jon", "1.2" 
    #Raw:  A mixture of types in the same cell: "Jon" 1 2 2.5 -1
    #Function: Essentially, conditional statements or transformations you want to apply to multiple cases 
    #that utilize operations from Base R or packages that you load.

#When reading in data, R will, by default, treat columns with different data types as different types of objects. 
#There are a few instances where this can be problematic. 
#For example, R tends to treat a column consisting of character variables as a factor, 
#essentially treating it as a categorical varaible when you may simply want a list of names.
#We can avoid these problems if we are mindful of the data types in our data,
#and specify the data type when importing our data in R.
#We can also "coerce" or transform a variable from one type to another. 
#We discuss both methods in this orientation. 

#OBJECT TYPES: Vectors, Lists, and Factors Oh My!
    #Vectors
    #Lists
    #Factors
    #Arrays
    #Matrices
    #Data Frames
    #Functions

#Vectors: A vector is a sequence of data elements of the same basic type.

c(2, 3, 5) 
c(TRUE, FALSE, TRUE, FALSE, FALSE) 
c("aa", "bb", "cc", "dd", "ee") 

#Lists: A list is a generic vector containing other objects.

#For example, the following variable x is a list containing copies of three members n, c, l, and a numeric value 3.
 n = c(2, 3, 5) 
 c = c("aa", "bb", "cc", "dd", "ee") 
 l = c(TRUE, FALSE, TRUE, FALSE, FALSE) 
 x = list(n, c, l, 3)   # x contains copies of n, s, b and the number 3
 
    #Slicing a list: We retrieve a list slice with the single square bracket "[]" operator. 
    #The following is a slice containing the second member of x, which is a copy of c.
    x[2]
    
    #Modifying a list
    x[[2]][1] = "ta" #We are manipulating the list directly, indicated by the double brackets around the 2,
                     #the 1 first element of the second member of the list.
    x[2]
    
#Factors: A vector of integer values with a corresponding set of character values to use when the factor is displayed.
  #Factors are R's way of representing categorical variables.
  
    #Creating an example factor
    data = c(1,2,2,3,1,2,3,3,1,2,3,3,1)
    factor = factor(data)  #We are specifying that 1, 2, and 3 correspond to levels, similar to SAS's class statement.
    factor
    
    #Creating Labels for Levels: 1 2 3
    factor = factor(factor,labels=c("I","II","III"))
    factor
    
    #When importing data, R will specify varibles that it thinks have levels as factors. 
    #This is problematic because R is now treating the variable as a catgorical variable, 
    #and thus will not perform many basic operations.
    
#Arrays: A multidimensional rectangular data object. 
    #"Rectangular" refers to the fact that each row is the same length, and likewise for each column.

    Three_D_Array <- array(
        1:24,                                    #24 rows for each dimension
        dim = c(4, 3, 2),                        #3 dimensions consisting of 4, 3, and 2 objects
        dimnames = list(
              c("one", "two", "three", "four"),
              c("ein", "zwei", "drei"),
              c("un", "deux")
        )
      )
    Three_D_Array  #Enlish Numbers by German Numbers by French Numbers
    
#Matrix: A collection of data elements arranged in a two-dimensional rectangular layout.
    #A matrix is a special case of an array, the 2D version.
    
    Matrix <- matrix(
      1:12,                #Creating cell values
      nrow = 4,            #Specifying the number of rows, ncol = 3 works the same
      dimnames = list(
        c("one", "two", "three", "four"),    #Specifying the rows and columns
        c("ein", "zwei", "drei")
        )
      )
    Matrix
    
#Data Frame:  A list of vectors of equal length.
    #A data frame is a special case of a matrix, 
    #one where we have specified that the data elments in each column are the same type.

    #Data frames are R's counterpart to a classic statistical package's data set.
    #The top line of the table is a header, and contains the column names. 
    #Each horizontal line after the header denotes a data row, which begins with the name of the row, 
    #and then followed by the actual data. 
    #Each data member of a row is called a cell.
    
    n = c(2, 3, 5) 
    c = c("aa", "bb", "cc") 
    l = c(TRUE, FALSE, TRUE) 
    data_frame = data.frame(n, c, l)       #In R forums, df is often used to refer to a data frame.
    data_frame
    
######################
#   IMPORTING DATA   #
######################

#Getting and Setting Your Work Directory
    #It's important to know where you are saving the data.
    #By default, R will save your data to the highest level of your user directory.
    
    #You can determine where R is saving your data by using the following command:
    getwd()
    
    #We can set a working directory which is quite useful because we, then, do not have specify 
    #the file location of eah our data sets when we import them.
    #You can even synchronize your work directory with an online directory.
    #We can set our work directory by using the following command:
    setwd("C:/Users/Jonathan H Morgan/Desktop/SN&H 2018")  # Note: forward slashes

#Importing data into R
    #There are numerous functions and packages for importing data into R. I am going to priamrily discuss "readr" 
    #because this package is capable of importing multiple data types, and is capable of importing large data 
    #sets (e.g., 87 GB).
    #For importing SPSS, SAS, and Stata files directly, we recommend using the "haven" package.
    #Documentaion for Haven: https://cran.r-project.org/web/packages/haven/haven.pdf
    
    #R does provide a GUI based option, but this is not optimal for large data sets
    AHS_Base=read.csv(file.choose(),header=TRUE)

    #Reading the CSV where readr is inferring the data type based on the first 1000 rows of data
    AHS_Base <- read_csv ('C:/Users/Jonathan H Morgan/Desktop/SN&H 2018/ahs_wpvar.csv',
                          col_names = TRUE)
    
    #Useful functionality when importing very large data sets by subsets
    
    f <- function(x, pos) subset(x, x[[27]] == 2)   #Subsetting by gender to isolate female respondents
                                                    #I am using column's index number because this notation
                                                    #works whether the file has a header or not.
    
    AHS_Base <- read_csv_chunked("C:/Users/Jonathan H Morgan/Desktop/SN&H 2018/ahs_wpvar.csv", 
                                     col_names = TRUE, 
                                     DataFrameCallback$new(f),
                                     chunk_size = 10000,
                                     progress=TRUE
    )
    
    #Transforming Grade and Sex into factors
        #Specifying a vector that specifies which variables I want to transform
        cols <- c("sex", "grade")
    
    AHS_Base %<>%
        mutate_each_(funs(factor(.)),cols)
    
    #Confirming that sex and grade now have levels
    str(AHS_Base)
  
##############################
#   DATA MANAGEMENT BASICS   #
##############################
    
#The Basic Grammar of Data Management in R
    #Selecting
    #Arranging
    #Mutating
    #Filtering
    #Renaming
    #Gathering
    #Summarizing
    #Separating
    #Making Distinct
    #Joining
    
#Selecting: "Selecting" always refers to selecting the columns you want.
    AHS_Edges <- AHS_Base %>%
        select(ego_nid, mfnid_1:mfnid_5, ffnid_1:ffnid_5, grade)
    
#Arranging: "Arranging" reorder rows with respect to columns. 
    AHS_Edges <- AHS_Base %>%
      select(ego_nid, mfnid_1:mfnid_5, ffnid_1:ffnid_5, grade, sex) %>%  #Using a second pipe to chain commands
      arrange(ego_nid, sex)                  #Arraning the rows with respect to ego ID and gender

#Mutating:  "Mutating" refers to creating a new variable based on operations peformed on another variable.
    #Mutating is admittedly the strangest function name in the R Tidyverse, but it refers to the idea that 
    #a new variable is the result of a transformation of an old one.
    AHS_Edges <- AHS_Base %>%
      select(ego_nid, mfnid_1:mfnid_5, ffnid_1:ffnid_5, grade, sex) %>% 
      arrange(ego_nid, sex) %>% 
      mutate(Female = ifelse(sex == 2, 1, ifelse(sex != 2, 0, 0)))
    

#Filtering: "Filtering" refers to filtering by rows (e.g., choosing only 7th grade girls in this case).
    AHS_Edges <- AHS_Base %>%
      select(ego_nid, mfnid_1:mfnid_5, ffnid_1:ffnid_5, grade, sex) %>% 
      arrange(ego_nid, sex) %>% 
      mutate(Female = ifelse(sex == 2, 1, ifelse(sex != 2, 0, 0))) %>%
      filter (grade == "7" & Female == 1)  #Double == comes from set notation if and only if
    
#Renaming: "Renaming" refers to relabeling column names.
    AHS_Edges <- AHS_Base %>%
      select(ego_nid, mfnid_1:mfnid_5, ffnid_1:ffnid_5, grade, sex) %>%  
      arrange(ego_nid, sex) %>%                   
      mutate(Female = ifelse(sex == 2, 1, ifelse(sex != 2, 0, 0))) %>%
      filter (grade == "7" & Female == 1)  %>%
      rename( id = `ego_nid`,
              gender = `sex`)
    
#Gathering:  "Gathering" refers to gathering columns to transform a wide data set into a long one.
    AHS_Edges <- AHS_Base %>%
      select(ego_nid, mfnid_1:mfnid_5, ffnid_1:ffnid_5, grade, sex) %>%  
      arrange(ego_nid, sex) %>%                   
      mutate(Female = ifelse(sex == 2, 1, ifelse(sex != 2, 0, 0))) %>%
      filter (grade == "7" & Female == 1)  %>%
      rename( id = `ego_nid`,
              gender = `sex`) %>%
      gather(Alter_Label, Target, mfnid_1:mfnid_5, ffnid_1:ffnid_5, na.rm = TRUE)
    
#Summarizing:  "Summarizing" refers to generating summary statitics for a given variable.
    #In this case, we are going to calculate the average number of friends boys and girls have
    
gc()
    
    #Reading in the data to calcualte separate gender means
    AHS_Base <- read_csv ('C:/Users/Jonathan H Morgan/Desktop/SN&H 2018/ahs_wpvar.csv',
                          col_names = TRUE)
    
    AHS_Edges <- AHS_Base %>%
      select(ego_nid, mfnid_1:mfnid_5, ffnid_1:ffnid_5, commcnt, sex) %>% 
      gather(Alter_Label, Target, mfnid_1:mfnid_5, ffnid_1:ffnid_5, na.rm = TRUE) %>% 
      arrange(ego_nid, sex) %>% 
      filter (Target != 99999)   #Eliminating 99999 values
    
    #Generating Summary Statistics
    Gender_Mean <- group_by(AHS_Edges, ego_nid, sex, commcnt) %>%   #Group by ego ID to create a count of alters
                  filter (commcnt == 7 & sex != 0)  %>%             #Examining community 7's school network, and dropping 0s
                  summarise(count = n()) %>%                        #Creating a count of each students alters
                  group_by (sex) %>%                                #Grouping by gender to generate seaparate averages
                  summarise (Gender_Mean = mean(count))             #Generating male and female averages 

gc()
    
#Separating: "Seperating" refers to splitting delimited values in one column into multiple columns
    #Separating is very useful when dealing with delimited items in text data.
    #For example, Qulatrics output for questions where respondents can makes multiple responses
    #has each response to the given question separated by commas in one column.
    #The separate function combined with gather can be quite useful to splitting responses,
    #and then grouping them by each responsdent.
    
    #Simulating data where the output is a string
    ID = c("Jim", "Molly", "Jaemin") 
    Male_Friends = c("Jon Jaemin Joe Jim", "Jim Mudit Marcus", "Jim Peter Chris Marcus") 
    Female_Friends = c("MC Molly Liann", "Crystal Molly Liann", "MC Molly Crystal") 
    data_frame = data.frame(ID, Male_Friends, Female_Friends)       #In R forums, df is often used to refer to a data frame.
    data_frame
    
    #Converting varaibles into character variables to avoid potential problems with gathering 
    #and spearating data.
    data_frame %<>%
      mutate_if(is.factor,as.character)
    
    #This data is a mess, lets fix it
    Edges <- data_frame %>%
      select (ID, Male_Friends, Female_Friends) %>%
      separate(Male_Friends, c("MF_1", "MF_2", "MF_3", "MF_4"), " ") %>%  #Separating each element separated by
                                                                          #a space in the male friends into  its
                                                                          #own column
      separate(Female_Friends, c("FF_1", "FF_2", "FF_3"), " ") %>%        #Repeating this step for female friends
      gather(Alter_Label, Target, MF_1:MF_4, FF_1:FF_3, na.rm = TRUE) %>% #Gathering all the variables to create
                                                                          #an edgelist 
      select (ID, Target)                                                 #Dropping Alter_Label
    
    #We have got the data into something we can use, but character IDs can be problematic
    #Let make unique numeric IDs for all the nodes
    
#Distinct: Eliminates all duplicate values 
  Nodes <- Edges %>%
    gather(Variable_Label, Sender, ID, Target, na.rm = TRUE)%>%  #Gathering ID and Target into one list
    mutate(ID = Sender) %>%                                       #Creating Node Labels for later
    select (ID)  %>%                                              #Dropping the other variables
    distinct(ID) %>%                                              #Isolating unique cases                           
    (add_rownames) %>%                                            #Getting the rownames to create sequential IDs
    rename (Sender_ID = rowname)%>%                               #Renaming rowname to Sender    
    mutate(Sender_ID = as.numeric(Sender_ID))                     #Converting rowname into a numeric variable
  
#Joing:  "Joing" refers to merging data sets using key variable.
    #There are several kinds of joins. We are going to do left and right joins in this case.
    #To learn more about joins see: ttp://www.rpubs.com/williamsurles/293454
  
  #We now want to merge our numeric IDs, Sender, with our edgelist with the ID variable
  Edges <- Edges %>%
    left_join(Nodes, by = c("ID"))
  
  #Renaming to merge Nodes with Target to get Taret_ID
  Nodes <- Nodes %>%
    rename( Target_ID = `Sender_ID`,
            Target = `ID`)
  
  #Merging Numeric IDs for the alters or targets
  Edges <- Edges %>%
    right_join(Nodes, by = c("Target"))
    
  #Final Formatting
  Edges <- Edges %>%
      select(Sender_ID, Target_ID) %>%
      rename ( Target = `Target_ID`,
               Sender = `Sender_ID`)
  
################################################################
#   VISUALIZING OUR SIMULATED NETWORK: PREPARATION FOR DAY 2   #
################################################################
  
  #Step 1: Formatting Sender and Target Variables to Construct a Statnet Network Object
  Edges [,1]=as.character(Edges[,1])
  Edges [,2]=as.character(Edges[,2])
  
  #Step 2: Creating a Network Object
  #Note, this is a directed graph. So, we specify that in the network object now. 
  #The specification of the graph as either directed or undirected is important because it impacts fundamentally how we interpret the relationships described by the graph.
  AHS_Network=network(Edges,matrix.type="edgelist",directed=TRUE) 
  
  #Creating a label vertex to assign to the network
  Label <- as.vector(Nodes$Target)
  
  #Step 3: Assigning Attributes to Vertices from our nodelist
  set.vertex.attribute(AHS_Network,"Label",Label)
  
  #Step 5: Visualizing the Network
  AHS_Network
  summary(AHS_Network)                                #Get numerical summaries of the network
  
  set.seed(12345)
  ggnetwork(AHS_Network) %>%
    ggplot(aes(x = x, y = y, xend = xend, yend = yend)) + 
    geom_edges(color = "lightgray") +
    geom_nodelabel_repel (label = Label) +            #For networks with fewer nodes, we might want to label
    theme_blank() + 
    geom_density_2d()
  
  