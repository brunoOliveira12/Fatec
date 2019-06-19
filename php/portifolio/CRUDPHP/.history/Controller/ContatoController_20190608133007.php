<?php

function __autoload($class) {
    require_once '../Model/' . $class . '.php';
}

$pes = new Pessoa();

//Cadastrar usuario
if (isset($_POST['cadastrar'])) {

    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $senha = md5($_POST['senha']);

    $pes->setNome($nome);
    $pes->setEmail($email);
    $pes->setSenha($senha);

    if ($pes->insert()) {
        header('Location: ../View/consulta.php');
    }
}
if (isset($_POST['alterar'])) {
    $id = $_POST['id'];
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $senha = md5($_POST['senha']);

    $pes->setNome($nome);
    $pes->setEmail($email);
    $pes->setSenha($senha);

    if ($pes->update($id)) {
        header('Location: ../View/consulta.php');
    }
}

//Deletar usuario
if (isset($_POST['deletar'])) {
    $id = $_POST['id'];

    if ($pes->delete($id)) {
        header('Location: ../View/consulta.php');
    }
}
?>

