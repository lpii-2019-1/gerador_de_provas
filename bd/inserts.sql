insert into categoria (categoria) values ('ENEM 2018');

insert into area (area) values ('Ciencias da Natureza e Suas Tecnologias');

insert into disciplina (disciplina) values ('Fisica');


insert into alternativa_correta(alternativa_correta) values ('375 hertz');

insert into alternativas (alternativa1, alternativa2, alternativa3, alternativa4, idalternativaCorreta) values ('8,6 hertz', '13,5 hertz', '1350 hertz', '4860 hertz', 1);


insert into professor(cpf,nome,email,senha) values (00000000001, 'Maria Tereza', 'mariatereza@gmail.com', '12345678');


insert into questao(enunciado, idcategoria, iddisciplina, idarea, professor_cpf,idalternativas,idAlternativaCorreta) 
values ('O sonorizador é um dispositivo físico implantado sobre a superfície de uma rodovia de modo que provoque uma trepidação e ruído quando da passagem de um veículo sobre ele, alertando para uma situação atípica à frente, como obras, pedágios ou travessia de pedestres. Ao passar sobre os sonorizadores, a suspensão do veículo sofre vibrações que produzem ondas sonoras, resultando em um barulho peculiar. Considere um veículo que passe com velocidade constante igual a 108km/h sobre um sonorizador cujas faixas são separadas por uma distância de 8cm. 
\nDisponível em: www.denatran.gov.br Acesso em: 2 set. 2015 (adaptado). \nA frequência da vibração do automóvel percebida pelo condutor durante a passagem nesse sonorizador é mais próxima de', 1,1,1,00000000001,1,1);

