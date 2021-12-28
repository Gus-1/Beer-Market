<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>

<head>
    <link type="text/css" href="<spring:url value="/css/first.css" />"
          rel="Stylesheet">
    <img src="<spring:url value="/images/2945083.png"/>"/>

    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr" />
        <a href="${localeFr}">
            <img alt="fr" src='<spring:url value="/images/localeFr.png"/>' height="50" width="50">
        </a>
    </spring:url>

    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en" />
        <a href="${localeEn}">
            <img alt="en" src='<spring:url value="/images/localeEn.png"/>' height="50" width="50">
        </a>
    </spring:url>

</head>

<body>
<div>
    Banner : ...
</div>
<div>
    <tiles:insertAttribute name="main-content" />
</div>
<div>
    Footer : ...
</div>
</body>

</html>
