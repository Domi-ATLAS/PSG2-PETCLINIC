<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="causes">
    <h2>Cause: ${cause.name}</h2>

    <div>
        Description: ${cause.description}
    </div>
    <div>
        Achieved budget: ${cause.achievedBudget}/${cause.budgetTarget}
    </div>
    <div>
        Organization: ${cause.nonProfitOrganization}
    </div>
    <div>
        <c:if test="${cause.isClosed}">
            This cause is closed
        </c:if>
    </div>

    <h2>Donations</h2>

    <table id="donations" class="table table-striped">
        <thead style="background-color: lightgray;">
        <tr>
            <th style="width: 150px;">Amount</th>
            <th style=" width: 200px;">Donor Name</th>
            <th>Message</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cause.donations}" var="donation">
            <tr>
                <td>
                    <c:out value="${donation.amount}"/>
                </td>
                <td>
                    <c:out value="${donation.donorName}"/>
                </td>
                <td>
                    <c:out value="${donation.message}"/>
                </td>
                <td>
                    <c:out value="${donation.date}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    
</petclinic:layout>
