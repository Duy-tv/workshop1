<%-- 
    Document   : addNewProduct
    Created on : Jun 23, 2024, 11:36:12 AM
    Author     : Duy.Tran
    
    Description:
    This JSP file allows users to add a new product to the system. It includes a form with fields for product ID, name,
    image, brief description, unit, type (category), posted date, price, and discount. Users can select a category from
    a dropdown list populated dynamically from the 'categoryList' attribute in the session scope. The form submits data
    to the 'MainController' servlet using POST method with the action parameter set to 'Action.ADD_NEW_PRODUCT'.
    
    Dependencies:
    - Includes 'includes/Header.jsp' for the header section of the page.
    - Utilizes an external CSS file 'addNew.css' for styling the form elements.
    
    Features:
    - Provides input fields and dropdowns for all required product details.
    - Validates that necessary fields are filled (e.g., product ID, name, image, unit, type, price, discount).
    - Displays an optional message ('message' attribute) for validation or informational purposes.
    - Automatically populates the current date as the posted date.
    - Allows users to submit the form to add a new product to the system.
    
    Note:
    - 'Action.ADD_NEW_PRODUCT' is a constant defined in the 'Action' interface, representing the action to add a new product.
    - 'loginedAcc' refers to the currently logged-in account.
    - 'categoryList' is a collection of categories available for product classification.
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
                    <input class="input-style" type="text" id="productId" name="productId" placeholder="Enter product Id" required="" value="${param.productId}"/>
                </div>
                <div class="div-style">
                    <label for="productName" class="label-style">Product Name</label>
                    <input class="input-style" type="text" id="productName" name="productName" placeholder="Enter product Name" required="" value="${param.productName}"/>
                </div>
                <div class="div-style">
                    <label for="productImage" class="label-style">Product Image</label>
                    <p class="text-gray-400">Note: Put images in the path /images/sanPham</p>
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

                <button type="submit" class="button-style" name="action" value="<%= Action.ADD_NEW_PRODUCT%>">Add</button>
            </form>
        </div>
    </div>
</body>
</html>
