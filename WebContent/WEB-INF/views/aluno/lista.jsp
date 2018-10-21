<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<c:import url="resources/header.jsp"/>

<h1>Lista de Alunos</h1>
	
	<table border="2">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Matrícula</th>
				<th>CPF</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aluno" items="${alunos }">

				<tr>

					<td>${aluno.nome }</td>
					<td>${aluno.matricula }</td>
					<td>${aluno.cpf }</td>
					<td>${aluno.endereco }</td>
					<td>${aluno.dataNascimento.time }</td>

				</tr>
			</c:forEach>

		</tbody>

	</table>
	


</body>
</html>
