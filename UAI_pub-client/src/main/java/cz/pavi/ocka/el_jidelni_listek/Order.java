/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.Date;

/**
 *
 * @author nevlu
 */
public class Order {
    
    private int orderId;
    private int mealId;
    private Date created;
    private Date closed;
   
    boolean success;
    
    public String message;

    public int getOrderId() {
        return orderId;
    }

    public int getMealId() {
        return mealId;
    }

    public Date getCrated() {
        return created;
    }

    public Date getClosed() {
        return closed;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public void setCrated(Date crated) {
        this.created = crated;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
