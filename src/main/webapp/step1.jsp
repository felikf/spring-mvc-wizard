<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

        <h1>Training Course Feedback Form</h1>
        <p>Please help us to improve our class by completing this form.</p>


        <form:form modelAttribute="wizardForm" action="step2Init" method="post">

            <div class="form-group <spring:bind path="firstName"><c:if test="${status.error}">has-error</c:if></spring:bind>">
                <label class="control-label" for="firstName">First Name:</label>
                <form:input type="text" path="firstName" class="form-control" id="firstName"/>
                <form:errors path="firstName" class="help-block" element="span"/>
            </div>

            <div class="form-group <spring:bind path="lastName"><c:if test="${status.error}">has-error</c:if></spring:bind>">
                <label class="control-label" for="firstName">Last Name:</label>
                <form:input type="text" path="lastName" class="form-control" id="lastName"/>
                <form:errors path="lastName" class="help-block" element="span"/>
            </div>

            <div class="form-group <spring:bind path="emailAddress"><c:if test="${status.error}">has-error</c:if></spring:bind>">
                <label class="control-label" for="emailAddress">Email Address:</label>
                <form:input type="text" path="emailAddress" class="form-control" id="emailAddress"/>
                <form:errors path="emailAddress" class="help-block" element="span"/>
            </div>

            <div class="form-group <spring:bind path="trainingCourseId"><c:if test="${status.error}">has-error</c:if></spring:bind>">
                <label class="control-label" for="trainingCourseId">Training Course:</label>
                <form:select path="trainingCourseId" class="form-control" id="trainingCourseId" items="${wizardForm.getAvailableTrainingCoursesMap()}">
                </form:select>
                <form:errors path="trainingCourseId" class="help-block" element="span"/>
            </div>

            <div class="form-group <spring:bind path="trainingCourseDate"><c:if test="${status.error}">has-error</c:if></spring:bind>">
                <label class="control-label" for="trainingCourseDate">Training Course Date:</label>
                <form:input type="text" path="trainingCourseDate" value="${wizardForm.trainingCourseDate}" class="form-control" id="trainingCourseDate"/>
                <form:errors path="trainingCourseDate" class="help-block" element="span"/>
            </div>

            <input id="reset" type="button" value="&lt; Cancel" class="btn btn-primary"/>
            <input type="submit" value="Continue &gt;" class="btn btn-primary"/>

        </form:form>

    </div>
</div>


<script type="text/javascript">
    document.getElementById("reset").onclick = function () {
        location.href = "wizardStop";
    };
</script>
</body>
</html>
