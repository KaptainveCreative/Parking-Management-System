
<jsp:include page="../include/header.jsp"/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../../pub/css/login.css">
</head>


<body>
<section class="vh-100">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-6 text-black">

                <div class="px-5 ms-xl-4">
                    <i class="fas fa-crow fa-2x me-3 pt-5 mt-xl-4" style="color: #709085;"></i>
                    <span class="h1 fw-bold mb-0"></span>
                </div>



                <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

<form action="/login/loginSubmit"  method="POST" style="width: 23rem;">

                        <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px; ">Log In</h3>

                        <div class="form-outline mb-4" >
                            <input type="email" id="form2Example18" class="form-control form-control-lg"  placeholder="Email Address" name="username"/>

                        </div>

                        <div class="form-outline mb-4">
                            <input type="password" id="form2Example28" class="form-control form-control-lg" placeholder="Password" name="password"/>

                        </div>

                        <div class="pt-1 mb-4">
                            <button class="btn btn-info btn-lg btn-block" type="submit">Login</button>
                        </div>

                        <p>Don't have an account? <a href="/login/Signup" class="link-info">Register here</a></p>

</form>
                </div>

</div>
            <div class="col-sm-6 px-0 d-none d-sm-block">
                <img src="../../../pub/images/P1.jpg"
                     alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
            </div>
        </div>
    </div>
</section>
</body>
</html>

<jsp:include page="../include/footer.jsp"/>


<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport"--%>
<%--          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">--%>
<%--    <meta http-equiv="X-UA-Compatible" content="ie=edge">--%>
<%--&lt;%&ndash;    <link rel="stylesheet" href="../../../pub/css/signup.css">&ndash;%&gt;--%>

<%--</head>--%>
<%--<body>--%>
<%--<h1>This is a login page</h1>--%>

<%--    <div >--%>


<%--        <form action="/login/loginSubmit" method="POST">--%>

<%--            Username:<input type="text" name="username">--%>
<%--            <br><br>--%>

<%--            Password:<input type="text" name="password">--%>
<%--            <br><br>--%>

<%--            <button type="submit">Login</button>--%>

<%--        </form>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

