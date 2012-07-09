#socail network renren
#http://cos.name/2011/04/exploring-renren-social-network/
library(igraph)

# g<-graph.ring(10)
# g<-set.graph.attribute(g,"name","Ring")
# g<-set.vertex.attribute(g,"color",value=c("red","green"))
# plot(g)

# g <- graph.disjoint.union( graph.full(5), graph.full(5) )
# clu <- clusters(g)$membership
# g <- add.edges(g, c(which(clu==1), which(clu==2)))
# bc <- biconnected.components(g)

# g <- graph.atlas(1000)        
# V(g)$name <- c("Alfred","Benny","Cristina","Delphine","Emily","Frank")        
# V(g)$name <- c("Alfred","Benny","Cristina","Delphine","Emily","Frank","Gus")        
# V(g)$label <- V(g)$name
# plot(g)

data<-read.csv(file="social.csv",header=FALSE)
d<-data[order(data$V1),]
g<-graph.data.frame(d,directed=TRUE)
V(g)$name <- c("A","B","C","D","E","F")
V(g)$label <- V(g)$name
g2<-simplify(g)
plot(g2)

# swiss[order(swiss$Education, -swiss$Examination),];data


# 
# # Read the files first
# traits <- read.csv("traits.csv", head=FALSE)
# rel <- read.csv("relations.csv", head=FALSE)
# 
# # Create the graph, add the vertices
# g <- graph.empty()
# g <- add.vertices(g, nrow(traits), 
#                   name=as.character(traits[,1]), age=traits[,2],
#                   gender=as.character(traits[,3]))
# 
# # Extract first names from the full names
# names <- sapply(strsplit(V(g)$name, " "), "[",1)
# ids <- 1:length(names)-1
# names(ids) <- names
# 
# # Create the edges
# from <- as.character(rel[,1])
# to <- as.character(rel[,2])
# edges <- matrix(c(ids[from], ids[to]), nc=2)

# # Add the edges
# g2 <- add.edges(g, t(edges),
#                room=as.character(rel[,3]),
#                friend=rel[,4], advice=rel[,5])

# E(g2)$color <- "black"
# E(g2)[ room=="Y" ]$color <- "red"
# #tkplot(g, layout=layout.kamada.kawai, edge.color=E(g)$color)
# plot(g2, layout=layout.kamada.kawai, edge.color=E(g)$color)
