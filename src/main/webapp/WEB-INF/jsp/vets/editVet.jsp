<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="vets">
    <jsp:body>
        <div style="text-align: center; ">
            <h2 style = "font-size: 40px; margin-bottom: 3%;";>Actualizar Veterinario</h2>
        </div>
        <form:form modelAttribute="vet"
                   class="form-horizontal">
            <input type="hidden" name="id" value="${vet.id}"/>
            <div class="form-group has-feedback">                
                <petclinic:inputField label="Nombre:" name="firstName"/>
                <petclinic:inputField label="Apellido:" name="lastName"/>
            </div>
            <div style="text-align:center; margin-top: 1%;">
                    <button class="btn btn-default" style="font-size: 20px; font-family: sans-serif; "  type="submit" href="/vets/edit">Actualizarlo</button>
            </div>
        </form:form>        
    </jsp:body>
</petclinic:layout>


