<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<link rel="stylesheet" href="../../../pub/css/search.css">


<h1> Parking Spot look up </h1>

<form action="/park/Search" method="get">
    <h4>We collaborate with companies across many states. Feel free to search by
        <state></state>
        <%--Here are the states we are working with this
                calendar year ( MN, NY, CA,IL, DC, CO,TX, NEB, GA, AZ )--%> </h4>

    <input  class="input-box" type="text" name="state" id="stateId" placeholder="e.g MN" maxlength="2">
    <button class="button" type="submit">Search</button>

</form>
<p id="error">${error}</p>


<table class="table">
    <tr scope="row">

        <th>Company Name</th>
        <th>Status</th>
        <th>5 Scale Rating</th>
        <th>Price for 1 Hour</th>
        <th>Available as of</th>
        <th>Zipcode</th>
        <th>State</th>

    </tr>

    <c:forEach items="${parkingSpots}" var="spot">

    <tr class="results" scope="row">
        <td>${spot.company.companyName}</td>
        <td>${spot.status}</td>
        <td>${spot.rating}</td>
        <td>$${spot.price}</td>
        <td>${spot.date}</td>
        <td>${spot.zipcode}</td>
        <td>${spot.state}</td>
        <td><a href="/park/Reserve/${spot.id}">Reserve</a></td>


    </tr>

    </c:forEach>
    <%--------------------------------------------------------------------------------------------------------%>

    <br>


    <table class="table">
        <tr scope="row">


            <th>Company Name</th>
            <th>Status</th>
            <th>5 Scale Rating</th>
            <th>Price for 1 Hour</th>
            <th>Available as of</th>
            <th>Zipcode</th>
            <th>State</th>

        </tr>
        <p id="availableStates">Here are all the available parking spots</p>
        <c:forEach items="${allparkingSpots}" var="allSpots">
            <tr class="results" scope="row">
                <td>${allSpots.company.companyName}</td>
                <td>${allSpots.status}</td>
                <td>${allSpots.rating}</td>
                <td>$${allSpots.price}</td>
                <td>${allSpots.date}</td>
                <td>${allSpots.zipcode}</td>
                <td>${allSpots.state}</td>
                <td><a href="/park/Reserve/${allSpots.id}">Reserve</a></td>


            </tr>

        </c:forEach>

    </table>


<jsp:include page="../include/footer.jsp"/>