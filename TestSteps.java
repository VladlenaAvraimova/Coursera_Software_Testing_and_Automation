/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
 * All Rights Reserved.
 * 
 * Permission has been explicitly granted to the University of Minnesota 
 * Software Engineering Center to use and distribute this source for 
 * educational purposes, including delivering online education through
 * Coursera or other entities.  
 * 
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including 
 * fitness for purpose.
 * 
 * 
 * Modified 20171114 by Ian De Silva -- Updated to adhere to coding standards.
 * 
 */
package edu.ncsu.csc326.coffeemaker;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.ncsu.csc326.coffeemaker.CoffeeMaker;
import edu.ncsu.csc326.coffeemaker.UICmd.AddInventory;
import edu.ncsu.csc326.coffeemaker.UICmd.ChooseRecipe;
import edu.ncsu.csc326.coffeemaker.UICmd.ChooseService;
import edu.ncsu.csc326.coffeemaker.UICmd.Command;
import edu.ncsu.csc326.coffeemaker.UICmd.DescribeRecipe;
import edu.ncsu.csc326.coffeemaker.UICmd.InsertMoney;

/**
 * Contains the step definitions for the cucumber tests.  This parses the 
 * Gherkin steps and translates them into meaningful test steps.
 */
public class TestSteps {
	
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	private Recipe recipe5;
	private CoffeeMakerUI coffeeMakerMain; 
	private CoffeeMaker coffeeMaker;
	private RecipeBook recipeBook;

	
	private void initialize() {
		recipeBook = new RecipeBook();
		coffeeMaker = new CoffeeMaker(recipeBook, new Inventory());
		coffeeMakerMain = new CoffeeMakerUI(coffeeMaker);
	}
	
    @Given("^an empty recipe book$")
    public void an_empty_recipe_book() throws Throwable {
        initialize();
        recipe5 = new Recipe();
    }
    @Given("a default recipe book")
	public void a_default_recipe_book() throws Throwable {
    	initialize();
    	
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
		
		//Set up for r5 (added by MWW)
		recipe5 = new Recipe();
		recipe5.setName("Super Hot Chocolate");
		recipe5.setAmtChocolate("6");
		recipe5.setAmtCoffee("0");
		recipe5.setAmtMilk("1");
		recipe5.setAmtSugar("1");
		recipe5.setPrice("100");

		recipeBook.addRecipe(recipe1);
		recipeBook.addRecipe(recipe2);
		recipeBook.addRecipe(recipe3);
		recipeBook.addRecipe(recipe4);
		
	}
    @Given("my default recipe book")
	public void my_default_recipe_book() throws Throwable {
    	initialize();
    	
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		
		recipeBook.addRecipe(recipe1);
		recipeBook.addRecipe(recipe2);
		recipeBook.addRecipe(recipe3);
		
	}
    @Given("my basic recipe book")
   	public void my_basic_recipe_book() throws Throwable {
       	initialize();
       	
   		//Set up for r1
   		recipe1 = new Recipe();
   		recipe1.setName("Coffee");
   		recipe1.setAmtChocolate("0");
   		recipe1.setAmtCoffee("3");
   		recipe1.setAmtMilk("1");
   		recipe1.setAmtSugar("1");
   		recipe1.setPrice("50");
   		
   		//Set up for r4
   		recipe4 = new Recipe();
   		recipe4.setName("Hot Chocolate");
   		recipe4.setAmtChocolate("4");
   		recipe4.setAmtCoffee("0");
   		recipe4.setAmtMilk("1");
   		recipe4.setAmtSugar("1");
   		recipe4.setPrice("65");
   	
   		recipeBook.addRecipe(recipe1);
   		recipeBook.addRecipe(recipe4);
   		
   	}
    //=============================== Mode =============================================
    @When("^user press the key (\\d+)")
    public void user_press_the_key(int keyPressed) throws Throwable {
    	Command cmd = new ChooseService(keyPressed);
    	coffeeMakerMain.UI_Input(cmd);
    }
    //===============================Adding Recipes=====================================
    @When("^user provide a valid recipe ingredients")
	public void user_provide_coffee_ammount() throws Throwable {
    	//Set up for r1
    	//Set up for r4
    	recipe4 = new Recipe();
    	recipe4.setName("Hot Chocolate");
    	recipe4.setAmtChocolate("4");
    	recipe4.setAmtCoffee("0");
    	recipe4.setAmtMilk("1");
    	recipe4.setAmtSugar("1");
    	recipe4.setPrice("65");
	}
    @When("^user press enter$")
    public void user_press_enter() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	Command cmd = new DescribeRecipe(recipe4);
    	coffeeMakerMain.UI_Input(cmd);
    }
    
	
	
	//================================== Delete Recipe ===================================
	@When("^user select a recipe ([-+]?\\d+) from the list$")
    public void user_select_a_recipe_Reipe_from_the_list(int recipeSelected) throws Throwable {
		Command cmd = new ChooseRecipe(recipeSelected);
  		coffeeMakerMain.UI_Input(cmd);
    }
	//===================================== EDIT RECIPE====================================
	
	//===================================== ADD INVENTORY ================================
	@When("^user type the ammount of material to add$")
    public void user_type_the_ammount_of_material_to_add() throws Throwable {
		Command cmd = new AddInventory(10, 10, 10, 10);
		coffeeMakerMain.UI_Input(cmd);
    }
	@When("^user type the invalid ammount of material to add$")
    public void user_type_the_invalid_ammount_of_material_to_add() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
		Command cmd = new AddInventory(-10, 10, 10, 10);
		coffeeMakerMain.UI_Input(cmd);
    }
	//===================================== Purchasing  ================================
	@When("^user provide money ([+-]?\\d+)$")
    public void user_provide_money(int insertedMoney) throws Throwable {
		Command cmd = new InsertMoney(insertedMoney);
	  	coffeeMakerMain.defaultCommands(cmd);
        
    }
    //================================== Assertion =======================================
    @Then("the status is ([A-Za-z_]*)")
	 public void the_status_is(String theStatus) throws Throwable{
		assertEquals(theStatus, coffeeMakerMain.status.name());
	 }  
	 @Then("the mode is ([A-Za-z_]*)")
	 public void the_mode_is(String theMode) throws Throwable{
		assertEquals(theMode, coffeeMakerMain.mode.name().toString());
	 } 
    
}

