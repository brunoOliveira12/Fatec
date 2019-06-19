<?php

require_once '../Lib/Conexao.php';

class Pessoa extends Conexao {

    private $nome;
    private $email;
    private $senha;
    
    function getNome() {
        return $this->nome;
    }
      function getSenha() {
        return $this->senha;
    }

    function getEmail() {
        return $this->email;
    }

    function setNome($nome) {
        $this->nome = $nome;
    }
    
     function setSenha($senha) {
        $this->senha = $senha;
    }

    function setEmail($email) {
        $this->email = $email;
    }

    public function find($id) {
        $sql = "SELECT * FROM pessoa WHERE id= :id";
        $stmt = Conexao::prepare($sql);
        $stmt->bindParam(':id', $id);
        $stmt->execute();
        //fetch:retorna 1 registro
        return $stmt->fetch();
    }

    public function login($email, $senha) {
        $sql = "SELECT * FROM pessoa WHERE email= :email and senha= :senha";
        $stmt = Conexao::prepare($sql);
        $stmt->bindParam(':email', $email);
        $stmt->bindParam(':senha', $senha);
        $stmt->execute();
        //fetch:retorna 1 registro
        return $stmt->fetch();
    }

    public function findAll() {
        $sql = "SELECT * FROM pessoa ORDER BY id";
        $stmt = Conexao::prepare($sql);
        $stmt->execute();
        //fetchAll: retorna todos registros
        return $stmt->fetchAll();
    }

    public function insert() {
        $sql = "INSERT INTO pessoa (nome, email, senha) VALUES (:nome, :email, :senha)";
        $stmt = Conexao::prepare($sql);
        $stmt->bindParam(':nome', $this->nome);
        $stmt->bindParam(':email', $this->email);
        $stmt->bindParam(':senha', $this->senha);
        return $stmt->execute();
    }

    public function update($id) {
        $sql = "UPDATE pessoa SET nome = :nome, email = :email, senha = :senha WHERE id = :id";
        $stmt = Conexao::prepare($sql);
        $stmt->bindParam(':nome', $this->nome);
        $stmt->bindParam(':email', $this->email);
        $stmt->bindParam(':senha', $this->senha);
        $stmt->bindParam(':id', $id);
        return $stmt->execute();
    }

    public function delete($id) {
        $sql = "DELETE FROM pessoa WHERE id = :id";
        $stmt = Conexao::prepare($sql);
        $stmt->bindParam(':id', $id);
        return $stmt->execute();
    }

}
