<?php

function __autoload($class) {
    require_once '../Model/' . $class . '.php';
}

$pes = new Produto();

//Cadastrar usuario
if (isset($_POST['cadastrar'])) {

    //$id_produto = $_POST['id_produto'];
    $nome_produto = $_POST['nome_produto'];
    $valor_produto = $_POST['valor_produto'];
    $nome_vendedor = $_POST['nome_vendedor'];
    
    $arquivo = $_FILES["fileupload"]["tmp_name"];
    if($arquivo != "" && $arquivo != null){
        $ext = strtolower(substr($_FILES['fileupload']['name'],-4)); //Pegando extensão do arquivo
        $new_name = $nome_produto . $ext; //Definindo um novo nome para o arquivo
        $dir = '../img/'; //Diretório para uploads        
        move_uploaded_file($_FILES['fileupload']['tmp_name'], $dir.$new_name); //Fazer upload do arquivo
        $caminho_arquivo = $dir.$new_name;
    }
    //$pes->setid_produto($id_produto);
    $pes->setnome_produto($nome_produto);
    $pes->setvalor_produto($valor_produto);
    $pes->setnome_vendedor($nome_vendedor);
    if($arquivo != "" && $arquivo != null){
        $pes->setcaminho_arquivo($caminho_arquivo);
    }
    if ($pes->insert()) {
        header('Location: ../View/consultaProduto.php');
    }
}
if (isset($_POST['alterar'])) {
    $id_produto = $_POST['id_produto'];
    $nome_produto = $_POST['nome_produto'];
    $valor_produto = $_POST['valor_produto'];
    $nome_vendedor = $_POST['nome_vendedor'];
    
    $arquivo = $_FILES["file_upload"]["tmp_name"];
    if($arquivo != "" && $arquivo != null){
        //$ext = strtolower(substr($_FILES['fileupload']['name'],-4)); //Pegando extensão do arquivo
        $ext = pathinfo($arquivo, PATHINFO_EXTENSION);
        $new_name = $nome_produto . $ext; //Definindo um novo nome para o arquivo
        $dir = '../img/'; //Diretório para uploads        
        move_uploaded_file($_FILES['file_upload']['tmp_name'], $dir.$new_name); //Fazer upload do arquivo
        $caminho_arquivo = Trim($dir.$new_name);
    }

    $pes->setid_produto($id_produto);
    $pes->setnome_produto($nome_produto);
    $pes->setvalor_produto($valor_produto);
    $pes->setnome_vendedor($nome_vendedor);
    if($arquivo != "" && $arquivo != null){	
		$pes->setcaminho_arquivo($caminho_arquivo);
    }

    if ($pes->update($id_produto)) {
        header('Location: ../View/consultaProduto.php');
    }
}

//Deletar Produto
if (isset($_POST['deletar'])) {
    $id_produto = $_POST['id_produto'];

    if ($pes->delete($id_produto)) {
        header('Location: ../View/consultaProduto.php');
    }
}
?>

