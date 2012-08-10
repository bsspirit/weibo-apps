#install.packages("arules")
library(arules)
# data(Groceries)
# 
# frequentsets=eclat(Groceries,parameter=list(support=0.05,maxlen=10))
# inspect(sort(frequentsets,by="support")[1:10])
# 
# rules=apriori(Groceries,parameter=list(support=0.01,confidence=0.5))
# summary(rules)
# inspect(rules)
# 
# x=subset(rules,subset=rhs%in%"whole milk"&lift>=1.2)
# inspect(sort(x,by="support"))


carts<-function(data1){
  cart<-list()
  id=0
  for(i in 1:nrow(data1)){
    #print(paste("i,id ==>",i,",",id))
    if(id==data1$id[i]){
      cart[[id]]<-c(cart[[id]],as.character(data1$item[i]))
    }else{
      id=data1$id[i]
      cart[[id]]=c(as.character(data1$item[i]))
    }
    #print(cart)
  }
  cart
}

check<-function(data,num){
  add=0
  for(i in 1:length(data)){
    if(length(which(data[[i]]==as.character(num)))>0){
      add=add+1
      print(i)
    }
  }
  print(paste("total:",add))
}

data1<-read.csv(file="data1.csv")
data<-carts(data1)

check(data,1000003585)

re1<-eclat(data,parameter=list(support=0.01,maxlen=17))
summary(re1)
inspect(sort(re1,by="support")[1:10])

rules=apriori(data,parameter=list(support=0.005,confidence=0.5))
# inspect(rules)





