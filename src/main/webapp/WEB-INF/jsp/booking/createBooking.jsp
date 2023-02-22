<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="bookings">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#startDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
        <script>
            $(function () {
                $("#finishDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h2>Hacer reserva</h2>

        <form:form modelAttribute="booking" class="form-horizontal" id="add-booking-form">
            <div class="form-group has-feedback">
                <input type="hidden" name="id" value="${booking.id}"/>
                
                <petclinic:inputField label="Fecha de inicio: " name="startDate"/>
                
                <petclinic:inputField label="Fecha de fin: " name="finishDate"/>

                <c:forEach items="${pets}" var="pet">
                    <tr>
                        <td>${pet.name}</td>
                        <td>
                            <input type="radio" name="pet" value="${pet.id}" checked/></br>
                        </td>
                    </tr>
                </c:forEach>
                <div style ="color: red;">
                    <c:out  value="${mesage}"/>
                </div>
                <tr>
                    <td>
                        <c:if test = "${!pets.isEmpty()}">
                            <button class="btn btn-default" type="submit">Reservar</button>
                        </c:if>
                        <c:if test = "${pets.isEmpty()}">
                            <a>Lo sentimos pero no tienes mascotas para las que reservar una habitaci&#243;n</a>
                        </c:if>
                    </td>
                </tr>
            </div>   
        </form:form>   
    </jsp:body>
</petclinic:layout>
