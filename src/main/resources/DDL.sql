CREATE TABLE paciente(
	id_paciente INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(50) NOT NULL,
    nascimento DATE NOT NULL,
    PRIMARY KEY(id_paciente)
);

CREATE TABLE telefone_paciente(
	id_telefone_paciente INT NOT NULL AUTO_INCREMENT,
	id_paciente INT NOT NULL,
    telefone VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_telefone_paciente),
    FOREIGN KEY(id_paciente) REFERENCES paciente(id_paciente)
);

CREATE TABLE contato_emergencia_paciente(
	id_contato_emergencia INT NOT NULL AUTO_INCREMENT,
	id_paciente INT NOT NULL,
    contato_emergencia VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_contato_emergencia),
    FOREIGN KEY(id_paciente) REFERENCES paciente(id_paciente)
);

CREATE TABLE endereco_paciente(
	id_endereco_paciente INT NOT NULL AUTO_INCREMENT,
	id_paciente INT NOT NULL,
    endereco VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_endereco_paciente),
    FOREIGN KEY(id_paciente) REFERENCES paciente(id_paciente)
);

CREATE TABLE medico (
	id_medico INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(50) NOT NULL,
    crm VARCHAR(50) NOT NULL,
    especialidade VARCHAR(50) NOT NULL,
    telefone VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_medico)
);

CREATE TABLE leito (
	id_leito INT NOT NULL AUTO_INCREMENT,
    id_paciente INT NOT NULL,
    numero INT,
    localizacao VARCHAR(50) NOT NULL,
    isOcupado BOOLEAN NOT NULL,
    PRIMARY KEY(id_leito),
    FOREIGN KEY(id_paciente) REFERENCES paciente(id_paciente)
);

CREATE TABLE atendimento (
    id_atendimento INT NOT NULL AUTO_INCREMENT,
    id_medico INT NOT NULL,
    id_paciente INT NOT NULL,
    data_atendimento DATETIME NOT NULL,
    motivo VARCHAR(50) NOT NULL,
    diagnostico VARCHAR(50) NOT NULL,
    recomendacao VARCHAR(50) NOT NULL,
    tipo_atendimento VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_atendimento),
    FOREIGN KEY (id_medico) REFERENCES medico (id_medico),
    FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente)
);

CREATE TABLE exames (
    id_exames INT NOT NULL AUTO_INCREMENT,
    atendimento_id INT NOT NULL,
    realizacao DATETIME NOT NULL,
    status_exame ENUM('CANCELADO', 'ANDAMENTO', 'CONCLUIDO') NOT NULL,
    PRIMARY KEY (id_exames),
    FOREIGN KEY (atendimento_id) REFERENCES atendimento (id_atendimento)
);

CREATE TABLE medicamento (
    id_medicamento INT NOT NULL AUTO_INCREMENT,
    atendimento_id INT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    validade DATE NOT NULL,
    lote BIGINT NOT NULL,
    fabricante VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_medicamento),
    FOREIGN KEY (atendimento_id) REFERENCES atendimento (id_atendimento)
);

CREATE TABLE atendimento_medicamento (
	atendimento_id INT NOT NULL,
    medicamento_id INT NOT NULL,
    prescricao VARCHAR(50) NOT NULL,
    PRIMARY KEY(atendimento_id),
    FOREIGN KEY(atendimento_id) REFERENCES atendimento(id_atendimento),
    FOREIGN KEY(medicamento_id) REFERENCES medicamento(id_medicamento)
);


CREATE TABLE resultados (
	id_exame INT NOT NULL AUTO_INCREMENT,
    resultado VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_exame),
    FOREIGN KEY(id_exame) REFERENCES exames(id_exames)
);

CREATE TABLE visitante(
	id_visitante INT NOT NULL AUTO_INCREMENT,
    paciente_id INT NOT NULL,
    atendimento_id INT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    parentesco VARCHAR(50) NOT NULL,
    periodo_visita DATETIME NOT NULL,
    telefone VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_visitante),
    FOREIGN KEY(paciente_id) REFERENCES paciente(id_paciente),
    FOREIGN KEY(atendimento_id) REFERENCES atendimento(id_atendimento)
);

CREATE TABLE cirurgia (
	id_cirurgia INT NOT NULL AUTO_INCREMENT,
    paciente_id INT NOT NULL,
    medico_id INT NOT NULL,
    atendimento_id INT NOT NULL,
    tipo_cirurgia VARCHAR(50) NOT NULL,
    grau_de_risco ENUM('NENHUM','BAIXO','MEDIO','GRAVE') NOT NULL,
    PRIMARY KEY(id_cirurgia),
    FOREIGN KEY(paciente_id) REFERENCES paciente(id_paciente),
    FOREIGN KEY(atendimento_id) REFERENCES atendimento(id_atendimento),
    FOREIGN KEY(medico_id) REFERENCES medico(id_medico)
);


CREATE TABLE enfermeira (
	id_enfermeira INT NOT NULL AUTO_INCREMENT,
    paciente_id INT NOT NULL,
    medicamento_id INT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(50) NOT NULL,
    cip VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_enfermeira),
    FOREIGN KEY(paciente_id) REFERENCES paciente(id_paciente),
    FOREIGN KEY(medicamento_id) REFERENCES medicamento(id_medicamento)
);

CREATE TABLE medicamento_enfermeira (
	medicamento_id INT NOT NULL,
    enfermeira_id INT NOT NULL,
    prescricao VARCHAR(50) NOT NULL,
    PRIMARY KEY(medicamento_id),
	FOREIGN KEY(medicamento_id) REFERENCES medicamento(id_medicamento),
    FOREIGN KEY(enfermeira_id) REFERENCES enfermeira(id_enfermeira)
);

CREATE TABLE internacao (
	id_internacao INT NOT NULL AUTO_INCREMENT,
    leito_id INT NOT NULL,
    atendimento_id INT NOT NULL,
    paciente_id INT NOT NULL,
    data_alta DATETIME NOT NULL,
    data_internacao DATETIME NOT NULL,
    motivo VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_internacao),
    FOREIGN KEY(leito_id) REFERENCES leito(id_leito),
    FOREIGN KEY(atendimento_id) REFERENCES atendimento(id_atendimento),
    FOREIGN KEY(paciente_id) REFERENCES paciente(id_paciente)
);

CREATE TABLE paciente_internacao (
	paciente_id INT NOT NULL,
    internacao_id INT NOT NULL,
    PRIMARY KEY(paciente_id),
    FOREIGN KEY(internacao_id) REFERENCES internacao(id_internacao)
);

SELECT * FROM paciente;
SELECT * FROM contato_emergencia_paciente;
SELECT * FROM telefone_paciente;