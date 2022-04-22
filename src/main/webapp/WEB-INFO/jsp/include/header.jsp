<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset ="utf-8">
    <title>PMS</title>
    <link rel="stylesheet" href="../../../pub/css/header.css">
</head>

<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<body>

<div class="container">


    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg fixed-top bg-light navbar-light">
        <div class="container">
            <a class="navbar-brand" href="/index"
            ><img
                    id="MDB-logo"
                    src="../../../pub/images/drone.jpg"
                    alt="MDB Logo"
                    draggable="false"
                    height="50px"
            /></a>
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto align-items-center">


                    <li class="nav-item">
                        <sec:authorize access="!isAuthenticated()">
                        <a class="nav-link mx-2" href="/login/Signup"> <i class="fas fa-plus-circle pe-2"> </i>Sign up </a>
                        </sec:authorize>


                    </li>
                    <li>
                        <sec:authorize access="!isAuthenticated()">
                            <a class="nav-link mx-2" href="/login/login"><i class="fas fa-plus-circle pe-2"></i>Login</a>
                        </sec:authorize>
                    </li>


                    <li class="nav-item">
<%--                        <a class="nav-link mx-2" href="#!"><i class="fas fa-bell pe-2"></i>Alerts</a>--%>

    <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                            <a class="nav-link mx-2" href="/park/List"><i class="fas fa-heart pe-2"></i>List your parking spot?</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link mx-2" href="/park/Search"><i class="fas fa-bell pe-2"></i>Search and Reserve</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link mx-2" href="/park/Reserve"><i class="fas fa-heart pe-2"></i> Current Reservations </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link mx-2" href="/park/Review"><i class="fas fa-heart pe-2"></i>Feedback</a>
                    </li>


                    <li class="nav-item">
                        <a class="nav-link mx-2" href="/login/logout"><i class="fas fa-heart pe-2"></i>Logout</a>

                    </li>



                    <li id="userName">
                        <span>Hello!</span>
                        <sec:authentication property="principal.username"/>
                    </li>


</sec:authorize>

               </ul>
            </div>
        </div>
    </nav>
    <!-- Navbar -->




    <br><br><br>

   <hr>
