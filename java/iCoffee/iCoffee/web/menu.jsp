 
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="../index.jsp">Index</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">                                       
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Op��es <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">Cadastros</li>                             
                        <li><a href="${pageContext.request.contextPath}/Categoria/salvar.jsp">Cadastrar Categoria</a></li>
                        <li><a href="${pageContext.request.contextPath}/Funcionario/salvar.jsp">Cadastrar Funcion�rio</a></li>
                        <li><a href="${pageContext.request.contextPath}/DadosProduto">Cadastrar Produto</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Listas</li>                               
                        <li><a href="${pageContext.request.contextPath}/ListarCategoria">Listar Categoria</a></li>
                        <li><a href="${pageContext.request.contextPath}/ListarFuncionario">Listar Funcionario</a></li>
                        <li><a href="${pageContext.request.contextPath}/ListarProduto">Listar Produto</a></li>  
                    </ul>
                </li> <!-- fim dropdown -->
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>