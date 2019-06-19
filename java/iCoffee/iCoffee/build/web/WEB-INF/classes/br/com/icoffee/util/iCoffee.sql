CREATE TABLE categoria(
	id_categoria serial NOT NULL PRIMARY KEY,
	nome_categoria varchar(300) NOT NULL UNIQUE,
	descricao_categoria varchar(1000));

CREATE TABLE produto(
	id_produto serial NOT NULL,
	nome_produto varchar(300) NOT NULL UNIQUE,
	valor_venda_produto numeric (10,2) NOT NULL,
	valor_compra_produto numeric (10,2) NOT NULL,
	quantidade_estoque_produto integer NOT NULL,
	id_categoria integer NOT NULL,
	CONSTRAINT pk_produto PRIMARY KEY (id_produto),
	CONSTRAINT fk_produto_categoria FOREIGN KEY (id_categoria)
	REFERENCES categoria(id_categoria));

