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

    <h2>Summary page</h2>

    <form:form modelAttribute="wizardForm" action="wizardFinish">

    <div class="form-group">
    </div>
      <label for="firstName">First Name:</label>
      <input readonly id="firstName" class="form-control" value="<c:out value="${wizardForm.firstName}"/>" />

      <div class="form-group">
        <label for="lastName">Last Name:</label>
        <input readonly id="lastName" class="form-control" value="<c:out value="${wizardForm.lastName}"/>" />
      </div>

      <div class="form-group">
        <label for="emailAddress">Email Address:</label>
        <input readonly id="emailAddress" class="form-control" value="<c:out value="${wizardForm.emailAddress}"/>" />
      </div>

      <div class="form-group">
        <label for="trainingCourse">Training Course:</label>
        <input readonly id="trainingCourse" class="form-control" value="<c:out value="${wizardForm.getTrainingCourse().getName()}"/>" />
      </div>

      <div class="form-group">
        <label for="trainingCourseDate">Training Course Date:</label>
        <input readonly id="trainingCourseDate" class="form-control" value="<c:out value="${wizardForm.trainingCourseDate}"/>">
      </div>

      <div class="form-group">
        <label for="trainingCourseSection">Favorite Section:</label>
        <input readonly id="trainingCourseSection" class="form-control" value="<c:out value="${wizardForm.getTrainingCourseSection().getName()}"/>">
      </div>

      <div class="form-group">
        <label>Rating</label>

        <form:radiobutton path="rating" value="1" class="radio-inline"/>1
        <form:radiobutton path="rating" value="2" class="radio-inline"/>2
        <form:radiobutton path="rating" value="3" class="radio-inline"/>3
        <form:radiobutton path="rating" value="4" class="radio-inline"/>4
        <form:radiobutton path="rating" value="5" class="radio-inline"/>5

        <div>
          <form:errors path="rating" />
        </div>

      </div>

      <div class="form-group">
        <label for="comments">Comments:</label>
        <textarea readonly rows="6" cols="40" name="comments" class="form-control" id="comments"><c:out value="${wizardForm.comments}"/></textarea>
      </div>

      <div class="form-group">
        <form:input path="stepTypeBack" type="submit" id="back" name="back" value="< Back" class="btn btn-primary"/>
        <form:input path="stepTypeForward" type="submit" value="Send Feedback" style="font-weight: bold" class="btn btn-primary"/>
      </div>

    </form:form>

  </div>
</div>

</body>
</html>