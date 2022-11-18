<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <title>Java Web - AT</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">
    <h2>Cadastro de Livros de Literatura</h2>
    <form action="/literatura/incluir" method="post">

        <div class="form-group">
            <label>Título:</label>
            <input type="text" value="Memórias Póstumas de Brás Cubas" class="form-control"
                   placeholder="Entre com o título" name="titulo">
        </div>

        <div class="form-group">
            <label>Autor:</label>
            <input type="text" value="Machado de Assis" class="form-control" placeholder="Entre com o autor"
                   name="autor">
        </div>

        <div class="form-group">
            <label>Valor:</label>
            <input type="text" value="10" class="form-control" placeholder="Entre com o valor" name="valorAluguel">
        </div>

        <div class="form-group">
            <label>Usado:</label>
            <label class="checkbox-inline"><input type="checkbox" name="usado" checked>Sim</label>
        </div>

        <div class="form-group">
            <label>Gênero:</label>
            <input type="text" value="Romance" class="form-control" placeholder="Entre com o gênero"
                   name="genero">
        </div>

        <div class="form-group">
            <label>Idioma:</label>
            <input type="text" value="Português" class="form-control" placeholder="Entre com o idioma" name="idioma">
        </div>

        <button type="submit" class="btn btn-default">Cadastrar</button>
    </form>
</div>

</body>
</html>