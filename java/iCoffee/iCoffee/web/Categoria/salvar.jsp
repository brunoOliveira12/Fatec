<%-- 
    Document   : salvar
    Created on : 19/06/2019, 13:08:30
    Author     : BrunoOliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../metas.jsp" %>
    </head>
    <body>
        <%@ include file="../menu.jsp" %>
        <h1 align="center">Cadastro de Categorias</h1>
        <div class="col-md-6 col-md-offset-3">            
            <form name="cadastro" action="${pageContext.request.contextPath}/SalvarCategoria" method="POST">
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                ID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="number" name="idcategoria" value="${categoria.idCategoria}" min="0" readonly  class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                NOME:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="text" name="nomecategoria" value="${categoria.nomeCategoria}" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                DESCRIÇÂO:
                            </span>
                            <input type="text" name="descricaocategoria" value="${categoria.descricaoCategoria}" maxlength="300" resdonly required autofocus class="form-control" data-parsley-minlength="6" />
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
