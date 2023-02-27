<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<style>
	.center {
		text-align: center;
	}
</style>

<petclinic:layout pageName="custom-logout">
    <div class="center">
        <h1>
            <strong>
                ¿Estás seguro de que deseas cerrar sesión?
            </strong>
        </h1>
        <form:form>
            <a class="btn btn-primary" href='<spring:url value="/" htmlEscape="true"/>'>Cancelar</a>
            <button class="btn btn-primary" type="submit">Cerrar Sesión</button>
        </form:form>
    </div> 
</petclinic:layout>