<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../metas.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="../menu.jsp" %>
        <h1 align="center">Listar Produtos</h1>        
        <div class="col-md-12" id="painel">
            <div class="panel panel-default" style="min-width: 800px;">
                <div class="panel-heading">
                    <div class="panel-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Valor Compra</th>
                                    <th>Valor Venda</th>
                                    <th>Quantidade Estoque</th>
                                    <th>Categoria</th>
                                    <th>Imagem</th>
                                    <th colspan="2">Editar</th>
                                </tr>

                                <c:forEach var="produto" items="${produtos}">
                                    <tr>
                                        <td>${produto.idProduto}</td>
                                        <td>${produto.nomeProduto}</td>
                                        <td>${produto.valorCompraProduto}</td>
                                        <td>${produto.valorCompraProduto}</td>
                                        <td>${produto.quantidadeEstoqueProduto}</td>
                                        <td>${produto.categoria.nomeCategoria}</td>
                                        <td><img width="50" height="50" src="${pageContext.request.contextPath}/MostrarImagem?idproduto=${produto.idProduto}"/></td>
                                        <td><a href="${pageContext.request.contextPath}/ExcluirProduto?idproduto=${produto.idProduto}">Excluir</td>
                                        <td><a href="${pageContext.request.contextPath}/CarregarProduto?idproduto=${produto.idProduto}">Alterar</td>

                                    </tr>
                                </c:forEach>
                                </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="../rodape.jsp" %>
    </body>
</html>
