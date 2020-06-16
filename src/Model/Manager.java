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
public class Manager extends User{
    
    private int accessLevel;
    private String school;
    public static final int ACCESS_MAX = 3;
    public static final int ACCESS_MED = 2;
    public static final int ACCESS_MIN = 1;

    public Manager(int accessLevel, ImageFile perfilImage, String school, Long id, String name, String login, String password, ImageFile perfilImage, String email, String address, String CEP, String phone) {
        super(id, name, login, password, perfilImage, email, address, CEP, phone);
        this.accessLevel = accessLevel;
        this.school = school;
    }

    public Manager(int accessLevel, ImageFile perfilImage, String school, String name, String login, String password, ImageFile perfilImage, String email, String address, String CEP, String phone) {
        super(name, login, password, perfilImage, email, address, CEP, phone);
        this.accessLevel = accessLevel;
        this.school = school;
    }


    
    public Manager() {
        super.perfilImage = new ImageFile("");
    }
    
    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

   
    
}
