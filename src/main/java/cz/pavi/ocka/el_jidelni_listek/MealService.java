/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.List;

/**
 *
 * @author Langi
 */
public interface MealService 
{
        
    List<Meal> getMeals();
    
    Meal getMealById(int mealId);
    
    List<Order> getOrdersByTableId(int tableId);
    
    void makeOrder(int tableId, int mealId);
    
    void deleteOrders(int tableId);
    
}