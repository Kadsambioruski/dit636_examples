package edu.ncsu.csc326.coffeemaker;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class CoffeeMakerTest {
    
    private CoffeeMaker cm;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;
    private Recipe r5;

    @BeforeEach
    public void setUp() throws Exception {
        cm = new CoffeeMaker();
        
        // Set up for r1
        r1 = new Recipe();
        r1.setName("Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("1");
        r1.setAmtSugar("1");
        r1.setPrice("50");
        
        // Set up for r2
        r2 = new Recipe();
        r2.setName("Mocha");
        r2.setAmtChocolate("20");
        r2.setAmtCoffee("3");
        r2.setAmtMilk("1");
        r2.setAmtSugar("1");
        r2.setPrice("75");
        
        // Set up for r3
        r3 = new Recipe();
        r3.setName("Latte");
        r3.setAmtChocolate("0");
        r3.setAmtCoffee("3");
        r3.setAmtMilk("3");
        r3.setAmtSugar("1");
        r3.setPrice("100");
        
        // Set up for r4
        r4 = new Recipe();
        r4.setName("Hot Chocolate");
        r4.setAmtChocolate("4");
        r4.setAmtCoffee("0");
        r4.setAmtMilk("1");
        r4.setAmtSugar("1");
        r4.setPrice("65");

        r5 = new Recipe();
        r5.setName("Whatever");
        r5.setAmtChocolate("16");
        r5.setAmtCoffee("16");
        r5.setAmtMilk("16");
        r5.setAmtSugar("16");
        r5.setPrice("10");
    }

    // Test adding a valid recipe
    @Test
    public void testAddRecipe() {
        assertTrue(cm.addRecipe(r1), "Recipe should be added successfully.");
        assertTrue(cm.addRecipe(r2), "Recipe should be added successfully.");
        assertTrue(cm.addRecipe(r3), "Recipe should be added successfully.");
        assertTrue(cm.addRecipe(r4), "Recipe should be added successfully.");
    }

    @Test
    public void testAddRecipe_NoSpace() {
        assertTrue(cm.addRecipe(r1), "Recipe should be added successfully.");
        assertTrue(cm.addRecipe(r2), "Recipe should be added successfully.");
        assertTrue(cm.addRecipe(r3), "Recipe should be added successfully.");
        assertTrue(cm.addRecipe(r4), "Recipe should be added successfully.");
        assertFalse(cm.addRecipe(r5), "No space in recipe.");
    }

    // Test adding duplicate recipe
    @Test
    public void testAddDuplicateRecipe() {
        cm.addRecipe(r1);
        assertFalse(cm.addRecipe(r1), "Duplicate recipe should not be added.");
    }

    // Test deleting an existing recipe
    @Test
    public void testDeleteRecipe() {
        cm.addRecipe(r1);
        String deletedRecipeName = cm.deleteRecipe(0);
        assertEquals("Coffee", deletedRecipeName, "The deleted recipe should be 'Coffee'");
    }

    // Test deleting a non-existing recipe
    @Test
    public void testDeleteNonExistingRecipe() {
        String deletedRecipeName = cm.deleteRecipe(0);
        assertNull(deletedRecipeName, "Deleting a non-existing recipe should return null.");
    }

    // Test editing an existing recipe
@Test
public void testEditRecipe() {
    cm.addRecipe(r1);
    try {
        r1.setPrice("60");  // This may throw RecipeException
        String editedRecipeName = cm.editRecipe(0, r1);
        assertEquals("Coffee", editedRecipeName, "The edited recipe should be 'Coffee'");
    } catch (RecipeException e) {
        fail("Setting price should not throw an exception.");
    }
}


    // Test editing a non-existing recipe
    @Test
    public void testEditNonExistingRecipe() {
        String editedRecipeName = cm.editRecipe(0, r1);
        assertNull(editedRecipeName, "Editing a non-existing recipe should return null.");
    }

    // Test adding inventory with valid input
    @Test
    public void testAddInventory() {
        try {
            cm.addInventory("10", "10", "10", "10");
        } catch (InventoryException e) {
            fail("Adding inventory should not throw an exception.");
        }
        assertEquals("Coffee: 25\nMilk: 25\nSugar: 25\nChocolate: 25\n", cm.checkInventory());
        
    }

    // Test making coffee with enough inventory
    @Test
    public void testMakeCoffeeWithEnoughInventory() {
        cm.addRecipe(r1);
        int change = cm.makeCoffee(0, 50);  // Price of r1 is 50
        assertEquals(0, change, "The coffee should be made successfully with no change.");
    }

    // Test making coffee with insufficient inventory
    @Test
    public void testMakeCoffeeWithInsufficientInventory() {
        cm.addRecipe(r5);
        int change = cm.makeCoffee(0, 50);  // Price of r1 is 50
        assertEquals(50, change, "The payment should be refunded due to insufficient inventory.");
    }

    // Test making coffee with invalid price (not enough money)
    @Test
    public void testMakeCoffeeWithInvalidPrice() {
        cm.addRecipe(r1);
        try {
            cm.addInventory("10", "10", "10", "10");
            int change = cm.makeCoffee(0, 40);  // Price of r1 is 50, but user paid only 40
            assertEquals(40, change, "The customer should get a refund if not enough money is provided.");
        } catch (InventoryException e) {
            fail("Inventory exception should not be thrown.");
        }
    }

    // Test making coffee when no recipes are available
    @Test
    public void testMakeCoffeeNoRecipes() {
        try {
            cm.addInventory("10", "10", "10", "10");
            int change = cm.makeCoffee(0, 50);  // No recipes should result in no coffee
            assertEquals(50, change, "No coffee should be made when no recipe is available.");
        } catch (InventoryException e) {
            fail("Inventory exception should not be thrown.");
        }
    }
}
