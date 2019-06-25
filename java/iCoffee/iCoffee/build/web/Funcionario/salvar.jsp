<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../metas.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="../menu.jsp" %>
        <div class="col-md-6 col-md-offset-3">
            <h1 align="center">Cadastro de Funcionário</h1>
            <form name="salvarfuncionario" action="${pageContext.request.contextPath}/SalvarFuncionario" method="POST" enctype="multipart/form-data">
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                ID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="number" name="idfuncionario" value="${funcionario.idFuncionario}" min="0" resdonly autofocus disabled class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                NOME:&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="text" name="nomepessoa" value="${funcionario.nomeFuncionario}" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="text" name="emailpessoa" value="${funcionario.emailFuncionario}" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Senha:&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="password" name="senhapessoa" value="${funcionario.senhaFuncionario}" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Salário:&nbsp;&nbsp;&nbsp;
                            </span>
                            <input type="number" name="salariopessoa" value="${funcionario.salarioFuncionario}" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>

                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Currículo:
                            </span>
                            <input type="file" name="curriculofuncionario" value="${funcionario.curriculoFuncionario}" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
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
