#http://en.wikibooks.org/wiki/Data_Mining_Algorithms_In_R/Classification/SVM
#http://planatscher.net/svmtut/svmtut.html



#install.packages('e1071',dependencies=TRUE)
library(e1071)
# data(iris)
# model<-svm(Species~.,data=iris)
# print(model)
# summary(model)
# plot(model,iris)

library(MASS)
data(cats)
model<-svm(Sex~.,data=cats)
print(model)
summary(model)
plot(model,cats)

index <- 1:nrow(cats)
testindex <- sample(index, trunc(length(index)/3))
testset <- cats[testindex,]
trainset <- cats[-testindex,]

model <- svm(Sex~., data = trainset)
prediction <- predict(model, testset[,-1])

tab <- table(pred = prediction, true = testset[,1])
classAgreement(tab)

tuned <- tune.svm(Sex~., data = trainset, gamma = 10^(-6:-1), cost = 10^(1:2))
summary(tuned)
plot(tuned,cats)

