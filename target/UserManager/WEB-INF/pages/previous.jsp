<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Parts Page</title>
    <style>
        .tableparams{
            position: absolute;
            top: 18%;
            right: 10%;
        }
        #header{
            position: absolute;
            top: 7%;
            right: 8%;
        }
        #hrefPrev{
            font-family: Arial, sans-serif;
            font-size: 12px;
            position: absolute;
            bottom: 30%;
            left: 20%;
        }
        #hrevNext{
            font-family: Arial, sans-serif;
            font-size: 12px;
            position: absolute;
            bottom: 30%;
            left: 30%;
        }

        #hrevSort{
            font-family: Arial, sans-serif;
            font-size: 12px;
            position: absolute;
            bottom: 20%;
            left: 30%;
        }

        #hrevSortId{
            font-family: Arial, sans-serif;
            font-size: 12px;
            position: absolute;
            bottom: 15%;
            left: 30%;
        }

    </style>
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
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Parts List</h1>

<c:if test="${!empty listPartsPrevious}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Quant</th>
            <th width="120">Need</th>

            <th width="60">Update</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPartsPrevious}" var="part">
            <tr>
                <td>${part.id}</td>
                <td><a href="/userdata/${part.name}" target="_blank">${part.name}</a></td>
                <td>${part.quant}</td>
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

                <td><a href="<c:url value='/edit/${part.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${part.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <table class="tg">
        <tr>
            <td width="80">Total</td>
            <td width="122">${listPartTotal}</td>
            <td width="120">Computer</td>

        </tr>
    </table>
</c:if>

<div id="header">
    <h1>Add and Edit Part</h1>
</div>

<c:url var="addAction" value="/parts/add"/>

<form:form action="${addAction}" commandName="part">
    <div class="divfortable">
        <table class="tableparams">
            <c:if test="${!empty part.name}">
                <tr>
                    <td>
                        <form:label path="id">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="id" readonly="true" size="8" disabled="true"/>
                        <form:hidden path="id"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>
                    <form:label path="name">
                        <spring:message text="Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="quant">
                        <spring:message text="Quant"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="quant"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="need">
                        <spring:message text="IsNeed"/>
                    </form:label>
                </td>
                <c:choose>
                    <c:when test="${need}">
                        <td>
                            <form:input path="need" value="Yes"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td>
                            <form:input path="need" value="No"/>
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>

            <tr>
                <td colspan="2">
                    <c:if test="${!empty part.name}">
                        <input type="submit"
                               value="<spring:message text="Edit Part"/>"/>
                    </c:if>
                    <c:if test="${empty part.name}">
                        <input type="submit"
                               value="<spring:message text="Add Part"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </div>

    <div id="hrefPrev">
        <a href="<c:url value="/previous"/>"><--previous</a>
    </div>
    <div id="hrevNext">
        <a href="<c:url value="/next"/>">next--></a>
    </div>


</form:form>
<c:url var="getAction" value="/partdata/"/>

<form:form action="${getAction}" commandName="part" method="GET">

    <table>

        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">

                <input type="submit"
                       value="<spring:message text="Find"/>"/>
            </td>
        </tr>
    </table>
</form:form>

<div id="hrefSort">
    <a href="<c:url value="/sort"/>">Sort by Need</a>
</div>

<div id="hrefSortId">
    <a href="<c:url value="/parts"/>">Sort by Id</a>
</div>
</body>
</html>
