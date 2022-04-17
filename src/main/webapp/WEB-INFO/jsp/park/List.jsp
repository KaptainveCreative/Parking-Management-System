<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">



</head>
<body>
<h1> Interested in listing your parking spot to our customers? Then go ahead and fill in your information below and will take care of the rest</h1>


<br>


<form action="/park/ListSubmit">

    <input type="hidden" name="id" id="Id" >
    <br>

    <!-- company name input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="zipcodeId">Enter the name of your spot</label>
        <input type="text" id="zipcodeId" class="form-control" name="companyName" <%--value="${form.zipcode}"--%>/>


    <!-- Zipcode input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="zipcodeId">Enter the zipcode for your parking spot</label>
        <input type="text" id="zipcodeId" class="form-control" name="zipcode" <%--value="${form.zipcode}"--%>/>

 <%--       <c:forEach items="${bindingResult.getFieldErrors('zipcode')}" var="error">
            <div style="color: red;"> ${error.getDefaultMessage()} </div>
        </c:forEach>--%>
    </div>

    <!-- price input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="priceId">Enter your fee for 1 hr</label>
        <input type="text" id="priceId" class="form-control" name="price" <%--value="${form.price}"--%>/>
<%--
        <c:forEach items="${bindingResult.getFieldErrors('price')}" var="error">
            <div style="color: red;"> ${error.getDefaultMessage()} </div>
        </c:forEach>--%>
    </div>

    <!-- Rating input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="ratingId">Enter your rating per BBP for your business</label>
        <input type="text" id="ratingId" class="form-control"  name="rating" />


    </div>

    <!-- status input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="statusId">Available or Booked</label>
        <input type="text" id="statusId" class="form-control"  name="status" <%--value="${form.status}"--%>/>

  <%--      <c:forEach items="${bindingResult.getFieldErrors('status')}" var="error">
            <div style="color: red;"> ${error.getDefaultMessage()} </div>
        </c:forEach>--%>
    </div>


    <!-- quantity input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="quantityId">How many spots do you have to reserve</label>
        <input type="text" id="quantityId" class="form-control" name="quantity" <%--value="${form.quantity}" --%>/>
    </div>

<%--    <c:forEach items="${bindingResult.getFieldErrors('quantity')}" var="error">--%>
<%--        <div style="color: red;"> ${error.getDefaultMessage()} </div>--%>
<%--    </c:forEach>--%>

    <!-- state input -->
    <div class="form-outline mb-4">
        <label class="form-label" for="stateId">Enter which state the spot is there for  </label>
        <input type="text" id="stateId" class="form-control" name="state" <%--value="${form.state}"--%> />

<%--        <c:forEach items="${bindingResult.getFieldErrors('state')}" var="error">
            <div style="color: red;"> ${error.getDefaultMessage()} </div>
        </c:forEach>--%>
    </div>
    <!-- 2 column grid layout for inline styling -->
    <div class="row mb-4">
        <button type="submit" class="btn btn-primary btn-block">List your spot</button>

    </div>

    <!-- Submit button -->

</form>



</body>
</html>



<jsp:include page="../include/footer.jsp" />