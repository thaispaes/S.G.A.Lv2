/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author Samuel
 */
public class Student extends User{
    
    private ImageFile imagePerfil;
    private String registration;
    private String city;
    private String module;
    private String grade;
    private String course;
    private String School;
    private String shift;
    private ArrayList<Rent> rents;

    public Student(ImageFile imagePerfil, String registration, String city, String module, String grade, String course, String School, String shift, ArrayList<Rent> rents, Long id, String name, String login, String password, ImageFile perfilImage, String email, String address, String CEP, String phone) {
        super(id, name, login, password, perfilImage, email, address, CEP, phone);
        this.imagePerfil = imagePerfil;
        this.registration = registration;
        this.city = city;
        this.module = module;
        this.grade = grade;
        this.course = course;
        this.School = School;
        this.shift = shift;
        this.rents = rents;
    }

    public Student(ImageFile imagePerfil, String registration, String city, String module, String grade, String course, String School, String shift, ArrayList<Rent> rents, String name, String login, String password, ImageFile perfilImage, String email, String address, String CEP, String phone) {
        super(name, login, password, perfilImage, email, address, CEP, phone);
        this.imagePerfil = imagePerfil;
        this.registration = registration;
        this.city = city;
        this.module = module;
        this.grade = grade;
        this.course = course;
        this.School = School;
        this.shift = shift;
        this.rents = rents;
    }
    
    public Student() {
        
        imagePerfil = new ImageFile("");
        
    }
    
    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String School) {
        this.School = School;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public ArrayList<Rent> getRents() {
        return rents;
    }

    public void setRents(ArrayList<Rent> rents) {
        this.rents = rents;
    }
    
}
