/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import View.Login;

/**
 *
 * @author Samuel
 */
public class LoginHelper {
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }

    public String getLogin() {
      
        return view.getTxtLoguin().getText();
    }
    
    public String getPassword(){
        
         char chars[] = view.getTxtSenha().getPassword();
         
         String password = new String(chars);  
         
         return password;
    }
    
}
