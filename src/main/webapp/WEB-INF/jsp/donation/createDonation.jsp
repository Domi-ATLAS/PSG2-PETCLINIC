<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="donation">
    <jsp:body>
        <div style="text-align: center; ">
            <h2 style = "font-size: 40px; margin-bottom: 3%;";>Crear Donaci&oacute;n</h2>
        </div>
        <form:form modelAttribute="donation" class="form-horizontal">
            <input type="hidden" name="id" value="${donation.id}"/>
            <input type="hidden" name="donorName" value="${donorName}"/>
            <div class="form-group has-feedback">                
                <tr>
                    <petclinic:inputField label="Cantidad: (En USD)" name="amount"/>
                </tr>
                <tr>
                    <petclinic:inputField label="Mensaje:" name="message"/>
                </tr>      
            </div>
            
            <div style="text-align:center; margin-top: 1%;">
                <button class="btn btn-default" style="font-size: 20px; font-family: sans-serif; "  type="submit" >Crear</button>
            </div> 
        </form:form> 
       
    </jsp:body>
</petclinic:layout>