<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="model.DAO"%>

<%-- JavaBeans contato = JavaBeans request.getAttribute("info"); --%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Mercasol</title>
<link rel="icon" href="imagens/market.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editando um Produto existente</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td><input type="type=text" name="idprod" value="<% out.print(request.getAttribute("idprod")); %>" class="caixa-1" readonly></td>
			</tr>
			<tr>
				<td><input type="type=text" name="nome"  value="<% out.print(request.getAttribute("nome")); %>"   class="caixa-1"></td>
			</tr>
			<tr>
				<td><input type="type=text" name="quantidade"  value="<% out.print(request.getAttribute("quantidade")); %>"  class="caixa-1"></td>
			</tr>
			<tr>
				<td><input type="type=text" name="tipo"  value="<% out.print(request.getAttribute("tipo")); %>" class="caixa-1"></td>
			</tr>
		</table>
		<input type="button" value="salvar" class="botao-1"   onclick="validar()" >
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>