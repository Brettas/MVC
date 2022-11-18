<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>AT</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container">
	  <h2>Cadastro de Solicitantes</h2>
	  <form action="/solicitante/incluir" method="post">

	    <div class="form-group">
	      <label>Nome:</label>
	      <input value="Carolina Alves" type="text" class="form-control" placeholder="Entre com o seu nome" name="nome">
	    </div>

	    <div class="form-group">
	      <label>E-mail:</label>
	      <input value="carolasilva99@gmail.com" type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email">
	    </div>

		  <div class="form-group">
			  <label>Telefone:</label>
			  <input value="(31)99361-6504" type="telefone" class="form-control" placeholder="Entre com o seu telefone" name="telefone">
		  </div>
		
	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>

</body>
</html>