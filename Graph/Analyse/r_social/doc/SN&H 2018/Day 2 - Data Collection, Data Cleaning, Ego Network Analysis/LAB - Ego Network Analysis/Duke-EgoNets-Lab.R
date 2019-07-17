
# title: "Duke-EgoNets-Lab"
# date: "May 15, 2018"

################################################################################
## Install (only required once)
################################################################################

## Use (for each R project)
library(foreign)
library(car)
library(het.test)
library(lmtest)
library(sandwich)
library(Hmisc)
library(multilevel)
library(optimx)

################################################################################
# REGRESSION WITH EGO NET VARIABLES 
################################################################################ 

################################################################################
# Data 
################################################################################ 

# Set seed for random estimates
set.seed(12345)

# Specify working folder
setwd("C:/Users/blperry/Dropbox/Teaching/Workshops/LINKS Ego Nets/R files")

# Load the data
data <-as.data.frame(read.dta("GSS-2002-EGONET-R.dta",convert.factor=FALSE))

################################################################################
# 1. Linear regression
################################################################################ 

# Effects of occupational prestige on density? 

describe(data$shdensity)
describe(data$netsize)

model1 <- lm(shdensity ~ female + white + rage + prestige + netsize, data=data)
summary(model1)

# Interpretations? Explanations?


################################################################################
## Skew? 
################################################################################ 
hist(data$shdensity)
hist(data$netsize)

#Different functional form 
data$shdensitysq <- (data$shdensity)^2
hist(data$shdensitysq)

# Model 
model2 <- lm(shdensitysq ~ female + white + rage + prestige + netsize, data=data)
summary(model2)


################################################################################
#2. Binary logistic regression
################################################################################ 

# Effects of structural holes on happiness? 

# Make sure dependent is listed as a binary variable
data$vhappy <- as.factor(data$vhappy)

# model
model4 <- glm(vhappy ~ shdensity + female + educyrs + married, family = binomial(link = "logit"), data=data)
summary(model4)

# Odds ratios
exp(coef(model4))

# Do findings support Coleman's argument about closure, or Burt's argument about structural holes?


################################################################################
#3. Interaction between a network and non-network variable
################################################################################ 

# Does being married change the effect of density on happiness?


# Model
model5 <- glm(vhappy ~ shdensity * married + female + educyrs , family = binomial(link = "logit"), data=data)
summary(model5)
exp(coef(model5))

# Effect of density for married individuals
2.93154622*0.36217219




###############################################################################
# MULTILEVEL MODELING FOR EGO NETS
###############################################################################

###############################################################################
# Data 
###############################################################################

# Load the data
data <-as.data.frame(read.dta("Fischer-R.dta", convert.factor=FALSE))

###############################################################################
# 4. Random intercept model
###############################################################################

# Null 2-level random intercept model 

describe(data$support)

model6 <- lme(support ~ 1, random = ~ 1 | EGOID, data=data, control=list(opt="nlmimb"), method="REML", na.action=na.omit)
summary(model6)  
VarCorr(model6)


## Intraclass correlation

# we take the variance from the EgoID, and divide it by the total variance
icc.six <- 0.04342021/(0.04342021+  0.71340995)
icc.six

# Random intercept model with covariates

model7 <- lme(support ~ egofem + altfem , random = ~ 1 | EGOID,  data=data, control=list(opt="optim"), method="REML", na.action=na.omit)
summary(model7)  
VarCorr(model7)

###############################################################################
# 5. Random intercept model with contextual effect
###############################################################################

# Compute contextual effect for alter gender 
data$netfem <- ave(data$altfem, data$EGOID, FUN=function(x) mean(x, na.rm=T))
head(data$netfem)
data$netfem10 <- data$netfem*10

# Random intercept model with contextual effect
model8 <- lme(support ~ egofem + altfem + netfem10, random = ~ 1 | EGOID,  data=data, control=list(opt="nlmimb"), method="REML", na.action=na.omit)
summary(model8)  
VarCorr(model8)

#Intraclass correlation
icc.eight <- 0.04335466/(0.04335466 + 0.71220206)
icc.eight

###############################################################################
# 6. Random coefficient model 
###############################################################################

# Random coefficient model 
model9 <- lme(support ~ egofem + altfem + netfem10, random = ~ altfem | EGOID , data=data, control=list(opt="nlmimb"), method="REML", na.action=na.omit)

# Lr test
anova(model8, model9)


# Random coefficient model with covariates and contextual effect

# Ran the model previously for the LR test 
summary(model9)  
VarCorr(model9)

# Intraclass correlation 
icc.rc <- 0.03821327/(0.03821327 + 0.00999234 + 0.70972871)
icc.rc

###############################################################################
# 7. cross-level interaction 
###############################################################################

model10 <- lme(support ~ egofem * altfem + netfem10 * egofem , random = ~ altfem | EGOID, data=data, control=list(opt="nlmimb"), method="REML", na.action=na.omit)
summary(model10)
VarCorr(model10)


# Final model - drop non-sig interaction term 

model11 <- lme(support ~ egofem * altfem + netfem10 , random = ~ altfem | EGOID, data=data, control=list(opt="optim"), method="REML", na.action=na.omit)
summary(model11)
VarCorr(model11)



###############################################################################
# MORE MLM IF WE HAVE TIME
###############################################################################

###############################################################################
# Data 
###############################################################################

# Load the data
data <-as.data.frame(read.dta("INMHS-LAB4-R.dta", convert.factor=FALSE))

###############################################################################
# 8. Random intercept model 
###############################################################################

# First run "empty" model

describe(data$tnumsup)
hist(data$tnumsup)

model12 <- lme(tnumsup ~ 1, random = ~ 1 | caseid,  
          data=data, control=list(opt="optim"), method="REML", 
          na.action=na.omit)
summary(model12)  
VarCorr(model12)

# Calculate ICC (rho)

icc.model12 <- 1.259612/(1.259612+4.616217)
icc.model12

# Who gives support to whom?

model13 <- lme(tnumsup ~ tfem + tageten + tvclose + tconflict + female + 
            ageten + gaf + degree + density , random = ~ 1 | caseid,  
          data=data, control=list(opt="optim"), method="REML", 
          na.action=na.omit)
summary(model13)  
VarCorr(model13)

# Calculate new ICC (rho)

icc.model13 <- 0.5749495/(0.5749495+2.5845224)
icc.model13

###############################################################################
# Compute contextual effects 
###############################################################################

data$netfem <- ave(data$tfem, data$caseid, FUN=function(x) mean(x, na.rm=T))
data$netage <- ave(data$tageten, data$caseid, FUN=function(x) mean(x, na.rm=T))
data$netclose <- ave(data$tvclose, data$caseid, FUN=function(x) mean(x, na.rm=T))
data$netconflict <- ave(data$tconflict, data$caseid, FUN=function(x) mean(x, na.rm=T))

describe(data$netfem)
describe(data$netage)
describe(data$netclose)
describe(data$netconflict)

# Random intercept model with contextual effects
model14 <- lme(tnumsup ~ tfem + netfem + tageten + netage + tvclose + netclose + tconflict + netconflict + female + ageten + gaf + degree + density, random = ~ 1 | caseid, data=data, control=list(opt="nlmimb"), method="REML", na.action=na.omit)
summary(model14)  
VarCorr(model14)

## can remove all but netfem 

###############################################################################
# Final model 
###############################################################################

model15 <- lme(tnumsup ~ tfem + netfem + tageten + tvclose +  tconflict  + female + ageten + gaf + degree + density, random = ~ 1 | caseid, data=data, control=list(opt="nlmimb"), method="REML", na.action=na.omit)
summary(model15)  
VarCorr(model15)


###############################################################################
# 9. Random coefficient model 
###############################################################################

model16 <- lme(tnumsup ~ tfem + netfem + tageten + tvclose +  tconflict  + female + ageten + gaf + degree + density, random = ~ tconflict | caseid, data=data, control=list(opt="nlmimb"), method="REML", na.action=na.omit)
summary(model16)  
VarCorr(model16)

###############################################################################
# LR test of random intercept versus random coefficient 
###############################################################################

anova(model15, model16)

###############################################################################




