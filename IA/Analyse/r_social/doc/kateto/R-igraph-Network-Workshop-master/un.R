
library("animation") 
library("igraph") 
library("network") 
library("sna")
library("visNetwork")
library("threejs")
library("networkD3")
library("ndtv")
library("ergm")

data(short.stergm.sim)
short.stergm.sim 
head(as.data.frame(short.stergm.sim))

compute.animation(net3.dyn, animation.mode = "kamadakawai",
                  slice.par=list(start=0, end=50, interval=1, 
                                 aggregate.dur=1, rule='any'))

render.d3movie(net3.dyn, usearrows = F, 
               displaylabels = F, label=net3 %v% "media",
               bg="#ffffff", vertex.border="#333333",
               vertex.cex = degree(net3)/2,  
               vertex.col = net3.dyn %v% "col",
               edge.lwd = (net3.dyn %e% "weight")/3, 
               edge.col = '#55555599',
               vertex.tooltip = paste("<b>Name:</b>", (net3.dyn %v% "media") , "<br>",
                                      "<b>Type:</b>", (net3.dyn %v% "type.label")),
               edge.tooltip = paste("<b>Edge type:</b>", (net3.dyn %e% "type"), "<br>", 
                                    "<b>Edge weight:</b>", (net3.dyn %e% "weight" ) ),
               launchBrowser=T, filename="Media-Network-Dynamic.html",
               render.par=list(tween.frames = 30, show.time = F),
               plot.par=list(mar=c(0,0,0,0)), output.mode='inline' )
# 