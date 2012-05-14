rm(list=ls())

library(RMySQL) 

conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="root", password="mysql")## 打开一个MySQL数据库的连接
fansVerifer <- dbGetQuery(conn, paste("SELECT verified FROM t_user u"))
dbDisconnect(conn)#关闭连接

len <- length(fansVerifer$verified)
t <- table(fansVerifer$verified)

labels=c(paste('V认证',round(t['t']/len*100,digits=1),'%'),paste('无认证',round(t['f']/len*100,digits=1),'%'))
pie(t,labels=labels,clockwise=TRUE,radius=1,border="white",col=c('red','orange'),main="我的微博粉丝认证比例")
print(t)
