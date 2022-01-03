<%--
  Created by IntelliJ IDEA.
  User: Evan Colle
  Date: 03-01-22
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
<div class="card">
    <div class="row no-gutters">
        <aside class="col-md-6">
            <article class="gallery-wrap">
                <div class="img-big-wrap">
                    <a href="#"> <img src="<spring:url value="/images/beers/Ayinger_Celebrator_Doppelbock.jpg" />"  ></a>
                </div> <!-- img-big-wrap.// -->

            </article> <!-- gallery-wrap .end// -->
        </aside>
        <main class="col-md-6 border-left">
            <article class="content-body">

                <h2 class="title">${beer.getLabel()}</h2>



                <div class="mb-3">
                    <var class="price h4">${beer.getPrice()} €</var>
                </div>

                <p> ${beer.getDescription()} </p>
                <dl class="row">
                    <dt class="col-sm-3">Brasserie : </dt>
                    <dd class="col-sm-9">${beer.getBrewery()}</dd>

                    <dt class="col-sm-3">Couleur :</dt>
                    <dd class="col-sm-9">Blond</dd>

                    <dt class="col-sm-3">Origine :</dt>
                    <dd class="col-sm-9">${beer.getOriginCountry()}</dd>

                    <dt class="col-sm-3">Goût :</dt>
                    <dd class="col-sm-9">${beer.getFlavour()}</dd>
                </dl>

                <hr>
                <div class="row">
                    <div class="form-group col-md flex-grow-0">
                        <label>Quantity</label>
                        <div class="input-group mb-3 input-spinner">
                            <div class="input-group-prepend">
                                <button class="btn btn-light" type="button" id="button-plus"> + </button>
                            </div>
                            <input type="text" class="form-control" value="1">
                            <div class="input-group-append">
                                <button class="btn btn-light" type="button" id="button-minus"> &minus; </button>
                            </div>
                        </div>
                    </div> <!-- col.// -->

                </div> <!-- row.// -->

                <a href="#" class="btn  btn-outline-primary"> <span class="text">Add to cart</span> <i class="fas fa-shopping-cart"></i>  </a>
            </article> <!-- product-info-aside .// -->
        </main> <!-- col.// -->
    </div> <!-- row.// -->
</div> <!-- card.// -->
<!-- ============================ COMPONENT 1 END .// ================================= -->

</body>
</html>