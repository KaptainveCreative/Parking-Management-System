<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
        <h1>Reservation page</h1>
<form action="">
        <!-- zipcode input -->
        <div class="form-outline mb-4">
            <label class="form-label" for="zipcodeId">Enter the ZIP-Code the parking spot you would like to reserve  </label>
            <input type="text" id="zipcodeId" class="form-control" name="zipcode" <%--value="${form.zipcode}"--%> placeholder="e.g. 02155" maxlength="5"/>

        </div>

        <!-- 2 column grid layout for inline styling -->
        <div class="row mb-4">
            <label class="form-label" for="dateId">Pick the date and time  </label>
            <input type="datetime-local" id="dateId" class="form-control" name="date" <%--value="${form.zipcode}"--%> placeholder="e.g. 02155" maxlength="5"/>

        </div>

        <!-- Submit button -->

</form>

</body>
</html>


<jsp:include page="../include/footer.jsp" />