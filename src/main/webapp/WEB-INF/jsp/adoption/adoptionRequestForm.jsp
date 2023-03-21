<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="adoptionRequest">
   
    <jsp:body>
        <h2>Hacer solicitud de adopción</h2>

        <form:form modelAttribute="adoptinoRequest" class="form-horizontal" id="add-adoptionRequest-form">
            <div class="form-group has-feedback">
                <input type="hidden" name="id" value="${adoptinoRequest.id}"/>
                <petclinic:inputField label="&iquest;Por qu&eacute; quiere que adopten su mascota? &iquest;Y c&oacute;mo deben tratarla?" name="message"/>
                <div>
                    <c:forEach items="${pets}" var="pet">
                        <tr>
                            <td>${pet.name}</td>
                            <td>
                                <input type="radio" name="pet" value="${pet.id}" checked/></br>
                            </td>
                        </tr>
                    </c:forEach>
                </div>
                <tr>
                    <td>
                        <c:if test = "${!pets.isEmpty()}">
                            <button class="btn btn-default" type="submit">Solicitar que me adopten la mascota</button>
                        </c:if>
                        <c:if test = "${pets.isEmpty()}">
                            <a>Lo sentimos pero no tienes mascotas para solicitar que te la adopten</a>
                        </c:if>
                    </td>
                </tr>
            </div>   
        </form:form>   
    </jsp:body>
</petclinic:layout>


























