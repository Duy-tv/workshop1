<%-- 
    Document   : showInfo
    Created on : Jun 22, 2024, 9:38:16 PM
    Author     : Duy.Tran
    
    Description:
    This JSP file displays detailed information about a specific product. It includes the product's image, name, brief description, price (with or without discount), unit, and additional details such as availability, condition, and shipping options.
    Users can add the product to their cart or navigate back to the homepage.
    
    Dependencies:
    - Includes 'includes/Header.jsp' for the header section of the page.
    
    Note:
    - The product information is retrieved using '${param.*}' variables.
    - Depending on whether the product has a discount, different pricing information is displayed.
    - Buttons allow users to add the product to their cart ('Add to Cart') or return to the homepage ('Back').
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="includes/Header.jsp" %>
</head>
<body>
    <div class="flex items-center justify-center min-h-screen bg-gray-100">
        <div class="max-w-7xl mx-auto px-8">
            <div class="grid grid-cols-1 md:grid-cols-4 gap-4">
                <div class="col-span-1 md:col-span-2">
                    <div class="max-w-md rounded-lg overflow-hidden shadow-lg bg-white">
                        <div class="w-full h-160 overflow-hidden">
                            <img class="object-cover w-full h-full" src=".${param.productImage}">
                        </div>
                    </div>
                </div>

                <div class="col-span-1 md:col-span-2">
                    <div class="max-w-md bg-white shadow-lg rounded-lg overflow-hidden">
                        <div class="px-6 py-4">
                            <div class="font-bold text-xl mb-2">${param.productName}</div>
                            <p class="text-gray-700 text-base mb-4">${param.brief}</p>
                            <div class="flex items-center mb-2">
                                <c:choose>
                                    <c:when test="${param.discount != 0}">
                                        <span class="text-green-600 text-sm font-semibold">${param.price - (param.price * param.discount / 100)} VND</span>
                                        <span class="text-gray-600 text-sm line-through mr-2">${param.price} VND</span>
                                        <span class="text-red-600 text-sm ml-2">${param.discount}% OFF</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="text-green-600 text-sm font-semibold">${param.price} VND</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="mt-4">
                                <p class="text-gray-700 text-sm"><span class="font-semibold">Unit:</span> ${param.unit}</p>
                                <p class="text-gray-700 text-sm"><span class="font-semibold">Name:</span> ${param.productName}</p>
                                <p class="text-gray-700 text-sm"><span class="font-semibold">Availability:</span> In stock</p>
                                <p class="text-gray-700 text-sm"><span class="font-semibold">Condition:</span> New</p>
                                <p class="text-gray-700 text-sm"><span class="font-semibold">Shipping:</span> Free Shipping</p>
                            </div>
                            <form action="MainController" method="post">
                                <div class="flex justify-between mt-7">
                                    <button class="mt-4 bg-blue-500 hover:bg-blue-600 text-white py-2 px-4 rounded focus:outline-none focus:shadow-outline">Add to Cart</button>
                                    <button class="mt-4 text-blue-500 hover:text-blue-600 hover:underline py-2 px-4" name="action" value="<%=Action.HOME%>">Back</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
