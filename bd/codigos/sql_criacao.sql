CREATE TABLE alternativa (
  idquestao int(11) NOT NULL,
  idalternativa int(11) NOT NULL,
  alternativa longtext NOT NULL,
  imagem longblob,
  correta tinyint(1) NOT NULL,
  PRIMARY KEY (idalternativa,idquestao),
  KEY idquestao (idquestao),
  FOREIGN KEY (idquestao) REFERENCES questao (idquestao)
);

CREATE TABLE area (
  idarea int(11) NOT NULL AUTO_INCREMENT,
  area varchar(200) NOT NULL,
  PRIMARY KEY (idarea)
);


CREATE TABLE auditoria (
  id_auditoria int(11) NOT NULL AUTO_INCREMENT,
  acao varchar(200) NOT NULL,
  enunciadoAntes longtext,
  enunciadoDepois longtext,
  alternativaAntes varchar(200) DEFAULT NULL,
  alternativaDepois longtext,
  dataAlteracao datetime NOT NULL,
  usuario varchar(200) NOT NULL,
  PRIMARY KEY (id_auditoria)
);

CREATE TABLE disciplina (
  iddisciplina int(11) NOT NULL AUTO_INCREMENT,
  disciplina varchar(90) NOT NULL,
  PRIMARY KEY (iddisciplina)
);

CREATE TABLE folhaAluno (
  idfolha int(11) NOT NULL AUTO_INCREMENT,
  codigofolha longtext NOT NULL,
  emailaluno varchar(200) DEFAULT NULL,
  folharespota longblob NOT NULL,
  idtipo int(11) NOT NULL,
  idprova int(11) NOT NULL,
  idrespostaAluno int(11) NOT NULL,
  PRIMARY KEY (idfolha),
  KEY idtipo (idtipo),
  KEY fk_folhaAluno_1_idx (idrespostaAluno),
  FOREIGN KEY (idrespostaAluno) REFERENCES respostaAluno (idrespostaAluno),
  FOREIGN KEY (idrespostaAluno) REFERENCES prova (idprova),
  FOREIGN KEY (idtipo) REFERENCES tipo (idtipo)
); 

CREATE TABLE origem (
  idorigem int(11) NOT NULL AUTO_INCREMENT,
  origem varchar(300) NOT NULL,
  ano year(4) NOT NULL,
  PRIMARY KEY (idorigem)
);

CREATE TABLE professor (
  cpf bigint(20) NOT NULL,
  nome varchar(120) CHARACTER SET latin1 NOT NULL,
  instituicao longtext CHARACTER SET latin1 NOT NULL,
  email varchar(60) CHARACTER SET latin1 NOT NULL,
  senha char(8) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (cpf)
);

CREATE TABLE prova (
  idprova int(11) NOT NULL AUTO_INCREMENT,
  professor_cpf bigint(20) NOT NULL,
  cabecalho longtext NOT NULL,
  PRIMARY KEY (idprova),
  KEY professor_cpf (professor_cpf),
  FOREIGN KEY (professor_cpf) REFERENCES professor (cpf)
);


CREATE TABLE questao (
  idquestao int(11) NOT NULL AUTO_INCREMENT,
  professor_cpf bigint(11) NOT NULL,
  idarea int(11) NOT NULL,
  iddisciplina int(11) NOT NULL,
  idorigem int(11) NOT NULL,
  enunciado longtext NOT NULL,
  imagem longblob,
  PRIMARY KEY (idquestao),
  KEY idorigem (idorigem),
  KEY iddisciplina (iddisciplina),
  KEY idarea (idarea),
  KEY professor_cpf (professor_cpf),
  FOREIGN KEY (idorigem) REFERENCES origem (idorigem),
  FOREIGN KEY (iddisciplina) REFERENCES disciplina (iddisciplina),
  FOREIGN KEY (idarea) REFERENCES area (idarea),
  FOREIGN KEY (professor_cpf) REFERENCES professor (cpf)
); 


CREATE TABLE respostaAluno (
  idrespostaAluno int(11) NOT NULL,
  posicao int(11) NOT NULL,
  letramarcarda varchar(2) NOT NULL,
  PRIMARY KEY (idrespostaAluno,posicao)
);

CREATE TABLE resultado (
  idresultado int(11) NOT NULL AUTO_INCREMENT,
  idfolha int(11) NOT NULL,
  nota double NOT NULL,
  acerto int(11) NOT NULL,
  erro int(11) NOT NULL,
  PRIMARY KEY (idresultado),
  KEY idfolha (idfolha),
  FOREIGN KEY (idfolha) REFERENCES folhaAluno (idfolha)
);

CREATE TABLE tipo (
  idprova int(11) NOT NULL,
  idtipo int(11) NOT NULL,
  idquestao int(11) NOT NULL,
  posicao int(11) NOT NULL,
  idalternativa int(11) NOT NULL,
  letra varchar(45) NOT NULL,
  PRIMARY KEY (idprova,idtipo,idquestao,posicao,idalternativa,letra),
  KEY idquestao (idquestao),
  KEY idalternativa (idalternativa),
  KEY idtipo (idtipo),
  FOREIGN KEY (idprova) REFERENCES prova (idprova),
  FOREIGN KEY (idquestao) REFERENCES questao (idquestao),
  FOREIGN KEY (idalternativa) REFERENCES alternativa (idalternativa)
);