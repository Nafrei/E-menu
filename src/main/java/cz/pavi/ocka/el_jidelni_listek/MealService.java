/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Langi
 */
public interface MealService 
{
    ObservableList<String> getSideDishes();
    
    ObservableList<Meal> getCurrentMeal(int type);
    
    ObservableList<Meal> getChosenMeals();
    
    void addToOrder();
    
    void order();
    
    void setChosenTable(int number); 
    
    int getChosenTable();
    
    void setNumberOfOrderedMeals(int number);
    
    int getNumberOfOrderedMeals();
}
