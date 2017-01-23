<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
    </script>
</head>
<body>
<div class="container theme-showcase">
    <div class="jumbotron">

        <h1>Feedbacks</h1>

        <p>There are listed all the feedback sent.</p>

    </div>

    <c:if test="${message != null}">
        <div class="alert alert-success">
            <c:out value="${message}" />
        </div>
    </c:if>

    <table class="table">
        <tr>
            <th>#</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Email Address</th>
            <th>Training Course</th>
            <th>Training Course Date</th>
            <th>Favorite Section</th>
            <th>Rating</th>
            <th>Comments</th>
        </tr>

        <c:forEach items="${feedbacks}" var="feedback" varStatus="index">
            <tr>
                <td><c:out value="${index.index}"/></td>
                <td><c:out value="${feedback.visitor.firstName}"/></td>
                <td><c:out value="${feedback.visitor.lastName}"/></td>
                <td><c:out value="${feedback.visitor.emailAddress}"/></td>
                <td><span class="label label-primary"><c:out value="${feedback.trainingCourse.name}"/></span></td>
                <td>
                    <fmt:formatDate pattern="dd/MM/yyyy" value="${feedback.date}" />
                </td>
                <td><span class="label label-info"><c:out value="${feedback.favoriteSection.name}"/></span></td>
                <td><c:out value="${feedback.rating}"/></td>
                <td><c:out value="${feedback.comment}"/></td>
            </tr>
        </c:forEach>

    </table>

    <a href="/" > Home</a>

</div>

</body>
</html>
