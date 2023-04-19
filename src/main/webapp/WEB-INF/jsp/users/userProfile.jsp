<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="userProfile">

<h2>User Profil</h2>


<table class="table table-striped">
    <tr>
        <th>User Name</th>
        <td><b><c:out value="${user.username}"/></b></td>
    </tr>
    <tr>
        <th>Dirección</th>
        <td><c:out value="${owner.address}"/></td>
    </tr>
    <tr>
        <th>Ciudad</th>
        <td><c:out value="${owner.city}"/></td>
    </tr>
    <tr>
        <th>Teléfono</th>
        <td><c:out value="${owner.telephone}"/></td>
    </tr>
</table>


<br/>
<br/>
<br/>
<h2>Mascotas y Visitas</h2>

<table class="table table-striped">
    <c:forEach var="pet" items="${owner.pets}">

        <tr>
            <td valign="top">
                <dl class="dl-horizontal">
                    <dt>Nombre</dt>
                    <dd><c:out value="${pet.name}"/></dd>
                    <dt>Cumpleaños</dt>
                    <dd><petclinic:localDate date="${pet.birthDate}" pattern="yyyy-MM-dd"/></dd>
                    <dt>Tipo</dt>
                    <dd><c:out value="${pet.type.name}"/></dd>
                </dl>
            </td>
            <td valign="top">
                <table class="table-condensed">
                    <thead>
                    <tr>
                        <th>Fecha de la Visita</th>
                        <th>Descripción</th>
                    </tr>
                    </thead>
                    <c:forEach var="visit" items="${pet.visits}">
                        <tr>
                            <td><petclinic:localDate date="${visit.date}" pattern="yyyy-MM-dd"/></td>
                            <td><c:out value="${visit.description}"/></td>
                            
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>

    </c:forEach>
</table>


</petclinic:layout>