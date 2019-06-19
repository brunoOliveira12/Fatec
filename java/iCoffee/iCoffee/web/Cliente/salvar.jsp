<%-- 
    Document   : salvar
    Created on : 19/06/2019, 13:12:45
    Author     : BrunoOliveira
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../metas.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-md-6 col-md-offset-3">
            <h1 align="center">Cadastro de Cliente</h1>
            <form name="salvarcliente" action="${pageContext.request.contextPath}/SalvarCliente" method="POST" enctype="multipart/form-data">
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                ID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="number" name="idcliente" value="${cliente.idCliente}" min="0" readonly autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                NOME:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="text" name="nomepessoa" value="${cliente.nomeCliente}" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="text" name="emailpessoa" value="${cliente.emailCliente}" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Senha:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="text" name="senhapessoa" value="${cliente.senhaCliente}" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Data Nascimento:
                            </span>
                            <input type="text" name="datanascimentocliente" value="${cliente.datanascimentoCliente}" maxlength="100" required autofocus class="form-control" data-parsley-minlength="20" />
                        </div>
                    </div>
                </div>

                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Foto Cliente:
                            </span>
                            <input type="file" name="fotocliente" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
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
