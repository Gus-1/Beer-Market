
<%@ page pageEncoding ="UTF-8"
    contentType="text/html;charset=UTF-8" language="java" %>
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
                    <a href="#"> <img src="<spring:url value="${beer.getImagePath()}" />"  ></a>
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
                    <dt class="col-sm-3"> <spring:message code="brewery"/> : </dt>
                    <dd class="col-sm-9">${beer.getBrewery()}</dd>

                    <dt class="col-sm-3"> <spring:message code="color"/> :</dt>
                    <dd class="col-sm-9">${color}</dd>

                    <dt class="col-sm-3"> <spring:message code="origin"/> :</dt>
                    <dd class="col-sm-9">${beer.getOriginCountry()}</dd>

                    <dt class="col-sm-3"> <spring:message code="taste"/> :</dt>
                    <dd class="col-sm-9">${beer.getFlavour()}</dd>
                </dl>

                <hr>

                <!-- <a href="#" class="btn  btn-outline-primary"> <span class="text">Add to cart</span> <i class="fas fa-shopping-cart"></i>  </a> -->
                <form:form id="addToCartForm" method="post" action="/cart/add/${beer.getBeerId()}" modelAttribute="orderLine">


                    <div class="row">
                        <div class="form-group col-md flex-grow-0">
                            <div class="mb-3 input-spinner">
                                <form:input cssStyle="max-width: 70px; width: 70px" type="number" cssClass="form-control" min="1" value="1" path="quantity" />
                            </div>
                        </div> <!-- col.// -->
                    </div> <!-- row.// -->
                    <form:button class="btn btn-outline-primary">
                        <spring:message code="addToCart"/> <i class="fas fa-shopping-cart"></i>
                    </form:button>
                </form:form>
            </article> <!-- product-info-aside .// -->
        </main> <!-- col.// -->
    </div> <!-- row.// -->
</div> <!-- card.// -->
<!-- ============================ COMPONENT 1 END .// ================================= -->

</body>
</html>