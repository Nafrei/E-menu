/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.ObservableList;

/**
 *
 * @author Langi
 */
public interface MealService 
{
    ObservableList<Meal> getSideDishes();
    
    ObservableList<Meal> getCurrentMeal(int type);
    
    HashMap<Meal, Meal> getChosenMeals();
    
    void addToOrder(Meal meal, Meal sideDishes);
    
    void deleteFromOrder(Meal meal);
    
    void order();
    
    void setChosenTable(int number); 
    
    int getChosenTable();

    int getNumberOfOrderedMeals();
    
    int getPriceOfChosenMeals();
}
