<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<style>
    .lista {
        list-style: none;
        padding: 0;
        margin: 0;
    }
    
    .lista li {
        background-color: #f9f9f9;
        padding: 20px;
        margin-bottom: 10px;
        border-radius: 5px;
    }
    
    .titulo {
        font-weight: bold;
        font-size: 20px;
        margin-bottom: 10px;
    }
    
    .descripcion {
        font-size: 16px;
        color: #666;
    }
    
    .encabezado {
        display: flex;
        align-items: center;
    }
    
    .encabezado img {
        margin-right: 10px;
        margin-bottom: 15;
        width: 30;
        height: 30;
    }
</style>

<petclinic:layout pageName="changelog">
    <div class="encabezado">
        <img src="/resources/images/changelogLogo.png"/>
        <h1>Registro de cambios - Sprint 4</h1>
    </div>
    <ul class="lista">
        <li>
            <div class="titulo">Plan de precios</div>
            <div class="descripcion">Se permite elegir un plan de precios entre Basic, Advanced y Pro ajustando las características y 
                términos de uso según el plan elegido. El plan por defecto es Basic. Se muestra una matriz de precios para facilitar
                la elección.
            </div>
        </li>
        <li>
            <div class="titulo">Perfil de usuario</div>
            <div class="descripcion">Además de otra información específica del usuario, se muestra el nombre del plan suscrito 
                por el usuario y la matriz de precios correspondiente.
            </div>
        </li>
        <li>
            <div class="titulo">Interfaz compatible con contratos</div>
            <div class="descripcion">La interfaz de la aplicación se ajusta al plan de precios asociado con el usuario logueado.</div>
        </li>
        <li>
            <div class="titulo">Uso de APIs</div>
            <div class="descripcion">Características añadidas sobre currency API y Maps API.
            </div>
        </li>
        <li>
            <div class="titulo">Página de soporte</div>
            <div class="descripcion">Detalles de contacto tales como página web, emails y números de teléfono del equipo de soporte de 
                la aplicación.
            </div>
        </li>
        <li>
            <div class="titulo">Acuerdo de cliente de los servicios de Petclinic PSG2-2223-G4-43</div>
            <div class="descripcion">Documento disponible como un nuevo elemento del menú de la aplicación.
            </div>
        </li>
    </ul>
</petclinic:layout>