CREATE TABLE proprietario (
    pk_proprietario SERIAL PRIMARY KEY,
    cnpj TEXT NOT NULL,
    escrituraEstadual TEXT NOT NULL,
    estadoCivil TEXT NOT NULL,
    sexo TEXT NOT NULL,
    idadeProprietario INTEGER NOT NULL,
    nomeProprietario TEXT NOT NULL
);

CREATE TABLE area_plantio (
    pk_terra SERIAL PRIMARY KEY,
    sementePlantada TEXT NOT NULL,
    dataPlantio DATE NOT NULL,
    dataColeita DATE NOT NULL,
    qualidadeSolo TEXT NOT NULL,
    quantidadeHectares DECIMAL(10, 2) NOT NULL,
    producaoHectare INTEGER NOT NULL,
    fk_proprietario INTEGER NOT NULL,
    FOREIGN KEY (fk_proprietario) REFERENCES proprietario(pk_proprietario)
);

CREATE TABLE fertilizante (
    pk_fertilizante SERIAL PRIMARY KEY,
    nomeFertilizante TEXT NOT NULL,
    tipoFertilizante TEXT NOT NULL,
    dataAplicacao DATE DEFAULT CURRENT_DATE,
    quantidadeAplicada DECIMAL(10, 2) NOT NULL,
    fk_proprietario INTEGER NOT NULL,
    fk_terra INTEGER NOT NULL,
    FOREIGN KEY (fk_proprietario) REFERENCES proprietario(pk_proprietario),
    FOREIGN KEY (fk_terra) REFERENCES area_plantio(pk_terra)
);

CREATE TABLE plantio (
    pk_plantio SERIAL PRIMARY KEY,
    nomeSemente TEXT NOT NULL,
    profundidadePlantada TEXT NOT NULL,
    fk_proprietario INTEGER NOT NULL,
    fk_terra INTEGER NOT NULL,
    fk_fertilizante INTEGER NOT NULL,
    FOREIGN KEY (fk_proprietario) REFERENCES proprietario(pk_proprietario),
    FOREIGN KEY (fk_terra) REFERENCES area_plantio(pk_terra),
    FOREIGN KEY (fk_fertilizante) REFERENCES fertilizante(pk_fertilizante)
);

-----------------------------------------------------------------------------------
--==> Valores -_-

INSERT INTO proprietario (cnpj, escrituraEstadual, estadoCivil, sexo, idadeProprietario, nomeProprietario) 
VALUES 
    ('12.345.678/0001-90', '123456789', 'Casado(a)', 'Masculino', 45, 'Carlos Eduardo Silva'),
    ('98.765.432/0001-10', '987654321', 'Solteiro(a)', 'Feminino', 38, 'Mariana Oliveira Santos');

INSERT INTO area_plantio (sementePlantada, dataPlantio, dataColeita, qualidadeSolo, quantidadeHectares, producaoHectare, fk_proprietario) 
VALUES 
    ('Soja', '2025-10-15', '2026-02-20', 'Excelente', 150.50, 60, 1),
    ('Milho', '2025-11-01', '2026-03-15', 'Boa', 80.00, 90, 2);

INSERT INTO fertilizante (nomeFertilizante, tipoFertilizante, dataAplicacao, quantidadeAplicada, fk_proprietario, fk_terra) 
VALUES 
    ('NPK 10-10-10', 'Químico', '2025-10-10', 2500.00, 1, 1),
    ('Adubo Orgânico Compostado', 'Orgânico', '2025-10-25', 1200.50, 2, 2);

INSERT INTO plantio (nomeSemente, profundidadePlantada, fk_proprietario, fk_terra, fk_fertilizante) 
VALUES 
    ('Soja Transgênica BRS', '4 cm', 1, 1, 1),
    ('Milho Híbrido DOW', '5 cm', 2, 2, 2);













