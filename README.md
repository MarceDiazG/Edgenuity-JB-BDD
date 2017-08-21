# Edgenuity JB-BDD using Java, JBehave and Spring

This tutorial uses JBehave 3.x and Selenium 2.x to test [Edgenuity](https://www.edgenuity.com/) web site.

<img src="http://jbehave.org/reference/preview/images/jbehave-logo.png" alt="JBehave logo" align="right" />


Prerequisites
--------------
**Java 8:** http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html


Install components
------------------
**Checkout project from:** 
https://github.com/MarceDiazG/Edgenuity-JB-BDD.git

**Download the driver of your preferred browser from:**
http://docs.seleniumhq.org/download/


## Running the stories

This will run the build and test the Edgenuity website:

    mvn clean install 

You should see Firefox (installed on your system) flicker as it tests Etsy.com

This will run a single story (one contained in a etsy_cart.story file):

    mvn clean install -DstoryFilter=firstStory

This will run a suite based on the meta filters in the three story files:

    mvn clean install -Dmeta.filter="+color red"

## Viewing the results

In directory target/jbehave/view, a page named 'reports.html' has been generated, which you open that in any browser to the stories that have run and their execution status.

There should be a row for each story.  The story reports are clickable to via links on the right-most column.

## Using this guide to find or start adding your own JBehave-based integration tests components.

This project provide fully-functional properties, optimized to run regression, smoke and any functional testing:

1. src/main/java/org/jbehave/edgenuity/RunnerStories.java is the entry-point that JBehave uses to run the stories. 
2. src/main/stories contains the stories run by JBehave via RunnerStories.java.
3. src/main/java/org/jbehave/edgenuity/steps/HousekeepingSteps.java contains the steps does housekeeping chores, such as emptying cart between scenarios. 
4. src/main/java/org/jbehave/edgenuity/steps/EdgenuitySteps.java contains the steps mapped to the textual steps.
5. src/main/java/org/jbehave/edgenuity/pages contains the page-objects used by steps to abstract in a more manageable and maintainable way the interaction with the web pages via Selenium WebDriver.
6. src/main/resources/edgenuity-steps.xml contains the Spring configuration for composition the steps


