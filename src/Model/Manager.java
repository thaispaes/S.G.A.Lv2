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
