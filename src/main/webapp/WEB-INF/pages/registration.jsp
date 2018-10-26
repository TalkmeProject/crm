<%@ page import="com.hlebik.crm.enumerated.Status" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>

    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>
<c:if test = "${message ne null}">
         <p>"${message}"<p>
  </c:if>
<div id="container">
    <h3>Save Customer</h3>
    <form:form action="/registration" modelAttribute="user"
               method="POST">
        <form:hidden path="id"/>
        <table>
            <tbody>
                <tr>
                    <td><label>User name:</label></td>
                    <td><form:input path="userName"/></td>
                </tr>
                <tr>
                    <td><label>Last name:</label></td>
                    <td><form:input type="password" path="password"/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save"/></td>
                </tr>
            </tbody>
        </table>
    </form:form>
    <div style=""></div>
</div>

</body>
</html>