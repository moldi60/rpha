<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html>
	<head>
		<title>JSP for AdvancedSearchForm form</title>
	</head>
	<body>
		<html:form action="/advancedSearch">
			query : <html:textarea property="query"/><html:errors property="query"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

