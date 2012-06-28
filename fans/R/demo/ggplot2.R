#参考30分钟学会ggplot2.pdf
library(ggplot2)
# 散点图
p<-ggplot(mtcars,aes(x=mpg,y=disp))
# p+geom_point()
# 
# summary(p)
# summary(p+geom_point())
# p+geom_point(aes(colour=factor(am),size=qsec),alpha=0.5,position="jitter")+stat_smooth()+scale_color_manual(values=c("blue","red"))+scale_size_continuous(range=c(4,10))+facet_wrap(~carb,ncol=1)

#直方图
#summary(p + geom_histogram())
#p+geom_histogram(aes(fill=factor(am),y=..density..),alpha=0.3,colour="black")+stat_density(geom="line",position="identity",size=1.5,aec=(colour=factor(am)))+facet_wrap(~am,ncol=1)

#条形图
#p2<-ggplot(mtcars,aes(x=mpg),fill=factor(am))
#p2+geom_bar(position="identity",alpha=0.5)

#饼图
#p3<-ggplot(mtcars,aes(x=factor(am), fill=factor(gear)))+geom_bar(width = 1)
#p3+coord_polar(theta="y")

#箱线图
#p4<-ggplot(mtcars,aes(mpg,disp,fill=disp))
#p4+geom_boxplot()

#散点图
#p5<-ggplot(mtcars,aes(mpg,disp))
#p5+geom_point()
#p5+stat_bin2d(bins=60)
#p5+stat_density2d(aes(fill=..level..),geom='ploygon')+coord_cartesian(xlim=c(0,45),ylim=c(0,500))+scale_fill_continuous(high="red2",low="blue4")
sink("result1.txt")
x<-1:10
y<-2:11
lm<-lm(y~x)
summary(lm)
sink()
