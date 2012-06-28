#ggplot2.pdf
library(ggplot2)
data(diamonds)
p<-ggplot(diamonds, aes(carat,price,colour=cut))
p+layer(geom="point")

p<-ggplot(diamonds,aes(x=carat))
p+layer(geom="bar",
        geom_params=list(fill="steelblue"),
        stat="bin",
        stat_params=list(binwidth=2)
        )

p<-ggplot(mtcars,aes(mpg,wt,colour=cyl))
p+geom_point();

mtcars<-transform(mtcars,mpg=mpg^2)
p %+% mtcars

p <- ggplot(mtcars)
summary(p)
p<-p+aes(wt,hp)
summary(p)

p <- ggplot(mtcars, aes(x = mpg, y = wt))
p+geom_point()
p + geom_point(aes(colour = factor(cyl)))
p + geom_point(aes(y = disp))
p + geom_point(colour="darkblue")

ggplot(diamonds,aes(carat))+geom_histogram(aes(y=..density..),binwidth=0.1)

#d<-ggplot(diamonds,aes(carat))+xlim(0.3)

require(nlme, quiet = TRUE, warn.conflicts = FALSE)
model <- lme(height ~ age, data = Oxboys,random = ~ 1 + age | Subject)
oplot <- ggplot(Oxboys, aes(age, height, group = Subject)) +  geom_line()


df <- data.frame(
  x = c(3, 1, 5),
  y = c(2, 4, 6),
  label = c("a","b","c")
)
p <- ggplot(df, aes(x, y, label = label)) + xlab(NULL) + ylab(NULL)
p + geom_point() + opts(title = "geom_point")
p + geom_bar(stat="identity") + opts(title = "geom_bar(stat=\"identity\")")
p + geom_line() + opts(title = "geom_line")
p + geom_area() + opts(title = "geom_area")
p + geom_path() + opts(title = "geom_path")
p + geom_text() + opts(title = "geom_text")
p + geom_tile() + opts(title = "geom_tile")
p + geom_polygon() + opts(title = "geom_polygon")


depth_dist <- ggplot(diamonds, aes(depth)) + xlim(58, 68)
depth_dist + geom_histogram(aes(y = ..density..), binwidth = 0.1) + facet_grid(cut ~ .)
depth_dist + geom_histogram(aes(fill = cut), binwidth = 0.1, position = "fill")
depth_dist + geom_freqpoly(aes(y = ..density.., colour = cut),binwidth = 0.1)

df <- data.frame(x = rnorm(2000), y = rnorm(2000))
norm <- ggplot(df, aes(x, y))
norm + geom_point()
norm + geom_point(shape = 1)
norm + geom_point(shape = ".") # Pixel sized

td <- ggplot(diamonds, aes(table, depth)) + xlim(50, 70) + ylim(50, 70)
td + geom_point()
td + geom_jitter()
jit <- position_jitter(width = 0.5)
td + geom_jitter(position = jit)
td + geom_jitter(position = jit, colour="black", alpha=1/10)
td + geom_jitter(position = jit, colour="black", alpha=1/50)
td + geom_jitter(position = jit, colour="black", alpha=1/200)

d <- ggplot(diamonds, aes(carat, price)) + xlim(1,3) +  opts(legend.position = "none")
d + stat_bin2d()
d + stat_bin2d(bins = 10)
d + stat_bin2d(binwidth=c(0.02, 200))
d + stat_binhex()
d + stat_binhex(bins = 10)
d + stat_binhex(binwidth=c(0.02, 200))


d <- ggplot(diamonds, aes(carat, price)) + xlim(1,3) +  opts(legend.position = "none")
d + geom_point() + geom_density2d()
d + stat_density2d(geom = "point", aes(size = ..density..), contour = F) + scale_area(range = c(0.2, 1.5))
d + stat_density2d(geom = "tile", aes(fill = ..density..), contour = F)
last_plot() + scale_fill_gradient(limits = c(1e-5,8e-4))


library(maps)
data(us.cities)
big_cities <- subset(us.cities, pop > 500000)
qplot(long, lat, data = big_cities) + borders("state", size = 0.5)
tx_cities <- subset(us.cities, country.etc == "TX")
ggplot(tx_cities, aes(long, lat)) +
  borders("county", "texas", colour = "grey70") +
  geom_point(colour="black", alpha=0.5)


library(maps)
states <- map_data("state")
arrests <- USArrests
names(arrests) <- tolower(names(arrests))
arrests$region <- tolower(rownames(USArrests))
choro <- merge(states, arrests, by = "region")
# Reorder the rows because order matters when drawing polygons
# and merge destroys the original ordering
choro <- choro[order(choro$order), ]
qplot(long, lat, data = choro, group = group,fill = assault, geom = "polygon")
qplot(long, lat, data = choro, group = group,
      fill = assault / murder, geom = "polygon")


#ia <- map_data("county", "iowa")
#mid_range <- function(x) mean(range(x, na.rm = TRUE))
#centres <- ddply(ia, .(subregion), colwise(mid_range, .(lat, long)))
#ggplot(ia, aes(long, lat)) +  geom_polygon(aes(group = group), fill = NA, colour = "grey60") +
#  geom_text(aes(label = subregion), data = centres,size = 2, angle = 45)


d <- subset(diamonds, carat < 2.5 & rbinom(nrow(diamonds), 1, 0.2) == 1)
d$lcarat <- log10(d$carat)
d$lprice <- log10(d$price)
# Remove overall linear trend
detrend <- lm(lprice ~ lcarat, data = d)
d$lprice2 <- resid(detrend)
mod <- lm(lprice2 ~ lcarat * color, data = d)
library(effects)
effectdf <- function(...) {
  suppressWarnings(as.data.frame(effect(...)))
}
color <- effectdf("color", mod)
both1 <- effectdf("lcarat:color", mod)
carat <- effectdf("lcarat", mod, default.levels = 50)
both2 <- effectdf("lcarat:color", mod, default.levels = 3)



# midm <- function(x) mean(x, trim = 0.5)
# m2 + stat_summary(aes(colour = "trimmed"), fun.y = midm, geom = "point")
#   + stat_summary(aes(colour = "raw"), fun.y = mean, geom = "point")
#   + scale_colour_hue("Mean")

(unemp <- qplot(date, unemploy, data=economics, geom="line",xlab = "", ylab = "No. unemployed (1000s)"))
presidential <- presidential[-(1:3), ]
yrng <- range(economics$unemploy)
xrng <- range(economics$date)
unemp + geom_vline(aes(xintercept = start), data = presidential)
#unemp + geom_rect(aes(NULL, NULL, xmin = start, xmax = end,
#  fill = party), ymin = yrng[1], ymax = yrng[2],data = presidential) 
  #+ scale_fill_manual(values=c("blue", "red"))
#last_plot() + geom_text(aes(x = start, y = yrng[1], label = name),
#  data = presidential, size = 3, hjust = 0, vjust = 0)
caption <- paste(strwrap("Unemployment rates in the US have varied a lot over the years", 40), collapse="\n")
unemp + geom_text(aes(x, y, label = caption),data = data.frame(x = xrng[2], y = yrng[2]),hjust = 1, vjust = 1, size = 4)

highest <- subset(economics, unemploy == max(unemploy))
unemp + geom_point(data = highest,size = 3, colour = "red",alpha= 0.5)


plot <- qplot(cty, hwy, data = mpg)
plot + aes(x = drv)
plot + aes(x = drv) + scale_x_discrete()
p <- qplot(sleep_total, sleep_cycle, data = msleep, colour = vore)
p + scale_colour_hue()

p + scale_colour_hue("What does\nit eat?",
  breaks = c("herbi", "carni", "omni", NA),
  labels = c("plants", "meat", "both", "don’t know"))


p<- qplot(cty, hwy, data = mpg, colour = displ)
p+scale_x_continuous("City mpg")
p+xlab("City mpg")
p+ylab("Highway mpg")
p+labs(x = "City mpg", y = "Highway", colour = "Displacement")
p+xlab(expression(frac(miles, gallon)))


qplot(log10(carat), log10(price), data = diamonds)
qplot(carat, price, data = diamonds) +
  scale_x_log10() + scale_y_log10()


plot <- qplot(date, psavert, data = economics, geom = "line") +
  ylab("Personal savings rate") +
  geom_hline(xintercept = 0, colour = "grey50")
plot
#plot + scale_x_date(major = "10 years")
plot + scale_x_date(
  limits = as.Date(c("2004-01-01", "2005-01-01"))
  #format = "%Y-%m-%d"
)





f2d <- with(faithful, MASS::kde2d(eruptions, waiting,h = c(1, 10), n = 50))
df <- with(f2d, cbind(expand.grid(x, y), as.vector(z)))
names(df) <- c("eruptions", "waiting", "density")
erupt <- ggplot(df, aes(waiting, eruptions, fill = density)) +geom_tile() 
+ scale_x_continuous(expand = c(0, 0)) 
+ scale_y_continuous(expand = c(0, 0))
erupt + scale_fill_gradient(limits = c(0, 0.04))
erupt + scale_fill_gradient(limits = c(0, 0.04),low = "white", high = "black")
erupt + scale_fill_gradient2(limits = c(-0.04, 0.04),midpoint = mean(df$density))




library(vcd)
fill_gradn <- function(pal) {
  scale_fill_gradientn(colours = pal(7), limits = c(0, 0.04))
}
erupt + fill_gradn(rainbow_hcl)
erupt + fill_gradn(diverge_hcl)
erupt + fill_gradn(heat_hcl)




point <- qplot(brainwt, bodywt, data = msleep, log = "xy", colour = vore)
area <- qplot(log10(brainwt), data = msleep, fill = vore,binwidth = 1)
point + scale_colour_brewer(pal = "Set1")
point + scale_colour_brewer(pal = "Set2")
point + scale_colour_brewer(pal = "Pastel1")
area + scale_fill_brewer(pal = "Set1")
area + scale_fill_brewer(pal = "Set2")
area + scale_fill_brewer(pal = "Pastel1")

mpg2 <- subset(mpg, cyl != 5 & drv %in% c("4", "f"))
qplot(cty, hwy, data = mpg2) + facet_grid(. ~ .)
qplot(cty, hwy, data = mpg2) + facet_grid(. ~ cyl)

qplot(displ, hwy, data = mpg2) +
  geom_smooth(aes(colour = drv), method = "lm", se = F) +
  facet_grid(cyl ~ drv, margins = T)


(p <- qplot(disp, wt, data=mtcars) + geom_smooth())
p + scale_x_continuous(limits = c(325, 500))
p + coord_cartesian(xlim = c(325, 500)))
(d <- ggplot(diamonds, aes(carat, price)) +
  stat_bin2d(bins = 25, colour="grey70") +
  opts(legend.position = "none"))
d + scale_x_continuous(limits = c(0, 2))
d + coord_cartesian(xlim = c(0, 2))


qplot(displ, cty, data = mpg) + geom_smooth()
qplot(cty, displ, data = mpg) + geom_smooth()
qplot(cty, displ, data = mpg) + geom_smooth() + coord_flip()






