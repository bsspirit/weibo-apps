对EXCEL操作的处理
========================================================

我不太喜欢处理Excel文件，通常转成CSV数据处理。



```r
# 执行excel操作
data <- read.csv("excel.csv", header = TRUE)
```

```
## Warning: 输入链结'excel.csv'内的输入不对
```

```
## Warning: readTableHeader在读取'excel.csv'时遇到了不完全的最后一行
```

```
## Error: empty beginning of file
```

```r

e <- data.frame(NA, NA, NA)
e <- e[-1, ]
names(e) <- names(data)

for (i in 1:length(data[, 2])) {
    if (data[i, ][2] != "") {
        if (length(j <- grep("/", as.character(data[, 3][i]))) == 1) {
            str <- strsplit(as.character(data[, 3][i]), "/")
            df <- data.frame(data[, 1][i], data[, 2][i], str[[1]][1])
            names(df) <- names(data)
            e <- rbind(e, df)
            df <- data.frame("", data[, 2][i], str[[1]][2])
            names(df) <- names(data)
            e <- rbind(e, df)
        } else if (length(j <- grep(" ", as.character(data[, 3][i]))) == 1) {
            str <- strsplit(as.character(data[, 3][i]), " ")
            df <- data.frame(data[, 1][i], data[, 2][i], str[[1]][1])
            names(df) <- names(data)
            e <- rbind(e, df)
            df <- data.frame("", data[, 2][i], str[[1]][2])
            names(df) <- names(data)
            e <- rbind(e, df)
        } else {
            e <- rbind(e, data[i, ])
        }
    }
}
```

```
## Error: 类别为'closure'的对象不可以取子集
```

```r

print(e)
```

```
## NULL
## <0 rows> (or 0-length row.names)
```

```r
write.csv(e, file = "excel-result.csv", row.names = FALSE)
```





