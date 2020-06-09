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
    private String type;
    public static final String TYPE_ADM = "ADM";
    public static final String TYPE_USER = "USER";

    public User(Long id, String name, String login, String password, String type) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.type = type;
    }

    public User() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
