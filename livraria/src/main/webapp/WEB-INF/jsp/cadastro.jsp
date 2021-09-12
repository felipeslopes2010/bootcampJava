<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Livraria</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body class="container">
	<h1 class="text-center mt-2">Cadastro de Autores</h1>
	<form action="<c:url value="/cadastro"/>" method="POST">
		<div class="form-group">
			<label for="nome">Nome</label>
			<input id="nome" class="form-control" name="nome">
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			<input id="email" class="form-control" name="email">
		</div>
		<div class="form-group">
			<label for="dataNascimento">Data de Nascimento</label>
			<input id="dataNascimento" class="form-control" name="dataNascimento">
		</div>
		<div class="form-group">
			<label for="curriculo">Mini Curriculo</label>
			<input id="curriculo" class="form-control" name="curriculo">
		</div>
		
		<input type="submit" value="Gravar" class="mt-2 btn-primary">
	</form>
	
	<h1 class="text-center mt-4 pb-4">Lista de Autores</h1>
	<table class="table table-hover table-striped table-bordered">
		<thead>
			<tr>
				<th class="text-center">NOME</th>
				<th class="text-center">EMAIL</th>
				<th class="text-center">DATA NASCIMENTO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${autores}" var="autor">
				<tr>
					<td class="text-center">${autor.nome}</td>
					<td class="text-center">${autor.email}</td>
					<td class="text-center">
						<fmt:parseDate value="${autor.dataNascimento}" pattern="yyyy-MM-dd" var="formatada" type="date"></fmt:parseDate>
						<fmt:formatDate value="${formatada}" pattern="dd/MM/yyyy" type="date"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>