<%-- 
    Document   : addCategory
    Created on : Jun 22, 2024, 1:08:43 PM
    Author     : Duy.Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/Header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/addNew.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="flex-block items-center  min-h-screen bg-gray-100">
       <div class="my-24 mx-32">
           <div class="bg-white p-8 rounded-lg shadow-lg w-full max-w-screen-xl">
               
               <form action="MainController" method="post">
                   <div class="div-style">
                       <label for="categoryName" class="label-style">Category Name</label>
                       <input class="input-style" type="text" name="categoryName" placeholder="Enter name" required=""/>
                   </div>
                   <div class="div-style">
                       <label for="memo" class="label-style">Memo</label>
                       <textarea class="input-style" name="memo" placeholder="Enter memo"></textarea>
                   </div>
                   
                   <button type="submit" class="button-style" name="action" value="<%= Action.ADD_NEW_CATEGORY %>">Add</button>
               </form>
           </div>
       </div>
    </body>
</html>
