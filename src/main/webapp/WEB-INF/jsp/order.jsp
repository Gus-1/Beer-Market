<%@ page pageEncoding ="UTF-8"
         contentType="text/html;charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<section class="section-content padding-y bg">
    <div class="container">
        <div class="row">
            <main class="col-md-8">

                <article class="card mb-4">
                    <div class="card-body">
                        <h4 class="card-title mb-4"><spring:message code="recap" /></h4>
                        <div class="row">
                            <c:forEach var="orderLine" items="${cart.values()}">
                                <div class="col-md-6">
                                    <figure class="itemside  mb-4">
                                        <div class="aside"><img src="../../images/${orderLine.getProduct().getImagePath()}" class="border img-sm"></div>
                                        <figcaption class="info">
                                            <p>${orderLine.getProduct().getLabel()}</p>
                                            <span class="text-muted">${orderLine.getQuantity()}x = ${orderLine.getProduct().getPrice() * orderLine.getQuantity()}&euro; </span>
                                        </figcaption>
                                    </figure>
                                </div> <!-- col.// -->
                            </c:forEach>
                        </div> <!-- row.// -->
                    </div> <!-- card-body.// -->
                </article> <!-- card.// -->
            </main> <!-- col.// -->
            <aside class="col-md-4">
                <div class="card shadow">
                    <div class="card-body">
                        <h4 class="mb-3"><spring:message code="review" /></h4>
                        <dl class="dlist-align">
                            <dt class="text-muted"><spring:message code="paymentMethod"/>:</dt>
                            <dd>PayPal</dd>
                        </dl>
                        <hr>
                        <dl class="dlist-align">
                            <dt>Total:</dt>
                            <dd class="h5">${Math.round(cart.values().stream().map(value -> value.getQuantity() * value.getProduct().getPrice()).reduce(0, (a, b) -> a + b) * 100.) / 100.}&euro;</dd>
                        </dl>
                        <hr>
                        <h6><spring:message code="notRedirected" /></h6>
                        <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                            <input hidden name="business" value="" />
                            <input hidden name="password" value="" />
                            <input hidden name="cert_id" value="" />
                            <input hidden name="cmd" value="_xclick" />
                            <input hidden name="amount" value="${Math.round(cart.values().stream().map(value -> value.getQuantity() * value.getProduct().getPrice()).reduce(0, (a, b) -> a + b) * 100.) / 100.}" />
                            <input hidden name="item_name" value="<spring:message code='insideOutOrder' />" />
                            <input hidden name="lc" value="fr_BE" />
                            <input hidden name="currency_code" value="EUR" />
                            <input hidden name="return" value="http://localhost:8082/order/success" />
                            <input hidden name="cancel_return" value="http://localhost:8082/cart" />
                            <input id="button" type="image" style="margin: auto" src="<spring:url value='/vendor/images/paypal_logo.png' />" />
                        </form>

                    </div> <!-- card-body.// -->
                </div> <!-- card.// -->
            </aside> <!-- col.// -->
        </div> <!-- row.// -->

        <!-- ============================ COMPONENT 2 END//  ================================= -->

        <script>
            window.onload = () => {
                let intervalId = setInterval(() => {
                    clearInterval(intervalId);
                    document.getElementById("button").click();
                }, 5000);
            }
        </script>

    </div> <!-- container .//  -->
</section>
