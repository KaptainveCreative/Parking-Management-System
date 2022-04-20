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



<body>


<c:if test="${!hideForm}">

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


<h1> Current Reservations</h1>


<table class="table">
    <tr scope="row">


    </tr>

    <c:forEach items="${reservationList}" var="reserve">
    <tr scope="row">
        <td>${reserve.parkingspot.company.companyName}</td>
        <td>${reserve.user.firstName}</td>

        <td>${reserve.parkingspot.price}</td>
        <td>${reserve.parkingspot.quantity}</td>
        <td>${reserve.date}</td>
        <td>${reserve.zipcode}</td>
        <td>${reserve.parkingspot.state}</td>
<%--        <td><a href="/park/Reserve/${reserve.id}">Reserve</a></td>--%>

            <%--                    <td>${spot.companyName}</td>--%>
            <%--                    <td>${spot.company_id}</td>--%>

    </tr>

    </c:forEach>


</body>
</html>


<jsp:include page="../include/footer.jsp"/>