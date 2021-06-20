--DROP TABLE IF EXISTS exames;

CREATE TABLE IF NOT EXISTS exames (
     id serial PRIMARY KEY,
     nome varchar(50),
     paciente varchar(50),
     data varchar (50),
     resultado varchar (50)
);