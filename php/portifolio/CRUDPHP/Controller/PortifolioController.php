<?php

function __autoload($class) {
    require_once '../Model/' . $class . '.php';
}

$pes = new Portifolio();

//Cadastrar usuario
if (isset($_POST['cadastrar'])) {

    //$id_portifolio = $_POST['id_portifolio'];
    $nome_disciplina = $_POST['nome_disciplina'];
    $grade_disciplina = $_POST['grade_disciplina'];
    $nome_professor = $_POST['nome_professor'];
    
    $arquivo = $_FILES["fileupload"]["tmp_name"];
    if($arquivo != ""){
        $ext = strtolower(substr($_FILES['fileupload']['name'],-4)); //Pegando extensão do arquivo
        $new_name = $nome_disciplina . $ext; //Definindo um novo nome para o arquivo
        $dir = '../img/'; //Diretório para uploads        
        move_uploaded_file($_FILES['fileupload']['tmp_name'], $dir.$new_name); //Fazer upload do arquivo
        $caminhoarquivo = $dir.$new_name;
    }
    //$pes->setid_portifolio($id_portifolio);
    $pes->setnome_disciplina($nome_disciplina);
    $pes->setgrade_disciplina($grade_disciplina);
    $pes->setnome_professor($nome_professor);
    if($arquivo != ""){
        $pes->setcaminhoarquivo($caminhoarquivo);
    }
    if ($pes->insert()) {
        header('Location: ../View/consultaPortifolio.php');
    }
}
if (isset($_POST['alterar'])) {
    $id_portifolio = $_POST['id_portifolio'];
    $nome_disciplina = $_POST['nome_disciplina'];
    $grade_disciplina = $_POST['grade_disciplina'];
    $nome_professor = $_POST['nome_professor'];
    
    $arquivo = $_FILES["file_upload"]["tmp_name"];
    if($arquivo != ""){
        //$ext = strtolower(substr($_FILES['fileupload']['name'],-4)); //Pegando extensão do arquivo
        $ext = pathinfo($arquivo, PATHINFO_EXTENSION);
        $new_name = $nome_disciplina . $ext; //Definindo um novo nome para o arquivo
        $dir = '../img/'; //Diretório para uploads        
        move_uploaded_file($_FILES['file_upload']['tmp_name'], $dir.$new_name); //Fazer upload do arquivo
        $caminhoarquivo = Trim($dir.$new_name);
    }

    $pes->setid_portifolio($id_portifolio);
    $pes->setnome_disciplina($nome_disciplina);
    $pes->setgrade_disciplina($grade_disciplina);
    $pes->setnome_professor($nome_professor);
    if($arquivo != ""){
        $pes->setcaminhoarquivo($caminhoarquivo);
    }

    if ($pes->update($id_portifolio)) {
        header('Location: ../View/consultaPortifolio.php');
    }
}

//Deletar portifolio
if (isset($_POST['deletar'])) {
    $id_portifolio = $_POST['id_portifolio'];

    if ($pes->delete($id_portifolio)) {
        header('Location: ../View/consultaPortifolio.php');
    }
}
?>

