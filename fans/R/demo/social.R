#socail network renren
#http://cos.name/2011/04/exploring-renren-social-network/
library(igraph)
# 
# people = data.frame(id = tmp1[, 4], name = tmp1[, 3])
# gg = graph.data.frame(d = tmp2, directed = F, vertices = people)
# is.simple(gg)
# gg = simplify(gg)
# ## 去掉重复的连接
# is.simple(gg)
# dg = degree(gg)
# gg = subgraph(gg, which(dg > 0) - 1)
# ## 去掉孤立点
# 
# ## png("net_simple.png", width = 500, height = 500)
# par(mar = c(0, 0, 0, 0))
# set.seed(14)
# plot(gg, layout = layout.fruchterman.reingold, vertex.size = 5, vertex.label = NA,
#      edge.color = grey(0.5), edge.arrow.mode = "-")
# ## dev.off()

# M<-matrix(round(runif(100,min=1,max=100)), nr=10 )
# g<-graph.adjacency( M >= 0.9 )
# plot(g)

# x1<-c("Alice","Alice","Alice","Alice","Bob","Bob","Bob","Cecil","Cecil","Denis")
# x2<-c("Bob","Cecil","Denis","Eszter","Cecil","Denis","Eszter","Denis","Eszter","Eszter")
# weight<-c(1,-1,1,1,-1,1,1,1,1,-1)
# df<-data.frame(x1,x2,weight)
# g <- graph.data.frame(df, directed=FALSE)
# plot(g)

traits <- read.csv("traits.csv", head=FALSE)
rel <- read.csv("relations.csv", head=FALSE)
g <- graph.empty()
g <- add.vertices(g, nrow(traits),
  name=as.character(traits[,1]), age=traits[,2],
  gender=as.character(traits[,3]))

names <- sapply(strsplit(V(g)$name, " "), "[",1)
ids <- 1:length(names)-1
names(ids) <- names
ids

from <- as.character(rel[,1])
to <- as.character(rel[,2])
edges <- matrix(c(ids[from], ids[to]), nc=2)
edges

g <- add.edges(g, t(edges), 
                 room=as.character(rel[,3]),
                 friend=rel[,4], advice=rel[,5])
g

E(g)$color <- "black"
E(g)[ room=="Y" ]$color <- "red"
tkplot(g, layout=layout.kamada.kawai, edge.color=E(g)$color)


