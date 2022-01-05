<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>

<head>
    <meta charset="utf-8"><meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- jQuery -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="<spring:url value='/vendor/js/jquery-2.0.0.min.js' />" type="text/javascript"></script>

    <!-- Bootstrap4 files-->
    <script src="<spring:url value='/vendor/js/bootstrap.bundle.min.js' />" type="text/javascript"></script>
    <link href="<spring:url value='/vendor/css/bootstrap.css' />" rel="stylesheet" type="text/css"/>

    <!-- Font awesome 5 -->
    <link href="<spring:url value='/vendor/fonts/fontawesome/css/all.min.css' />" type="text/css" rel="stylesheet">

    <!-- custom style -->
    <link href="<spring:url value='/vendor/css/ui.css' />" rel="stylesheet" type="text/css"/>
    <link href="<spring:url value='/vendor/css/responsive.css' />" rel="stylesheet" media="only screen and (max-width: 1200px)" />

    <!-- custom javascript -->
    <script src="<spring:url value='/vendor/js/script.js' />" type="text/javascript"></script>

</head>
<body>
<header class="section-header">
    <section class="header-main border-bottom">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-3 col-sm-4 col-12">
                    <a href="<spring:url value="/"/>" class="brand-wrap">
                        <img class="logo" src= "<spring:url value='/images/logo.png' />" >
                    </a>
                </div>
                <div class="col-lg-4 col-xl-5 col-sm-8 col-12">
                    <form action="#" class="search">
                        <div class="input-group w-100">
                            <input type="text" class="form-control" style="width:55%;" placeholder="Search">

                            <div class="input-group-append">
                                <button class="btn btn-primary" type="submit">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-5 col-xl-4 col-sm-12">
                    <div class="widgets-wrap float-md-right">
                        <a href="<spring:url value="/cart"/>" class="widget-header mr-2">
                            <div class="icon">
                                <i class="icon-sm rounded-circle border fa fa-shopping-cart"></i>
                                <span class="notify">0</span>
                            </div>
                        </a>
                        <div class="widget-header dropdown">
                            <a href="#" data-toggle="dropdown" data-offset="20,10">
                                <div class="icontext">
                                    <div class="icon">
                                        <i class="icon-sm rounded-circle border fa fa-user"></i>
                                    </div>
                                    <div class="text">
                                        <small class="text-muted">Sign in | Join</small>
                                        <div>My account <i class="fa fa-caret-down"></i> </div>
                                    </div>
                                </div>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right">
                                <form class="px-4 py-3">
                                    <div class="form-group">
                                        <label>Email address</label>
                                        <input type="email" class="form-control" placeholder="email@example.com">
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" class="form-control" placeholder="Password">
                                    </div>
                                    <button type="submit" class="btn btn-primary">Sign up</button>
                                </form>
                                <hr class="dropdown-divider">
                                <a class="dropdown-item" href="<spring:url value="/register"/>">Don't have an account? Sign in</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <nav class="navbar navbar-main navbar-expand-lg border-bottom">
        <div class="container">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main_nav5" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="main_nav5">
                <ul class="navbar-nav">

                    <a class="nav-link pl-0" href="<spring:url value="/beers/${0}"/>"> Toutes les catégories</a>

                    <c:forEach items="${categories}" var="category" >

                        <li class="nav-item">
                            <a class="nav-link pl-0" href="<spring:url value="/beers/${category.getCategoryId()}"/>"> ${category.getLabel()}</a>
                        </li>

                    </c:forEach>

                </ul>
            </div>
        </div>
    </nav>

</header>

<tiles:insertAttribute name="main-content" />

<footer id="footer" class="section-footer border-top">
    <div class="container">


        <section class="footer-bottom border-top row">
            <div class="col-md-6">
                <p class="mb-0">
                    <a href="">Terms and Conditions</a> |
                    <a href="">Privacy</a> |
                    <a href="">Cookies</a>
                </p>

                <p> Beer market</p>
            </div>
            <div class="col-md-6 text-md-right">
                <i class="fab fa-lg fa-cc-paypal"></i>
            </div>
        </section>
    </div>
</footer>
</body>

</html>
