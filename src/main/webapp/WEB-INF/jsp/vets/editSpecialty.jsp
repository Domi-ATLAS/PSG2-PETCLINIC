<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="specialty">
    <jsp:body>
        <div style="text-align: center; ">
            <h2 style = "font-size: 40px; margin-bottom: 3%;";>A&#241;adir Especialidad</h2>
        </div>
        <form:form modelAttribute="specialty"
                   class="form-horizontal">
                   <input type="hidden" name="spec.id" value ="spec.id"/>
            <c:forEach items="${specialty}" var="esp">
                        <tr>
                            <td>${esp.name}</td>
                            <td>
                                <input type="radio" name="name" value="${esp.name}" checked>
                            </td>
                        </tr>
                    </c:forEach>
            <div style="text-align:center; margin-top: 1%;">
                    <button class="btn btn-default" style="font-size: 20px; font-family: sans-serif; "  type="submit" href="/vets/edit">Actualizarlo</button>
            </div>
        </form:form>        
    </jsp:body>
</petclinic:layout>


