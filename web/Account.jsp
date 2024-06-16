<%-- 
    Document   : Account
    Created on : Jun 16, 2024, 3:00:28 PM
    Author     : Duy.Tran
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <jsp:include page="includes/Header.jsp"/>
    <link href="styles/table.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="table-container">
        <div class="table-wrapper">
            <h1 class="text-2xl font-bold mb-4">List of account in system</h1>
            <table>
                <thead>
                    <tr>
                        <th>Account</th>
                        <th>Full name</th>
                        <th>Birth day</th>
                        <th>Gender</th>
                        <th>Phone</th>
                        <th>Role in system</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="account" items="${accountList}">
                        <tr>
                            <td>${account.account}</td>
                            <td>${account.firstName}, ${account.lastName}</td>
                            <td>${account.birthday}</td>
                            <td>${account.gender ? 'Male' : 'Female'}</td>
                            <td>${account.phone}</td>
                            <td><c:choose>
                                    <c:when test="${account.roleInSystem == 1}">
                                        Administrator
                                    </c:when>
                                    <c:otherwise>
                                        Staff
                                    </c:otherwise>
                                </c:choose></td>
                            <td>
                                <button class="update">Update</button>
                                <button class="deactivate">${account.isUse ? 'Deactivate' : 'Activate'}</button>
                                <button class="delete">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
