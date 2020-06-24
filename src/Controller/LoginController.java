/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import DAO.ManagerDAO;
import DAO.StudentDAO;
import DAO.UserDAO;
import Model.Manager;
import Model.Student;
import Model.User;
import View.Login;

/**
 *
 * @author Samuel
 */
public class LoginController {
    
    private final Login view;
    private final LoginHelper helper;
    private final UserDAO userDAO;
    private final StudentDAO studntDAO;
    private final ManagerDAO managerDAO;

    public LoginController(Login view) {
        
        this.view = view;
        this.helper = new LoginHelper(view);
        this.userDAO = new UserDAO();
        this.studntDAO = new StudentDAO();
        this.managerDAO = new ManagerDAO();
        
    }

    public void logInto() {
      
        String login = helper.getLogin();
        String password = helper.getPassword();
        
        Manager manager = managerDAO.exist(login, password);
        
        if(manager != null){
           
            UserDAO.setLoggedUser(manager);
        
        }
        
        User user = userDAO.exist(login, password);
        
        if(user != null){
        
            UserDAO.setLoggedUser(user);
        
    }
    
        Student student = studntDAO.exist(login, password);
        
        if(student != null){
            
            UserDAO.setLoggedUser(student);
            
            openStar();
        }
    
}

    private void openStar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
