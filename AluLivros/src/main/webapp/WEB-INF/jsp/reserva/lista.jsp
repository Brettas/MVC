<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Java Web - AT</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">

		<form action="/reserva" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>
		
		<hr>
	
		<c:if test="${not empty msg}">
			<div class="alert alert-success">
			  <strong>Sucesso!</strong> ${msg}
			</div>
		</c:if>

		<c:if test="${not empty lista}">
			<h4>Quantidade de reservas existentes: ${lista.size()}!!!</h4>
			
			<hr>
	
			<table class="table table-striped">
		    <thead>
		      <tr>
		      	<th>Id</th>
		        <th>Observação</th>
		        <th>Solicitante</th>
		        <th>Livros</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>		    
		    	<c:forEach var="p" items="${lista}">
			      <tr>
			        <td>${p.id}</td>
			        <td>${p.observacao}</td>
			        <td>${p.solicitante.nome}</td>
			        <td>${p.livros.size()}</td>
			        <td><a href="/reserva/${p.id}/excluir">Excluir</a></td>
			      </tr>
		    	</c:forEach>
		    </tbody>
		  	</table>
	  	</c:if>
	  	
	  	<c:if test="${empty lista}">
			<h4>Não existem reservas cadastradas!!!</h4>
	  	</c:if>
	</div>
</body>
</html>