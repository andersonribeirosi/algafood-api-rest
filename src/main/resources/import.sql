insert into cozinha (id, nome) values (1, 'Brasileira');
insert into cozinha (id, nome) values (2, 'Chinesa');

insert into Restaurante (nome, taxa_frete, cozinha_id) values('Yoi Restaurante', 5, 2);
insert into Restaurante (nome, taxa_frete, cozinha_id) values('Bar do Cuzcuz', 6, 1);

insert into Forma_Pagamento (descricao) values ('Cartão de credito');
insert into Forma_Pagamento (descricao) values ('Cartão de debito');
insert into Forma_Pagamento (descricao) values ('Dinheiro');

insert into Permissao (nome, descricao) values ('Anderson', 'Admin');
insert into Permissao (nome, descricao) values ('Juliana', 'User');