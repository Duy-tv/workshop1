<%-- 
    Document   : categories
    Created on : Jun 21, 2024, 4:23:07 PM
    Author     : Duy.Tran
    
    Description:
    This JSP file displays a list of categories in the system. It includes a table with columns for category ID, name, memo,
    and actions (update and delete). Each category is iterated over using the 'categoryList' attribute, which contains category
    objects with properties like typeId, categoryName, and memo. The form submission actions (update and delete) are handled
    by the 'MainController' servlet using POST method with parameters like typeId, categoryName, and memo.
    
    Dependencies:
    - Includes 'includes/Header.jsp' for the header section of the page.
    - Utilizes an external CSS file 'table.css' for styling the table elements.
    
    Features:
    - Displays a table listing all categories with their respective details.
    - Allows users to update or delete categories using form buttons.
    - Provides an option to add a new category by clicking the 'Add new' button, which submits an action to 'MainController'.
    
    Note:
    - 'Action.UPDATE_CATEGORY' and 'Action.DELETE_CATEGORY' are constants defined in the 'Action' interface, representing
      the actions for updating and deleting categories, respectively.
    - 'Action.ADD_CATEGORY' is a constant representing the action to add a new category.
    - 'categoryList' is a collection of categories retrieved from the server-side.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="styles/table.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <%@include file="includes/Header.jsp" %>
     <c:set var="userRole" value="${loginedAcc.roleInSystem}" />
    <div class="table-container">
        <div class="table-wrapper">
            <h1 class="text-2xl font-bold mb-4">List of categories in system</h1>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>MEMO</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="category" items="${categoryList}">
                        <tr>
                            <td>${category.typeId}</td>
                            <td>${category.categoryName}</td>
                            <td>${category.memo}</td>
                            <td>
                                <form action="MainController" method="post">
                                    <input type="hidden" name="typeId" value="${category.typeId}" />
                                    <input type="hidden" name="categoryName" value="${category.categoryName}" />
                                    <input type="hidden" name="memo" value="${category.memo}" />
                                    <button class="update" type="submit" name="action" value="<%= Action.UPDATE_CATEGORY%>">Update</button>
                                    <button class="delete" type="submit" name="action" value="<%= Action.DELETE_CATEGORY%>">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:if test="${userRole == 1}">
            <form action="MainController" method="post">
                <div class="flex w-full justify-center mt-7">
                    <button class="deactivate" type="submit" name="action" value="<%= Action.ADD_CATEGORY%>">Add new</button>
                </div>
            </form>
            </c:if>
        </div>
    </div>
</body>
</html>
