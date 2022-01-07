<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<script>
    $('.datepicker').datepicker();
</script>

<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">

    <!-- ============================ COMPONENT REGISTER   ================================= -->
    <div class="card mx-auto" style="max-width:520px; margin-top:40px;">
        <article class="card-body">
            <header class="mb-4"><h4 class="card-title"><spring:message code="signUp"/></h4></header>
            <div class="bootstrap-iso">
                <form:form id="registerForm"
                           method="post"
                           action="/register/send"
                           modelAttribute="customer">

                    <div class="form-group">
                        <form:label path="email">
                            <spring:message code="email"/>
                        </form:label>
                        <form:input path="email" cssClass="form-control" />
                        <form:errors path="email"/>
                    </div> <!-- form-group end.// -->

                    <div class="form-row">
                        <div class="col form-group">
                            <form:label path="password">
                                <spring:message code="password"/>
                            </form:label>
                            <form:input path="password" type="password" cssClass="form-control" />
                            <form:errors path="password"/>
                        </div> <!-- form-group end.// -->

                        <div class="col form-group">
                            <form:label path="password">
                                <spring:message code="confirmationPassword"/>
                            </form:label>
                            <form:input path="confirmationPassword" type="password" cssClass="form-control" />
                            <form:errors path="password"/>
                        </div> <!-- form-group end.// -->
                    </div> <!-- form-row end.// -->

                    <div class="form-row">
                        <div class="col form-group">
                            <form:label path="firstName">
                                <spring:message code="firstName"/>
                            </form:label>
                            <form:input path="firstName" cssClass="form-control" />
                            <form:errors path="firstName"/>
                        </div> <!-- form-group end.// -->

                        <div class="col form-group">
                            <form:label path="name">
                                <spring:message code="name"/>
                            </form:label>
                            <form:input path="name" cssClass="form-control" />
                            <form:errors path="name"/>
                        </div> <!-- form-group end.// -->
                    </div> <!-- form-row end.// -->


                    <div class="form-group">
                        <form:label path="phoneNumber">
                            <spring:message code="phoneNumber"/>
                        </form:label>
                        <form:input type="phone" path="phoneNumber" cssClass="form-control" />
                        <form:errors path="phoneNumber"/>
                    </div> <!-- form-group end.// -->

                    <div class="form-group">
                        <form:label path="vatNumber">
                            <spring:message code="vat"/>
                        </form:label>
                        <form:input path="vatNumber" cssClass="form-control" />
                    </div> <!-- form-group end.// -->

                    <div class="form-group">
                        <label class="custom-control custom-radio custom-control-inline">
                            <form:radiobutton path="gender" value="m" class="custom-control-input"/>
                            <span class="custom-control-label">
                                        <spring:message code='man'/>
                                </span>
                        </label>
                        <label class="custom-control custom-radio custom-control-inline">
                            <form:radiobutton path="gender" value="f" class="custom-control-input"/>
                            <span class="custom-control-label">
                                        <spring:message code='women'/>
                                </span>
                        </label>
                        <label class="custom-control custom-radio custom-control-inline">
                            <form:radiobutton path="gender" value="x" class="custom-control-input"/>
                            <span class="custom-control-label">
                                        <spring:message code='other'/>
                                </span>
                        </label>
                        <form:errors path="gender"/>
                    </div> <!-- form-group end.// -->

                    <div class="form-group">
                        <form:label path="address">
                            <spring:message code="address"/>
                        </form:label>
                        <form:input path="address" cssClass="form-control" />
                    </div> <!-- form-group end.// -->

                    <div class="form-group">
                        <form:button type="submit" class="btn btn-primary btn-block"> <spring:message code="register"/> </form:button>
                    </div>

                </form:form>
            </div>

        </article><!-- card-body.// -->
    </div> <!-- card .// -->
    <br><br>
    <!-- ============================ COMPONENT REGISTER  END.// ================================= -->
</section>
