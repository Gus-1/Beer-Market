<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>

<html>
<head>
    <meta charset="utf-8">
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


    <!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

    <!--Font Awesome (added because you use icons in your prepend/append)-->
    <link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />

</head>
<body>

<header class="section-header">
    <section class="header-main border-bottom">
    </section>
</header> <!-- section-header.// -->

<section class="section-content padding-y">
    <div class="container">

        <header class="section-heading">
            <h2 class="section-title"><spring:message code="about"/></h2>
        </header><!-- sect-heading -->

        <article>

            <p>Beer Market a été développé par un groupe de deux étudiants.</p>
            <p><br></p>
            <p>Nous avions eu le choix des articles que nous souhaiterions vendre.</p>
            <p><br></p>
            <p>La raison pour laquelle nous avons choisi de créer Beer Market est qu'il est difficile de trouver un site de vente spécialisé dans la bière, malgré que nous soyons en Belgique.</p>
            <p><br></p>
            <br><br><br><br><br><br><br><br><br>
            <button class="btn btn-dark" type="button" onclick="window.history.back()">Go back</button>
        </article>
    </div> <!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->

<!-- ========================= FOOTER ========================= -->
<footer class="section-footer border-top padding-y"></footer>
<!-- ========================= FOOTER END // ========================= -->

</body>
</html>
