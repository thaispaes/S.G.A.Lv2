/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Samuel
 */
public class Rent {
    
    private Student client;
    private Book book;
    private Date rented;
    private Date term;
    private boolean delivered;
    private double penality;

    public Rent(Student client, Book book, Date rented, Date term, boolean delivered, double penality) {
        this.client = client;
        this.book = book;
        this.rented = rented;
        this.term = term;
        this.delivered = delivered;
        this.penality = penality;
    }

    public Rent() {
    }

    public Student getClient() {
        return client;
    }

    public void setClient(Student client) {
        this.client = client;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getRented() {
        return rented;
    }

    public void setRented(Date rented) {
        this.rented = rented;
    }

    public Date getTerm() {
        return term;
    }

    public void setTerm(Date term) {
        this.term = term;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public double getPenality() {
        return penality;
    }

    public void setPenality(double penality) {
        this.penality = penality;
    }
    
    
    
}
