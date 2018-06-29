/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Patrik-NB
 */
public class MealServiceImplTest {

    /**
     * Test of addToOrder method, of class MealServiceImpl.
     */
    @Test
    public void testAddToOrder() {
        MealServiceImpl service = new MealServiceImpl();
        service.addToOrder(new Meal("Rizek", 20), new Meal("Hranolky", 10));
        assertEquals(1, service.getNumberOfOrderedMeals());
    }

    /**
     * Test of getNumberOfOrderedMeals method, of class MealServiceImplementation.
     */
    @Test
    public void testGetNumberOfOrderedMeals() {
        MealServiceImpl service = new MealServiceImpl();
        service.addToOrder(new Meal("Kurizek", 20), new Meal("brambor", 10));
        service.addToOrder(new Meal("Kurizek", 20), new Meal("brambor", 10));
        assertEquals(service.getNumberOfOrderedMeals(), 2);
    }


      /**
     * Test of getPriceOfChosenMeals method, of class MealServiceImplementation.
     */
    @Test
    public void testGetPriceOfChosenMealsWithoutSideDishes() {
        MealServiceImpl service = new MealServiceImpl();
         service.addToOrder(new Meal("Rybi polevka", 17), null);
        assertEquals(17, service.getPriceOfChosenMeals());
    }
      /**
     * Test of getPriceOfChosenMeals method, of class MealServiceImplementation.
     */
    @Test
    public void testGetPriceOfChosenMealsWithSideDishes() {
        MealServiceImpl service = new MealServiceImpl();
        service.addToOrder(new Meal("Kurizek", 20), new Meal("brambor", 10));
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
