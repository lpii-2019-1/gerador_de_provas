create trigger questaoBeforeUpdate 
before update on questao for each row 
insert into auditoria
set acao = 'update',
enunciadoAntes = OLD.enunciado,
enunciadoDepois = NEW.enunciado,
alternativaAntes = NULL,
alternativaDepois = NULL,
dataAlteracao = NOW(),
usuario = session_user();

create trigger questaoBeforeDelete 
before delete on questao for each row 
insert into auditoria
set acao = 'delete', 
enunciadoAntes = OLD.enunciado,
enunciadoDepois = Null,
alternativaAntes = NULL,
alternativaDepois = NULL,
dataAlteracao = NOW(),
usuario = session_user();


create trigger alternativaBeforeUpdate 
before update on alternativa for each row
insert into auditoria
set  acao = 'update',
enunciadoAntes = NULL,
enunciadoDepois = Null,
alternativaAntes = OLD.alternativa,
alternativaDepois = NEW.alternativa,
dataAlteracao = NOW(),
usuario = session_user();


create trigger alternativaBeforeDelete 
before update on alternativa for each row
insert into auditoria
set  acao = 'delete',
enunciadoAntes = NULL,
enunciadoDepois = Null,
alternativaAntes = OLD.alternativa,
alternativaDepois = NULL,
dataAlteracao = NOW(),
usuario = session_user();
