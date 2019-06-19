<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <title>JSP Page</title>
    </head>
    <body>                
        <div class="col-md-6 col-md-offset-3">        
            <form name="controleacesso" action="${pageContext.request.contextPath}/LogarPessoa" method="POST">
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Email:&nbsp;&nbsp;
                            </span>
                            <input type="email" name="emailpessoa" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <div class="form-group mb-md" style="padding-top:15px;">
                    <div class="col-md-12">
                        <div class="input-group input-group-lg">                            
                            <span class="input-group-addon">
                                Senha:
                            </span>
                            <input type="password" name="senhapessoa" maxlength="100" required autofocus class="form-control" data-parsley-minlength="6" />
                        </div>
                    </div>
                </div>
                <input type="hidden" name="acao" value="logar" />               
                <div class="col-md-12 login-do" style="padding-top:15px;">
                    <input type="submit" name="acessar" value="Acessar" class="btn btn-lg btn-success btn-block">
                </div>
                <%--<p>Email: <input type="email" name="nomepessoa" required /></p>
                <p>Senha: <input type="password" name="senhapessoa" required /></p>
                <input type="hidden" name="acao" value="logar" />
                <p><input type="submit" name="acessar" value="Acessar" /></p>--%>
            </form> 
        </div>
    </body>
</html>
