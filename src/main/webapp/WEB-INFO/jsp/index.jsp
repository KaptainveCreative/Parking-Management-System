<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<jsp:include page="./include/header.jsp"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../pub/css/index.css">



</head>
<body>

<sec:authorize access="!isAuthenticated()">
    <div class="Welcome">
        <h1>Hello Pal! Welcome To Park Connect!</h1>

        <p> Here, we help you find a convenient, yet easy to use service to find where you can park your car or  to rent your
            parking spot. We can also help you reach more clients </p>

        <br><br><br><br>
        <p> Please Click on Login / sign up in the top right corner to get started </p>

    </div>

</sec:authorize>

<sec:authorize access="isAuthenticated()">

    <div class="Welcome">
        <h1>Welcome Back! <sec:authentication property="principal.username"/></h1>


        <p> Now you take a look at all the services we provide. </p>


        <p> use the navigation bar to check our the services </p>

        <br>

    </div>

</sec:authorize>

<%--        <h3 id="h1" class="neonText">--%>

<%--            <a class="nav-link mx-2" href="/login/Signup"> <i class="fas fa-plus-circle pe-2"> </i>Signup </a>--%>
<%--            <a class="nav-link mx-2" href="/login/login"> <i class="fas fa-plus-circle pe-2"></i>Login</a>--%>

<%--        </h3>--%>


</body>
</html>


<%--<ol>--%>


<%--    <c:forEach var="user" items="${users}">--%>

<%--        <li> ${user.firstName} </li>--%>
<%--</c:forEach>--%>

<%--</ol>--%>
<jsp:include page="include/footer.jsp"/>