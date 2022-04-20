<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

</head>

<c:if test="${hideForm}">

    <form action="/park/Reserve/${parkingSpotId}" method="post">


        <!-- time and date-->
        <div class="row mb-4">
            <label class="form-label" for="dateId">Pick the date and time </label>
            <input type="datetime-local" id="dateId" class="form-control" name="date" <%--value="${form.zipcode}"--%>
                   placeholder="e.g. 02155" maxlength="5"/>

        </div>

        <button type="submit">Submit</button>


    </form>

</c:if>
<body>
<h1>Reservation page</h1>


<table class="table">
    <tr scope="row">


    </tr>

    <c:forEach items="${allparkingSpots}" var="allSpots">
    <tr scope="row">
        <td>${allSpots.company.companyName}</td>
        <td>${allSpots.status}</td>
        <td>${allSpots.rating}</td>
        <td>${allSpots.price}</td>
        <td>${allSpots.quantity}</td>
        <td>${allSpots.date}</td>
        <td>${allSpots.zipcode}</td>
        <td>${allSpots.state}</td>
        <td><a href="/park/Reserve/${allSpots.id}">Reserve</a></td>

            <%--                    <td>${spot.companyName}</td>--%>
            <%--                    <td>${spot.company_id}</td>--%>

    </tr>

    </c:forEach>


</body>
</html>


<jsp:include page="../include/footer.jsp"/>