<%@ taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<jsp:include page="../include/header.jsp"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <%--    <link href="<c:url value="/pub/css/signup.css" />" rel="stylesheet">--%>

    <link rel="stylesheet" href="../../../pub/css/signup.css">
    <%--CSS Link--%>
    <script src="../../../pub/js/script.js" defer></script>
    <%--Js Link--%>


</head>
<body>
<form action="/login/SignupSubmit" id="signUpForm" method="post">


    <div class="sign-up-form">
        <!--    <img src="./images/P1.jpg" alt=""> -->
        <h1> Sign up now to learn more </h1>
        <input class="input-box" type="text" name="firstName" id="firstNameId" value="${form.firstName}"
               placeholder=" Your First Name ">
        <v:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
            <div style="color: red;"> ${error.getDefaultMessage()} </div>
        </v:forEach>


        <br>
        <br>

        <input class="input-box" type="text" name="lastName" id="lastNameId" value="${form.lastName}"
               placeholder="Your Last Name ">

        <v:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
            <div style="color: red;"> ${error.getDefaultMessage()} </div>
        </v:forEach>
        <br>
        <br>
        <input class="input-box" type="email" name="email" id="emailId" value="${form.email}" placeholder="Your  Email">


        <v:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
            <div style="color: red;"> ${error.getDefaultMessage()} </div>
        </v:forEach>

        <br>
        <br>

        <input class="input-box" type="paymentMethod" name="paymentMethod" id="paymentMethodId"
               value="${form.paymentMethod}" placeholder=" Your Payment Method ">
        <v:forEach items="${bindingResult.getFieldErrors('paymentMethod')}" var="error">
            <div style="color: red;"> ${error.getDefaultMessage()} </div>
        </v:forEach>

        <br>
        <br>

        <input class="input-box" type="phoneNumber" name="phoneNumber" id="phoneNumberId" value="${form.phoneNumber}"
               placeholder=" Your Phone Number " maxlength="10">
        <v:forEach items="${bindingResult.getFieldErrors('phoneNumber')}" var="error">
            <div style="color: red;"> ${error.getDefaultMessage()} </div>
        </v:forEach>

        <br>
        <br>

        <input class="input-box" type="password" name="password" id="password" value="<%--${form.password}--%>"
               placeholder=" Password ">
        <span id="PasswordErrorMessage"></span>
        <%--    <v:forEach items="${bindingResult.getFieldErrors('password')}" var="error">--%>
        <%--        <div style="color: red;"> ${error.getDefaultMessage()} </div>--%>
        <%--    </v:forEach>--%>

        <br>
        <br>

        <input class="input-box" type="password" name="confirmPassword" id="confirmPassword"
               value="<%--${form.confirmPassword}--%>" placeholder=" Confirm Password ">
        <span id="ConfirmPasswordErrorMessage"></span>
        <%--    <v:forEach items="${bindingResult.getFieldErrors('confirmPassword')}" var="error">--%>
        <%--        <div style="color: red;"> ${error.getDefaultMessage()} </div>--%>
        <%--    </v:forEach>--%>
        <br>
        <br>

        Remember Me <input type="checkbox" name="checkbox">
        <br>
        <br>
        <button type="submit" class="signup-btn">Submit</button>
        <hr>

        <p>Do you have an account? <a href="/login/login"> Sign in</a></p>

    </div>
</form>


</body>
</html>

<jsp:include page="../include/footer.jsp"/>
