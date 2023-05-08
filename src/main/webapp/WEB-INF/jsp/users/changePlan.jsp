<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="owners">
    <h2>
        Escoge el plan que quieras
    </h2>
    <div style="text-align: center; align-items: center;">
    <form:form modelAttribute="user" class="form-horizontal">
        <div class="form-group has-feedback">
            <div>

                <select name="plan" style="width: 150px;height: 50px;margin-bottom: 100 px;">
                    <c:if test="${plan !='BASIC'}">
                      <option value="BASIC">BASIC</option>
                    </c:if>
                    <c:if test="${plan !='ADVANCED'}">
                      <option value="ADVANCED">ADVANCED</option>
                    </c:if>
                    <c:if test="${plan !='PRO'}">
                      <option value="PRO">PRO</option>
                    </c:if>
                  </select>
            </div>    
            <button class="btn btn-default" style="font-size: 20px; font-family: sans-serif; "  type="submit">Cambiar Plan</button>
        </div>
    </form:form>
    </div>

    <h3>Recuerda que estos son los precios de los planes:</h3>
    <table style="border-collapse: collapse; width: 100%;">
  <thead>
    <tr>
      <th style="padding: 10px; border: 1px solid black;">Plan</th>
      <th style="padding: 10px; border: 1px solid black;">Precio</th>
      <th style="padding: 10px; border: 1px solid black;">Ventajas</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="padding: 10px; border: 1px solid black;">BASIC</td>
      <td style="padding: 10px; border: 1px solid black;">0€/mes</td>
      <td style="padding: 10px; border: 1px solid black;">Hacer donaciones, podrás ver otros propietarios y sus detalles</td>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid black;">ADVANCED</td>
      <td style="padding: 10px; border: 1px solid black;">5€/mes</td>
      <td style="padding: 10px; border: 1px solid black;">Adem&aacute;s de lo anterior, podr&aacute;s hacer reservas y solicitar que adopten a tus mascotas</td>
    </tr>
    <tr>
      <td style="padding: 10px; border: 1px solid black;">PRO</td>
      <td style="padding: 10px; border: 1px solid black;">10€/mes</td>
      <td style="padding: 10px; border: 1px solid black;">Adem&aacute;s de lo anterior, podr&aacute;s adoptar y crear causas para que te hagan donaciones</td>
    </tr>
  </tbody>
</table>


</petclinic:layout>
