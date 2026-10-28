CREATE TABLE cliente(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome TEXT NOT NULL CHECK (btrim(nome) <> ''),
    cpf CHAR(11) NOT NULL UNIQUE CHECK (cpf ~ '^[0-9]{11}$'),
    cep CHAR(8) NOT NULL CHECK (cep ~ '^[0-9]{8}$'),
    numero_residencia TEXT NOT NULL CHECK (btrim(numero_residencia) <> ''),
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    criado_em TIMESTAMPTZ NOT NULL DEFAULT now(),
    atualizado_em TIMESTAMPTZ NOT NULL DEFAULT now()
);