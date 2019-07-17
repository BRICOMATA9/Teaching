#Example R-based network drawing tools

#This is a compilation of code snipits pulled from Jaemin Lee's 2016 presentation,
#the Polnet 2016 tutorial, and examples from the various package vingettes

#Make sure you have the relevant packages, you likely do given the earlier modules, 
#but for completeness here are relevant packages, we wont' 
#go over all these today...

#install.packages("igraph") 
#install.packages("network") 
#install.packages("sna")
#install.packages("visNetwork")
#install.packages("ndtv", dependencies=T)
#install.packages("GGally")
#install.packages("ggraph")
#install.packages("ggnetwork")
#install.packages("networkD3")
#install.packages("tidyr")

#clear everything to start
rm(list = ls())
gc()

library(dplyr); 
library(readr);
library(magrittr)     #Supports pipe (%>%) commands that allow you to perform multiple operations with one statement
library(dplyr)        #Manipulate data
library(tidyr)        #Additional functions for manipulating data

#load the data
#first build the edgelist & nodelist info
setwd("C:/SNH18wd")
AHS_Base <- read_csv ('C:/SNH18wd/ahs_wpvar.csv',
                    col_names = TRUE);
AHS_adjlist <- AHS_Base %>%
  select(ego_nid, mfnid_1:mfnid_5, ffnid_1:ffnid_5, grade, sex, commcnt) %>%
  filter(commcnt==1);

AHS_Edges <- AHS_adjlist %>%
  rename( id = `ego_nid`,
          gender = `sex`) %>%
   gather(Alter_Label, Target, mfnid_1:mfnid_5, ffnid_1:ffnid_5, na.rm = TRUE)

AHS_Edges=AHS_Edges %>% filter (Target != 99999);
AHS_Edges=AHS_Edges %>%select(id, Target);

#now we have nodeset...

#plot it.
library(sna)
library(GGally)
library(ggplot2)
library(network)

g=as.network(AHS_Edges)
g %v% "grade" <- AHS_adjlist$grade
g %v% "sex" <- AHS_adjlist$sex
g %v% "degree" <- degree(g)

plot.network(g,vertex.col="grade", 
             vertex.cex="degree",
             jitter=T)

g %v% "logdegree" <- log(degree(g)+1)
plot.network(g,vertex.col="grade", 
             vertex.cex="logdegree",
             jitter=T)

library(networkD3)

gn=data.frame(NodeID=as.numeric(AHS_adjlist$ego_nid-1),Nodesize=(degree(g)))
ge=data.frame(AHS_Edges-1)
gn$group <- AHS_adjlist$grade

forceNetwork(Links=ge, Nodes = gn,
             Source = "id", Target = "Target", Group="group",
             Nodesize = "Nodesize", NodeID = "NodeID", 
             opacity = 0.9, bounded=FALSE, opacityNoHover=.2)

#forceNetwork(Links=ge, Nodes = gn,
#             Source = "id", Target = "Target", Group="group",
#            Nodesize = "Nodesize", NodeID = "NodeID", 
#             opacity = 0.9, bounded=FALSE, opacityNoHover=.2) %>%
#  saveNetwork(file = 'C:/jwm/Presentations/Viztalk/ah_comm1.htm')


library(igraph)
#basic default plot
#create a graph object from the dataframe.  
gi<- graph_from_data_frame(ge, directed=TRUE, vertices=gn)

plot(gi)

#pretty ugly...arrows are too big and labes are 
#in the way.  So let's specify those with the 
#igraph options remove those:
plot(gi, edge.arrow.size=.2,vertex.label=NA)

#better, the layout is not optimal...lots of node
#overlap and such.  Let's see what else we can do...
#Fruchterman Rheingold is a good default:
plot(gi, edge.arrow.size=.2,vertex.label=NA, 
     layout=layout_with_fr)

#you can see the basic clustering here some, let's highlight
#that with a community detection clustering
imc<-cluster_infomap(gi)
membership(imc)

plot(gi, edge.arrow.size=.2,vertex.label=NA, 
     layout=layout_with_fr,
     vertex.color=imc$membership)

#add in some size information...
plot(gi, edge.arrow.size=.2,vertex.label=NA, 
     layout=layout_with_fr,
     vertex.color=imc$membership,
     vertex.size=degree(gi,mode = "in"))

#try it w. KK
plot(gi, edge.arrow.size=.2,vertex.label=NA, 
     layout=layout_with_kk,
     vertex.color=imc$membership,
     vertex.size=degree(gi,mode = "in"))

#switch to grade
plot(gi, edge.arrow.size=.2,vertex.label=NA, 
     layout=layout_with_kk,
     vertex.color=gn$group,
     vertex.size=degree(gi,mode = "in"))


#arcs are still hard to see...lets adjust a little more...
plot(gi, edge.arrow.size=.1,vertex.label=NA, 
     layout=layout_with_kk,
     vertex.color=imc$membership,
     vertex.size=degree(gi,mode = "in"),
     edge.curved=.2)


#default laout
plot(gi, edge.arrow.size=.1,vertex.label=NA, 
     layout=layout_nicely,
     vertex.color=imc$membership,
     vertex.size=degree(gi,mode = "in"),
     edge.curved=.2)


#MDS
plot(gi, edge.arrow.size=.1,vertex.label=NA, 
     layout=layout_with_mds,
     vertex.color=imc$membership,
     vertex.size=degree(gi,mode = "in"),
     edge.curved=.2)

#some rarely used/not so effective styles:
#Circle - really only useful for very small networks
plot(gi, edge.arrow.size=.1,vertex.label=NA, 
     layout=layout_in_circle,
     vertex.color=imc$membership,
     vertex.size=degree(gi,mode = "in"),
     edge.curved=.2)

#random -- no idea why you'd use this
plot(gi, edge.arrow.size=.1,vertex.label=NA, 
     layout=layout_randomly,
     vertex.color=imc$membership,
     vertex.size=degree(gi,mode = "in"),
     edge.curved=.2)

#ditto
plot(gi, edge.arrow.size=.1,vertex.label=NA, 
     layout=layout_on_sphere,
     vertex.color=imc$membership,
     vertex.size=degree(gi,mode = "in"),
     edge.curved=.2)


#cute way to get a list of them all...if you want 
#to try some...note they dont all apply to us, many 
#really only work well if the graph is a single connected
#component (i.e. no isolates)

layouts <- grep("^layout_", ls("package:igraph"), value=TRUE)[-1] 
layouts

#another modification of the spring embedder
plot(gi, edge.arrow.size=.1,vertex.label=NA, 
     layout=layout_with_graphopt,
     vertex.color=imc$membership,
     vertex.size=degree(gi,mode = "in"),
     edge.curved=.2)

#similar
plot(gi, edge.arrow.size=.1,vertex.label=NA, 
     layout=layout_with_dh,
     vertex.color=imc$membership,
     vertex.size=degree(gi,mode = "in"),
     edge.curved=.2)

#these only work with fully only connected components, if your
#graph is like that, give 'em a try

#plot(g, edge.arrow.size=.2,vertex.label=NA, 
#  layout=layout_with_drl,
#     vertex.color=imc$membership,
#      vertex.size=degree(g,mode = "in"),
#      edge.curved=.1)

#plot(g, edge.arrow.size=.2,vertex.label=NA, 
#        layout=layout_with_gem,
#     vertex.color=imc$membership,
#      vertex.size=degree(g,mode = "in"),
#        edge.curved=.1)

#to use other tools, need to remove statnet 
detach("package:igraph", unload=TRUE)

plot.network(g,vertex.col="grade", 
             vertex.cex="logdegree", 
             arrowhead.cex = .5,
             jitter=T)

?plot.network


#interactive & high resolution...
library('visNetwork') 
??visNetwork

#visNetwork needs a dataframe with "to" 
#and "from" columns, so change

library(plyr) 
links <- rename(ge,c("id" = "from", "Target" = "to"))
nodes <- rename(gn,c('NodeID'="id"))

#just a simple interactive plot .. really
#almost exactly like the d3 plot above..
#note it might take a moment to run...
visNetwork(nodes, links, width="100%", height="400px",main="Network!")

#some alternative options...need to specify on the graph object
 nodes$shape <- "dot"  
 nodes$shadow <- TRUE # Nodes will drop shadow
 nodes$size <- gn$Nodesize # Node size
 nodes$borderWidth <- .5 # Node border width
 nodes$color.background <- c("slategrey", "tomato", "gold", "red", "blue", "green","lightgray","lavender")[imc$membership]
 nodes$color.border <- "black"
 nodes$color.highlight.background <- "orange"
 nodes$color.highlight.border <- "darkred"
 visNetwork(nodes, links)
