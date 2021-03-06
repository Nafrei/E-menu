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
     * Test of getName method, compares Name atribute with constructor parameter
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Meal m = new Meal("rizek", "toto je super kureci rizek z kurete z volneho chovu", "1,3,2,4", "1", 100, 1);
        assertEquals("rizek", m.getName());
    }

    /**
     * Test of getDescription method, compares Description atribute with constructor parameter
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Meal m = new Meal("rizek", "toto je super kureci rizek z kurete z volneho chovu", "1,3,2,4", "1", 100, 1);
        assertEquals("toto je super kureci rizek z kurete z volneho chovu", m.getDescription());
    }

    /**
     * Test of getAllergens method, compares Allergens atribute with constructor parameter
     */
    @Test
    public void testGetAllergens() {
        System.out.println("getAllergens");
        Meal m = new Meal("rizek", "toto je super kureci rizek z kurete z volneho chovu", "1,3,2,4", "1", 100, 1);
        assertEquals("1,3,2,4", m.getAllergens());
    }

    /**
     * Test of getQuantity method, compares Quantity atribute with constructor parameter
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Meal m = new Meal("rizek", "toto je super kureci rizek z kurete z volneho chovu", "1,3,2,4", "1", 100, 1);
        assertEquals("1", m.getQuantity());
    }

    /**
     * Test of setQuantity method, changes Quantity atribute and then compares to expected value
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        Meal m = new Meal("rizek", "toto je super kureci rizek z kurete z volneho chovu", "1,3,2,4", "1", 100, 1);
        m.setQuantity("5");
        assertEquals("5", m.getQuantity());
    }

    /**
     * Test of getPrice method, compares Price atribute with constructor parameter
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Meal m = new Meal("rizek", "toto je super kureci rizek z kurete z volneho chovu", "1,3,2,4", "1", 100, 1);
        assertEquals(100, m.getPrice());
    }

    /**
     * Test of getType method, compares Type atribute with constructor parameter
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Meal m = new Meal("rizek", "toto je super kureci rizek z kurete z volneho chovu", "1,3,2,4", "1", 100, 1);
        assertEquals(1, m.getType());
    }

}
