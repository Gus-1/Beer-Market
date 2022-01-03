<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<!-- ========================= SECTION PAGETOP ========================= -->
<section class="section-pagetop bg">
    <div class="container">
        <h2 class="title-page"> ${categoryChosen} </h2>
    </div> <!-- container //  -->
</section>
<!-- ========================= SECTION INTRO END// ========================= -->

<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">
    <div class="container">

        <div class="row">

            <main class="col-md-9">

                <header class="border-bottom mb-4 pb-3">
                    <div class="form-inline">

                    </div>
                    <title>${title}</title>

                </header><!-- sect-heading -->

                <div class="row">
                    <c:forEach items="${beers}" var="product">
                        <div class="col-md-4">
                            <figure class="card card-product-grid">
                                <div class="img-wrap">
                                    <img src="${product.getImagePath()}">
                                    <a class="btn-overlay" href="<spring:url value='/details/${product.getBeerId()}' />"><i class="fa fa-search-plus"></i> <spring:message code="details"/> </a>
                                </div> <!-- img-wrap.// -->
                                <figcaption class="info-wrap">
                                    <div class="fix-height">
                                        <a href="<spring:url value='/details/${product.getBeerId()}' />" class="title">${product.getLabel()}</a>
                                        <div class="price-wrap mt-2">
                                            <span class="price">${product.getPrice()}€</span>
                                        </div> <!-- price-wrap.// -->
                                    </div>
                                    <form:form id="addToCartForm" method="post" action="/cart/add/${product.getBeerId()}" modelAttribute="orderLine">
                                        <div class="row">
                                            <div class="form-group col-md flex-grow-0">
                                                <form:hidden path="quantity" value="1" />
                                            </div> <!-- col.// -->
                                        </div> <!-- row.// -->
                                        <form:button class="btn btn-block btn-primary" >
                                            <spring:message code="addToCart"/>
                                        </form:button>
                                    </form:form>
                                </figcaption>
                            </figure>
                        </div> <!-- col.// -->

                    </c:forEach>

                </div>
            </main> <!-- col.// -->
        </div>
    </div> <!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->
