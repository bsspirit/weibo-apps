rm(list=ls())

library(RMySQL) 

conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="root", password="mysql")## 打开一个MySQL数据库的连接
fansGender <- dbGetQuery(conn, paste("select u.gender from t_user u "))
dbDisconnect(conn)#关闭连接

t <- table(fansGender$gender)
pie(t,labels=c(paste('女',t['f']/length(fansGender),'%'),paste('男',t['m']/length(fansGender),'%')),clockwise=TRUE,radius=1,border="white",col=c('red','orange'),main="我的微博粉丝性别比例")

