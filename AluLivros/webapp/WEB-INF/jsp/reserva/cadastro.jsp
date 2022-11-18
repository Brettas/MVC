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

	<c:set var="botao" value=""/>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	  <h2>Cadastro de Reservas</h2>
	  <form action="/reserva/incluir" method="post">

		<div class="form-group">
		  <c:if test="${not empty solicitantes}">
		  	  <label>Solicitante:</label>
			  <select class="form-control" name="solicitante.id">
				<c:forEach var="s" items="${solicitantes}">
					<option value="${s.id}">${s.nome}</option>
				</c:forEach>
			  </select>
		  </c:if>
		  <c:if test="${empty solicitantes}">
		  	  <c:set var="botao" value="disabled"/>
		  	  <label>Solicitante: não existem registros cadastrados!!!</label>
		  </c:if>
		</div>	

	    <div class="form-group">
	      <label>Observação:</label>
	      <input value="Primeira reserva" type="text" class="form-control" placeholder="Entre com a observacao" name="observacao">
	    </div>	    
		
		<div class="form-group">			
		<c:if test="${not empty livros}">
			<label>Livros:</label>
			<c:forEach var="livro" items="${livros}">
			  	<div class="form-check">
					<label class="form-check-label">
					<input name="livrosId" type="checkbox" checked="checked" value="${livro.id}"> ${livro.titulo}
					</label>
				</div>
			</c:forEach>
		</c:if>
		<c:if test="${empty livros}">
		    <c:set var="botao" value="disabled"/>
			<label>Livros: não existem registros cadastrados!!!</label>
		</c:if>
		</div>	    

	    <button type="submit" ${botao} class="btn btn-default">Cadastrar</button>
	  </form>
	</div>

</body>
</html>