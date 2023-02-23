<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="bookings">
    <h2>Listado de mascotas de <c:out value = "${principal}"/></h2>

    <table id="ownersTable" class="table table-striped">
        <thead style="background-color: lightgray;">
        <tr>
            <th>Fecha de inicio </th>
            <th>Fecha de fin</th>
            <th>Mascota</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookings}" var="booking">
            <tr>
                <td>
                    <c:out value="${booking.startDate}"/>
                </td>
                <td>
                    <c:out value="${booking.finishDate}"/>
                </td>
                <td>
                    <c:out value="${booking.pet.getName()}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>

        
    </table>


    <spring:url value="/booking/new" htmlEscape="true" var="newBooking"/>
    <a class="btn btn-default" href="${newBooking}">Reservar</a>

</petclinic:layout>
