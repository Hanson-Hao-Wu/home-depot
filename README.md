# home-depot

Customer Review Exercise Overview

* In this exercise you will need to extend out of the box features.  
* Do not overwrite or edit the Java source code files we provide in the “customerreviewserver.jar.src” folder  
* You do not need to compile/run the exercise at the end.  
* Syntax matters, do your best to write Java code that would compile (no pseudo code).
* Tools you will need:
* Your favourite text editor

Requirements

1. Provide a way to get a product’s total number of customer reviews whose ratings are within a given range (inclusive).
1. Add the following additional checks before creating a customer review:
	1. 	Your service should read a list of curse words. This list should not be defined in Java class. 
	1. 	Check if Customer’s comment contains any of these curse words. If it does, throw an exception with a message.
	1. 	Check if the rating is not < 0.  If it is < 0, throw an exception with a message.
1. 	If all the rules are passed, go ahead and create the customer review.
1. Ensure the new functionality can be used elsewhere in the application (i.e.  a bean containing the new functionality is defined within the customerreview-spring.xml).

# Steps

## 1. New a spring initializr

> Build up a spring application and add a StatusController to make sure it's up and running



