<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="model.DAO"%>
<%@ page import="java.util.ArrayList"%>

<%
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
%>
<!DOCTYPE html>
<html lang=pt-br>
<head>
<meta charset="UTF-8">
<title>Mercasol</title>
<link rel="icon" href="imagens/market.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Lista de produtos cadastrados</h1>
	

	<br>
<table >
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>quantidade</th>
				<th>tipo</th>
				<th>Editar</th>
				<th>Excluir<th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdProd()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getQuantidade()%></td>
				<td><%=lista.get(i).getTipo()%></td>
				<td><a href="select?idprod=<%=lista.get(i).getIdProd() %>" class="botao-1">Editar</a></td>
				<td><a href="delete?idprod=<%=lista.get(i).getIdProd() %>" class="botao-1">Excluir</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<br>
	<p class="opcao"> Adicionando um novo produto</p>
	<br>
	
	<a href="contForm.html" class="botao-1">Novo produto</a>
	<br>
</body>
</html>