<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<style>
    .fondo {
        background-color: #f9f9f9;
        padding: 50px 0;
    }
    
    .contenedor {
        max-width: 1200px;
        margin: 0 auto;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-wrap: wrap;
    }
    
    .info {
        flex-basis: 50%;
        text-align: center;
    }
    
    .info h2 {
        font-size: 2em;
        margin-bottom: 30px;
    }
    
    .info ul {
        list-style: none;
        padding: 0;
    }
    
    .info ul li {
        margin-bottom: 10px;
    }
    
    .info ul li a {
        color: #333;
        font-size: 1.2em;
    }
    
    .imagen {
        flex-basis: 50%;
        text-align: center;
    }
    
    .imagen img {
        max-width: 80%;
        height: auto;
    }

    .encabezado {
        text-align: center;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    
    .encabezado img {
        margin-right: 10;
        margin-bottom: 15;
        width: 30;
        height: 30;
    }
</style>

<petclinic:layout pageName="supportPage">
    <div class="encabezado">
        <img src="/resources/images/soporteLogo.png"/>
        <h1>Página de soporte</h1>
    </div>
    <div class="fondo">
        <div class="contenedor">
            <div class="info">
                <h2>Información de contacto</h2>
                <ul>
                    <h3>Página web:</h3>
                    <li><a href="/resources/images/perroAuricular.jpg" target="_blank">www.petclinicsupport.com</a></li>
                    <h3>Emails:</h3>
                    <li><a href="mailto:support@petclinic.com">support@petclinic.com</a></li>
                    <li><a href="mailto:help@petclinic.com">help@petclinic.com</a></li>
                    <h3>Teléfonos:</h3>
                    <li><a href="tel:123456789">123 45 67 89</a></li>
                    <li><a href="tel:987654321">987 65 43 21</a></li>
                    <br>
                    <p>Nos esforzamos en responder las consultas en el menor tiempo posible.</p>
                    <p>Gracias por su colaboración.</p>
                </ul>
            </div>
            <div class="imagen">
                <img src="/resources/images/soporte.jpg">
            </div>
        </div>
    </div>
</petclinic:layout>