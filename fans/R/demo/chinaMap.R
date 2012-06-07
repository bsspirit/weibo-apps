#http://yihui.name/cn/2007/09/china-map-at-province-level/
#http://cos.name/2009/07/drawing-china-map-using-r/
#http://flowingdata.com/2011/05/11/how-to-map-connections-with-great-circles/

library(maps)
library(mapdata)
library(maptools)

x<-readShapePoly('data/bou2_4p.shp')
## plot(x,col=gray(924:0/924));

## getColor=function(mapdata,provname,provcol,othercol){
## 	f=function(x,y) ifelse(x %in% y,which(y==x),0);
## 	colIndex=sapply(mapdata@data$NAME,f,provname);
## 	fg=c(othercol,provcol)[colIndex+1];
## 	return(fg);
## }

## provname=c("北京市","天津市","上海市","重庆市");
## provcol=c("red","green","yellow","purple");
## plot(x,col=getColor(x,provname,provcol,"white"));

provname=c("北京市","天津市","河北省","山西省","内蒙古自治区",
		"辽宁省","吉林省","黑龙江省","上海市","江苏省",
		"浙江省","安徽省","福建省","江西省","山东省",
		"河南省","湖北省","湖南省","广东省",
		"广西壮族自治区","海南省","重庆市","四川省","贵州省",
		"云南省","西藏自治区","陕西省","甘肃省","青海省",
		"宁夏回族自治区","新疆维吾尔自治区","台湾省",
		"香港特别行政区");
pop=c(1633,1115,6943,3393,2405,4298,2730,3824,1858,7625,
		5060,6118,3581,4368,9367,9360,5699,6355,9449,
		4768,845,2816,8127,3762,4514,284,3748,2617,
		552,610,2095,2296,693);
provcol=rgb(red=1-pop/max(pop)/2,green=1-pop/max(pop)/2,blue=0);
plot(x,col=getColor(x,provname,provcol,"white"),xlab="",ylab="");
## 
## getID=function(mapdata,provname){
## 	index=mapdata$att.data$NAME %in% provname;
## 	ids=rownames(mapdata$att.data[index,]);
## 	return(as.numeric(ids));
## }
## midchina=c("河南省","山西省","湖北省","安徽省","湖南省","江西省");
## #plot(x,recs=getID(x,midchina),col="green",ol="white",xlab="",ylab="");
## plot(x, col = getColor(x, midchina, rep("green", 6),"white"), border = "white", xlab = "", ylab = "")
