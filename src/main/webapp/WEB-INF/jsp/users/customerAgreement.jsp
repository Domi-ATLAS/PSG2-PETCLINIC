<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="CA">
  
    ${htmlText1}
    <table>
    <thead>
        <tr>
          <th style="padding: 10px; border: 1px solid black;min-width: 40%;width: 500px;">Plan</th>
          <th style="padding: 10px; border: 1px solid black;min-width: 20%;text-align: center;">Basic</th>
          <th style="padding: 10px; border: 1px solid black;min-width: 20%;text-align: center;">Advanced</th>
          <th style="padding: 10px; border: 1px solid black;min-width: 20%;text-align: center;">Pro</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td style="padding: 10px; border: 1px solid black;">Reservas</td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: red;" class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span>2 al mes</td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span>Sin limitaci&oacute;n</td>
        </tr>
        <tr>
          <td style="padding: 10px; border: 1px solid black;">Crear causas</td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: red;" class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: red;" class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
        </tr>
        <tr>
          <td style="padding: 10px; border: 1px solid black;">Donar</td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>  
        </tr>
        <tr>
            <td style="padding: 10px; border: 1px solid black;">Visitas</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span>0% de descuento</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span>5% de descuento</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span>10% de descuento</td>  
        </tr>
        <tr>
            <td style="padding: 10px; border: 1px solid black;">Solicitar adopciones</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: red;" class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
        </tr>
        <tr>
            <td style="padding: 10px; border: 1px solid black;">Responder solicitudes de adopción</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: red;" class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: red;" class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
        </tr>
        <tr>
            <td style="padding: 10px; border: 1px solid black;">Resolución de incidentes</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: red;" class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
        </tr>
        <tr>
            <td style="padding: 10px; border: 1px solid black;">Peticiones de los usuarios</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: red;" class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
        </tr>
        <tr>
            <td style="padding: 10px; border: 1px solid black;">Peticiones de cambio</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: red;" class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: red;" class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
          <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>

        </tr>
        <tr>
            <td style="padding: 10px; border: 1px solid black;">Disponibilidad de los servicios a todas horas</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: red;" class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;"><span style="color: green;" class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
        
        </tr>
        <tr>
            <td style="padding: 10px; border: 1px solid black;">Precio</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;">0€/mes</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;">5€/mes</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;">10€/mes</td>
        </tr>
      </tbody>
    </table>
    ${htmlText2}


</petclinic:layout>

    


