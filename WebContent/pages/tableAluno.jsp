<table border="2">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Matr�cula</th>
				<th>CPF</th>
				<th>Endere�o</th>
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