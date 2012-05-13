fansProv<-read.csv("data/fansProvinces.csv",fileEncoding="utf-8",header=F)
plot(fansProv$V2,xlab="城市",type='b',ylim=c(0,60),xaxt="n")
axis(1,labels=fansProv$V1,at=1:length(fansProv$V1))


pie(fansProv$V2,labels=fansProv$V1,clockwise=TRUE,radius=1,border="white",main="Percentage Share of Internet Browser usage")

