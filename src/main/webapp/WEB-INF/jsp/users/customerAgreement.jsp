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

    <br/>
    <h2>Indicadores de servicios</h2>
    <br/>

    <table>
      <thead>
          <tr>
            <th style="padding: 10px; border: 1px solid black;min-width: 20%;width: 500px;">Indicador</th>
            <th style="padding: 10px; border: 1px solid black;min-width: 40%;text-align: center;">Definición</th>
            <th style="padding: 10px; border: 1px solid black;min-width: 20%;text-align: center;">Unidad</th>
            <th style="padding: 10px; border: 1px solid black;min-width: 20%;text-align: center;">Objetivo</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style="padding: 10px; border: 1px solid black;">Indicador 1</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;">Avisos de inactividad breve por cambios de estética en la página</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;">Horas</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;">I1 >= 4</td>
          </tr>
          <tr>
            <td style="padding: 10px; border: 1px solid black;">Indicador 2</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;">Aviso de actividades por actualizaciones de funcionalidad</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;">Días</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;">I2 >= 2</td>
          </tr>
          <tr>
            <td style="padding: 10px; border: 1px solid black;">Indicador 3</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;">Indica el rendimiento en segundos que tardan en realizarse las peticiones del sistema</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;">Segundos</td>
            <td style="padding: 10px; border: 1px solid black;text-align: center;">I3 >= 2.5</td>
          </tr>
        </tbody>
      </table>

      <br/>
      <br/>
  
      <table>
        <thead>
          <tr>
            <th style="padding: 10px; border: 1px solid black;min-width: 20%;width: 500px;">Indicador</th>
            <th style="padding: 10px; border: 1px solid black;min-width: 40%;text-align: center;">Definición</th>
            <th style="padding: 10px; border: 1px solid black;min-width: 20%;text-align: center;">Unidad</th>
            <th style="padding: 10px; border: 1px solid black;min-width: 20%;text-align: center;">Objetivo</th>
          </tr>
          </thead>
          <tbody>
            <tr>
              <td style="padding: 10px; border: 1px solid black;">Indicador 4</td>
              <td style="padding: 10px; border: 1px solid black;text-align: center;">Aviso de algún tipo de inactividad del servicio por motivos previstos</td>
              <td style="padding: 10px; border: 1px solid black;text-align: center;">Días</td>
              <td style="padding: 10px; border: 1px solid black;text-align: center;">I4 >= 7</td>
            </tr>
            <tr>
              <td style="padding: 10px; border: 1px solid black;">Indicador 5</td>
              <td style="padding: 10px; border: 1px solid black;text-align: center;">Aviso de inactividad por incorporación de funcionalidad</td>
              <td style="padding: 10px; border: 1px solid black;text-align: center;">Días</td>
              <td style="padding: 10px; border: 1px solid black;text-align: center;">I5 >= 5</td>
            </tr>
            <tr>
              <td style="padding: 10px; border: 1px solid black;">Indicador 6</td>
              <td style="padding: 10px; border: 1px solid black;text-align: center;">Fallo de una funcionalidad, dejando al resto de la aplicación estable.</td>
              <td style="padding: 10px; border: 1px solid black;text-align: center;">Nº de funcionalidades caidas</td>
              <td style="padding: 10px; border: 1px solid black;text-align: center;">I6 <= 1</td>
            </tr>
            <tr>
              <td style="padding: 10px; border: 1px solid black;">Indicador 7</td>
              <td style="padding: 10px; border: 1px solid black;text-align: center;">Tiempo que tarda en confirmar que el dinero ha llegado a la organización.</td>
              <td style="padding: 10px; border: 1px solid black;text-align: center;">Días</td>
              <td style="padding: 10px; border: 1px solid black;text-align: center;">I7 <= 1</td>
            </tr>
          </tbody>
        </table>

        <br/>
        <br/>
    
        <table>
          <thead>
            <tr>
              <th style="padding: 10px; border: 1px solid black;min-width: 20%;width: 500px;">Indicador</th>
              <th style="padding: 10px; border: 1px solid black;min-width: 40%;text-align: center;">Definición</th>
              <th style="padding: 10px; border: 1px solid black;min-width: 20%;text-align: center;">Unidad</th>
              <th style="padding: 10px; border: 1px solid black;min-width: 20%;text-align: center;">Objetivo</th>
            </tr>
            </thead>
            <tbody>
              <tr>
                <td style="padding: 10px; border: 1px solid black;">Indicador 8</td>
                <td style="padding: 10px; border: 1px solid black;text-align: center;">Aviso de algún tipo de inactividad del servicio por motivos imprevistos</td>
                <td style="padding: 10px; border: 1px solid black;text-align: center;">Días</td>
                <td style="padding: 10px; border: 1px solid black;text-align: center;">I8 >= -1</td>
              </tr>
              <tr>
                <td style="padding: 10px; border: 1px solid black;">Indicador 9</td>
                <td style="padding: 10px; border: 1px solid black;text-align: center;">Avisos de inactividad por cambios en el núcleo del sistema</td>
                <td style="padding: 10px; border: 1px solid black;text-align: center;">Días</td>
                <td style="padding: 10px; border: 1px solid black;text-align: center;">I9 >= 12</td>
              </tr>
              <tr>
                <td style="padding: 10px; border: 1px solid black;">Indicador 10</td>
                <td style="padding: 10px; border: 1px solid black;text-align: center;">Tiempo de disponibilidad mensual de la aplicación</td>
                <td style="padding: 10px; border: 1px solid black;text-align: center;">Porcentaje</td>
                <td style="padding: 10px; border: 1px solid black;text-align: center;">I10 >= 95.5</td>
              </tr>
            </tbody>
          </table>


</petclinic:layout>

    


