/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Duy.Tran
 */
public interface Action {
    public final String HOME = "home";
    public final String REGISTER = "register"; 
    public final String LOGIN = "login";
    public final String LOGOUT = "logout";
    public final String ADD_TO_CART = "cart";
    public final String ACCOUNT = "account";
    public final String PRODUCT = "product";
    public final String CATEGORIES = "categories";
    public final String CONTACT = "contact";
    
    
    
    public final String HOME_URL = "Index.jsp";
    public final String ACCOUNT_URL = "Account.jsp";
    public final String PRODUCT_URL = "Product.jsp";
    public final String CATEGORIES_URL = "Categories.jsp";
    public final String CONTACT_URL = "Contact.jsp";
    public final String LOGIN_URL = "Login.jsp";
    public final String REGISTER_URL = "Register.jsp";
    
}
