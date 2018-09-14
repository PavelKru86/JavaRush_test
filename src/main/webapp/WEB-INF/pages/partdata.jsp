<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>PartData</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>

</head>
<body>
    <a href="../../parts">Back to Parts List</a>
    <h1>Find by name</h1>

    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="120">Name</th>
            <th width="120">Quant</th>
            <th width="120">Need</th>

        </tr>

        <c:forEach items="${listPartsByName}" var="part">
            <tr>
                <td>${part.id}</td>
                <td>${part.name}</td>
                <c:choose>
                    <c:when test="${part.need}">
                        <td>
                            <spring:message text="Yes"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td>
                            <spring:message text="No"/>
                        </td>
                    </c:otherwise>
                </c:choose>
                <td>${part.quant}</td>

                <td><a href="<c:url value='/edit/${part.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${part.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>



</body>
</html>
