<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="causes">
    <h2>Causes</h2>

    <table id="causesList" class="table table-striped">
        <thead style="background-color: lightgray;">
        <tr>
            <th style="width: 150px;">Name</th>
            <th style=" width: 200px;">Achieved Budget</th>
            <th>Budget Target</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${causes}" var="cause">
            <tr>
                <td>
                    <c:out value="${cause.name}"/>
                </td>
                <td>
                    <c:out value="${cause.achievedBudget}"/>
                </td>
                <td>
                    <c:out value="${cause.budgetTarget}"/>
                </td>
                <td>
                    <a class="btn btn-default" style="font-size: 15px; font-family: sans-serif; margin-left: 75%; margin-right: 10%;"  href="/causes/details/{cause.id}">Details</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div style="position: relative;">
        <a class="btn btn-default" style="font-size: 15px; font-family: sans-serif; margin-left: 75%; margin-right: 10%;"  href="/donation/new">Donate</a>
        <a class="btn btn-default" style="font-size: 15px; font-family: sans-serif; margin-left: 75%; margin-right: 10%;"  href="/causes/new">Create a new cause</a>
    </div>
    
</petclinic:layout>
