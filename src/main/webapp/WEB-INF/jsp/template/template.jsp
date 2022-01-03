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
    <title>Template</title>

</head>
<body>
<header class="section-header">
    <section class="header-main border-bottom">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-3 col-sm-4 col-12">
                    <a href="http://bootstrap-ecommerce.com" class="brand-wrap">
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
                        <a href="#" class="widget-header mr-2">
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
                                    <button type="submit" class="btn btn-primary">Sign in</button>
                                </form>
                                <hr class="dropdown-divider">
                                <a class="dropdown-item" href="#">Have account? Sign up</a>
                                <a class="dropdown-item" href="#">Forgot password?</a>
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
                    <li class="nav-item">
                        <a class="nav-link pl-0" href="#"> <strong>All category</strong></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Brown</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Blond</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Ruby</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Amber</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Dark</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>

</header>

<tiles:insertAttribute name="main-content" />

<footer class="section-footer border-top">
    <div class="container">
        <section class="footer-top  padding-y">
            <div class="row">
                <aside class="col-md-4 col-12">
                    <article class="mr-md-4">
                        <h5 class="title">Nous contacter</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer in feugiat lorem. </p>
                        <ul class="list-icon">
                            <li> <i class="icon fa fa-map-marker"> </i>542 Fake Street, Cityname 10021 Netheerlends </li>
                            <li> <i class="icon fa fa-envelope"> </i> info@example.com</li>
                            <li> <i class="icon fa fa-phone"> </i> 080/80.80.80</li>
                            <li> <i class="icon fa fa-clock"> </i>Lun-Ven 10:00 - 19:00</li>
                        </ul>
                    </article>
                </aside>
                <aside class="col-md col-6">
                    <h5 class="title">Information</h5>
                    <ul class="list-unstyled">
                        <li> <a href="#">About us</a></li>
                        <li> <a href="#">Career</a></li>
                        <li> <a href="#">Find a store</a></li>
                        <li> <a href="#">Rules and terms</a></li>
                        <li> <a href="#">Sitemap</a></li>
                    </ul>
                </aside>
                <aside class="col-md col-6">
                    <h5 class="title">My Account</h5>
                    <ul class="list-unstyled">
                        <li> <a href="#">Contact us</a></li>
                        <li> <a href="#">Money refund</a></li>
                        <li> <a href="#">Order status</a></li>
                        <li> <a href="#">Shipping info</a></li>
                        <li> <a href="#">Open dispute</a></li>
                    </ul>
                </aside>
                <aside class="col-md-4 col-12">
                    <h5 class="title">Newsletter</h5>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer in feugiat lorem. </p>

                    <form class="form-inline mb-3">
                        <input type="text" placeholder="Email" class="form-control" name="">
                        <button class="btn ml-2 btn-warning"> Subscribe</button>
                    </form>

                    <p class="text-white-50 mb-2">Follow us on social media</p>
                    <div>
                        <a href="#" class="btn btn-icon btn-light"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="btn btn-icon btn-light"><i class="fab fa-twitter"></i></a>
                        <a href="#" class="btn btn-icon btn-light"><i class="fab fa-instagram"></i></a>
                        <a href="#" class="btn btn-icon btn-light"><i class="fab fa-youtube"></i></a>
                    </div>

                </aside>
            </div>
        </section>

        <section class="footer-bottom border-top row">
            <div class="col-md-6">
                <p class="mb-0">
                    <a href="">Terms and Conditions</a> |
                    <a href="">Privacy</a> |
                    <a href="">Cookies</a>
                </p>
            </div>
            <div class="col-md-6 text-md-right">
                <i class="fab fa-lg fa-cc-visa"></i>
                <i class="fab fa-lg fa-cc-paypal"></i>
                <i class="fab fa-lg fa-cc-mastercard"></i>
            </div>
        </section>
    </div>
</footer>
</body>

</html>
