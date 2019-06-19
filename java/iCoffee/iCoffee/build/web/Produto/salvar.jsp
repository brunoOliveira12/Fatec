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
        <div class="col-md-6 col-md-offset-3">
            <h1 align="center">Cadastro de Produtos</h1>
            <form name="cadastro" action="${pageContext.request.contextPath}/SalvarProduto" method="POST" enctype="multipart/form-data">
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                ID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="number" name="idproduto" value="${produto.idProduto}" min="0" resdonly autofocus disabled class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                NOME:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="text" name="nomeproduto" value="${produto.nomeProduto}" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Valor Compra:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="text" name="valorcompraproduto" value="${produto.valorCompraProduto}" maxlength="300" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Valor Venda:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="text" name="valorvendaproduto" value="${produto.valorVendaProduto}" maxlength="300" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Quantidade Estoque:
                            </span>
                            <input type="text" name="quantidadeestoqueproduto" value="${produto.quantidadeEstoqueProduto}" maxlength="300" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Foto:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="file" name="fotoproduto" autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">
                            <span class="input-group-addon">
                                Categoria:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <select name="idcategoria" autofocus class="form-control" data-parsley-minlength="6" />
                            <c:forEach var="categoria" items="${categorias}">
                                <option value="${categoria.idCategoria}" ${produto.categoria.idCategoria==categoria.idCategoria ? 'selected' : ''}>
                                    ${categoria.nomeCategoria}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>              
                <div class="col-md-12 login-do" style="padding-top:15px;">
                    <input type="submit" name="salvar" value="Salvar" class="btn btn-lg btn-success btn-block">
                </div>                                      
            </form>
        </div>
        <%@ include file="../rodape.jsp" %>
    </body>
</html>
