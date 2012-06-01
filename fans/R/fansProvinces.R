rm(list=ls())

library(RMySQL) 

conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="root", password="mysql")## 打开一个MySQL数据库的连接
dbGetQuery(conn,'SET NAMES "gbk"')
fansProv = dbGetQuery(conn, paste(
                "select p.name,count(p.name) as count from t_user u, t_provinces p ", 
                "where u.province=p.id group by p.name order by count desc"))
dbDisconnect(conn)#关闭连接


#source("util/db.R")
#print(query)


#pie(fansProv$count,labels=fansProv$name,clockwise=TRUE,radius=1,border="white",main="我的微博粉丝分布")
barplot(fansProv$count,xlab="城市",ylim=c(0,60),xaxt="n")
axis(1,1:length(fansProv$name),fansProv$name)
print(fansProv)


## 列出数据库中表
#dbListTables(conn)
## 把一个数据框导入到数据库，删除任何已经存在的拷贝
#data(USArrests)
#> dbWriteTable(con, "arrests", USArrests, overwrite = TRUE)

#> dbListTables(con)
#[1] "arrests"
## 获得整个表
#dbReadTable(conn, "t_provinces")
## 从导入的表中查询


