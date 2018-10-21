<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="resources/header.jsp"/>



	<h1>Add Aluno </h1>
		<form method="POST" action="/bibliotecaspring/aluno">
		<div>
			<label>Nome: </label> 
			<input type="text" name="nome">
		</div>
		<div>
			<label>Matrícula: </label> 
			<input type="text" name="matricula">
		</div>
		<div>
			<label>CPF: </label> 
			<input type="text" name="cpf">
		</div>
		<div>
			<label>Endereço: </label> 
			<input type="text" name="endereco">
		</div>
		<div>
			<label>Data de Nascimento: </label>
			<input type="text" name="dataNascimento">
		</div>
		<div>
			<button type="submit">Adicionar</button>
		</div>
		</form>
	

</body>
</html>