<%-- 
    Document   : product
    Created on : Jun 21, 2024, 4:22:55 PM
    Author     : Duy.Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/Header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/productTable.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="table-container">
            <div class="table-wrapper">
                <h1 class="table-title">List of products in the system</h1>
                <table class="product-table rounded-lg">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NAME</th>
                            <th>IMAGE</th>
                            <th>DATE</th>
                            <th>TYPE ID</th>
                            <th>ACCOUNT</th>
                            <th>UNIT</th>
                            <th>PRICE</th>
                            <th>DISCOUNT</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${productList}">
                            <tr>
                                <td>${product.productId}</td>
                                <td>${product.productName}</td>
                                <td><img src=".${product.productImage}" alt="${product.productName} Image" /></td>
                                <td>${product.postedDate}</td>
                                <td>${product.type}</td>
                                <td>${product.account}</td>
                                <td>${product.unit}</td>
                                <td>${product.price}</td>
                                <td>${product.discount}</td>
                                <td>
                                    <form class="action-buttons" action="MainController" method="post">
                                        <input type="hidden" name="productId" value="${product.productId}" />
                                        <input type="hidden" name="productName" value="${product.productName}" />
                                        <input type="hidden" name="productImage" value="${product.productImage}" />
                                        <input type="hidden" name="brief" value="${product.brief}" />
                                        <input type="hidden" name="postedDate" value="${product.postedDate}" />
                                        <input type="hidden" name="type" value="${product.type}" />
                                        <input type="hidden" name="account" value="${product.account}" />
                                        <input type="hidden" name="unit" value="${product.unit}" />
                                        <input type="hidden" name="price" value="${product.price}" />
                                        <input type="hidden" name="discount" value="${product.discount}" />
                                        <button class="button-update rounded-lg" type="submit" name="action" value="<%= Action.UPDATE_PRODUCT%>">Update</button>
                                        <button class="button-delete rounded-lg" type="submit" name="action" value="<%= Action.DELETE_PRODUCT%>">Delete</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <form action="MainController" method="post">
                    <div class="flex w-full justify-center mt-7">
                        <button class="deactivate" type="submit" name="action" value="<%= Action.ADD_PRODUCT%>">Add new</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
