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


    <form:form modelAttribute="wizardForm" action="step3Init" method="post">

      <div class="form-group">
        <label for="trainingCourseSectionId">Favorite Section:</label>

        <form:select path="trainingCourseSectionId" class="form-control" id="trainingCourseSectionId" items="${wizardForm.getAvailableTrainingCourseSectionsMap()}">
        </form:select>
        <form:errors path="trainingCourseSectionId" />

      </div>

      <div class="form-group">
        <label>Please rate the rating:</label>

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
        <label for="comments">Please share with us your comments on how we can improve this class for future:</label>
        <textarea rows="6" cols="40" name="comments" class="form-control" id="comments"></textarea>
      </div>

      <form:input path="stepTypeBack" type="submit" name="back" value="< Back" class="btn btn-primary"/>
      <form:input path="stepTypeForward" type="submit" value="Continue >" class="btn btn-primary"/>
    </form:form>

  </div>
</div>

</body>
</html>
