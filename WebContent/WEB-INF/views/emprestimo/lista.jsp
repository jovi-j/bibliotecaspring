<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<c:import url="/WEB-INF/resources/header.jsp"/>

	<h1>Lista de contatos:</h1>

	<table border="2">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Endere�o</th>
				<th>Data de Nascimento</th>
				<th>Apagar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="contato" items="${contatos }">

				<tr>

					<td>${contato.nome }</td>
					<td>${contato.email }</td>
					<td>${contato.endereco }</td>
					<td>${contato.dataNascimento.time }</td>
					<td>
						<form class="btn-apagar" action="/agendaspring/contatos/delete"
							method="post">
							<input type="hidden" name="id" value="${contato.id}" />
							<button type="submit"></button>
						</form>
					</td>

				</tr>
			</c:forEach>

		</tbody>

	</table>


</body>
</html>
