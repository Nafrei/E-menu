/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.input.MouseEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zuzana Bumbová
 */
public class MainControllerTest {
    
    public MainControllerTest() {
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
     * Test of initialize method, of class MainController.
     */
    @org.junit.Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        MainController instance = new MainController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEventHandlerOnAddOrderButtons method, of class MainController.
     */
    @org.junit.Test
    public void testSetEventHandlerOnAddOrderButtons() {
        System.out.println("setEventHandlerOnAddOrderButtons");
        MainController instance = new MainController();
        instance.setEventHandlerOnAddOrderButtons();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModel method, of class MainController.
     */
    @org.junit.Test
    public void testSetModel() {
        System.out.println("setModel");
        MealService service = null;
        MainController instance = new MainController();
        instance.setModel(service);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onMysPrycStul method, of class MainController.
     */
    @org.junit.Test
    public void testOnMysPrycStul() {
        System.out.println("onMysPrycStul");
        MouseEvent mouseEvent = null;
        MainController instance = new MainController();
        instance.onMysPrycStul(mouseEvent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
