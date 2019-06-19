<%-- 
    Document   : listar
    Created on : 19/06/2019, 13:07:49
    Author     : BrunoOliveira
--%>

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
        <h1 align="center">Lista de Categoria</h1>        
        <div class="col-md-12" id="painel">
            <div class="panel panel-default" style="min-width: 800px;">
                <div class="panel-heading">
                    <div class="panel-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Descrição</th>
                                    <th colspan="2">Editar</th>
                                </tr>
                            </thead>      
                            <tbody>
                                <c:forEach var="categoria" items="${categorias}">
                                    <tr>
                                        <td>${categoria.idCategoria}</td>
                                        <td>${categoria.nomeCategoria}</td>
                                        <td>${categoria.descricaoCategoria}</td>                    
                                        <td><a href="${pageContext.request.contextPath}/ExcluirCategoria?idcategoria=${categoria.idCategoria}">Excluir</a></td>
                                        <td><a href="${pageContext.request.contextPath}/CarregarCategoria?idcategoria=${categoria.idCategoria}">Alterar</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>                  
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="../rodape.jsp" %>
    </body>
</html>
