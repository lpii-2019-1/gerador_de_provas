


CREATE TABLE professor (
  cpf BIGINT NOT NULL,
  nome VARCHAR(120) NOT NULL,
  email VARCHAR(60) NOT NULL,
  senha CHAR(8) NOT NULL,
  PRIMARY KEY (cpf)
);


CREATE TABLE origem (
  idorigem INT NOT NULL AUTO_INCREMENT,
  origem VARCHAR(300) NOT NULL,
  ano YEAR NOT NULL,
  PRIMARY KEY (idorigem)
);


CREATE TABLE disciplina (
  iddisciplina INT NOT NULL AUTO_INCREMENT,
  disciplina VARCHAR(90) NOT NULL,
  PRIMARY KEY (iddisciplina)
);

CREATE TABLE area (
  idarea INT NOT NULL AUTO_INCREMENT,
  area VARCHAR(200) NOT NULL,
  PRIMARY KEY (idarea)
);

CREATE TABLE questao (
  idquestao INT NOT NULL AUTO_INCREMENT,
  professor_cpf BIGINT NOT NULL,
  idarea INT NOT NULL,
  iddisciplina INT NOT NULL,
  idorigem INT NOT NULL,
  enunciado LONGTEXT NOT NULL,
  imagem longblob NULL,
  PRIMARY KEY (idquestao),
  FOREIGN KEY (idorigem) REFERENCES origem (idorigem),
  FOREIGN KEY (iddisciplina) REFERENCES disciplina (iddisciplina),
  FOREIGN KEY (idarea) REFERENCES area (idarea),
  FOREIGN KEY (professor_cpf) REFERENCES professor (cpf)
);

CREATE TABLE alternativa (
  idquestao INT NOT NULL,
  idalternativa INT NOT NULL,
  alternativa LONGTEXT NOT NULL,
  correta boolean NOT NULL,
  PRIMARY KEY (idalternativa, idquestao),
  FOREIGN KEY (idquestao) REFERENCES questao (idquestao)
);

CREATE TABLE prova (
  idprova INT NOT NULL AUTO_INCREMENT,
  professor_cpf BIGINT NOT NULL,
  cabecalho LONGTEXT NOT NULL,
  idquestao INT NOT NULL,
  PRIMARY KEY (idprova),
  FOREIGN KEY (professor_cpf) REFERENCES professor (cpf),
  FOREIGN KEY (idquestao) REFERENCES questao (idquestao)
);


CREATE TABLE tipo (
  idprova INT NOT NULL,
  idtipo INT NOT NULL,
  idquestao INT NOT NULL,
  posicao INT NOT NULL,
  idalternativa INT NOT NULL,
  letra VARCHAR(45) NOT NULL,
  PRIMARY KEY (idprova, idtipo, idquestao, posicao, idalternativa),
  FOREIGN KEY (idprova) REFERENCES prova (idprova),
  FOREIGN KEY (idquestao) REFERENCES questao (idquestao),
  FOREIGN KEY (idalternativa) REFERENCES alternativa (idalternativa)
);



create table folhaAluno(
	idfolha int not null auto_increment,
    codigofolha longtext not null,
    emailaluno varchar(200),
    folharespota longblob,
    idtipo int not null,
    posicao int not null,
    letramarcarda varchar(45) not null,
    primary key(idfolha),
    FOREIGN KEY (idtipo) REFERENCES tipo (idtipo)
);


create table resultado(
	idresultado int not null auto_increment,
    idfolha int not null,
    nota double not null,
    acerto int not null,
    erro int not null,
    primary key (idresultado),
    foreign key(idfolha) references folhaAluno(idfolha)
);