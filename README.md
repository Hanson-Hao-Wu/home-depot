# home-depot

## Customer Review Exercise Overview

* In this exercise you will need to extend out of the box features.  
* Do not overwrite or edit the Java source code files we provide in the “customerreviewserver.jar.src” folder  
* You do not need to compile/run the exercise at the end.  
* Syntax matters, do your best to write Java code that would compile (no pseudo code).
* Tools you will need:
* Your favourite text editor

## Requirements

1. Provide a way to get a product’s total number of customer reviews whose ratings are within a given range (inclusive).
2. Add the following additional checks before creating a customer review:
	1. 	Your service should read a list of curse words. This list should not be defined in Java class. 
	2. 	Check if Customer’s comment contains any of these curse words. If it does, throw an exception with a message.
	3. 	Check if the rating is not < 0.  If it is < 0, throw an exception with a message.
3. 	If all the rules are passed, go ahead and create the customer review.
4. Ensure the new functionality can be used elsewhere in the application (i.e.  a bean containing the new functionality is defined within the customerreview-spring.xml).

# Steps

## 1. New a spring initializr

* Build up a spring application with web lombok and web feature.
* Add a StatusController to make sure it's up and running

## 2. Add Customer Service

1. Add AdditionalCustomerReviewService interface with 2 function:
    1. ```int getCustomerReviewsBetween(double min, double max)```
    1. ```CustomerReviewModel addCustomerReview(Double rating, String headline, String comment, UserModel user, ProductModel product)```
1. Add UtilityService:
    1. add comma split list from application.properties ```homeDepot.customerReview.curseWords```
    1. add ```boolean isHaveCurseWords(String customerReviewContent)``` check if content have ignore case curse words
1. Add exception ```HomeDepotException```
1. Define exception constant in ```ExceptionConstant```
1. Mock the Model Class
    1. ```CustomerReviewModel```
    1. ```ProductModel```
    1. ```UserModel```
1. Implement AdditionalCustomerReviewService with Class AdditionalCustomerReviewServiceImpl

## 3. Config XML for DI

1. Add additionalCustomerReviewService bean
1. Cause in the additionalCustomerReviewServiceImpl need to use the customerReviewService. Inject customerReviewService to this bean

> In additionalCustomerReviewServiceImpl, the UtilityService used the annotation to implement DI 