药品的数据集分析
========================================================



```r
# install.packages('arules')
library(arules)
```

```
## Loading required package: Matrix
```

```
## Loading required package: lattice
```

```
## Attaching package: 'Matrix'
```

```
## The following object(s) are masked from 'package:base':
## 
## det
```

```
## Attaching package: 'arules'
```

```
## The following object(s) are masked from 'package:base':
## 
## %in%
```

```r

carts <- function(data1) {
    cart <- list()
    id = 0
    for (i in 1:nrow(data1)) {
        if (id == data1$id[i]) {
            cart[[id]] <- c(cart[[id]], c(as.character(data1$item[i])))
        } else {
            id = data1$id[i]
            cart[[id]] = c(as.character(data1$item[i]))
        }
    }
    cart
}

data1 <- read.csv(file = "data1.csv")
data <- carts(data1)

re1 = eclat(data, parameter = list(support = 0.01, maxlen = 17))
```

```
## 
## parameter specification:
##  tidLists support minlen maxlen            target   ext
##     FALSE    0.01      1     17 frequent itemsets FALSE
## 
## algorithmic control:
##  sparse sort verbose
##       7   -2    TRUE
## 
## eclat - find frequent item sets with the eclat algorithm
## version 2.6 (2004.08.16)         (c) 2002-2004   Christian Borgelt
## create itemset ... 
## set transactions ...[374 item(s), 14841 transaction(s)] done [0.01s].
## sorting and recoding items ... [68 item(s)] done [0.00s].
## creating sparse bit matrix ... [68 row(s), 14841 column(s)] done [0.00s].
## writing  ... [83 set(s)] done [0.01s].
## Creating S4 object  ... done [0.00s].
```

```r
summary(re1)
```

```
## set of 83 itemsets
## 
## most frequent items:
## 1000003405 1000003585 1000483387 1000003500 1000003483    (Other) 
##          8          6          6          5          3         70 
## 
## element (itemset/transaction) length distribution:sizes
##  1  2 
## 68 15 
## 
##    Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
##    1.00    1.00    1.00    1.18    1.00    2.00 
## 
## summary of quality measures:
##     support      
##  Min.   :0.0107  
##  1st Qu.:0.0142  
##  Median :0.0187  
##  Mean   :0.0270  
##  3rd Qu.:0.0300  
##  Max.   :0.1451  
## 
## includes transaction ID lists: FALSE 
## 
## mining info:
##  data ntransactions support
##  data         14841    0.01
```

```r

rules = apriori(data, parameter = list(support = 0.005, confidence = 0.5))
```

```
## 
## parameter specification:
##  confidence minval smax arem  aval originalSupport support minlen maxlen
##         0.5    0.1    1 none FALSE            TRUE   0.005      1     10
##  target   ext
##   rules FALSE
## 
## algorithmic control:
##  filter tree heap memopt load sort verbose
##     0.1 TRUE TRUE  FALSE TRUE    2    TRUE
## 
## apriori - find association rules with the apriori algorithm
## version 4.21 (2004.05.09)        (c) 1996-2004   Christian Borgelt
## set item appearances ...[0 item(s)] done [0.00s].
## set transactions ...[374 item(s), 14841 transaction(s)] done [0.00s].
## sorting and recoding items ... [123 item(s)] done [0.00s].
## creating transaction tree ... done [0.01s].
## checking subsets of size 1 2 3 done [0.00s].
## writing ... [4 rule(s)] done [0.00s].
## creating S4 object  ... done [0.01s].
```

```r
inspect(rules)
```

```
##   lhs             rhs           support confidence   lift
## 1 {1000003402} => {1000003220} 0.007681     0.5278 17.924
## 2 {1000483386} => {1000483387} 0.011657     0.5767  6.787
## 3 {1000483385} => {1000483387} 0.023718     0.6241  7.345
## 4 {1000483385,                                           
##    1000483386} => {1000483387} 0.005795     0.7414  8.725
```





