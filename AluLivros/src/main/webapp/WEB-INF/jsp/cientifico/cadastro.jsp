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
    <h2>Cadastro de Livros Científicos</h2>
    <form action="/cientifico/incluir" method="post">

        <div class="form-group">
            <label>Título:</label>
            <input type="text" value="Livro Científico" class="form-control"
                   placeholder="Entre com o título" name="titulo">
        </div>

        <div class="form-group">
            <label>Autor:</label>
            <input type="text" value="Marcos O Cientista" class="form-control" placeholder="Entre com o autor"
                   name="autor">
        </div>

        <div class="form-group">
            <label>Valor:</label>
            <input type="text" value="20" class="form-control" placeholder="Entre com o valor" name="valorAluguel">
        </div>

        <div class="form-group">
            <label>Usado:</label>
            <label class="checkbox-inline"><input type="checkbox" name="usado" checked>Sim</label>
        </div>

        <div class="form-group">
            <label>Ramo:</label>
            <input type="text" value="Biologia" class="form-control" placeholder="Entre com o ramo"
                   name="ramo">
        </div>

        <div class="form-group">
            <label>Volumes:</label>
            <input type="number" value="4" class="form-control" placeholder="Entre com a quantidade de volumes"
                   name="volumes">
        </div>

        <button type="submit" class="btn btn-default">Cadastrar</button>
    </form>
</div>

</body>
</html>