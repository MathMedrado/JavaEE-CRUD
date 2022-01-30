create database db_prod;
use db_prod;
create table produtos(
	idprod int primary key auto_increment,
    nome varchar(50) not null,
    quantidade varchar(15) not  null,
    tipo varchar(50)
);
/* CRUD CREATE */
insert into produtos (nome,quantidade,tipo) values ('Arroz Cristal','100','alimento');

/*CRUD READ */
select * from produtos order by nome;
select * from produtos where idprod=1;


/*CRUD update*/
update produtos set nome="Arroz Cristal",quantidade="50",tipo="alimento" where idprod="1";
/*CRUD DELETE*/
delete from produtos where produtos.idprod=1;

