<%@ page pageEncoding = "UTF-8"
    contentType = "text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
    Welcome our wonderful world !

    <form:form id="form" method="POST"  action="/firstSpring/hello/send"  modelAttribute="magicKeyForm">
        <form:label path="magicKey">
            <spring:message code="magicKeyLabel"/>
        </form:label>

        <form:input path="magicKey"></form:input>
        <form:button>
            <spring:message code= "magicKeySendButton"/>
        </form:button>
    </form:form>
</body>
</html>