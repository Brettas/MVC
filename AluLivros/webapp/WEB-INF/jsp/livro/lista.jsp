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

		<c:if test="${not empty msg}">
			<div class="alert alert-success">
			  <strong>Sucesso!</strong> ${msg}
			</div>
		</c:if>

		<c:if test="${not empty livros}">
			<h4>Quantidade de livros existentes: ${livros.size()}!!!</h4>
			
			<hr>
	
			<table class="table table-striped">
		    <thead>
		      <tr>
		      	<th>Id</th>
		        <th>Título</th>
			  	<th>Autor</th>
		        <th>Valor</th>
		        <th>Usado</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>		    
		    	<c:forEach var="l" items="${livros}">
			      <tr>
			        <td>${l.id}</td>
			        <td>${l.titulo}</td>
			        <td>${l.autor}</td>
			        <td>${l.valorAluguel}</td>
				  	<td>${l.usado}</td>
			        <td><a href="/livro/${l.id}/excluir">Excluir</a></td>
			      </tr>
		    	</c:forEach>
		    </tbody>
		  	</table>
	  	</c:if>
	  	
	  	<c:if test="${empty livros}">
			<h4>Não existem livros cadastrados!</h4>
	  	</c:if>
	</div>
</body>
</html>