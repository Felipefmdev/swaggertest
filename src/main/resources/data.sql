-- Inserindo dados na tabela Instrutor
INSERT INTO Instrutor (idinstrutor, RG, nome, nascimento, titulacao) VALUES (1, '123456789', 'João Silva', '1980-01-15', 1);
INSERT INTO Instrutor (idinstrutor, RG, nome, nascimento, titulacao) VALUES (2, '987654321', 'Maria Oliveira', '1975-07-30', 2);

-- Inserindo dados na tabela Turma
INSERT INTO Turma (idturma, horario, duracao, datainicio, dataFim, instrutor_id) VALUES (1, '09:00:00', 60, '2024-01-15', '2024-03-15', 1);
INSERT INTO Turma (idturma, horario, duracao, datainicio, dataFim, instrutor_id) VALUES (2, '14:00:00', 90, '2024-02-01', '2024-04-01', 2);
