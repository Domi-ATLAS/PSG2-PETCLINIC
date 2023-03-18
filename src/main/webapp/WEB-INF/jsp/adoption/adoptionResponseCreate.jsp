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

<petclinic:layout pageName="adoptionResponse">
   
    <jsp:body>
        <h2>Responder solicitud de adopci&oacute;n de <c:out value = "${adoptionRequest.pet.name}"/></h2>

        <form:form modelAttribute="adoptionResponse" class="form-horizontal" id="add-adoptionResponse-form">
            <div class="form-group has-feedback">
                <input type="hidden" name="id" value="${adoptionResponse.id}"/>
                <petclinic:inputField label="&iquest;Como tratar&aacute;s la m&aacute;scota?" name="description"/>
                <button class="btn btn-default" type="submit">Enviar respuesta a la solicitud</button>        
            </div>   
        </form:form>   
    </jsp:body>
</petclinic:layout>





