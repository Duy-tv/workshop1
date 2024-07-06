<%-- 
    Document   : Account
    Created on : Jun 16, 2024, 3:00:28 PM
    Author     : Duy.Tran
    
    Description:
    This JSP file displays a list of accounts in the system with their details such as account name, full name,
    birth date, gender, phone number, role in the system, and actions (update, activate/deactivate, delete).

    Dependencies:
    - Imports the 'controller.Action' interface for action constants.
    - Utilizes JSTL core tags for iteration and conditional rendering.
    - Includes an external CSS file 'table.css' for table styling.

    Features:
    - Lists accounts excluding the currently logged-in account.
    - Allows updating account details, activating/deactivating accounts, and deleting accounts.
    - Provides a link to add a new account.

    Note:
    - 'loginedAcc' refers to the currently logged-in account.
    - 'accountList' contains a list of accounts to display.
--%>

<%@page import="controller.Action"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Product</title>
        <jsp:include page="includes/Header.jsp"/>
        <link href="styles/table.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:set var="currentAccount" value="${loginedAcc.account}" />
        <c:set var="userRole" value="${loginedAcc.roleInSystem}" />

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
                                <c:if test="${userRole == 1}">
                                <th>Action</th>
                                </c:if>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="account" items="${accountList}">
                            <c:if test="${!account.account.equals(currentAccount)}">
                                <tr>
                                    <td>${account.account}</td>
                                    <td>${account.firstName}, ${account.lastName}</td>
                                    <td>${account.birthday}</td>
                                    <td>${account.gender ? 'Male' : 'Female'}</td>
                                    <td>${account.phone}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${account.roleInSystem == 1}">
                                                Administrator
                                            </c:when>
                                            <c:otherwise>
                                                Staff
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <c:if test="${userRole == 1}">
                                        <td>
                                            <form action="MainController" method="post">
                                                <input type="hidden" name="account" value="${account.account}" />
                                                <input type="hidden" name="password" value="${account.pass}" />
                                                <input type="hidden" name="firstName" value="${account.firstName}" />
                                                <input type="hidden" name="lastName" value="${account.lastName}" />
                                                <input type="hidden" name="phone" value="${account.phone}" />
                                                <input type="hidden" name="birthday" value="${account.birthday}" />
                                                <input type="hidden" name="gender" value="${account.gender ? '1' : '0'}"/>
                                                <input type="hidden" name="isUse" value="${account.isUse ? '1' : '0'}"/>
                                                <input type="hidden" name="roleInSystem" value="${account.roleInSystem}" />

                                                <button class="update" type="submit" name="action" value="<%= Action.UPDATE%>">Update</button>
                                                <button class="deactivate" type="submit" name="action" value="<%= Action.ACTIVE%>">${account.isUse ? 'Deactivate' : 'Activate'}</button>
                                                <button class="delete" type="submit" name="action" value="<%= Action.DELETE%>">Delete</button>
                                            </form>
                                        </td>
                                    </c:if>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${userRole == 1}">
                    <form action="MainController" method="post">
                        <div class="flex w-full justify-center mt-7 hover:text-blue-500">
                            <button class="deactivate" type="submit" name="action" value="<%= Action.ADD_NEW%>">Add new account</button>
                        </div>
                    </form>
                </c:if>
            </div>
        </div>
    </body>
</html>
