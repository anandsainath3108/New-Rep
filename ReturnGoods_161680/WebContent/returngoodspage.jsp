<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Return Goods Page </title>
</head>
<body>
<h1><u>Return Goods</u></h1>


<table border="1" align="center">

<fo:form action="success" method="POST" modelAttribute="goods" >

<tr>
<td>Customer E-Mail Id: </td>
<td> <fo:input path="customerEmailId" /></td>
</tr>

<tr>
<td>Product Id: </td>
<td> <fo:input path="productId" /></td>
</tr>

<tr>
<td>Product Quantity: </td>
<td> <fo:input path="productQuantity" /></td>
</tr>

<tr>
<td>Do you want to Exchange Goods or Refund Amount ?: </td>
<td> <fo:select path="exchangeStatus" items="${ExchangeRefund}" ></fo:select>
</td>
</tr>

<tr>
<td>Select the reason for Returning: </td>
<td> <fo:select path="productDescription" items="${returnGoodsReason}" ></fo:select>
</td>
</tr>

<tr>
<td>
<input type="submit" value="Save" />
</td>
</tr>

</fo:form>
</table>
</body>
</html>