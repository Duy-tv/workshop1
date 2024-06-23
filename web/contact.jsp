<%-- 
    Document   : contact
    Created on : Jun 21, 2024, 4:27:28 PM
    Author     : Duy.Tran
    
    Description:
    This JSP file represents the contact page of the application. It includes a simple greeting message ("Hello World!") 
    and includes the header section using the 'Header.jsp' file.
    
    Dependencies:
    - Includes 'includes/Header.jsp' for the header section of the page.
    
    Features:
    - Displays a greeting message to users visiting the contact page.
    - Utilizes the header section to maintain consistent styling and navigation across pages.
    
    Note:
    - This page currently serves as a placeholder for future contact information or functionality.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <%@include file="includes/Header.jsp" %>
    <h1>Hello World!</h1>
</body>
</html>
