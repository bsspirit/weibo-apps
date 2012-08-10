#http://en.wikibooks.org/wiki/Data_Mining_Algorithms_In_R/Classification/SVM
#http://planatscher.net/svmtut/svmtut.html


#http://www.cnblogs.com/zgw21cn/archive/2009/04/14/1435877.html
#install.packages('e1071',dependencies=TRUE)
# library(e1071)
# model<-svm(Species~. , data = iris, method="C-classification", kernel="radial",cost=100,gamma=0.1)
# summary(model)
# #png(file="svm1.png")
# plot(model,iris,Petal.Width~Petal.Length,slice = list(Sepal.Width=3,Sepal.Length=5))
#dev.off();
#png(file="svm2.png")
#plot(iris)
#dev.off();

#install.packages("klaR")
# library("klaR")
# data("B3")
# Bmod <-svmlight(PHASEN ~ ., data = B3)#, svm.options = "-t 2 -g 0.1")
# predict(Bmod, B3[c(4, 9, 30, 60, 80, 120),-1])


# library(MASS)
# data(cats)
# model<-svm(Sex~.,data=cats)
# print(model)
# summary(model)
# plot(model,cats)
# 
# index <- 1:nrow(cats)
# testindex <- sample(index, trunc(length(index)/3))
# testset <- cats[testindex,]
# trainset <- cats[-testindex,]
# 
# model <- svm(Sex~., data = trainset)
# prediction <- predict(model, testset[,-1])
# 
# tab <- table(pred = prediction, true = testset[,1])
# classAgreement(tab)
# 
# tuned <- tune.svm(Sex~., data = trainset, gamma = 10^(-6:-1), cost = 10^(1:2))
# summary(tuned)
# plot(tuned,cats)

# install.packages("plotrix")
# library(plotrix)
# plot(1:5,seq(1,10,length=5),type="n",xlab="",ylab="",main="Test draw.circle")
# draw.circle(4,4,1,border="purple",lty=1,lwd=1)
# draw.circle(2.5,8,0.6,border="red",lty=3,lwd=3)

library(e1071)
z=seq(0, 2*pi,length=200)
x=jitter(sin(z),1,0.05)
y=jitter(cos(z),1,0.05)

x2=jitter(sin(z),1,0.05)*2
y2=jitter(cos(z),1,0.05)*2
png(file="svm-cricle1.png")
plot(x,y,cex=0.6,col="red",xlim=c(-2,2),ylim=c(-2,2))
points(x2,y2,cex=0.6,col="blue")
dev.off();

png(file="svm-cricle2.png")
df<-data.frame(x=c(x,x2),y=c(y,y2))
data<-cbind(df,c=c(rep(1,200),rep(2,200)))
model<-svm(c~. , data = data, type="C-classification", kernel="radial",cost=100,gamma=0.1)
summary(model)
plot(model,data,x~y)
dev.off();

# model<-svm(c~.,data=data,type="eps-regression",kernel="linear")
# summary(model)
# plot(model,data)



# library(e1071)
# model<-svm(c~. , data = iris, method="C-classification", kernel="radial",cost=100,gamma=0.1)
# summary(model)
#png(file="svm1.png")
#plot(model,iris,Petal.Width~Petal.Length,slice = list(Sepal.Width=3,Sepal.Length=5))











