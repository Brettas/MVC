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
    <h2>Editar</h2>
    <form action="literatura/lista" >
    	<div class="form-group">
            <input type="hidden" value="${lit.id}" readonly >
        </div>

        <div class="form-group">
            <label>Título:</label>
            <input type="text" value="${lit.titulo}"  class="form-control"
                   placeholder="Entre com o título" name="titulo">
        </div>

        <div class="form-group">
            <label>Autor:</label>
            <input type="text" value="${lit.autor}" class="form-control" placeholder="Entre com o autor"
                   name="autor">
        </div>

        <div class="form-group">
            <label>Valor:</label>
            <input type="text" value="${lit.valorAluguel}" class="form-control" placeholder="Entre com o valor" name="valorAluguel">
        </div>

        <div class="form-group">
            <label>Usado:</label>
            <label class="checkbox-inline"><input value="${lit.usado}" type="checkbox" name="usado" checked>Sim</label>
        </div>

        <div class="form-group">
            <label>Gênero:</label>
            <input type="text" value="${lit.genero}" class="form-control" placeholder="Entre com o gênero"
                   name="genero">
        </div>

        <div class="form-group">
            <label>Idioma:</label>
            <input type="text" value="${lit.idioma}" class="form-control" placeholder="Entre com o idioma" name="idioma">
        </div>

        <button type="submit" class="btn btn-default">Salvar</button>
    </form>
</div>

</body>
</html>