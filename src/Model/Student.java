/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Samuel
 */
public class Student {
    
    private Long id;
    private String name;
    private String CEP;
    private String login;
    private String password;
    private ImageFile imagePerfil;
    private String registration;
    private String email;
    private String phone;
    private String Address;
    private String city;
    private String module;
    private String grade;
    private String course;
    private String School;
    private String shift;
    private ArrayList<Rent> rents;

    public Student(Long id, String name, String CEP, String login, String password, ImageFile imagePerfil, String registration, String email, String phone, String Address, String city, String module, String grade, String course, String School, String shift, ArrayList<Rent> rents) {
        this.id = id;
        this.name = name;
        this.CEP = CEP;
        this.login = login;
        this.password = password;
        this.imagePerfil = imagePerfil;
        this.registration = registration;
        this.email = email;
        this.phone = phone;
        this.Address = Address;
        this.city = city;
        this.module = module;
        this.grade = grade;
        this.course = course;
        this.School = School;
        this.shift = shift;
        this.rents = rents;
    }

    public Student(String name, String CEP, String login, String password, ImageFile imagePerfil, String registration, String email, String phone, String Address, String city, String module, String grade, String course, String School, String shift, ArrayList<Rent> rents) {
        this.name = name;
        this.CEP = CEP;
        this.login = login;
        this.password = password;
        this.imagePerfil = imagePerfil;
        this.registration = registration;
        this.email = email;
        this.phone = phone;
        this.Address = Address;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ImageFile getImagePerfil() {
        return imagePerfil;
    }

    public void setImagePerfil(ImageFile imagePerfil) {
        this.imagePerfil = imagePerfil;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
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
