select f.idfolha, f.emailaluno, r.posicao, r.letramarcarda, a.correta from folhaAluno f 
inner join respostaAluno r on f.idrespostaAluno = r.idrespostaAluno 
inner join tipo t on f.idtipo = t.idtipo and f.idprova = t.idprova and r.posicao = t.posicao and r.letramarcarda = t.letra
inner join alternativa a on t.idalternativa = a.idalternativa and t.idquestao = a.idquestao;


