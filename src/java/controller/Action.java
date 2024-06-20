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
    public final String ADD_NEW = "add";
    public final String UPDATE = "update";
    public final String UPDATE_ACC = "updateAcc";
    public final String DELETE = "delete";
    
    
    public final String HOME_URL = "index.jsp";
    public final String ACCOUNT_URL = "account.jsp";
    public final String PRODUCT_URL = "product.jsp";
    public final String CATEGORIES_URL = "categories.jsp";
    public final String CONTACT_URL = "contact.jsp";
    public final String LOGIN_URL = "login.jsp";
    public final String REGISTER_URL = "register.jsp";
    public final String UPDATE_ACCOUNT_URL = "updateAcc.jsp";
    public final String ERROR_URL = "error404.html";
}
