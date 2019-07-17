#Social Networks and Health Training Program
#Descriptive Network Analyses
#Jonathan H. Morgan and Molly Copeland

#RESOURCES
  #Acton's and Jasny's Statnet Tutorial: https://statnet.org/trac/raw-attachment/wiki/Resources/introToSNAinR_sunbelt_2012_tutorial.pdf
  #Wasserman and Faust's (1994) book, Social Network Analysis: Methods and Applications

#Clearing Old Data
rm(list = ls())
gc()

########################
#   LOADING PACKAGES   #
########################

library (plyr)
library (dplyr)
library (tidyr)
library(statnet)
library(ggplot2)
library(ggnetwork)
#library (igraph)                                 igraph and sna packages are not compatible. Run one or the other.

#To get get more information about the sna and statnet packages
#The statnet package draws on the sna package to compute the majority of its descriptive network statistics.
help(package = sna)
help(package = statnet)

######################
#   IMPORTING DATA   #
######################

#Look for an icon in your task bar to select today's data set: ahs_wpvar.csv
#I chose this import strategy because particpants may have varying levels of familiarity with the computer they are using.
AHS_WPVAR=read.csv(file.choose(),header=TRUE)

#################################################
#   Creating School 7's Edgelist and Nodelist   # 
#################################################

#############################
#   CREATING THE EDGELIST   #
#############################

#Step 1: Subsetting AHS_WPVAR to Isolate Schools
AHS_Edges <- AHS_WPVAR %>% 
  #Step 1: Selecting Variables of Interest 
  select(ego_nid, mfnid_1:mfnid_5, ffnid_1:ffnid_5, 
         commcnt) %>% 
  #Step 2: Filtering to keep only community 7
  filter(commcnt == 7)

#Step 3: Gathering Columns to Create a Long Data Set
AHS_Edges <- AHS_Edges %>% 
  gather(Alter_Label, value, mfnid_1:mfnid_5, 
         ffnid_1:ffnid_5,na.rm = TRUE)

#Step 4: Deleting 9999 values from the data subsets; 
#the gather statements have eliminated the other missing values.
#Renaming ego_nid to Sender
#Renaming Value to Target
AHS_Edges <- AHS_Edges %>%
  filter (value != 99999)  %>%    #Eliminating 99999 values
                                  #We go from 2,659 edges to 2,099 edges
  select(ego_nid, value) %>%      #Dropping the now redundant ID column.
  rename ( Sender = `ego_nid`,    #Renaming columns to indicate directionality.
           Target = `value`)

####################################################
#   CREATING NODELIST AND SEQUENTIAL NUMERIC IDs   #
####################################################

#Step 1: Creating a Comprehensive Nodelist
AHS_Nodes <- AHS_Edges %>% 
  gather(Alter_Label, value, Sender, Target,
         na.rm = TRUE) %>%
  #Step 2: Dropping the old column headers
  select(value) %>%
  #Step 3: Renaming value ego_nid to merge in attributes
  rename(ego_nid = `value`)

#Step 4: Getting Rid of Duplicates
AHS_Nodes <- AHS_Nodes %>%
  distinct(ego_nid)

#Step 5: Creating Numeric IDs because there are gaps
#in the sequence of ID numbers which can cause errors
AHS_Nodes <- AHS_Nodes %>%
  (add_rownames) %>%                                            #Getting the rownames to create sequential IDs
  rename (Sender_ID = rowname)%>%                               #Renaming rowname to Sender    
  mutate(Sender_ID = as.numeric(Sender_ID)) 

#Step 6: Merging/Joining Numeric IDs into the Edgelist
  #Renaming Variables to merge numeric IDs for Senders
  #Merging the numeric IDs for senders
  #Renamining Variable for Targets
  #Merging the numeric IDs for targets

#Renaming ego_nid to Sender in order to merge with the
#Edgelist
AHS_Nodes <- AHS_Nodes %>%
  rename(Sender = `ego_nid`)

#Joining Sequential Numeric ID for Senders
AHS_Edges <- AHS_Edges %>%
  left_join(AHS_Nodes, by = c("Sender"))

#Renaming Sender to Target and Sender_ID to Target_ID,
#so we can merge our sequential numeric IDs
AHS_Nodes <- AHS_Nodes %>%
  rename(Target = `Sender`,
         Target_ID = `Sender_ID`)

#Merging Sequential Numeric IDs for Targets
AHS_Edges <- AHS_Edges %>%
  left_join(AHS_Nodes, by = c("Target"))

#Step 7: Tidying Up Our Edgelists and Nodelists

#Because we have the labels in our nodelist,
#We are going to drop our old node labels to avoid
#inducing errors based in gaps in the IDs
AHS_Edges <- AHS_Edges %>%
  select(Sender_ID, Target_ID)  %>%
  rename(Sender = `Sender_ID`,
         Target = `Target_ID`)

#Relabeling Target and Target_ID back to ego_nid and ID
AHS_Nodes <- AHS_Nodes %>%
  rename (ego_nid = `Target`,
          ID = `Target_ID`)

##########################
#   MERGING ATTRIBUTES   #
##########################

AHS_Attributes <- AHS_WPVAR %>%
  #Step 1: Selecting the Variables of Interest
  select(commcnt, ego_nid, sex, grade, race5) %>%
  #Step 2: Flitering to retain only community 7
  filter(commcnt == 7)

#Step 3: Merging/Joining Attributes with the Nodes File
AHS_Nodes <- AHS_Nodes %>%
  left_join(AHS_Attributes, by = c("ego_nid"))

#We are doing a left_join because we only want 
#attributes for vertices(nodes) that appear in our 
#network
    
#Step 4: Tidying: Removing Non-essential data sets
rm(AHS_Attributes)

save(AHS_Edges,file="AHS_Edges.Rda")
save(AHS_Nodes, file="AHS_Nodes.Rda")

################################################
#   Constructing and Visualizing the Network   #
################################################

#Step 1: Formatting Sender and Target Variables to Construct a Statnet Network Object
AHS_Edges[,1]=as.character(AHS_Edges[,1])
AHS_Edges[,2]=as.character(AHS_Edges[,2])

#Step 2: Creating a Network Object
#Note, this is a directed graph. So, we specify that in the network object now. 
#The specification of the graph as either directed or undirected is important because it impacts fundamentally how we interpret the relationships described by the graph.
AHS_Network=network(AHS_Edges,matrix.type="edgelist",directed=TRUE) 

AHS_Network

#Step 3: Calculating Network Measures to Create Network Attributes for Visualization Purposes, More on the Measures Soon
Eigen <- evcent(AHS_Network)                          #Computing the eigenvector centrality of each node
InDegree <- degree(AHS_Network, cmode="indegree")     #Computing the in-degree of each node
InDegree <- InDegree * .15                            #Scaling in-degree to avoid high in-degree nodes from crowding out the rest of the nodes

#Step 4: Creating Network Attributes
  #Specifying Colors for Gender and Race
  AHS_Nodes <- AHS_Nodes %>% 
    mutate (Color_Female = ifelse(sex == 2, 'red', ifelse(sex != 2, 'black', 'black')))

  AHS_Nodes <- AHS_Nodes %>% 
    mutate (Color_Race = ifelse(race5 == 0, 'gold', ifelse(race5 == 1, 'chartreuse4', 
          ifelse(race5 == 2, 'blue1', ifelse(race5 == 3, 'brown', ifelse(race5 == 4, 'purple', 'gray0'))))))

  #Creating Vectors to Assign as Attributes to the Network
  Gender <- as.vector(AHS_Nodes$sex)  
  Race <- as.vector(AHS_Nodes$race5)  
  Color_Race <- as.vector(AHS_Nodes$Color_Race)          #Important: 2d network Plots require a vector for an attribute
  Color_Female <- as.vector(AHS_Nodes$Color_Female) 

  #Assigning Attributes to Vertices
  set.vertex.attribute(AHS_Network,"Gender",Gender)
  set.vertex.attribute(AHS_Network,"Race",Race)
  set.vertex.attribute(AHS_Network,"Color_Race",Color_Race)
  set.vertex.attribute(AHS_Network,"Color_Female",Color_Female)
  set.vertex.attribute(AHS_Network, "InDegree", InDegree)

#Step 5: Visualizing the Network
AHS_Network
summary(AHS_Network)                                        #Get numerical summaries of the network
  
set.seed(12345)
ggnetwork(AHS_Network) %>%
    ggplot(aes(x = x, y = y, xend = xend, yend = yend)) + 
    geom_edges(color = "lightgray") +
    geom_nodes(color = Color_Race, size = InDegree) +       
    #geom_nodelabel_repel (color = Race, label = Race) +#   For networks with fewer nodes, we might want to label
    theme_blank() + 
    geom_density_2d()

############################
#   FUNDAMENTAL CONCEPTS   #
############################

#Node: An entity such as an social actor, firm, or organism. 
#Nodes can represent almost anything, as long as there is some meaningful set of relationships between the entities.

#Edge: A relationship between a pair of nodes where the relationship is nondirectional (e.g., kinship relationships or co-memberships in organizations).
#Arc: A directed relationship such as friendships. I can be friends with Joe, but Joe may not necessarily be my friend. Sad for me.

#Graph: A set of nodes and edges. The relationships are nondirectional and dichotomous (We are either kin or not.)
#Di-Graph: A set of nodes and arcs. The relationships are directional and can either be dichotomous or weighted. 

#Network: A graph or di-graph where the nodes have attributes assigned to them such as names, genders, or sizes. 

#Basic Measures
  #Network Size: We also know this from the number of obsevations in the Nodelist
  network.size(AHS_Network)

  #Number of Edges: Corresponds to the number of observations in the edgelist
  network.edgecount(AHS_Network) 

  #Number of Dyads (Node Pairs)
  network.dyadcount(AHS_Network) 

#############################
#   SYSTEM LEVEL MEASURES   #
#############################

#Density: The ratio of Observed Ties/All Possible Ties
gden(AHS_Network, mode = 'digraph')

#Degree Distribution
#Calculating In-Degree and Out-Degree to Visualize the Total Degree Distribution: What is the distribution of Connectiveness?
InDegree <- degree(AHS_Network, cmode="indegree")     #Computing the in-degree of each node
OutDegree <- degree(AHS_Network, cmode="outdegree")   #Computing the out-degree of each node

par(mar = rep(2, 4))
par(mfrow=c(2,2)) # Set up a 2x2 display
hist(InDegree, xlab="Indegree", main="In-Degree Distribution", prob=FALSE)
hist(OutDegree, xlab="Outdegree", main="Out-Degree Distribution", prob=FALSE)
hist(InDegree+OutDegree, xlab="Total Degree", main="Total Degree Distribution", prob=FALSE)
par(mfrow=c(1,1)) # Restore display

#Average Path Length 
  #Walks: A walk is a sequence of nodes and ties, starting and ending with nodes, in which each node is incident with the edges
        #...following and preceding it in the sequence (Wasserman and Faust 1994, p. 105).
        # The beginning and ending node of a walk may be differeent, some nodes may be included more than once, and some ties may be included more than once.
  #Paths: A path is a walk where all the nodes and all the ties are distinct.
  #A shortest path between two nodes is refrred to as a geodesic (Wasserman and Faust 1994, p. 110)
  #Average path length or the geodesic distance is the average number of steps along the shortest paths for all possible pairs of nodes.

# By default, nodes that cannot reach each other have a geodesic distance of infinity. 
# Because, Inf is the constant for infinity, we need to replace INF values to calculate the shortest path length.
# Here we replace infinity values with 0 for visualization purposes.

AHS_Geo <- geodist(AHS_Network, inf.replace=0)
#AHS_Geo <- geodist(AHS_Network)                #Matrix with Infinity
(AHS_Geo)

#The length of the shortest path for all pairs of nodes.
AHS_Geo$gdist 

#The number of shortest path for all pairs of nodes.
AHS_Geo$counts  

#Shortest Path Matrix
Geo_Dist = AHS_Geo$gdist
hist(Geo_Dist)

#For non-zero paths, we see the distirubtion is approximately centered around 4.5.
#If we compare to iGraph's reported value of 4.496353, this seems reasonable.

#average.path.length(AHS_Graph, directed=TRUE, unconnected=TRUE)

#Global Clustering Coefficient: Transitivity
#Transitivity: A triad involving actors i, j, and k is transitive if whenever i --> j and j --> k then i --> k (Wasserman and Faust 1994, p. 243)
gtrans(AHS_Network)
  #Weak and Weak Census
  #Weak transitivity is the most common understanding, the one reflected in Wasserman's and Faust's definition.
  #When 'weak' is specified as the measure, R returns the fraction of potentially intransitive triads obeying the weak condition
  #Transitive Triads/Transtive and Intransitive Triads.
  #In contrast, when 'weak census' is specfified, R returns the count of transitive triads.
  gtrans(AHS_Network, mode='digraph', measure='weak')
  gtrans(AHS_Network, mode='digraph', measure='weakcensus')

#CUG (Conditional Uniform Graph) Tests:  IS this Graph More Clustered than We Would Expect by Chance
#See Wasserman and Faust 1994, p. 543-545 for more information.
#Note: These tests are somewhat computationally intensive.
    #Conducting these tests, we find that athough the transitivity is higher than would be expect by chance given the network's size;
    #...it is not greater than would be expected given either the number of edges or dyads.
  
  #Test transitivity against size
  Cug_Size <- cug.test(AHS_Network,gtrans,cmode="size")
  plot(Cug_Size)

 #Test transitivity against density
  Cug_Edges <- cug.test(AHS_Network,gtrans,cmode="edges")
  plot(Cug_Edges)
  
  #Test Transitivity against the Dyad Census
  Cug_Dyad <- cug.test(AHS_Network,gtrans,cmode="dyad.census")
  plot(Cug_Dyad)

###########################
#   MESO-LEVEL MEASURES   #
###########################

#Dyads
  #Null-Dyads: Pairs of nodes with no arcs between them
  #Asymmetric dyads: Pairs of nodes that have an arc between the two nodes going in one direction or the other, but not both
  #Mutual/Symmetric Dyad: Pairs of nodes that have arcs going to and from both nodes  <--> 
  
#Number of Symmetric Dyads
mutuality(AHS_Network)

#Dyadic Ratio: Ratio of Dyads where (i,j)==(j,i) to all Dyads
grecip(AHS_Network, measure="dyadic")

#Edgwise Ratio: Ratio of Reciprocated Edges to All Edges
grecip(AHS_Network, measure="edgewise")

#Directed Triad Census
#Triads can be in Four States
  #Empty: A, B, C
  #An Edge: A -> B, C
  #A Star (2 Edges): A->B->C
  #Closed: A->B->C->A

#Triad types (per Davis & Leinhardt):
  #003  A, B, C, empty triad.
  #012  A->B, C 
  #102  A<->B, C  
  #021D A<-B->C 
  #021U A->B<-C 
  #021C A->B->C
  #111D A<->B<-C
  #111U A<->B->C
  #030T A->B<-C, A->C
  #030C A<-B<-C, A->C.
  #201  A<->B<->C.
  #120D A<-B->C, A<->C.
  #120U A->B<-C, A<->C.
  #120C A->B->C, A<->C.
  #210  A->B<->C, A<->C.
  #300  A<->B<->C, A<->C, completely connected.

triad.census(AHS_Network)

#Hierarchy Measures: Components,Cut Points, K-Cores, and Cliques
  #Components: Components are maximally connected subgraphs (Wasserman and Faust 1994, p. 109). 
  #Recall that community 7 has two large components and several small dyads and triads.
  #There are two types of components: strong and weak.
    #Strong components are components connected through directed paths (i --> j, j --> i)
    #Weak components are components connected through semi-paths (--> i <-- j --> k)
  components(AHS_Network, connected="strong")
  components(AHS_Network, connected="weak")
  
  #Which node belongs to which component?
  AHS_Comp <- component.dist(AHS_Network, connected="strong")
  
  AHS_Comp$membership # The component each node belongs to
  AHS_Comp$csize      # The size of each component
  AHS_Comp$cdist      # The distribution of component sizes
  
  #Cut-Sets and Cut-Points: Cut-sets describe the connectivity of the graph based on the removal of nodes, while cut-points describe
  #...the connectivity of the graph based on the removal of lines (Harary 1969)
  #k refers to the number of nodes or lines that would need to be removed to reduce the graph to a disconnected state.
  cutpoints(AHS_Network, connected="strong")
  gplot(AHS_Network,vertex.col=2+cutpoints(AHS_Network,mode="graph",return.indicator=T))
    #The plot only shows subgraphs consisting of nodes with a degree of 2 or more.
    #The green nodes indicate cut-ponts where the removal of the node would separate one subgraph from another.
  
    #Let's remove one of the cutpoints and count components again.
    AHS_Cut <- AHS_Network[-11,-11]
    #"-11" selects all the elments in the first row/column.
    #So, AHS_Cut will be AHS_Network with node 1 removed.
    
    components(AHS_Cut, connected="strong")  #There are 74 strong components in AHS_Cut compared to 73 in AHS_Network
    
    #Bi-Components: Bi-Components refer to subgraphs that require at least the removal of two nodes or two lines to transform it into a 
    #...disconnected set of nodes. 
    #In large highly connected networks, we frequently analyze the properties of the largest bi-component to get a better understanding
    #...of the social system represented by the network.
    bicomponent.dist(AHS_Network) 
    
  #Identify Cohesive Subgroups
    #K-Cores: A k-core is a subgraph in which each node is adjacent to at least a minimum number of, k, to the other nodes in the subgraph.
    #..., while a k-plex specifies the acceptable number of lines that can be absent from each node (Wasserman and Faust 1994, p. 266). 
  kcores(AHS_Network) 
  #Show the nesting of cores
  AHS_kc<-kcores(AHS_Network,cmode="indegree")
  gplot(AHS_Network,vertex.col=rainbow(max(AHS_kc)+1)[AHS_kc+1])

  #Now, showing members of the 4-core only (All Nodes Have to Have a Degree of 4)
  gplot(AHS_Network[AHS_kc>3,AHS_kc>3],vertex.col=rainbow(max(AHS_kc)+1)[AHS_kc[AHS_kc>3]+1])
  
  #Cliques:  A clique is a maximally complete subgraph of three or more nodes.
  #In other words, a clique consists of a subset of nodes, all of which are adjacent to each other, and where there are no other 
  #...nodes that are also adjacent to all of the members of the clique (Luce and Perry 1949)
  
  #We need to symmetrize recover all ties between i and j.
  set.network.attribute(AHS_Network, "directed", FALSE) 
  
  #The clique census returns a list with several important elements 
  #Let's assign that list to an object we'll call AHS_Cliques.
      #The clique.comembership parameter takes values "none" (no co-membership is computed),
      #"sum" (the total number of shared cliques for each pair of nodes is computed),
      #bysize" (separate clique co-membership is computed for each clique size)
  
  AHS_Cliques <- clique.census(AHS_Network, mode = "graph", clique.comembership="sum")
  AHS_Cliques # an object that now contains the results of the clique census
  
      #The first element of the result list is clique.count: a matrix containing the number of cliques of different 
      #...sizes (size = number of nodes in the clique).
      #The first column (named Agg) gives you the total  number of cliqies of each size,
      #The rest of the columns show the number of cliques each node participates in.
  
  #Note that this includes cliques of sizes 1 & 2. We have those when the largest fully connected structure includes just 1 or 2 nodes.
  AHS_Cliques$clique.count

  #The second element is the clique co-membership matrix:
  AHS_Cliques$clique.comemb
  
  # The third element of the clique census result is a list of all found cliques:
  # (Remember that a list can have another list as its element)
  AHS_Cliques$cliques # a full list of cliques, all sizes
  
  AHS_Cliques$cliques[[1]] # cliques size 1
  AHS_Cliques$cliques[[2]] # cliques of size 2
  AHS_Cliques$cliques[[3]] # cliques of size 3
  AHS_Cliques$cliques[[4]] # cliques of size 4

###########################
#   NODE LEVEL MEASURES   #
###########################
  
#Restoring Our Directed Network
set.network.attribute(AHS_Network, "directed", TRUE) 

#Reachability
#An actor is "reachable" by another if there exists any set of connections by which we can trace from the source to the target actor, 
#regardless of how many other nodes fall between them (Wasserman and Faust 1994, p. 132).
#If the network is a directed network, then it possible for actor i to be able to reach actor j, but for j not to be able to reach i.
#We can classify how connected one node is to another by considering the types of paths connecting them.
  #Weakly Connected: The nodes are connected by a semi-path (--> i <--- j ---> k)
  #Unilaterally Connected: The nodes are connected by a path (i --> j --> k)
  #Strongly Connected: The nodes are connected by a path from i to k and a path from k to i.
  #Recursively Connected: The nodes are strongly connected, and the nodes along the path from i to k and from k to i are the same in reverse order.
    #e.g., i <--> j <--> k 
  
#Interpreting the reachability matrix, the first column indicates a specific node, the second an alter (alters can occur multiple times),
#and the third column indicates the number of paths connecting the two (total is a cumulative count of the number of paths in the network).
#For example, interpreting row 2, node 2 can reach node 235 through 235 paths (470-235), whereas in the middle of the list node 343 can reach node 1 through only 1 path.
reachability(AHS_Network) 
??reachablity #For more information on this measure

#Degree Centraltiy: Total, In-Degree, Out-Degree
  
  #In-Degree Centrality: The number of nodes adjacent to node i (Wasserman and Faust 1994, p. 126). i <--
  InDegree <- degree(AHS_Network, cmode="indegree")
  InDegree <- InDegree * .15                #Scaling in-degree to avoid high in-degree nodes from crowding out the rest of the nodes
  
  set.vertex.attribute(AHS_Network, "InDegree", InDegree)
  
  #Out-Degree Centrality: The number of nodes adjacent from node i (Wasserman and Faust, p. 126). i -->
  OutDegree <- degree(AHS_Network, cmode="outdegree")
  OutDegree <- OutDegree * .5                 #Scaling in-degree to avoid high in-degree nodes from crowding out the rest of the nodes
  
  set.vertex.attribute(AHS_Network, "OutDegree", OutDegree)
  
  #Total Degree Centrality: The Total Number of Adjacent Nodes (In-Degree + Out-Degree)
  TotalDegree <- OutDegree + InDegree
  TotalDegree <- TotalDegree * .4
  
  set.vertex.attribute(AHS_Network, "TotalDegree", TotalDegree)
  
  #Try Sizing by the Different Degrees
  set.seed(12345)
  ggnetwork(AHS_Network) %>%
    ggplot(aes(x = x, y = y, xend = xend, yend = yend)) + 
    geom_edges(color = "lightgray") +
    geom_nodes(color = Color_Race, size = InDegree) +       
    #geom_nodelabel_repel (color = Race, label = Race) +#   For networks with fewer nodes, we might want to label
    theme_blank() + 
    geom_density_2d()

#Path Centralities: Closeness Centrality, Information Centrality, Betweenness Centrality
  
  #Closeness Centrality: Closeness centrality measures the geodesic distances of node i to all other nodes.
  #Functionally, this measures range from 0 to 1, and is the inverse average distance between actor i and all other actors (Wasserman and Faust 1994, p. 185)
  #This measure does not work well when there are disconnected components because the distances between components cannot be summed as
  #...they are technically infinite. There are several work arounds, see Acton and Jasny's alternative below.
  
  AHS_Closeness <- closeness(AHS_Network, gmode="digraph", cmode="directed")
  AHS_Closeness
  hist(AHS_Closeness , xlab="Closness", prob=TRUE) 

  #Alternative Approach to Measuring Closesness from the Geodesic Distances Matrix from Acton's and Jasny's Statnet Tutorial
  Closeness <- function(x){ # Create an alternate closeness function!
    geo <- 1/geodist(x)$gdist # Get the matrix of 1/geodesic distance
    diag(geo) <- 0 # Define self-ties as 0
    apply(geo, 1, sum) # Return sum(1/geodist) for each vertex
  }
  
  Closeness <-  Closeness(AHS_Network)                        #Applying the function
  Closeness
  hist( Closeness , xlab="Alt. Closeness", prob=TRUE)         #Better behaved!
  
  #Information Centrality: Information Centrality measures the information flowing from node i.
  #In general, actors with higher information centrality are predicted to have greater control over the flow of information within a network.
  #Highly information-central individuals tend to have a large number of short paths to many others within the social structure.
  ?infocent  #For more information
  
  AHS_Info <- infocent(AHS_Network, rescale=TRUE)
  AHS_Info
  hist(AHS_Info , xlab="Information Centrality", prob=TRUE) 
  
  gplot(AHS_Network, vertex.cex=(AHS_Info)*250, gmode="graph") # Use w/gplot
  #As suggested by the histogram there is relatively little variation in information centrality in this graph.
  
  #Betweenness Centrality: The basic intuition behind Betweenness Centrality is that the actor between all the other actors in the 
  #...has some control over the paths in the network. 
  #Functionally, Betweenness Centrality is the ratio of the sum of all shortest paths linking j and k that includes node i over 
  #...all the shortest paths linking j and k (Wasserman and Faust 1994, p. 191)
  
  AHS_Betweenness <- betweenness(AHS_Network, gmode="digraph")  
  AHS_Betweenness
  hist(AHS_Betweenness , xlab="Betweenness Centrality", prob=TRUE) 
  
  gplot(AHS_Network, vertex.cex=sqrt(AHS_Betweenness)/25, gmode="digraph") 
  
  #Comparing Closeness and Betweenness Centralities
  cor(Closeness, AHS_Betweenness)                             #Correlate our adjusted measure of closeness with betweenness
  plot(Closeness, AHS_Betweenness)                            #Plot the bivariate relationship
  
#Measures of Power in Influence Networks: Bonachich and Eigenvector Centrality
  
  #Bonachich Centrality: The intuition behind Bonachich Power Centrality is that the power of node i is recursively defined 
  #...by the sum of the power of its alters. 
  #The nature of the recursion involved is then controlled by the power exponent: positive values imply that vertices become 
  #...more powerful as their alters become more powerful (as occurs in cooperative relations), while negative values imply 
  #...that vertices become more powerful only as their alters become weaker (as occurs in competitive or antagonistic relations).
  ?bonpow   #For more information about the measure
  
  #Eigenvector Centrality: Conceptually, the logic behind eigenvectory centrality is that node i's influence is proportional to the 
  #...to the centraltities' of the nodes adjacent to node i. In other words, we are important because we know highly connected people.
  #Mathematically, we capture this concept by calculating the values of the first eigenvector of the graph's adjacency matrix.
  ?evcent   #For more information.
  
  AHS_Eigen <- evcent(AHS_Network)
  AHS_Eigen
  hist(AHS_Eigen , xlab="Eigenvector Centrality", prob=TRUE) 
  
  gplot(AHS_Network, vertex.cex=AHS_Eigen*10, gmode="digraph") 
  
#Adding Network Attributes to the Node List
AHS_NodeList<- cbind(AHS_NodeList, AHS_Betweenness, AHS_Closeness, AHS_Info, Eigen, InDegree, OutDegree)

###########################
#   POSITIONAL ANALYSIS   #
###########################
#Burt's (1992) measures of structural holes are supported by iGraph and ego network variants of these measures are supported by egonet
#...the egonet package is compatable with the sna package.
  
#You can find descriptions and code to run Burt's measures in igraph at: http://igraph.org/r/doc/constraint.html
  
  #Brokerage: The brokerage measure included in the SNA package builds on past work on borkerage (Marsden 1982), but is a more 
  #...explicitly group oriented measure. Unlike Burt's (1992) measure, the Gould-Fernandez measure requires specifying a group variable
  #...based on an attribute. I use race in the example below.
  
    #Brokerage Roles: Group-Based Concept
    #w_I: Coordinator Role (Mediates Within Group Contact)
    #w_O: Itinerant Broker Role (Mediates Contact between Individuals in a group to which the actor does not belong)
    #b_{IO}: Representative: (Mediates incoming contact from out-group members)
    #b_{OI}: Gatekeeper: (Mediates outgoing contact from in-group members)
    #b_O: Liason Role: (Mediates contact between individuals of two differnt groups, neither of which the actor belongs)
    #t: Total or Cumulative Brokerage (Any of the above paths)
  ?brokerage   #for more information
  
  AHS_Brokerage <- brokerage(AHS_Network, Race)
  AHS_Brokerage
  hist(AHS_Brokerage$cl, xlab="Cumulative Brokerage", prob=TRUE) 
  
  AHS_CBrokerage <- (AHS_Brokerage$cl)
  gplot(AHS_Network, vertex.cex=AHS_CBrokerage*.5, gmode="digraph") 
  
#Jimi Adams's Function for Calculating Effective Size
  #Effective size is the average degree of ego network without counting alters' ties to ego 
  
  #Detaching to ensure that Statnet and iGraph do not conflict
  detach("package:sna", unload=TRUE)
  library(igraph)
  
  #Loading Example Data
  load("Flo_Edges.Rda")
  load("Flo_Nodes.Rda")
  
  g=graph.data.frame(Flo_Edges)
  V(g)$ego=as.character(Flo_Nodes$ego[match(V(g)$name,Flo_Nodes$ID)])
  V(g)
  plot(g, vertex.label=Flo_Nodes$ego, 
       edge.arrow.size=.05, edge.arrow.width=.05,
       vertex.size=degree(g,mode = "in"))
  
  effective.size <- function(g, ego, mode="all") {		# igraph doesn't have an "effective size" command
    n <- degree(g, mode=mode)[ego]						        # ego's degree
    es <- n												                    # initializing effective size
    ns <- neighbors(g,ego, mode=mode)					        # identifying ego's neighborhood
    if(n>0){
      for (j in 1:n){									                # looping over everyone in ns
        nsns <- neighbors(g,ns[j], mode=mode)		      # finding neighbors' neighbors
        r <- length(intersect(ns, nsns))			        # only those also in ego's neighborhood
        es <- es - (r/n)							                # subtracting redundancies
      }
    }
    return(es)
  }
  
  effective.size(g, "9", mode="all")
  
  #Trying on Our School Networks
  AHS_Graph=graph.data.frame(AHS_Edges)
  effective.size(AHS_Graph, "1", mode="all")
  
#Jimi Adams's Function for Calculating the Index of Qualitative Variatio
  #The index of qualitative variation (IQV) is a measure of variation among the categories
  #of a qualitative variable.  
  #It is calculated as [1 - sum(p2)]  * [K / (K - 1)], 
  #where p is the proportion in each category, and K is the number of categories. 
  #The variable ranges from 0 to 1, where 0 represents a completely homogeneous group,
  #and 1 represents a group with equal parts in each category.
  
  iqv <- function(graph, attribute) {
    N <- length(V(graph))
    cats <- unique(get.vertex.attribute(graph,attribute,V(graph)))
    nlev <- length(cats)
    cat_list <- rep(0,N)
    p <- rep(0, N) 
    p2_list <- as.list(0)
    for (j in 1:nlev) {
      for(i in 1:length(V(graph))){
        i_att <- get.vertex.attribute(graph, attribute, V(graph)[neighborhood(graph,1)[[i]]]) 
        att <- length(which(i_att==cats[j]))
        num <- length(V(graph)[neighborhood(graph, 1)[[i]]])
        p[i]<-att/num
        p2<-p*p
      }
      p2_list[[j]] <- p2
      cat_list <- cat_list + p2
    }
    IQV <- (nlev/(nlev-1))*(1-cat_list)
    IQV1 <- as.list(0)
    IQV1[[2]] <- IQV
    IQV1[[1]] <- mean(IQV)
    names(IQV1) <- c("full_graph", "egonet")
    return (IQV1)
  } 
  
  #Assigning Attributes
  AHS_Graph <- AHS_Graph %>%
    set_vertex_attr("sex", value = AHS_Nodes$sex) %>%
    set_vertex_attr("grade", value = AHS_Nodes$grade)
  
  V(AHS_Graph)
  
  #This function takes some time to calculate for a network of this size
  #because you are calculating the variation ratio for each person 
  #in a passed complete network, for a single attribute at a time.
  iqv(AHS_Graph, "sex")
  
#Detaching to ensure that Statnet and iGraph do not conflict
  detach("package:igraph", unload=TRUE)
  library(sna)

#Structural Equivalence
  #Structural equivalence: Similarity/Distance Measures Include:
    #Correlation
    #Euclidean Distance
    #Hamming Distance
    #Gamma Correlation
  sedist(AHS_Network, mode="digraph", method="hamming")
  
  #Cluster based on structural equivalence:
  AHS_Clustering <- equiv.clust(AHS_Network, mode="digraph",plabels=network.vertex.names(AHS_Network))
  AHS_Clustering                        #Specification of the equivalence method used
  plot(AHS_Clustering)                  #Plot the dendrogram
  rect.hclust(AHS_Clustering$cluster, h=30)
  
  #Generating a Block Model based on the Structural Equivalence Clustering
  AHS_BM <- blockmodel(AHS_Network, AHS_Clustering, h=30)
  AHS_BM
    
  #Extract the block image for Visualization
  bimage <- AHS_BM$block.model
  bimage
  bimage[is.nan(bimage)] <- 1
  
  #Visualizing the block image (with self-reflexive ties)
  gplot(bimage, diag=TRUE, edge.lwd=bimage*5, vertex.cex=sqrt(table(AHS_BM$block.membership))/2,
        gmode="graph", vertex.sides=50, vertex.col=gray(1-diag(bimage)))
  