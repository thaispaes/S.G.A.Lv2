/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Samuel
 */
public class User {
    
    private Long id;
    private String name;
    private String login;
    private String password;
    private ImageFile perfilImage;
    private String email;
    private String address;
    private String CEP;
    private String phone;
    private String school;

    public User(Long id, String name, String login, String password, ImageFile perfilImage, String email, String address, String CEP, String phone, String school) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.perfilImage = perfilImage;
        this.email = email;
        this.address = address;
        this.CEP = CEP;
        this.phone = phone;
        this.school = school;
    }

    public User(String name, String login, String password, ImageFile perfilImage, String email, String address, String CEP, String phone, String school) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.perfilImage = perfilImage;
        this.email = email;
        this.address = address;
        this.CEP = CEP;
        this.phone = phone;
        this.school = school;
    }

    public User() {
        perfilImage = new ImageFile("");
    }
    
    
    
}
