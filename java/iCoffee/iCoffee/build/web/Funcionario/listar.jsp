<%-- 
    Document   : listar
    Created on : 19/06/2019, 13:15:05
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
        <h1 align="center">Listar Funcionários</h1>
        <div class="col-md-12" id="painel">
            <div class="panel panel-default" style="min-width: 800px;">
                <div class="panel-heading">
                    <div class="panel-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Email</th>
                                    <th>Senha</th>
                                    <th>Tipo</th>
                                    <th>Salario</th>
                                        <%--<th>Curriculo</th>--%>
                                    <th colspan="2">Editar</th>
                                        <c:forEach var="funcionario" items="${funcionarios}">
                                    <tr>
                                        <td>${funcionario.idPessoa}</td>
                                        <td>${funcionario.nomePessoa}</td>
                                        <td>${funcionario.emailPessoa}</td>
                                        <td>${funcionario.senhaPessoa}</td>
                                        <td>${funcionario.tipoPessoa}</td>
                                        <td>${funcionario.salarioFuncionario}</td>                                        

                                        <!--<td><a href="${pageContext.request.contextPath}/ExcluirFuncionario?idfuncionario=${funcionario.idPessoa}">Excluir</td>
                                        <td><a href="${pageContext.request.contextPath}/CarregarFuncionario?idfuncionario=${funcionario.idPessoa}">Alterar</td>-->
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

