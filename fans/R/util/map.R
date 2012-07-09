#map util
key<-function(map,ks){
  names(map)<-c("k","v")
  for(i in 1:length(ks)){
    if(length(map[which(map$k==ks[i]),]$v)>0){
      ks[i]<-as.character(map[which(map$k==ks[i]),]$v)
    }
  }
  ks
}

# k<-c(1,2,3)
# v<-c("a","b","c")
# map<-data.frame(k,v)
# ks<-c(2,3)
# vs<-key(map,ks)