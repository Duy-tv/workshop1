<%-- 
    Document   : updateCategory
    Created on : Jun 22, 2024, 12:29:50 PM
    Author     : Duy.Tran
    
    Description:
    This JSP file allows administrators or staff to update category information. It includes fields such as category ID (displayed but not editable), category name, and memo.
    Users can update the category information by modifying the respective fields and submitting the form.
    
    Dependencies:
    - Includes 'includes/Header.jsp' for the header section of the page.
    
    Note:
    - The category ID is displayed but not editable ('readonly').
    - Errors related to category name input validation are handled by HTML5 'required' attribute.
    - The form action is handled by 'MainController' and identifies the action as '${Action.EDIT_CATEGORY}'.
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
                       <label for="typeId" class="label-style">ID</label>
                       <input class="input-style cursor-not-allowed bg-gray-100" type="text" name="typeId" value="${param.typeId}" readonly/>
                   </div>
                   <div class="div-style">
                       <label for="categoryName" class="label-style">Category Name</label>
                       <input class="input-style" type="text" name="categoryName" value="${param.categoryName}" placeholder="Enter name" required=""/>
                   </div>
                   <div class="div-style">
                       <label for="memo" class="label-style">Memo</label>
                       <textarea class="input-style" name="memo" placeholder="Enter memo">${param.memo}</textarea>
                   </div>
                   
                   <button type="submit" class="button-style" name="action" value="<%= Action.EDIT_CATEGORY %>">Update</button>
               </form>
           </div>
       </div>
    </body>
</html>
