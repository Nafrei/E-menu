/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Patrik-NB
 */
public class MealServiceImplementationTest {
    
    public MealServiceImplementationTest() {
    }

    /**
     * Test of getSideDishes method, of class MealServiceImplementation.
     */
    @Test
    public void testGetSideDishes() {
       
    }

    /**
     * Test of getCurrentMeals method, of class MealServiceImplementation.
     */
    @Test
    public void testGetCurrentMeals() {
    }

    /**
     * Test of addToOrder method, of class MealServiceImplementation.
     */
    @Test
    public void testAddToOrder() {
    }

    /**
     * Test of makeOrder method, of class MealServiceImplementation.
     */
    @Test
    public void testMakeOrder() {
         MealServiceImpl service = new MealServiceImpl();
         try {
            service.makeOrder(1, null);
                         assertTrue(true);
        } catch (Exception e) {
            fail("Exception occured");
        }
         
         
    }

    /**
     * Test of setChosenTable method, of class MealServiceImplementation.
     */
    @Test
    public void testSetChosenTable() {
    }

    /**
     * Test of getChosenTable method, of class MealServiceImplementation.
     */
    @Test
    public void testGetChosenTable() {
    }

    /**
     * Test of getChosenMeals method, of class MealServiceImplementation.
     */
    @Test
    public void testGetChosenMeals() {
        MealServiceImpl service = new MealServiceImpl();
        service.addToOrder(new Meal("Kuøízek", 20), new Meal("brambor", 10));
        service.addToOrder(new Meal("Kuøízek", 20), new Meal("brambor", 10));
        assertEquals(2, service.getNumberOfOrderedMeals());
    }

    /**
     * Test of getNumberOfOrderedMeals method, of class MealServiceImplementation.
     */
    @Test
    public void testGetNumberOfOrderedMeals() {
    }

    /**
     * Test of deleteOrders method, of class MealServiceImplementation.
     */
    @Test
    public void testDeleteOrders() {
        
    }

    /**
     * Test of getPriceOfChosenMeals method, of class MealServiceImplementation.
     */
    @Test
    public void testGetPriceOfEmptyChosenMeals() {
        MealServiceImpl service = new MealServiceImpl();
        assertEquals(0, service.getPriceOfChosenMeals());
    }
      /**
     * Test of getPriceOfChosenMeals method, of class MealServiceImplementation.
     */
    @Test
    public void testGetPriceOfChosenMealsWithoutSideDishes() {
        MealServiceImpl service = new MealServiceImpl();
         service.addToOrder(new Meal("Rybí polévka", 17), null);
        assertEquals(17, service.getPriceOfChosenMeals());
    }
      /**
     * Test of getPriceOfChosenMeals method, of class MealServiceImplementation.
     */
    @Test
    public void testGetPriceOfChosenMealsWithSideDishes() {
        MealServiceImpl service = new MealServiceImpl();
        service.addToOrder(new Meal("Kuøízek", 20), new Meal("brambor", 10));
        assertEquals(30, service.getPriceOfChosenMeals());
    }
    
      /**
     * Test of getPriceOfChosenMeals method, of class MealServiceImplementation.
     */
    @Test
    public void testGetPriceOfMultipleChoosenDishes() {
        MealServiceImpl service = new MealServiceImpl();
        service.addToOrder(new Meal("Kuøízek", 20), new Meal("brambor", 10));
        service.addToOrder(new Meal("Kuøízek", 20), new Meal("brambor", 10));
        assertEquals(60, service.getPriceOfChosenMeals());
    }
    
}
