<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp"%>

<c:set scope="page" var="total" value="${Math.round(cart.values().stream().map(value -> value.getQuantity() * value.getBeer().getPrice()).reduce(0, (a, b) -> a + b) * 100.) / 100.}" />

<!-- ========================= SECTION PAGETOP ========================= -->
<section class="section-pagetop bg">
  <div class="container">
    <h2 class="title-page">Shopping cart</h2>
  </div> <!-- container //  -->
</section>
<!-- ========================= SECTION INTRO END// ========================= -->

<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">
  <div class="container">

    <div class="row">
      <main class="col-md-9">
        <div class="card">

          <table class="table table-borderless table-shopping-cart">
            <thead class="text-muted">
            <title>${title}</title>
            <tr class="small text-uppercase">
              <th scope="col"><spring:message code="product" /></th>
              <th scope="col" style="width: 120px"><spring:message code="quantity" /></th>
              <th scope="col" style="width: 120px"><spring:message code="price" /></th>
              <th scope="col" class="text-right" style="width: 200px"> </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="orderLine" items="${cart.values()}">
              <tr>
                <form:form action="/cart/update/${orderLine.getBeer().getBeerId()}" method="post" modelAttribute="orderLine">
                  <td>
                    <figure class="itemside">
                      <div class="aside">
                        <img src="${orderLine.getBeer().getImagePath()}" class="img-sm">
                      </div>
                      <figcaption class="info">
                        <a href="#" class="title text-dark">${orderLine.getBeer().getLabel()}</a>
                        <ul>
                          <c:forTokens var="descriptionLine" items="${orderLine.getBeer().getDescription()}" delims="°">
                            <li class="small text-muted">${descriptionLine}</li>
                          </c:forTokens>
                        </ul>
                      </figcaption>
                    </figure>
                  </td>
                  <td>
                    <form:input type="number" min="0" id="quantity" step="1" value="${orderLine.getQuantity()}" class="form-control"  path="quantity"/>
                  </td>
                  <td>
                    <div class="price-wrap">
                      <var class="price">${orderLine.getQuantity() * orderLine.getBeer().getPrice()}&euro;</var>
                      <small class="text-muted"> ${orderLine.getBeer().getPrice()}&euro; <spring:message code="each" /></small>
                    </div> <!-- price-wrap .// -->
                  </td>
                  <td class="text-right">
                    <button class="btn btn-light btn-round"> <spring:message code="update" /></button>
                  </td>
                </form:form>
              </tr>
            </c:forEach>
            </tbody>
          </table>

          <div class="card-body border-top">
            <button id="orderButton" class="btn btn-primary float-md-right"> <spring:message code='buttonMakePurchase' /> <i class="fa fa-chevron-right"></i> </button>
            <a href="<spring:url value='/beers/1' />" class="btn btn-light"> <i class="fa fa-chevron-left"></i> <spring:message code='buttonContinueShopping' /> </a>
          </div>
        </div> <!-- card.// -->

        <div class="alert alert-success mt-3">
          <p class="icontext"><i class="icon text-success fa fa-truck"></i><spring:message code="delivery"/></p>
        </div>

      </main> <!-- col.// -->
      <aside class="col-md-3">
        <div class="card">
          <div class="card-body">
            <dl class="dlist-align">
              <dt>Total price:</dt>
              <dd class="text-right">${total}&euro;</dd>
            </dl>
            <dl class="dlist-align">
              <dt>Discount:</dt>
              <dd class="text-right">0&euro;</dd>
            </dl>
            <dl class="dlist-align">
              <dt>Total:</dt>
              <dd class="text-right  h5"><strong>${total}&euro;</strong></dd>
              <dd>${discount}</dd>
            </dl>
            <hr>
            <p class="text-center mb-3">
              <img src="<spring:url value='/images/paypal_logo.png' />" height="56">
            </p>

          </div> <!-- card-body.// -->
        </div>  <!-- card .// -->
      </aside> <!-- col.// -->
    </div>

  </div> <!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->

<script>
  window.onload = () => {
    let button = document.getElementById("orderButton");

    button.onclick = () => {
      if (window.confirm(`<spring:message code="confirmOrder" />`)) {
        document.location = "<spring:url value='/order' />";
      }
    }
  }
</script>
