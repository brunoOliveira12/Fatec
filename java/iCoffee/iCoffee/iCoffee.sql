select * from pessoa

CREATE TABLE pessoa(
	id_pessoa serial NOT NULL PRIMARY KEY,
	nome_pessoa varchar(300) NOT NULL UNIQUE,
	email_pessoa varchar(1000),
	senha_pessoa varchar(100),
	tipo_pessoa char(1));

CREATE TABLE funcionario(
	id_funcionario serial NOT NULL,
	salario_funcionario numeric (10,2) NOT NULL,
	curriculo_funcionario varchar(1000),
	id_pessoa integer NOT NULL,
	CONSTRAINT pk_id_funcionario PRIMARY KEY (id_funcionario),
	CONSTRAINT fk_funcionario_pessoa FOREIGN KEY (id_pessoa)
	REFERENCES pessoa(id_pessoa));

CREATE TABLE cliente(
	id_cliente serial NOT NULL,
	data_nascimento DATE NOT NULL,
	foto_cliente bytea,
	id_pessoa integer NOT NULL,
	CONSTRAINT pk_id_cliente PRIMARY KEY (id_cliente),
	CONSTRAINT fk_cliente_pessoa FOREIGN KEY (id_pessoa)
	REFERENCES pessoa(id_pessoa));

select * from pessoa p, funcionario f where p.id_pessoa = f.id_pessoa order by p.nome_pessoa;

select p.*, c.nome_categoria from produto p, categoria c where p.id_categoria = c.id_categoria order by p.nome_produto;