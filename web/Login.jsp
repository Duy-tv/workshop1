<%-- 
    Document   : Login
    Created on : Jun 16, 2024, 4:11:44 PM
    Author     : Duy.Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/animations.css">
    </head>
    <body class="flex-block items-center  min-h-screen bg-gray-100">
        <%@include file="includes/Header.jsp" %>
        <form action="LoginServlet" method="post" class="bg-white p-6 rounded-lg shadow-md w-full max-w-sm h-full max-h-sm my-20 mx-auto fade-in">
            <h2 class="text-2xl font-bold mb-4 text-center">Login</h2>

            <div class="mb-4">
                <label for="txtaccount" class="block text-gray-700">Account</label>
                <input type="text" id="txtaccount" name="txtaccount" placeholder="Enter Account" required=""
                       class="mt-1 block w-full px-3 py-2 bg-white border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:ring-1 focus:border-indigo-500 sm:text-sm" />
            </div>

            <div class="mb-6">
                <label for="txtpassword" class="block text-gray-700">Password</label>
                <input type="password" id="txtpassword" name="txtpassword" placeholder="Enter password" required=""
                       class="mt-1 block w-full px-3 py-2 bg-white border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:ring-1 focus:border-indigo-500 sm:text-sm" />
            </div>

            <button type="submit" class="w-full py-2 px-4 bg-indigo-600 text-white font-bold rounded-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-opacity-50" name="action" value="<%= Action.LOGIN %>">Login</button>
            <p class="my-2 text-red-600">${message}</p>
            
        </form>
    </body>
</html>