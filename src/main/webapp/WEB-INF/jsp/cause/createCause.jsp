<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="cause">
    <jsp:body>
        <div style="text-align: center; ">
            <h2 style = "font-size: 40px; margin-bottom: 3%;";>Crear causa</h2>
        </div>
        <form:form modelAttribute="cause" class="form-horizontal">
            <input type="hidden" name="id" value="${cause.id}"/>
            <div class="form-group has-feedback">                
                <petclinic:inputField label="Nombre de la causa:" name="name"/>
                <petclinic:inputField label="Descripción:" name="description"/>
                <petclinic:inputField label="Cantidad objetivo: (En USD)" name="budgetTarget"/>
                <petclinic:inputField label="Organización:" name="nonProfitOrganization"/>
            </div>
            <div style="text-align:center; margin-top: 1%;">
                    <button class="btn btn-default" style="font-size: 20px; font-family: sans-serif; "  type="submit" href="/causes/new">Crear</button>
            </div>
        </form:form>                 
    </jsp:body>
</petclinic:layout>