## install rtweet 
#install.packages("rtweet")

## load rtweet package
library(rtweet)

#visit apps.twitter.com to create a developer account and get credentials

#Set callback URL to (in settings): http://127.0.0.1:1410


## whatever name you assigned to your created app
appname <- "Computational Soc"

## api key (example below is not a real key)
key <- "cc22qSuxibolSOpBAXzYfQQHN"

## api secret (example below is not a real key)
secret <- "jWhUoG9LOjeL8UiiY5yR4hkCc8snKcjCJ8ZiMcZqDHh44FZqzp"

## create token named "twitter_token"
twitter_token <- create_token(
  app = appname,
  consumer_key = key,
  consumer_secret = secret)

#example to show it’s working
search_tweets("networks", n = 100)




# let's find some tweets about social networks
network_tweets <- search_tweets("social networks", 
  n = 1000, include_rts = FALSE)

#just for fun let's plot their frequency over time
ts_plot(network_tweets, "3 hours") +
  ggplot2::theme_minimal() +
  ggplot2::theme(plot.title = ggplot2::element_text(face = "bold")) +
  ggplot2::labs(
    x = NULL, y = NULL,
    title = "Frequency of tweets that mention social networks from past 9 days",
    subtitle = "Tweets aggregated in three-hour intervals",
    caption = "\nSource: Twitter's REST API"
  )

#grab tweets by geographic location
us_net_tweets <- search_tweets("social networks",
  "lang:en", geocode = lookup_coords("usa"), n = 1000,
  include_rts = FALSE, type="recent"
)

## geocode tweets (where available in bios/tweets)
us_net_tweets <- lat_lng(us_tweets)

## plot state boundaries
#install.packages("maps")
library(maps)
par(mar = c(0, 0, 0, 0))
maps::map("state", lwd = .25)

## plot lat and lng points onto state map
with(us_net_tweets, points(lng, lat, pch = 20, cex = .75, col = rgb(0, .3, .7, .75)))

# how to get some tweets from Christakis
christakis <- get_timelines(c("@NAChristakis"), n = 100)

#now let's build some networks using Phil Cohen's list of sociologists on twitter
lists_users("familyunequal")

#let's look at the Sociologists list
sociologists<-lists_members("54978486")

#how do we get followers?
followers<-get_followers(sociologists$screen_name[1])
details <- lookup_users(followers)

#to build the network we need to write a loop

#create empty container to store data we scrape
soc_nets<-as.data.frame(NULL)

#loop
for(i in 98:nrow(sociologists)){
  #check rate limits
  checker<-rate_limit()
  #check limits for specific query
  another_check<-checker[checker$query=="followers/ids",]
  #if limits have been reached wait fifteen minutes
  if(another_check$remaining==0){
    print("sleeping...")
    Sys.sleep(15*60)
  }
  #make sure account is not protected
  if(sociologists$protected[i]==FALSE){
  #collect followers
  followers<-get_followers(sociologists$screen_name[i])
  #get details of followers
  details <- lookup_users(followers)
  #make edgelist
  edges<-cbind(rep(sociologists$name[i], 
                  nrow(details)), details$name)
  #bind edges 
  soc_nets<-rbind(soc_nets, edges)
  #for debugging/monitoring
  print(i)
    }
}

#stopped at 185

save(soc_nets, file="Sociology Networks.Rdata")

#now drop everyone not in the sociology list

soc_nets$V2<-as.character(soc_nets$V2)
pruned<-soc_nets[(soc_nets$V2 %in% sociologists$name ),]

library(igraph)
soc_igraph<-graph.data.frame(pruned)
length(V(soc_igraph))


#calculate modularity for coloring
library(ggraph)
ggraph(soc_igraph, layout = "fr") +
  geom_node_point(color = "blue", size = 2) +
  geom_edge_link()+
  geom_node_text(aes(label = name), repel = TRUE, size=2) +
  theme_void()
