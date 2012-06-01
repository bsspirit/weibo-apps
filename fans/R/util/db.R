#MySQL connection
library(RMySQL)

conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="root", password="mysql")
query <- dbGetQuery(conn, sql)
dbDisconnect(conn)
