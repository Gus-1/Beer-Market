<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome on inscription page !</title>
</head>
<body>
<form:form id="form" method="POST"  action="/firstSpring/inscription/send"  modelAttribute="currentUser">
    <form:label path=""> Name </form:label>
    <form:input path="name"></form:input>

    <form:label path=""> Age </form:label>
    <form:input path="age"></form:input>

    <form:radiobutton path="male" value="true" label="Boy" />
    <form:radiobutton path="male" value="false" label="Girl" />

    <form:select path="hobby">
        <form:options items="${hobbies}" itemValue="id"></form:options>
    </form:select>

    <form:button> Send </form:button>
</form:form></body>
</html>
