package edu.ncsu.csc326.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

/**
 *
 * Example Unit tests for CoffeeMaker class.
 * Do not submit as your own!
 */
public class InventoryTest {
	
	private Inventory inv;


	@BeforeEach
	public void setUp() {
		inv = new Inventory();
	}

	@Test
	public void testSetChocolate_Normal(){
		inv.setChocolate(1);
		int expectedChocAmount = 1;
		assertEquals(expectedChocAmount, inv.getChocolate());
	}

	@Test
	public void testSetChocolate_Negative(){
		inv.setChocolate(-1);
		int expectedChocAmount = 15;
		assertEquals(expectedChocAmount, inv.getChocolate());
	}

	
	@Test
	public void testSetChocolate_Zero(){
		inv.setChocolate(0);
		int expectedChocAmount = 0;
		assertEquals(expectedChocAmount, inv.getChocolate());
	}

	@Test
	public void testAddChocolate_Normal(){
		try {
			inv.addChocolate("10");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		int expectedChocAmount = 25;
		assertEquals(expectedChocAmount, inv.getChocolate());
	}

	@Test
	public void testAddChocolate_InvalidString(){
		InventoryException exception = assertThrows(InventoryException.class, () -> {
			inv.addChocolate("abc");
		});
		
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}

	@Test
	public void testAddChocolate_Negative(){
		InventoryException exception = assertThrows(InventoryException.class, () -> {
			inv.addChocolate("-1");
		});
		
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}

	@Test
	public void testAddChocolate_Zero(){
		try {
			inv.addChocolate("0");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		int expectedChocAmount = 15;
		assertEquals(expectedChocAmount, inv.getChocolate());
	}

	@Test
	public void testSetMilk_Normal(){
		inv.setMilk(1);
		int expectedMilkAmount = 1;
		assertEquals(expectedMilkAmount, inv.getMilk());
	}

	@Test
	public void testSetMilk_Negative(){
		inv.setMilk(-1);
		int expectedMilkAmount = 15;
		assertEquals(expectedMilkAmount, inv.getMilk());
	}

	@Test
	public void testSetMilk_Zero(){
		inv.setMilk(0);
		int expectedMilkAmount = 0;
		assertEquals(expectedMilkAmount, inv.getMilk());
	}

	@Test
	public void testAddMilk_Normal(){
		try {
			inv.addMilk("10");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		int expectedMilkAmount = 25;
		assertEquals(expectedMilkAmount, inv.getMilk());
	}

	@Test
	public void testAddMilk_InvalidString(){
		InventoryException exception = assertThrows(InventoryException.class, () -> {
			inv.addMilk("abc");
		});
		
		assertEquals("Units of milk must be a positive integer", exception.getMessage());
	}

	@Test
	public void testAddMilk_Negative(){
		InventoryException exception = assertThrows(InventoryException.class, () -> {
			inv.addMilk("-1");
		});
		
		assertEquals("Units of milk must be a positive integer", exception.getMessage());
	}

	@Test
	public void testAddMilk_Zero(){
		try {
			inv.addMilk("0");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		int expectedChocAmount = 15;
		assertEquals(expectedChocAmount, inv.getMilk());
	}

	@Test
	public void testSetCoffee_Normal(){
		inv.setCoffee(1);
		int expectedCoffeeAmount = 1;
		assertEquals(expectedCoffeeAmount, inv.getCoffee());
	}

	@Test
	public void testSetCoffee_Negative(){
		inv.setCoffee(-1);
		int expectedCoffeeAmount = 15;
		assertEquals(expectedCoffeeAmount, inv.getCoffee());
	}

	
	@Test
	public void testSetCoffee_Zero(){
		inv.setCoffee(0);
		int expectedCoffeeAmount = 0;
		assertEquals(expectedCoffeeAmount, inv.getCoffee());
	}

	@Test
	public void testAddCoffee_Normal(){
		try {
			inv.addCoffee("10");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		int expectedCoffeeAmount = 25;
		assertEquals(expectedCoffeeAmount, inv.getCoffee());
	}

	@Test
	public void testAddCoffee_InvalidString(){
		InventoryException exception = assertThrows(InventoryException.class, () -> {
			inv.addCoffee("abc");
		});
		
		assertEquals("Units of coffee must be a positive integer", exception.getMessage());
	}

	@Test
	public void testAddCoffee_Negative(){
		InventoryException exception = assertThrows(InventoryException.class, () -> {
			inv.addCoffee("-1");
		});
		
		assertEquals("Units of coffee must be a positive integer", exception.getMessage());
	}

	@Test
	public void testAddCoffee_Zero(){
		try {
			inv.addCoffee("0");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		int expectedCoffeeAmount = 15;
		assertEquals(expectedCoffeeAmount, inv.getCoffee());
	}

	@Test
	public void testSetSugar_Normal(){
		inv.setSugar(1);
		int expectedSugarAmount = 1;
		assertEquals(expectedSugarAmount, inv.getSugar());
	}

	@Test
	public void testSetSugar_Negative(){
		inv.setSugar(-1);
		int expectedSugarAmount = 15;
		assertEquals(expectedSugarAmount, inv.getSugar());
	}

	
	@Test
	public void testSetSugar_Zero(){
		inv.setSugar(0);
		int expectedSugarAmount = 0;
		assertEquals(expectedSugarAmount, inv.getSugar());
	}

	@Test
	public void testAddSugar_Normal(){
		try {
			inv.addSugar("10");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		int expectedSugarAmount = 25;
		assertEquals(expectedSugarAmount, inv.getSugar());
	}

	@Test
	public void testAddSugar_InvalidString(){
		InventoryException exception = assertThrows(InventoryException.class, () -> {
			inv.addSugar("abc");
		});
		
		assertEquals("Units of sugar must be a positive integer", exception.getMessage());
	}

	@Test
	public void testAddSugar_Negative(){
		InventoryException exception = assertThrows(InventoryException.class, () -> {
			inv.addSugar("-1");
		});
		
		assertEquals("Units of sugar must be a positive integer", exception.getMessage());
	}

	@Test
	public void testAddSugar_Zero(){
		try {
			inv.addSugar("0");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		int expectedSugarAmount = 15;
		assertEquals(expectedSugarAmount, inv.getCoffee());
	}

	@Test
	public void testEnoughIngredients_Normal() {
		Recipe r = new Recipe();
		try {
			r.setAmtMilk("10");
			r.setAmtCoffee("10");
			r.setAmtSugar("10");
			r.setAmtChocolate("10");
			
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown.");
		}
		assertEquals(true, inv.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredients_NotEnoughMilk() {
		Recipe r = new Recipe();
		try {
			r.setAmtMilk("999");
			r.setAmtCoffee("10");
			r.setAmtSugar("10");
			r.setAmtChocolate("10");
			
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown.");
		}
		assertEquals(false, inv.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredients_NotEnoughCoffee() {
		Recipe r = new Recipe();
		try {
			r.setAmtMilk("10");
			r.setAmtCoffee("999");
			r.setAmtSugar("10");
			r.setAmtChocolate("10");
			
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown.");
		}
		assertEquals(false, inv.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredients_NotEnoughSugar() {
		Recipe r = new Recipe();
		try {
			r.setAmtMilk("10");
			r.setAmtCoffee("10");
			r.setAmtSugar("999");
			r.setAmtChocolate("10");
			
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown.");
		}
		assertEquals(false, inv.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredients_NotEnoughChocolate() {
		Recipe r = new Recipe();
		try {
			r.setAmtMilk("10");
			r.setAmtCoffee("10");
			r.setAmtSugar("10");
			r.setAmtChocolate("999");
			
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown.");
		}
		assertEquals(false, inv.enoughIngredients(r));
	}

	@Test
	public void testUseIngredients_Normal(){
		Recipe r = new Recipe();
		try {
			r.setAmtMilk("10");
			r.setAmtCoffee("10");
			r.setAmtSugar("10");
			r.setAmtChocolate("10");
			
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown.");
		}
		
		assertEquals(true, inv.useIngredients(r));
	}

	@Test
	public void testUseIngredients_NotEnoughIngredients(){
		Recipe r = new Recipe();
		try {
			r.setAmtMilk("999");
			r.setAmtCoffee("999");
			r.setAmtSugar("999");
			r.setAmtChocolate("999");
			
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown.");
		}
		
		assertEquals(false, inv.useIngredients(r));
	}

	@Test
	public void testUseIngredients_milkAmountDecreasing(){
		int milkAmount = inv.getMilk();
		Recipe r = new Recipe();
		try {
			r.setAmtMilk("10");
			r.setAmtCoffee("10");
			r.setAmtSugar("10");
			r.setAmtChocolate("10");
			
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown.");
		}

		inv.useIngredients(r);

		assertEquals(milkAmount - 10, inv.getMilk());
	}

	@Test
	public void testUseIngredients_coffeeAmountDecreasing(){
		int coffeeAmount = inv.getCoffee();
		Recipe r = new Recipe();
		try {
			r.setAmtMilk("10");
			r.setAmtCoffee("10");
			r.setAmtSugar("10");
			r.setAmtChocolate("10");
			
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown.");
		}
		
		inv.useIngredients(r);

		assertEquals(coffeeAmount - 10, inv.getCoffee());
	}

	@Test
	public void testUseIngredients_sugarAmountDecreasing(){
		int sugarAmount = inv.getSugar();
		Recipe r = new Recipe();
		try {
			r.setAmtMilk("10");
			r.setAmtCoffee("10");
			r.setAmtSugar("10");
			r.setAmtChocolate("10");
			
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown.");
		}
		
		inv.useIngredients(r);

		assertEquals(sugarAmount - 10, inv.getSugar());
	}

	@Test
	public void testUseIngredients_chocolateAmountDecreasing(){
		int chocolateAmount = inv.getChocolate();
		Recipe r = new Recipe();
		try {
			r.setAmtMilk("10");
			r.setAmtCoffee("10");
			r.setAmtSugar("10");
			r.setAmtChocolate("10");
			
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown.");
		}
		
		inv.useIngredients(r);

		assertEquals(chocolateAmount - 10, inv.getChocolate());
	}

	@Test
	public void testToString() {
		String expectedToString = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
		assertEquals(expectedToString, inv.toString());
	}
}
