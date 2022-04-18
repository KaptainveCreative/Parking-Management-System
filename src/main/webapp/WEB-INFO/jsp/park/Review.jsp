<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>


<h1>This is a review page</h1>

<h1> Here is a list of the companies we are contracted with. We would love to hear your thoughts. Please feel free to leave an honest review based on your experience </h1>


<form action="/park/ReviewAll" method="get" >
<%--    We collaborate with companies across many states following states. Here are the states we are working with this calendar year ( MN, NY, CA,IL, DC, CO,TX, NEB, GA, AZ )--%>
<%--    <br>--%>
<%--    Search by state's acronym.--%>
<%--    <input type="text" name="state" id="statusid">--%>
    <button type="submit" >Show List </button>

    <br>
</form>

<table class="table">
    <tr scope="row">

        <th>Company Id</th>
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
            <td>${allSpots.company.id}</td>
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

<%---------------------------------------------------------------------------------------------------%>

<div class="bg-white rounded shadow-sm p-4 mb-5 rating-review-select-page">
    <h5 class="mb-4">Leave Comment</h5>
    <p class="mb-2">Rate The Parking spot</p>
    <div class="mb-4">
                        <span class="star-rating">
                                 <a href="#"><i class="icofont-ui-rating icofont-2x"></i></a>
                                 <a href="#"><i class="icofont-ui-rating icofont-2x"></i></a>
                                 <a href="#"><i class="icofont-ui-rating icofont-2x"></i></a>
                                 <a href="#"><i class="icofont-ui-rating icofont-2x"></i></a>
                                 <a href="#"><i class="icofont-ui-rating icofont-2x"></i></a>
                                 </span>
    </div>
    <form action="/park/ReviewSubmit" method="POST">
        <div class="form-group">
            <label>Company Id </label>
            <div class="form-outline mb-4" >
               <input type="text" id="form2Example18" class="form-control form-control-lg"  placeholder="See Above" name="company_id"/>
            </div>
            <textarea  class="form-control"  placeholder="Give us your thoughts" name="customer_reviews"></textarea>
        </div>
        <br>
        <div class="form-group">
            <button class="btn btn-primary btn-sm" type="submit"> Submit Comment </button>
        </div>
    </form>
</div>


<%--------------------------------------------------------------------------------------%>
<div class="container">
    <div class="mgb-40 padb-30 auto-invert line-b-4 align-center">
        <h4 class="font-cond-l fg-accent lts-md mgb-10" contenteditable="false">Not Yet Convinced?</h4>
        <h1 class="font-cond-b fg-text-d lts-md fs-300 fs-300-xs no-mg" contenteditable="false">Read Customer Reviews</h1>
    </div>
    <ul class="hash-list cols-3 cols-1-xs pad-30-all align-center text-sm">
        <li>
            <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="wpx-100 img-round mgb-20" title="" alt="" data-edit="false" data-editor="field" data-field="src[Image Path]; title[Image Title]; alt[Image Alternate Text]">
            <p class="fs-110 font-cond-l" contenteditable="false">" Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae. "</p>
            <h5 class="font-cond mgb-5 fg-text-d fs-130" contenteditable="false">Martha Stewart</h5>
            <small class="font-cond case-u lts-sm fs-80 fg-text-l" contenteditable="false">Business Woman - New York</small>
        </li>
        <li>
            <img src="https://bootdey.com/img/Content/avatar/avatar4.png" class="wpx-100 img-round mgb-20" title="" alt="" data-edit="false" data-editor="field" data-field="src[Image Path]; title[Image Title]; alt[Image Alternate Text]">
            <p class="fs-110 font-cond-l" contenteditable="false">" Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae. "</p>
            <h5 class="font-cond mgb-5 fg-text-d fs-130" contenteditable="false">Ariana Menage</h5>
            <small class="font-cond case-u lts-sm fs-80 fg-text-l" contenteditable="false">Recording Artist - Los Angeles</small>
        </li>
        <li>
            <img src="https://bootdey.com/img/Content/avatar/avatar5.png" class="wpx-100 img-round mgb-20" title="" alt="" data-edit="false" data-editor="field" data-field="src[Image Path]; title[Image Title]; alt[Image Alternate Text]">
            <p class="fs-110 font-cond-l" contenteditable="false">" Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae. "</p>
            <h5 class="font-cond mgb-5 fg-text-d fs-130" contenteditable="false">Sean Carter</h5>
            <small class="font-cond case-u lts-sm fs-80 fg-text-l" contenteditable="false">Fund Manager - Chicago</small>
        </li>
    </ul>
</div>


</body>
</html>


<jsp:include page="../include/footer.jsp" />