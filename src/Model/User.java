/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.InputStream;

/**
 *
 * @author Samuel
 */
public class User {
    
    private Long id;
    private String name;
    private String login;
    private String password;
    private int accessLevel;
    private ImageFile perfilImage;
    private String ImageName;
    private String email;
    private String address;
    private String CEP;
    private String phone;
    private String school;
    public static final int ACCESS_MAX = 3;
    public static final int ACCESS_MED = 2;
    public static final int ACCESS_MIN = 1;

    public User(Long id, String name, String login, String password, int accessLevel, ImageFile perfilImage, String email, String address, String CEP, String phone, String school) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.accessLevel = accessLevel;
        this.perfilImage = perfilImage;
        this.email = email;
        this.address = address;
        this.CEP = CEP;
        this.phone = phone;
        this.school = school;
        this.ImageName = perfilImage.getName();        
    }

    public User(String name, String login, String password, int accessLevel, ImageFile perfilImage, String email, String address, String CEP, String phone, String school) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.accessLevel = accessLevel;
        this.perfilImage = perfilImage;
        this.email = email;
        this.address = address;
        this.CEP = CEP;
        this.phone = phone;
        this.school = school;
        this.ImageName = perfilImage.getName();
    }

    
    
    public User() {
        this.perfilImage = new ImageFile("");
        this.ImageName = perfilImage.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setId(int id) {
        this.id = new Long(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public ImageFile getPerfilImage() {
        return perfilImage;
    }

    public void setPerfilImage(ImageFile perfilImage) {
        this.perfilImage = perfilImage;
    }
    
    public void setPerfilImage(InputStream inputS, String name) {
        
        this.perfilImage = new ImageFile(inputS, name);
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    
}
