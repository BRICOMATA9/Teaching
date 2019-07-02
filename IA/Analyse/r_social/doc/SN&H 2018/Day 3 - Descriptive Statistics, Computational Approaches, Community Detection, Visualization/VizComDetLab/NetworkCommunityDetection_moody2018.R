#this program demonstrates some of the community detection tools
#commonly used in R to partition networks.

#Moody, 5.15.2018; stealing rather completely from Morgan's 2016 tutorial,
#just without all the pretty explaination bits.  :-)


#clear everything to start...
rm(list = ls())
gc()

#load basic data manipulation bits
library(dplyr); 
library(readr);
library(magrittr)     #Supports pipe (%>%) commands that allow you to perform multiple operations with one statement
library(tidyr)        #Additional functions for manipulating data

#load the data
#first build the edgelist & nodelist info
setwd("C:/SNH18wd")
AHS_Base <- read_csv ('ahs_wpvar.csv',
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

#now we have a base edgelist & a base node level dataset, let's 
#pull them into iGraph to check out their functions.

library(igraph)
#Create a Graph Obeject for Subsequent Analyses. Note the 
#subtraction!  igraph indexes from 0-(N-1). This only works
#because the nodeids in this dataset are already listed from 1 to N
#else we'd need to create an index by sort order in the arbitrary-length
#IDs

gn=data.frame(NodeID=as.numeric(AHS_adjlist$ego_nid-1))
ge=data.frame(AHS_Edges-1)
gn$group <- AHS_adjlist$grade
glimpse(gn)


#create a graph object from the dataframe.  
net<- graph_from_data_frame(ge, directed=TRUE, vertices=gn)

#quick look...
V(net)[[1:5]]

plot(net)

#strongly connected components
scc <- clusters(net, "strong")     #Type scc in the console to have the 

#add in some size information...
plot(net, edge.arrow.size=.2,vertex.label=NA, 
     layout=layout_with_fr,
     vertex.color=scc$membership,
     vertex.size=degree(net,mode = "in")+6)

#Weakly  connected components
wcc <- clusters(net, "weak")   

#add in some size information...
plot(net, edge.arrow.size=.2,vertex.label=NA, 
     layout=layout_with_fr,
     vertex.color=wcc$membership,
     vertex.size=degree(net,mode = "in")+5)

#lots of the network clustering algorithms assume an 
#undirected graph.  So going to create that here.  

symnet=as.undirected(net)

#Edge-betweenness is a divisive clustering technique, had by 
#cutting the graph at its weakest links in sequence, then
#finding the set of cuts that maximizes modularity.

GNC <- cluster_edge_betweenness(symnet, weights = NULL)
plot_dendrogram(GNC)
modularity(GNC)

#attach the membership to the node vertices...
V(net)$ebtwn_cluster <-membership(GNC)              
V(net)[[1:5]]

plot(net, edge.arrow.size=.2,vertex.label=NA, 
     layout=layout_with_kk,
     vertex.color=membership(GNC),
     vertex.size=degree(net,mode = "in")+5)

symnet2 <- symnet %>%
  set_vertex_attr("ebtwn_cluster", value = membership(GNC))

V(symnet2)[[1:5]]
plot(symnet2, edge.arrow.size=.2, 
     layout=layout_with_kk,
     vertex.label.cex=0.5, 
     vertex.size=10, 
     vertex.color=membership(GNC),
     vertex.size=degree(symnet2,mode = "in")+5)

#make this part of the dataset for later...because of the different 
#data formats - factors, strings, etc. -- takes a couple steps...

# 1. pull out the membership info 
members <- membership(GNC)      
# 2. make a dataframe from teh bits we want..
GNC_ID <- data.frame(GNC_ID = as.numeric(members), NodeID = as.numeric(names(members))) 
glimpse(GNC_ID)
# 3.  Merget back to node level dataset...
gn <- merge(gn, GNC_ID, by= 'NodeID', all=TRUE) #Merging the data sets.
rm(members,GNC_ID)



#Newman Leading Eigenvector
EVC <- cluster_leading_eigen(symnet, weights = NULL)
modularity(EVC)

plot(symnet, 
       edge.arrow.size=.2, 
       vertex.label.cex=0.5, 
       vertex.size=10, 
       layout=layout_with_kk,
       vertex.color=membership(EVC))

#same tricks to merge the result to data...
members <- membership(EVC)      
EVC_ID <- data.frame(EVC_ID = as.numeric(members), NodeID = as.numeric(names(members))) 
gn <- merge(gn, EVC_ID, by= 'NodeID', all=TRUE) 
rm(members,EVC_ID)


#Walktrap (Pons & Latapy 2005): 
WTC <- cluster_walktrap(symnet)
modularity(WTC)

plot(symnet, 
     edge.arrow.size=.2, 
     vertex.label.cex=0.5, 
     vertex.size=10, 
     layout=layout_with_kk,
     vertex.color=membership(WTC))

#same tricks to merge the result to data...
members <- membership(WTC)      
WTC_ID <- data.frame(WTC_ID = as.numeric(members), NodeID = as.numeric(names(members))) 
gn <- merge(gn, WTC_ID, by= 'NodeID', all=TRUE) 
#clean house, so we don't mistakenly pick something later we don't want
rm(members,WTC_ID)

#label propagation

#Label Propogation
#Label Propogation Techniques (Ragavan, Albert, & Kumara 2007)
#Label_Prop in iGraph assumes an undirected graph

LP <- cluster_label_prop(symnet)
modularity(LP)
plot(symnet, 
     edge.arrow.size=.2, 
     vertex.label.cex=0.5, 
     vertex.size=10, 
     layout=layout_with_kk,
     vertex.color=membership(LP))

#same tricks to merge the result to data...
members <- membership(LP)      
LP_ID <- data.frame(LP_ID = as.numeric(members), NodeID = as.numeric(names(members))) 
gn <- merge(gn, LP_ID, by= 'NodeID', all=TRUE) 
rm(members,WTC_ID)

#InfoMAP (Rosvall, Axelsson, Berstrom 2009)
#Using a map algorithm that models a network work as a system of flows.
#http://www.tp.umu.se/~rosvall/livemod/mapequation/

IMP <- cluster_infomap(symnet)
modularity(IMP)

plot(symnet, 
     edge.arrow.size=.2, 
     vertex.label.cex=0.5, 
     vertex.size=10, 
     layout=layout_with_kk,
     vertex.color=membership(IMP))

#same tricks to merge the result to data...
members <- membership(IMP)      
IMP_ID <- data.frame(IMP_ID = as.numeric(members), NodeID = as.numeric(names(members))) 
gn <- merge(gn, IMP_ID, by= 'NodeID', all=TRUE) 
rm(members,IMP_ID)

#louvain method
#Resolution parameter set to 1 by omission. 
#iGraph does not support changing the resolution parameter, but it can be important.
#In instances where the group appear too coarse or too fine, we suggest trying Pajek which is also publicly avaialable: http://mrvar.fdv.uni-lj.si/pajek/pajekman.pdf

LC <- cluster_louvain(symnet, weights = NULL)
modularity(LC)

plot(symnet, 
     edge.arrow.size=.2, 
     vertex.label.cex=0.5, 
     vertex.size=10, 
     layout=layout_with_kk,
     vertex.color=membership(LC))

#evaluate the clusters...see how similar they are...
#install.packages("clues")
library(clues)
help(cluster)

adjustedRand(gn$WTC_ID, gn$EVC_ID)
adjustedRand(gn$LP_ID, gn$GNC_ID)
