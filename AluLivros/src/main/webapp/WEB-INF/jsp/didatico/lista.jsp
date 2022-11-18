<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <form action="/didatico" method="get">
        <button type="submit" class="btn btn-link">Incluir</button>
    </form>

    <hr>

    <c:if test="${not empty msg}">
        <div class="alert alert-success">
            <strong>Sucesso!</strong> ${msg}
        </div>
    </c:if>

    <c:if test="${not empty didaticos}">
        <h4>Quantidade de livros didáticos existentes: ${didaticos.size()}!!!</h4>

        <hr>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Título</th>
                <th>Autor</th>
                <th>Valor do Aluguel</th>
                <th>Usado</th>
                <th>Disciplina</th>
                <th>Série</th>
                <th>Conservado</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="d" items="${didaticos}">
                <tr>
                    <td>${d.id}</td>
                    <td>${d.titulo}</td>
                    <td>${d.autor}</td>
                    <td>${d.valorAluguel}</td>
                    <td>${d.usado}</td>
                    <td>${d.disciplina}</td>
                    <td>${d.serie}</td>
                    <td>${d.conservado}</td>
                    <td><a href="/didatico/${d.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty didaticos}">
        <h4>Não existem livros didáticos cadastrados!</h4>
    </c:if>
</div>
</body>
</html>