<%-- 
    Document   : addCategory
    Created on : Jun 22, 2024, 1:08:43 PM
    Author     : Duy.Tran
    
    Description:
    This JSP file allows users to add a new category to the system. It includes a form with fields for category name and memo.
    The form submits data to the 'MainController' servlet using POST method with the action parameter set to 'Action.ADD_NEW_CATEGORY'.
    
    Dependencies:
    - Includes 'includes/Header.jsp' for the header section of the page.
    - Utilizes an external CSS file 'addNew.css' for styling the form elements.
    
    Features:
    - Provides input fields for category name and memo.
    - Validates that the category name is required.
    - Allows users to submit the form to add a new category.
    
    Note:
    - 'Action.ADD_NEW_CATEGORY' is a constant defined in the 'Action' interface, representing the action to add a new category.
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
