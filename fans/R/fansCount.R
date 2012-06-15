#粉丝数量的回归分析

sql<-paste("SELECT uid,followers_count,friends_count,statuses_count,favourites_count,if(verified='f',0,1) as v,province,if(description='',0,1) as description,",
		"if(url='',0,1) as url,if(profile_image_url='',0,1) as image,",
        "if(domain='',0,1) as domain, if(gender='f',0,1) as gender",
        "FROM t_user")
#sql<-paste("SELECT friends_count,statuses_count,followers_count FROM t_user")

source("util/db.R")
source("MINE.r")

write.table(query,file="query.csv",col.names=TRUE,row.names=FALSE,quote=FALSE,sep=",")

#MINE("data/WHO.csv",'master.variable','3')
#rMINE(as.matrix(query),"matrix",'master.variable',2)
MINE("query.csv",'master.variable',1)


## print(query)
## 
## data.lm<-lm(followers_count~friends_count+statuses_count+favourites_count+v+gender+province+description+url+image+domain,data=query)
## summary(data.lm)
## 
## data.new<-lm(followers_count~friends_count+statuses_count+domain,data=query)
## summary(data.new)
## 
## data.pred<-predict(data.new,data.frame(friends_count=200,statuses_count=485,domain=1),interval="prediction",level=0.95)
## data.pred
