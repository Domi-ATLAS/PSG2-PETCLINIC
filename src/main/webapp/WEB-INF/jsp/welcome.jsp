<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %-->  

<petclinic:layout pageName="home">
    <h2>Bienvenido al Petclinic PSG2-2223-G4-43</h2>
    <div class="row">
        <div class="col-md-12">
            <spring:url value="/resources/images/caballo.png" htmlEscape="true" var="petsImage"/>
            <img class="img-responsive" src="${petsImage}"/>
            
        </div>
    </div>
    <c:out value="${model.get('message')}"/>

    <a class="btn btn-default"  href="/users/changePlan">Cambiar plan</a>
</petclinic:layout>
