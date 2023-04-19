Feature: CoffeeMakerFeature

In this feature, we are going to test the user stories and use cases for the CoffeeMaker
Example.  We have provided a CoffeeMakerMain.java file that you can use to examine the 
modal behavior in the coffee maker and issue UI commands to use it, so that we can 
adequately test the user stories.

Hints: to catch the mistakes, you might need to add out of range cases for 
recipes and amounts of ingredients.  Also, be sure to check machine state
after running the user story:
  - Are the amounts of ingredients correct?
  - Is the system in the right mode?
  - Is the status what you expect?
  - Is the change produced correct?
  - etc.

Scenario Outline: Waiting State
      Priority: 1 Story Points: 2
      If the Coffee Maker is not in use it waits for user input. There are six different 
      options of user input: 1) add recipe, 2) delete a recipe, 3) edit a recipe, 
      4) add inventory, 5) check inventory, and 6) purchase beverage.
      
      For this scenario, what we will do is try each of the six user inputs and make sure 
      that the coffee maker ends up in the appropriate mode.  This would be a good place
      for a scenario outline with a table that described user inputs and expected final states.
      
      You might also want to try a couple of exceptional values to see what the 
      Coffee Maker does.
      
   Given my default recipe book
   When user press the key <Key>
   Then the status is <Status>
   And the mode is <Mode>
  
   Examples:
   | Key  | Mode               | Status | 
   |  1   |  ADD_RECIPE        |  OK    |
   |  2   |  DELETE_RECIPE     |  OK    |
   |  3   |  EDIT_RECIPE       |  OK    |
   |  4   |  ADD_INVENTORY     |  OK    |
   |  5   |  CHECK_INVENTORY   |  OK    |
   |  6   |  PURCHASE_BEVERAGE |  OK    |
   |  8   |       WAITING      |  OK    |
   # add more here!   
Scenario: Add a Recipe

	Given an empty recipe book
	When user press the key 1
   	And user provide a valid recipe ingredients
   	And user press enter 
   	Then the status is OK
   	And the mode is WAITING
   	
Scenario: Add a More than three Recipes 
 	Given my default recipe book
 	When user press the key 1
 	And user provide a valid recipe ingredients
 	And user press enter
   	Then the status is RECIPE_NOT_ADDED
   	And the mode is WAITING
   	
Scenario: Add a recipe with same name
 	Given my basic recipe book
 	When user press the key 1
 	And user provide a valid recipe ingredients
 	And user press enter
   	Then the status is RECIPE_NOT_ADDED
   	And the mode is WAITING
   	
Scenario Outline: Delete a Recipe
    Given my basic recipe book
    When user press the key 2
    And user select a recipe <Recipe> from the list
    Then the status is <Status>
    And the mode is <Mode>
   Examples:
   |Recipe|Status|Mode|
   |0|OK|WAITING|
   |1|OK|WAITING|
   |2|OUT_OF_RANGE|WAITING|
   |-2|OUT_OF_RANGE|WAITING|
   
Scenario: Edit a Recipe
   Given a default recipe book
   When user press the key 3
   And user select a recipe 1 from the list
   And user provide a valid recipe ingredients
   And user press enter
   Then the status is OK
   And the mode is WAITING
   
   
Scenario: Add Inventory

   Given a default recipe book
   When user press the key 4
   When user type the ammount of material to add
   Then the status is OK
   And the mode is WAITING
   
Scenario: Add Invalid Inventory

   Given a default recipe book
   When user press the key 4
   When user type the invalid ammount of material to add
   Then the status is OUT_OF_RANGE
   And the mode is WAITING
   
Scenario Outline: Purchase Beverage
      
   Given my default recipe book
   When user press the key 6
   And user provide money <Money>
   And user select a recipe <Recipe> from the list
   Then the status is <Status>
   And the mode is <Mode>
   Examples: 
      | Money | Recipe | Status             | Mode    |
      |   100 |      0 | OK                 | WAITING |
      |    49 |      0 | INSUFFICIENT_FUNDS | WAITING |
      |    50 |      0 | OK                 | WAITING |
      |  100  |      1 |   INSUFFICIENT_FUNDS     | WAITING |
      |  150  |     -1  |   OUT_OF_RANGE     | WAITING |


