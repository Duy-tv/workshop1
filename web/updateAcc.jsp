<%-- 
    Document   : UpdateAcc
    Created on : Jun 18, 2024, 8:32:16 PM
    Author     : Duy.Tran
    
    Description:
    This JSP file allows administrators or staff to update account information. It includes fields such as account details (displayed but not editable), password, last name, first name, phone number, birthday, gender, role in the system, and account status.
    Users can update the account information by modifying the respective fields and submitting the form.
    
    Dependencies:
    - Includes 'includes/Header.jsp' for the header section of the page.
    
    Note:
    - The account details such as account ID are displayed but not editable ('readonly').
    - Errors related to phone number input validation are displayed using '${message}'.
    - Radio buttons for gender and account status ('Active') are pre-selected based on the 'param' values.
    - Users can select between 'Administrator' and 'Staff' roles from a dropdown list.
    - The form action is handled by 'MainController' and identifies the action as '${Action.UPDATE_ACC}'.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/Header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/addNew.css" rel="stylesheet" type="text/css"/>
        <title>Product</title>
    </head>
    <body>
        <div class="bg-gray-100 flex items-center justify-center h-full w-full p-8">
            <div class="bg-white p-8 rounded-lg shadow-lg w-full max-w-screen-xl">
                <h2 class="text-2xl font-bold mb-6 text-gray-800">Update account</h2>
                <form action="MainController" method="post">
                    <div class="div-style">
                        <label class="label-style">Account</label>
                        <input type="text" name="account" class="input-style cursor-not-allowed bg-gray-100" placeholder="Enter account" value="${param.account}" readonly>
                    </div>
                    <div class="div-style">
                        <label class="label-style">Password</label>
                        <input type="text" name="password" class="input-style" placeholder="Enter password" value="${param.password}" required>
                    </div>
                    <div class="div-style">
                        <label class="label-style">Last name</label>
                        <input type="text" name="lastName" class="input-style" placeholder="Last name" value="${param.lastName}" required>
                    </div>
                    <div class="div-style">
                        <label class="label-style">First name</label>
                        <input type="text" name="firstName" class="input-style" placeholder="First name" value="${param.firstName}" required>
                    </div>
                    <div class="div-style">
                        <label class="label-style">Phone number</label>
                        <p class="error-message">${message}</p>
                        <input type="text" name="phone" class="input-style" placeholder="Phone number" value="${param.phone}" required>
                    </div>
                    <div class="div-style">
                        <label class="label-style">Birth day</label>
                        <input type="date" name="birthday" class="input-style" value="${param.birthday}" required>
                    </div>
                    <div class="div-style">
                        <label class="label-style">Gender</label>
                        <div class="flex items-center">
                            <label class="mr-4">
                                <input type="radio" name="gender" value="1" class="mr-1" ${param.gender == '1' ? 'checked' : ''} required> Male
                            </label>
                            <label>
                                <input type="radio" name="gender" value="0" class="mr-1" ${param.gender == '0' ? 'checked' : ''} required> Female
                            </label>
                        </div>
                    </div>
                    <div class="div-style">
                        <label class="label-style">Role in system</label>
                        <select name="roleInSystem" class="input-style" required>
                            <option value="1" ${param.roleInSystem == '1' ? 'selected' : ''}>Administrator</option>
                            <option value="2" ${param.roleInSystem == '2' ? 'selected' : ''}>Staff</option>
                        </select>
                    </div>
                    <div class="div-style">
                        <label class="label-style">Active</label>
                        <div class="flex items-center">
                            <label class="mr-4">
                                <input type="radio" name="isUse" value="1" class="mr-1" ${param.isUse == '1' ? 'checked' : ''}> Enable
                            </label>
                            <label>
                                <input type="radio" name="isUse" value="0" class="mr-1" ${param.isUse == '0' ? 'checked' : ''}> Disable
                            </label>
                        </div>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="button-style" name="action" value="<%= Action.UPDATE_ACC %>">Update</button>
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>