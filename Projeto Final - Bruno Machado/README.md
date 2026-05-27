# PROJETO FINAL DA DISCIPLINA
# Edis Pisos

## Base de dados

Para que o projeto funcione corretamente, siga os passos abaixo para configurar o banco de dados:

1. **Criar o Banco de Dados -**
   Crie uma base de dados com o nome de 'pisos'

2. **Criação das tabelas -**
    Para criar as tabelas da base de dados execute os seguintes comandos:
    ```sql
    create table usuario(
    
        id serial primary key,
        nome varchar(50),
        email varchar(100),
        senha varchar(16)
    
    );
    
    create table avaliacao(
    
        id serial primary key,
        texto varchar(200),
        usuario_id int,
        CONSTRAINT fk_avalicao_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
    
    );
    
    create table produto(
    
        id serial primary key,
        marca varchar(50),
        modelo varchar(50)
    
    );
    
    create table favorito(
    
        id serial primary key,
        usuario_id int,
        produto_id int,
        CONSTRAINT fk_favorito_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
        CONSTRAINT fk_favorito_produto FOREIGN KEY (produto_id) REFERENCES produto(id)
        
    );
   
3. **Adicionando catálogo:**
   Para adicionar o catálogo de produtos execute o seguinte comando:
    ```sql
   insert into produto(marca, modelo)
	  values 
		 ('Eucafloor', 'Click'),
		 ('Durafloor', 'Urban'),
		 ('Durafloor', 'New Way'),
		 ('Durafloor', 'Spot'),
	 	 ('Quick-Step', 'Smart'),
	 	 ('Quick-Step', 'Vision'),
	 	 ('Tarket', 'Injoy'),
	 	 ('Tarket', 'Ambienta'),
	 	 ('Belgotex', 'Jazz'),
	 	 ('Belgotex', 'Castilla');