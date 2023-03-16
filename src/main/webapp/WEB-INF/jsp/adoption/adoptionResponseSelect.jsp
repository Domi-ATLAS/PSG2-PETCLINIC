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


<petclinic:layout pageName="adoptionRequest">
    <div style="font-size: 20px;color: black;">
        <div>
            <p>Propietario de la mascota:</p><c:out value="${adoptionRequest.author.user.username}"/>
        </div>
        <div>
            <p>Mensaje del propietario: </p><c:out value="${adoptionRequest.message}"/>
        </div>
        <div>
            <p>Nombre de la mascota:</p><c:out value= "${adoptionRequest.pet.name}"/>
        </div>
    </div>

    <form:form modelAttribute="adoptionRequest" class="form-horizontal" id="add-adoptionRequest-form">
                <input type="hidden" name="id" value="${adoptionRequest.id}"/>
                <input type="hidden" name="message" value="${adoptionRequest.message}"/>
                <input type="hidden" name="author" value="${adoptionRequest.author.id}"/>
                          

    <table id="adoptionRequestTable" class="table table-striped">
        <thead style="background-color: lightgray;">
            <tr>
                <th>Seleccionar</th>
                <th>Autor </th>
                <th>Mensaje</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${adoptionRequest.responses}" var="adoptionResponse">
            <tr>
                <td>
                    <input type="radio" name ="selectedResponse"value="${adoptionResponse.id}" checked/>
                </td>
                <td>
                    <c:out value="${adoptionResponse.owner.user.username}"/>
                </td>
                <td>
                    <c:out value="${adoptionResponse.description}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>        
    </table>
    <c:if test = "${adoptionRequest.author.user.username == principal}">
        <button class="btn btn-default" type="submit">Escoger nuevo due&ntilde;o para mi mascota</button> 
    </c:if>
</form:form>   
    
</petclinic:layout>