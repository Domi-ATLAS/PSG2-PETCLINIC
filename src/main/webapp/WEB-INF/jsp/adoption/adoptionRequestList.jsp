<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="adoptionRequest">

    <table id="adoptionRequestTable" class="table table-striped">
        <thead style="background-color: lightgray;">
            <tr>
                <th>Autor </th>
                <th>Mensaje</th>
                <th>Mascota</th>
                <th>Respuestas</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${adoptionRequests}" var="adoptionRequest">
            <tr>
                <td>
                    <c:out value="${adoptionRequest.author.user.username}"/>
                </td>
                <td>
                    <c:out value="${adoptionRequest.message}"/>
                </td>
                <td>
                    <c:out value="${adoptionRequest.pet.name}"/>
                </td>
                <td>
                    <a href="/adoptionRequest/${adoptionRequest.id}">Respuestas</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>        
    </table>

    <spring:url value="/adoptionRequest/new" htmlEscape="true" var="newAR"/>
    <a class="btn btn-default" href="${newAR}">Solicitar Adopci&oacute;n</a>

</petclinic:layout>
