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

    ${beer.getLabel()}
</body>
</html>