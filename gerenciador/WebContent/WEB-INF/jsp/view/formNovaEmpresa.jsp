<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/UnicaEntradaServlet" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="logout_parcial.jsp"></c:import>
	<form action="${linkServletNovaEmpresa}?acao=AdicionarEmpresa" method="post">
	
		Nome: <input type="text" name="nome"  />
		Data Abertura: <input type="text" name="data"  />
	
		<input type="submit" />
	</form>

</body>
</html>