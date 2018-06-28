/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Langi
 */
public interface MealService 
{
    List<Meal> getSideDishes();
    
    List<Meal> getCurrentMeals(int type);
    
    HashMap<Meal, Meal> getChosenMeals();
    
    //List<Order> getOrdersByTableId(int tableId);
    
    void addToOrder(Meal meal, Meal sideDishes);
    
    void deleteOrders(int tableID);
    
    void makeOrder(int tableID, List<Meal> orderedMeals);
    
    void setChosenTable(int number); 
    
    int getChosenTable();

    int getNumberOfOrderedMeals();
    
    int getPriceOfChosenMeals();
    
    
}
