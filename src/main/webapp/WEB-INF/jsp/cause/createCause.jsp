<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="cause">
    <jsp:body>
        <div style="text-align: center; ">
            <h2 style = "font-size: 40px; margin-bottom: 3%;";>Create Cause</h2>
        </div>
        <form:form modelAttribute="cause" class="form-horizontal">
            <input type="hidden" name="id" value="${cause.id}"/>
            <div class="form-group has-feedback">                
                <petclinic:inputField label="Cause name:" name="name"/>
                <petclinic:inputField label="Description:" name="description"/>
                <petclinic:inputField label="Budget Target:" name="budgetTarget"/>
                <petclinic:inputField label="Organization:" name="nonProfitOrganization"/>
            </div>
            <div style="text-align:center; margin-top: 1%;">
                    <button class="btn btn-default" style="font-size: 20px; font-family: sans-serif; "  type="submit" href="/causes/new">Create</button>
            </div>
        </form:form>                 
    </jsp:body>
</petclinic:layout>