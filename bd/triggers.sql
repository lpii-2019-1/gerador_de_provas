create trigger questaoBeforeUpdate 
before update on questao for each row 
insert into auditoria
set acao = 'update', 
valorAntes = OLD.enunciado,
valorDepois = NEW.enunciado,
campoAlterado = 'enunciado',
dataAlteracao = NOW(),
usuario = session_user();


create trigger questaoBeforeDelete 
before delete on questao for each row 
insert into auditoria
set acao = 'delete', 
valorAntes = OLD.enunciado,
valorDepois = NULL,
campoAlterado = 'enunciado',
dataAlteracao = NOW(),
usuario = session_user();
