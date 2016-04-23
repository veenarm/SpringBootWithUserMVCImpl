<%@ page session="false"%>
<%@page pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragments/header.jsp" />

<body>

	<div class="container">
		<h1>You got an exception! There's a BUG somewhere!</h1>
		<ul>
			<li>Date/time: <c:out value="${date}"/> </li>
            <li>User agent: ${header['user-agent']}</li>
            <li>User IP: ${ip}</li>
            <li>Request URI: ${requestScope['javax.servlet.error.request_uri']}</li>
            <li>Ajax request: ${isAjax ? 'Yes' : 'No'}</li>
            <li>Status code: ${requestScope['javax.servlet.error.status_code']}</li>
            <li>Exception type: ${requestScope['javax.servlet.error.exception_type']}</li>
            <li>Exception message: ${requestScope['javax.servlet.error.message']}</li>
            <li>Stack trace:
                <pre>
                    ${pageContext.out.flush()}${exception.printStackTrace(pageContext.response.writer)}
				</pre>
			</li>
		</ul>
	</div>

	<jsp:include page="fragments/footer.jsp" />

</body>
</html>