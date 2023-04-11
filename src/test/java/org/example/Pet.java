package org.example;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.Date;

public class Pet {
    private long id;
    private long petId;
    private float quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public long getId() {
        return id;
    }

    public long getPetId() {
        return petId;
    }

    public float getQuantity() {
        return quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public String getStatus() {
        return status;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}