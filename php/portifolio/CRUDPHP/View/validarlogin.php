<?php
function __autoload($class){
    require_once '../Model/' . $class . '.php';
}
$email = $_POST['email'];
$senha = md5($_POST['senha']);
$pes = new Pessoa();
$resultado = $pes->login($email,$senha);
session_start();
//VERIFICA SE RETORNOU ALGO
if ($resultado == null) {
     $_SESSION['autenticado'] = 'false';
     Header("location: sempermissao.php");
} else {         
    //INICIALIZA A SESSÃO    
    //GRAVA AS VARIAVEIS NA SESSÃO
    $_SESSION['email'] = $email;
    $_SESSION['senha'] = $senha;       

    //REDIRECIONA PARA A PAGINA QUE VAI EXIBIR
    if ($email == 'bruno@admin.com')
    {
        $_SESSION['autenticado'] = 'true';
        Header("location: cadastro.php");
    }
    else
    {
       $_SESSION['autenticado'] = 'false';
        Header("location: consulta.php");
    }
};
?>
	