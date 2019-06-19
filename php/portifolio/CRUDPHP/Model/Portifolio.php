<?php

require_once '../Lib/Conexao.php';

class portifolio extends Conexao {

    private $id_portifolio;
    private $nome_disciplina;
    private $grade_disciplina;
    private $nome_professor;
    private $caminhoarquivo;

    
    function getnome_disciplina() {
        return $this->$nome_disciplina;
    }

    function getid_portifolio() {
        return $this->$id_portifolio;
    }
      function getgrade_disciplina() {
        return $this->$grade_disciplina;
    }

    function getnome_professor() {
        return $this->$nome_professor;
    }

    function getcaminhoarquivo() {
        return $this->$caminhoarquivo;
    }

    function setnome_disciplina($nome_disciplina) {
        $this->nome_disciplina = $nome_disciplina;
    }
    
     function setgrade_disciplina($grade_disciplina) {
        $this->grade_disciplina = $grade_disciplina;
    }

    function setnome_professor($nome_professor) {
        $this->nome_professor = $nome_professor;
    }

    function setcaminhoarquivo($caminhoarquivo) {
        $this->caminhoarquivo = $caminhoarquivo;
    }

    function setid_portifolio($id_portifolio) {
        $this->id_portifolio = $id_portifolio;
    }

    public function find($id_portifolio) {
        $sql = "SELECT * FROM portifolio WHERE id_portifolio= :id_portifolio";
        $stmt = Conexao::prepare($sql);
        $stmt->bindParam(':id_portifolio', $id_portifolio);
        $stmt->execute();
        //fetch:retorna 1 registro
        return $stmt->fetch();
    }

    public function findAll() {
        $sql = "SELECT * FROM portifolio ORDER BY id_portifolio";
        $stmt = Conexao::prepare($sql);
        $stmt->execute();
        //fetchAll: retorna todos registros
        return $stmt->fetchAll();
    }

    public function insert() {
        $sql = "INSERT INTO portifolio (nome_disciplina, grade_disciplina,
        nome_professor,caminhoarquivo) VALUES (:nome_disciplina, :grade_disciplina,
        :nome_professor,:caminhoarquivo)";
        $stmt = Conexao::prepare($sql);
        $stmt->bindParam(':nome_disciplina', $this->nome_disciplina);
        $stmt->bindParam(':grade_disciplina', $this->grade_disciplina);
        $stmt->bindParam(':nome_professor', $this->nome_professor);
        $stmt->bindParam(':caminhoarquivo', $this->caminhoarquivo);
        return $stmt->execute();
    }

    public function update($id_portifolio) {
        $sql = "UPDATE portifolio SET nome_disciplina = :nome_disciplina, grade_disciplina = :grade_disciplina,
        nome_professor = :nome_professor,caminhoarquivo = :caminhoarquivo WHERE id_portifolio = :id_portifolio";
        $stmt = Conexao::prepare($sql);
        $stmt->bindParam(':nome_disciplina', $this->nome_disciplina);
        $stmt->bindParam(':grade_disciplina', $this->grade_disciplina);
        $stmt->bindParam(':nome_professor', $this->nome_professor);
        $stmt->bindParam(':caminhoarquivo', $this->caminhoarquivo);
        $stmt->bindParam(':id_portifolio', $this->id_portifolio);
        return $stmt->execute();
    }

    public function delete($id_portifolio) {
        $sql = "DELETE FROM portifolio WHERE id_portifolio = :id_portifolio";
        $stmt = Conexao::prepare($sql);
        $stmt->bindParam(':id_portifolio', $id_portifolio);
        return $stmt->execute();
    }

}
