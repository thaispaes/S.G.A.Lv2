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
    
    private Long id;
    private Student student;
    private Book book;
    private Client client;
    private Date rented;
    private Date returnDate;
    private boolean delivered;
    private double penality;
    private String obrservation;

    public Rent(Student student, Book book, Client client, Date rented, Date returnDate, boolean delivered, double penality, String obrservation) {
        this.student = student;
        this.book = book;
        this.client = client;
        this.rented = rented;
        this.returnDate = returnDate;
        this.delivered = delivered;
        this.penality = penality;
        this.obrservation = obrservation;
    }


    
    public Rent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = new Long (id);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getObrservation() {
        return obrservation;
    }

    public void setObrservation(String obrservation) {
        this.obrservation = obrservation;
    }
    
    
    
}
