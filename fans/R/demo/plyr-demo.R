#http://cos.name/cn/topic/107434#post-234333
# 问题如下：
# 问题1：如何按照x列的变量名对y列的数据求和，即所有与a1同行的数据（1828 1828 1793 1736）求和，依次类推，按照a2，a3和a4分组求和
# 问题2：如何按照x列的变量名分组，求每组第一个数据与最后一个数据的差？以a1为例，求1736-1828的值，以此类推，把整个数据框分组求差。

dat = read.table(textConnection(
'x     y
 a1    1828
 a1    1828
 a1    1793
 a1    1736
 a2    1679
 a2    1599
 a2    1507
 a3    1162
 a3    1199
 a3    921
 a3    832
 a3    514.6
 a4    432.4
 a4    290.7
 a4    149.6
'), header = TRUE)

aggregate(dat[-1], by = list(dat$x), sum)
minus = function(x) return(x[length(x)] - x[1])
# aggregate(dat[-1], by = list(dat$x), minus)
system.time(for (i in 1:10000) invisible(aggregate(dat[-1], by = list(dat$x), minus)))

minus = function(x) tail(x, 1) - head(x, 1)
system.time(for (i in 1:10000) invisible(aggregate(dat[-1], by = list(dat$x), minus)))

library(plyr)
minus = function(x) tail(x, 1) - head(x, 1)
# ddply(dat,"x",summarise,toal=sum(y),differ=minus(y))
system.time(for (i in 1:10000) invisible(ddply(dat, 'x', summarise, differ = minus(y))))

# 读文本
txt<-scan(file="_train_1.dat",what='character',sep="\n")
a<-str_c(txt,sep="",collapse="")
str_count(a,':9')


dat = read.table(textConnection(
'ID value
 1 4
 1 7
 2 8
 2 3
 2 3
'), header = TRUE)

aggregate(dat[-1],by=list(ID=dat$ID),sum)
