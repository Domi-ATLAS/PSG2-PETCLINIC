<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="causes">
    <h2>Causas</h2>

    <br/>        

    <h2>Selecciona una divisa:</h2>

    <div style="text-align: center; align-items: center;">
        <form action="/causes" method="post">
            <label for="currency">Divisas:</label>
            <select name="currency" id="currency">
              <c:forEach items="${options}" var="option">
                <option value="${option}">${option}</option>
              </c:forEach>
            </select>
            <button type="submit">Aceptar</button>
          </form>
    </div>

    <table id="causesList" class="table table-striped">
        <thead style="background-color: lightgray;">
        <tr>
            <th style="width: 150px;">Nombre</th>
            <th style=" width: 200px;">Cantidad conseguida</th>
            <th>Cantidad objetivo</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${causeBudgets}" var="causeBudget">
            <tr>
                <td>
                    <c:out value="${causeBudget.key.name}"/>
                </td>
                <td>
                    <c:out value="${causeBudget.value.get(1).value} ${causeBudget.value.get(1).currency}"/>
                </td>
                <td>
                    <c:out value="${causeBudget.value.get(0).value} ${causeBudget.value.get(0).currency}"/>
                </td>
                <td>
                    <div>
                        <a class="btn btn-default" style="font-size: 15px; font-family: sans-serif; margin-left: 75%; margin-right: 10%;"  href="/causes/details/${causeBudget.key.id}">Detalles</a>
                        <c:if test="${!causeBudget.key.isClosed}">
                            <a class="btn btn-default" style="font-size: 15px; font-family: sans-serif; margin-left: 75%; margin-right: 10%;"  href="/donation/new/${causeBudget.key.id}">Donar</a>
                        </c:if>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div style="position: relative;">
        <a class="btn btn-default" style="font-size: 15px; font-family: sans-serif; margin-left: 75%; margin-right: 10%;"  href="/causes/new">Crear nueva causa</a>
    </div>
    
</petclinic:layout>
