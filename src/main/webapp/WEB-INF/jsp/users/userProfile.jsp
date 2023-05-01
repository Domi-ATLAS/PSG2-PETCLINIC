<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  

<petclinic:layout pageName="userProfile">

    <h2>User Profile</h2>

    <h2>Plan Type: ${plan.name}</h2>
        <c:if test="${type == 'veterinarian'}">
            <table class="table table-striped">
                <tr>
                    <th>Name</th>
                    <td><b><c:out value="${user.username} "/></b></td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td><c:out value="${vet.firstName}"/></td>
                </tr>
                <tr>
                    <th>City</th>
                    <td><c:out value="${vet.lastName}"/></td>
                </tr>
            </table>
            
            <br/>
            <br/>
            <br/>
                <h2>Specialties</h2>

                <c:forEach var="sp" items="${vet.specialties}">
            
                        <tr>
                            <td valign="top">
                                <dl class="dl-horizontal">
                                    <tr>
                                        <td><b><c:out value="${sp} "/></b></td>
                                    </tr>
                                </dl>
                            </td>
                        </tr>
            
                    </c:forEach>
            </c:if>
     
        <c:if test="${type == 'owner'}">
            <table class="table table-striped">
                <tr>
                    <th>Name</th>
                    <td><b><c:out value="${user.username} "/></b></td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td><c:out value="${owner.address}"/></td>
                </tr>
                <tr>
                    <th>City</th>
                    <td><c:out value="${owner.city}"/></td>
                </tr>
                <tr>
                    <th>Telephone Number</th>
                    <td><c:out value="${owner.telephone}"/></td>
                </tr>
            </table>
            
            <br/>
            <br/>
            <br/>
            <h2>Pets</h2>
        
            <table class="table table-striped">
                <c:forEach var="pet" items="${owner.pets}">
        
                    <tr>
                        <td valign="top">
                            <dl class="dl-horizontal">
                                <dt>Name</dt>
                                <dd><c:out value="${pet.name}"/></dd>
                                <dt>BirthDay</dt>
                                <dd><petclinic:localDate date="${pet.birthDate}" pattern="yyyy-MM-dd"/></dd>
                                <dt>Pet type</dt>
                                <dd><c:out value="${pet.type.name}"/></dd>
                            </dl>
                        </td>
                    </tr>
        
                </c:forEach>
            </table>
        </c:if>

    


</petclinic:layout>
