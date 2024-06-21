<%-- 
    Document   : Account
    Created on : Jun 16, 2024, 3:00:28 PM
    Author     : Duy.Tran
--%>

<%@page import="controller.Action"%>
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
                        <c:set var="currentAccount" value="${loginedAcc.account}"></c:set>
                        <c:forEach var="account" items="${accountList}">
                            
                            <c:if test="${!account.account.equals(currentAccount) }">
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


                                </tr>
                            </c:if>

                        </c:forEach>
                    </tbody>
                </table>
                <div class="flex w-full justify-center mt-7 hover:text-blue-500 hover:underline">
                    <a href="MainController?action=<%= Action.ADD_NEW%>">Add new account</a>
                </div>
            </div>
        </div>
    </body>
</html>
