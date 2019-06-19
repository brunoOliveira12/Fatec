<?php

require_once '../Lib/Conexao.php';

class produto extends Conexao {

    private $id_produto;
    private $nome_produto;
    private $valor_produto;
    private $nome_vendedor;
    private $caminho_arquivo;

    
    function getnome_produto() {
        return $this->$nome_produto;
    }

    function getid_produto() {
        return $this->$id_produto;
    }
      function getvalor_produto() {
        return $this->$valor_produto;
    }

    function getnome_vendedor() {
        return $this->$nome_vendedor;
    }

    function getcaminho_arquivo() {
        return $this->$caminho_arquivo;
    }

    function setnome_produto($nome_produto) {
        $this->nome_produto = $nome_produto;
    }
    
     function setvalor_produto($valor_produto) {
        $this->valor_produto = $valor_produto;
    }

    function setnome_vendedor($nome_vendedor) {
        $this->nome_vendedor = $nome_vendedor;
    }

    function setcaminho_arquivo($caminho_arquivo) {
        $this->caminho_arquivo = $caminho_arquivo;
    }

    function setid_produto($id_produto) {
        $this->id_produto = $id_produto;
    }

    public function find($id_produto) {
        $sql = "SELECT * FROM produto WHERE id_produto= :id_produto";
        $stmt = Conexao::prepare($sql);
        $stmt->bindParam(':id_produto', $id_produto);
        $stmt->execute();
        //fetch:retorna 1 registro
        return $stmt->fetch();
    }

    public function findAll() {
        $sql = "SELECT * FROM produto ORDER BY id_produto";
        $stmt = Conexao::prepare($sql);
        $stmt->execute();
        //fetchAll: retorna todos registros
        return $stmt->fetchAll();
    }

    public function insert() {
        $sql = "INSERT INTO produto (nome_produto, valor_produto,
        nome_vendedor,caminho_arquivo) VALUES (:nome_produto, :valor_produto,
        :nome_vendedor,:caminho_arquivo)";
        $stmt = Conexao::prepare($sql);
        $stmt->bindParam(':nome_produto', $this->nome_produto);
        $stmt->bindParam(':valor_produto', $this->valor_produto);
        $stmt->bindParam(':nome_vendedor', $this->nome_vendedor);
        $stmt->bindParam(':caminho_arquivo', $this->caminho_arquivo);
        return $stmt->execute();
    }

    public function update($id_produto) {
		if($this->caminho_arquivo != "")
		{
			$sql = "UPDATE produto SET nome_produto = :nome_produto, valor_produto = :valor_produto,
			nome_vendedor = :nome_vendedor,caminho_arquivo = :caminho_arquivo WHERE id_produto = :id_produto";
			$stmt = Conexao::prepare($sql);
			$stmt->bindParam(':nome_produto', $this->nome_produto);
			$stmt->bindParam(':valor_produto', $this->valor_produto);
			$stmt->bindParam(':nome_vendedor', $this->nome_vendedor);
			$stmt->bindParam(':caminho_arquivo', $this->caminho_arquivo);
			$stmt->bindParam(':id_produto', $this->id_produto);
		}else{
			$sql = "UPDATE produto SET nome_produto = :nome_produto, valor_produto = :valor_produto,
			nome_vendedor = :nome_vendedor WHERE id_produto = :id_produto";
			$stmt = Conexao::prepare($sql);
			$stmt->bindParam(':nome_produto', $this->nome_produto);
			$stmt->bindParam(':valor_produto', $this->valor_produto);
			$stmt->bindParam(':nome_vendedor', $this->nome_vendedor);	
			$stmt->bindParam(':id_produto', $this->id_produto);
		}
        return $stmt->execute();
    }

    public function delete($id_produto) {
        $sql = "DELETE FROM produto WHERE id_produto = :id_produto";
        $stmt = Conexao::prepare($sql);
        $stmt->bindParam(':id_produto', $id_produto);
        return $stmt->execute();
    }

}
