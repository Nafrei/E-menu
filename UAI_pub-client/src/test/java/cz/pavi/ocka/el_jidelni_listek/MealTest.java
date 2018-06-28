/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author voldy
 */
public class MealTest {
    
    public MealTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Meal.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Meal m = new Meal("rizek", "toto je super kureci rizek z kurete z volneho chovu", "1,3,2,4", "1", 100, 1);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Meal.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Meal instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllergens method, of class Meal.
     */
    @Test
    public void testGetAllergens() {
        System.out.println("getAllergens");
        Meal instance = null;
        String expResult = "";
        String result = instance.getAllergens();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class Meal.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Meal instance = null;
        String expResult = "";
        String result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class Meal.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        String quantity = "";
        Meal instance = null;
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Meal.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Meal instance = null;
        int expResult = 0;
        int result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPicture method, of class Meal.
     */
    @Test
    public void testGetPicture() {
        System.out.println("getPicture");
        Meal instance = null;
        Image expResult = null;
        Image result = instance.getPicture();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Meal.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Meal instance = null;
        int expResult = 0;
        int result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
