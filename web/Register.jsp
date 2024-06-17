<%-- 
    Document   : Register
    Created on : Jun 16, 2024, 4:40:18 PM
    Author     : Duy.Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/Header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
    </head>
    <body>
        <div class="bg-gray-100 flex items-center justify-center h-full w-full">
            <div class="bg-white p-8 rounded-lg shadow-lg w-full max-w-screen-xl">
                <h2 class="text-2xl font-bold mb-6 text-gray-800">Add new account</h2>
                <form action="MainController" method="post">
                    <div class="mb-4">
                        <label class="block text-gray-700">Account</label>
                        <p style="color:red">${message}</p>
                        <input type="text" name="account" class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-indigo-500" placeholder="Enter account" required>
                    </div>
                    <div class="mb-4">
                        <label class="block text-gray-700">Password</label>
                        <input type="password" name="password" class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-indigo-500" placeholder="Enter password" required>
                    </div>
                    <div class="mb-4">
                        <label class="block text-gray-700">Last name</label>
                        <input type="text" name="lastName" class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-indigo-500" placeholder="Last name" required>
                    </div>
                    <div class="mb-4">
                        <label class="block text-gray-700">First name</label>
                        <input type="text" name="firstName" class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-indigo-500" placeholder="First name" required>
                    </div>
                    <div class="mb-4">
                        <label class="block text-gray-700">Phone number</label>
                        <p style="color:red">${message1}</p>
                        <input type="text" name="phone" class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-indigo-500" placeholder="Phone number" required>
                    </div>
                    <div class="mb-4">
                        <label class="block text-gray-700">Birth day</label>
                        <input type="date" name="birthday" class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-indigo-500" required>
                    </div>
                    <div class="mb-4">
                        <label class="block text-gray-700">Gender</label>
                        <div class="flex items-center">
                            <label class="mr-4">
                                <input type="radio" name="gender" value="1" class="mr-1" required> Male
                            </label>
                            <label>
                                <input type="radio" name="gender" value="0" class="mr-1" required> Female
                            </label>
                        </div>
                    </div>
                    <div class="mb-4">
                        <label class="block text-gray-700">Role in system</label>
                        <select name="roleInSystem" class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:border-indigo-500" required>
                            <option value="1">Administrator</option>
                            <option value="0">Staff</option>
                        </select>
                    </div>
                    <div class="mb-4">
                        <label class="block text-gray-700 flex">Active</label>
                        <div class="flex items-center">
                            <label class="mr-4" >
                                <input type="radio" name="isUse" value="1" class="mr-1" checked> Enable
                            </label>
                            <label class="mr-4" >
                                <input type="radio" name="isUse" value="0" class="mr-1" > Disable
                            </label>
                        </div>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="w-full bg-indigo-500 text-white px-4 py-2 rounded-md hover:bg-indigo-600 focus:outline-none focus:bg-indigo-600" name="action" value="<%= Action.REGISTER %>">Add</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
