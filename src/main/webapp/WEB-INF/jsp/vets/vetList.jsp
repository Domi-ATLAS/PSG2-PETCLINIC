<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="vets">
    <h2>Veterinarians</h2>

    <table id="vetsTable" class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Especialidades</th>
            <th>Editar</th>
            <th>A&#241;adir Especialidades</th>
            <th>Eliminar Especialidades</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${vets.vetList}" var="vet">
            <tr>
                <td>
                    <c:out value="${vet.firstName} ${vet.lastName}"/>
                </td>
                <td>
                    <c:forEach var="specialty" items="${vet.specialties}">
                        <c:out value="${specialty.name} "/>
                    </c:forEach>
                    <c:if test="${vet.nrOfSpecialties == 0}">none</c:if>
                </td>
                <td>
                    <a href="/vets/edit/${vet.id}">   
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>     
                    </a>
                </td>
                <td>
                    <a href="/vets/editSpecialty/${vet.id}">   
                        <span class="glyphicon glyphicon-plus" aria-hidden="true" style=" margin-left: 20%"></span>     
                    </a>
                </td>
                <td>
                    <a href="/vets/deleteSpecialty/${vet.id}">   
                        <span class="glyphicon glyphicon-minus" aria-hidden="true" style=" margin-left: 20%"></span>     
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table class="table-buttons">
        <tr>
            <td>
                <a href="<spring:url value="/vets.xml" htmlEscape="true" />">View as XML</a>
            </td>            
        </tr>
    </table>

    <div style="position: relative;">
                <a class="btn btn-default" style="font-size: 15px; font-family: sans-serif; margin-left: 75%; margin-right: 10%;"  href="/vets/new">Crear un nuevo veterinario</a>
    </div>
</petclinic:layout>