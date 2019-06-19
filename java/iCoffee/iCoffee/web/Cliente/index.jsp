<%-- 
    Document   : index
    Created on : 19/06/2019, 13:09:59
    Author     : BrunoOliveira
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../metas.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Página do Cliente</h1>
        <div class="col-md-12" id="painel">
            <div class="panel panel-default" style="min-width: 800px;">
                <div class="panel-heading">
                    <div class="panel-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Nome</th>
                                    <th scope="col">Preço</th>
                                    <th scope="col">Quantidade</th>
                                    <th scope="col">Confirmar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="produto" items="${produtos}">
                                <form name="adicionarcarrinho" action="${pageContext.request.contextPath}/AdicionarCarrinho" method="POST">
                                    <input type="hidden" id="idproduto" name="idproduto" value="${produto.idProduto}"/>
                                    <tr>
                                        <td>${produto.idProduto}</td>
                                        <td>${produto.nomeProduto}</td>
                                        <td>${produto.valorVendaProduto}</td>
                                        <td><input type="number" name="quantidade" required/></td>
                                        <td><input type="submit" name="add" value="Adicionar" required/></td>

                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>
                        <p class="text-center">
                            <a class="btn btn-link" href="${pageContext.request.contextPath}/SalvarCarrinho"><i class="fas fa-plus"></i> Finalizar Venda </a>
                        </p>
                    </div>
                </div>
            </div>
        </div>                                                                                        
        <%@ include file="../rodape.jsp" %>
    </body>
</html>