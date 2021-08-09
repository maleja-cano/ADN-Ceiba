create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table revisiones(
 idRevision int(10) not null auto_increment,
 matriculaInmobiliaria varchar(15) not null,
 direccion varchar(30) not null,
 fechaVisita date not null,
 calificacion varchar(5) not null,
 fechaProximaRevision date,
 valorRevision int(10),
 primary key(idRevision)
);