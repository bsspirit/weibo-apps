#分类器

#线性分类
library(MASS)
#lda()

#马氏距离
ma <- cbind(1:6, 1:3)
(S <-  var(ma))
mahalanobis(c(0,0), 1:2, S)

#Fisher分类
library(penalizedLDA)

#聚类分析
#hclust()