select cabecalho, enunciado, alternativa, correta from tipo t inner join
prova p on t.idprova = p.idprova inner join
questao q on t.idquestao = q.idquestao inner join
alternativa a on q.idquestao = a.idquestao; 


/* Selecionar as alternativas*/
select * from alternativa a
inner join questao q 
on a.idquestao = q.idquestao
where q.idquestao=1;


/* */
select * from tipo t 
inner join prova p
on t.idprova = p.idprova
inner join alternativa a
on t.idalternativa = a.idalternativa
where a.idquestao = 1;

