<%-- 
    Document   : updateProduct
    Created on : Jun 23, 2024, 8:12:15 PM
    Author     : Duy.Tran
    
    Description:
    This JSP file allows administrators or staff to update product information. It includes fields such as product ID (displayed but not editable), product name, product image, brief description, posted date (automatically set to current date), unit, category type, account, price, and discount.
    Users can update the product information by modifying the respective fields and submitting the form.
    
    Dependencies:
    - Includes 'includes/Header.jsp' for the header section of the page.
    - Requires 'MainController' for form submission and identifies the action as '${Action.EDIT_PRODUCT}'.
    
    Note:
    - The product ID is displayed but not editable ('readonly').
    - Product image upload is facilitated through an input of type 'file' with acceptance restricted to image types.
    - Errors related to required fields and numeric inputs are handled by HTML5 'required' attribute and input type restrictions.
--%>

<%@page import="java.time.LocalDate"%>
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
                <c:set var="selectedTypeId" value="${sessionScope.selectedTypeId}" />
                <form action="MainController" method="post">
                    <div class="div-style">
                        <label for="productId" class="label-style">Product Id</label>
                        <p class="text-red-600">${message}</p>
                        <input class="input-style cursor-not-allowed bg-gray-100" type="text" id="productId" name="productId" placeholder="Enter product Id" readonly="" value="${param.productId}"/>
                    </div>
                    <div class="div-style">
                        <label for="productName" class="label-style">Product Name</label>
                        <input class="input-style" type="text" id="productName" name="productName" placeholder="Enter product Name" required="" value="${param.productName}"/>
                    </div>
                    <div class="div-style">
                        <label for="productImage" class="label-style">Product Image</label>
                        <p class="text-gray-400">Note:Put images in the path /images/sanPham</p>
                        <input class="input-style" type="file" name="productImage" placeholder="Enter product Image" accept="image/*" required="" value="${param.productImage}" />
                    </div>
                    <div class="div-style">
                        <label for="brief" class="label-style">Brief</label>
                        <textarea class="input-style" id="brief" name="brief" placeholder="Enter brief" >${param.brief}</textarea>
                    </div>
                    <div>
                        <input class="input-style" type="hidden" id="postedDate" name="postedDate" value="<%= LocalDate.now()%>" required />
                    </div>
                    <div class="div-style">
                        <label for="unit" class="label-style">Unit</label>
                        <input class="input-style" type="text" id="unit" name="unit" placeholder="unit" required="" value="${param.unit}"/>
                    </div>
                    <div class="div-style">
                        <label for="typeId" class="label-style">Type</label>
                        <select class="input-style" id="typeId" name="typeId" required>
                            <c:forEach var="option" items="${categoryList}">
                                <option value="${option.typeId}" ${selectedTypeId != null && selectedTypeId == option.typeId ? 'selected="selected"' : ''}> ${option.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <input class="input-style" type="hidden" id="account" name="account" value="${loginedAcc.account}"/>
                    </div>
                    <div class="div-style">
                        <label for="price" class="label-style">price</label>
                        <input class="input-style" type="number" name="price" id="price" placeholder="Enter price"  required="" value="${param.price}"/>
                    </div>
                    <div class="div-style">
                        <label for="discount" class="label-style">discount</label>
                        <input class="input-style" type="number"  name="discount" id="discount" placeholder="Enter discount" required="" value="${param.discount}"/>
                    </div>

                    <button type="submit" class="button-style" name="action" value="<%= Action.EDIT_PRODUCT%>">Update</button>
                </form>
            </div>
        </div>
    </body>
</html>
