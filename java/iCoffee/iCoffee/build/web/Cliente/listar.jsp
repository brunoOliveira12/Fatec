<%-- 
    Document   : listar
    Created on : 19/06/2019, 13:11:44
    Author     : BrunoOliveira
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        < <%@ include file="../metas.jsp" %>
        <title>Clientes</title>
    </head>
    <body>

        <div class="container">

            <div class="row">

                <div class="col-12 col-lg-10 d-block mx-auto">

                    <div class="mt-5">

                        ${mensagem}

                        <h5 class="text-center py-4">
                            <strong>Clientes Cadastrados</strong>
                        </h5>

                        <div class="table-responsive">
                            <table class="table border">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Nome</th>
                                        <th scope="col">E-mail</th>
                                        <th scope="col">Nascimento</th>
                                        <th colspan="2" class="text-center">Editar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cliente" items="${clientes}">
                                    <tr>
                                        <td>${cliente.idCliente}</td>
                                        <td>${cliente.nomePessoa}</td>
                                        <td>${cliente.emailPessoa}</td>
                                        <td><fmt:formatDate type="date" value="${cliente.dataNascimentoCliente}" pattern="dd/MM/yyyy"/></td>
                                    <td class="text-center">
                                        <a class="btn-link mx-3" href="${pageContext.request.contextPath}/CarregarCliente?idCliente=${cliente.idCliente}"><i class="fas fa-pen"></i></a>
                                        <a class="btn-link mx-3" href="${pageContext.request.contextPath}/ExcluirCliente?idCliente=${cliente.idCliente}"><i class="fas fa-trash-alt"></i></a>
                                    </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <p class="text-center">
                            <a class="btn btn-link" href="${pageContext.request.contextPath}/cliente/salvar.jsp"><i class="fas fa-plus"></i> Adicionar Cliente </a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="../rodape.jsp" %>
    </body>
</html>
