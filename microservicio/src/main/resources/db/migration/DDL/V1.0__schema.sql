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