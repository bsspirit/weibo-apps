#聚类算法
x<-c(1,2,6,8,11)
dim(x)<-c(5,1)
d<-dist(x)

hc1<-hclust(d,"single")
hc2<-hclust(d,"complete")
hc3<-hclust(d,"median")
hc4<-hclust(d,"mcquitty")

opar<-par(mfrow=c(2,2))
plot(hc1,hang=-1);
plot(hc2,hang=-1);
plot(hc3,hang=-1);
plot(hc4,hang=-1);
par(opar)
