<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />


<h1> Parking Spot look up </h1>

<form action="/park/Search" method="get" >
    We collaborate with companies across many states following states. Here are the states we are working with this calendar year ( MN, NY, CA,IL, DC, CO,TX, NEB, GA, AZ )
    <br>
    Search by state's acronym.
         <input type="text" name="state" id="statusid">
                    <button type="submit" >Search </button>

    <br>
</form>
<table class="table">
    <tr scope="row">

        <th>Company Name</th>
        <th>Status</th>
        <th>5 Scale Rating</th>
        <th>Price for 1 Hour </th>
        <th>Spots Open</th>
        <th>Zipcode</th>
        <th>Available as of</th>
        <th>State</th>

    </tr>

    <c:forEach items="${parkingSpots}" var="spot">
    <tr scope="row">
        <td>${spot.company.companyName}</td>
        <td>${spot.status}</td>
        <td>${spot.rating}</td>
        <td>${spot.price}</td>
        <td>${spot.quantity}</td>
        <td>${spot.date}</td>
        <td>${spot.zipcode}</td>
        <td>${spot.state}</td>
            <%--                    <td>${spot.companyName}</td>--%>
            <%--                    <td>${spot.company_id}</td>--%>

    </tr>

    </c:forEach>
    <%--------------------------------------------------------------------------------------------------------%>

    <br>
<table class="table">
    <tr scope="row">

        <form action="/park/Search" method="get" >
            To see all availabe spots, hit Search below
            <br>
            <%--    <input type="text" name="state" id="stateid">--%>
            <button type="submit" >Search</button>
        </form>
                <th>Company Name</th>
                <th>Status</th>
                <th>5 Scale Rating</th>
                <th>Price for 1 Hour </th>
                <th>Spots Open</th>
                <th>Zipcode</th>
                <th>Available as of</th>
                <th>State</th>

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
<%--                    <td>${spot.companyName}</td>--%>
<%--                    <td>${spot.company_id}</td>--%>

                </tr>

            </c:forEach>

</table>





<jsp:include page="../include/footer.jsp" />