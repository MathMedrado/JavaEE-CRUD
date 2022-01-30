<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="model.DAO"%>
<%   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mercasol</title>
<link rel="icon" href="imagens/phone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<% String idprod = request.getAttribute("idprod").toString(); %>
	<h1>Seleção de Exclusão de produtos</h1>
	<p>Tem certeza que gostaria de excluir esse produto?</p>
	<a href="excluir?idprod=<%=idprod%>" class="botao-1">Sim</a>
	<a href="index.html" class="botao-1">Não</a>
	
</body>
</html>