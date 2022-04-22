<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../include/header.jsp" />

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../../pub/css/reviewpage.css">
</head>
<body>




<h2> Here is a list of the companies we are contracted with. We would love to hear your thoughts. Please feel free to leave an honest review based on your experience </h2>


<%--<form action="/park/ReviewAll" method="get" >--%>
<%--&lt;%&ndash;    We collaborate with companies across many states following states. Here are the states we are working with this calendar year ( MN, NY, CA,IL, DC, CO,TX, NEB, GA, AZ )&ndash;%&gt;--%>
<%--&lt;%&ndash;    <br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    Search by state's acronym.&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="text" name="state" id="statusid">&ndash;%&gt;--%>
<%--    <button type="submit" >Show List </button>--%>

<%--    <br>--%>
<%--</form>--%>

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
            <td>${allSpots.zipcode}</td>
            <td>${allSpots.date}</td>
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
    <form action="/park/ReviewSubmit" method="POST"  id="form">
        <div class="form-group">
            <label>Company Id </label>
            <div class="form-outline mb-4" >
               <input type="text" id="form2Example18" class="form-control form-control-lg"  placeholder="See Above" name="companyId"/>
            </div>
            <label>Customer name </label>
            <div class="form-outline mb-4" >
                <input type="text" id="form2Example17" class="form-control form-control-lg"  placeholder="" name="customerName"/>
            </div>
            <textarea  class="form-control"  placeholder="Give us your thoughts" name="customerReviews"></textarea>
        </div>
        <br>
        <div class="form-group">

            <button class="btn btn-primary btn-sm" type="submit"> Submit Comment </button>


<%--            <c:if test="${form.customerReviews.length > 36}">--%>
<%--                <h1>Thank you for leaving a review </h1>--%>
<%--            </c:if>--%>
        </div>
    </form>
</div>


<%--------------------------------------------------------------------------------------%>
<%--<div class="container">--%>
<%--    <div class="mgb-40 padb-30 auto-invert line-b-4 align-center">--%>
<%--        <h4 class="font-cond-l fg-accent lts-md mgb-10" contenteditable="false">Not Yet Convinced?</h4>--%>
<%--        <h1 class="font-cond-b fg-text-d lts-md fs-300 fs-300-xs no-mg" contenteditable="false">Read Customer Reviews</h1>--%>
<%--    </div>--%>
<%--    <ul class="hash-list cols-3 cols-1-xs pad-30-all align-center text-sm">--%>
<%--        <li>--%>
<%--            <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="wpx-100 img-round mgb-20" title="" alt="" data-edit="false" data-editor="field" data-field="src[Image Path]; title[Image Title]; alt[Image Alternate Text]">--%>
<%--            <p class="fs-110 font-cond-l" contenteditable="false">" Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae. "</p>--%>
<%--            <h5 class="font-cond mgb-5 fg-text-d fs-130" contenteditable="false">Martha Stewart</h5>--%>
<%--            <small class="font-cond case-u lts-sm fs-80 fg-text-l" contenteditable="false">Business Woman - New York</small>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <img src="https://bootdey.com/img/Content/avatar/avatar4.png" class="wpx-100 img-round mgb-20" title="" alt="" data-edit="false" data-editor="field" data-field="src[Image Path]; title[Image Title]; alt[Image Alternate Text]">--%>
<%--            <p class="fs-110 font-cond-l" contenteditable="false">" Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae. "</p>--%>
<%--            <h5 class="font-cond mgb-5 fg-text-d fs-130" contenteditable="false">Ariana Menage</h5>--%>
<%--            <small class="font-cond case-u lts-sm fs-80 fg-text-l" contenteditable="false">Recording Artist - Los Angeles</small>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <img src="https://bootdey.com/img/Content/avatar/avatar5.png" class="wpx-100 img-round mgb-20" title="" alt="" data-edit="false" data-editor="field" data-field="src[Image Path]; title[Image Title]; alt[Image Alternate Text]">--%>
<%--            <p class="fs-110 font-cond-l" contenteditable="false">" Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae. "</p>--%>
<%--            <h5 class="font-cond mgb-5 fg-text-d fs-130" contenteditable="false">Sean Carter</h5>--%>
<%--            <small class="font-cond case-u lts-sm fs-80 fg-text-l" contenteditable="false">Fund Manager - Chicago</small>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--</div>--%>




<table class="table">
    <tr scope="row">


        <th> Customer Name</th>
        <th> Feedback</th>
        <th> Parking Facilitator</th>



    </tr>

    <c:forEach items="${allReviews}" var="review">
        <tr scope="row">
            <td>${review.customerName}</td>
            <td>${review.customerReviews}</td>
            <td>${review.company.companyName}</td>


            <sec:authorize access="hasAuthority('ADMIN')">
                <td>
                    <form action="/park/Review/${review.id}" method="post">
                        <button type="submit">Delete</button>
                    </form>

                </td>
            </sec:authorize>

        </tr>

    </c:forEach>

</table>

</body>
</html>


<jsp:include page="../include/footer.jsp" />