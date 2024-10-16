CREATE TABLE acessorio (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO acessorio (descricao) VALUES ('Ar Condicionado');
INSERT INTO acessorio (descricao) VALUES ('Airbags');
INSERT INTO acessorio (descricao) VALUES ('Trava Elétrica');
INSERT INTO acessorio (descricao) VALUES ('Vidros Elétricos');
INSERT INTO acessorio (descricao) VALUES ('Direção Hidráulica');
INSERT INTO acessorio (descricao) VALUES ('Sensor de Estacionamento');
INSERT INTO acessorio (descricao) VALUES ('Câmera de Ré');
INSERT INTO acessorio (descricao) VALUES ('Faróis de Neblina');
INSERT INTO acessorio (descricao) VALUES ('Rodas de Liga Leve');
INSERT INTO acessorio (descricao) VALUES ('Sistema de Som');
-- Tabela Fabricantes
CREATE TABLE fabricantes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE
);


INSERT INTO fabricantes (nome) VALUES ('Toyota');
INSERT INTO fabricantes (nome) VALUES ('Honda');
INSERT INTO fabricantes (nome) VALUES ('Ford');
INSERT INTO fabricantes (nome) VALUES ('Chevrolet');
INSERT INTO fabricantes (nome) VALUES ('Nissan');
INSERT INTO fabricantes (nome) VALUES ('Volkswagen');
INSERT INTO fabricantes (nome) VALUES ('Hyundai');
INSERT INTO fabricantes (nome) VALUES ('Kia');
INSERT INTO fabricantes (nome) VALUES ('BMW');
INSERT INTO fabricantes (nome) VALUES ('Mercedes-Benz');


-- Tabela Modelos de Carro
CREATE TABLE modelos_carro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    fabricante_id BIGINT,
    categoria VARCHAR(50),
    FOREIGN KEY (fabricante_id) REFERENCES fabricantes(id) ON DELETE CASCADE
);
INSERT INTO modelos_carro (categoria, descricao, fabricante_id) VALUES
('SEDAN_GRANDE', 'Camry', 1),  -- Toyota
('HATCH_COMPACTO', 'Fit', 2),  -- Honda
('ESPORTIVO', 'Mustang', 3),   -- Ford
('SEDAN_MEDIO', 'Onix', 4),    -- Chevrolet
('UTILITARIO_COMERCIAL', 'NV3500', 5), -- Nissan
('SEDAN_COMPACTO', 'Jetta', 6), -- Volkswagen
('HATCH_MEDIO', 'Elantra', 7), -- Hyundai
('SEDAN_GRANDE', 'Optima', 8), -- Kia
('ESPORTIVO', 'Z4', 9),        -- BMW
('SEDAN_GRANDE', 'S-Class', 10), -- Mercedes-Benz
('HATCH_COMPACTO', 'Yaris', 1),  -- Toyota
('MINIVAN', 'Odyssey', 2),     -- Honda
('UTILITARIO_COMERCIAL', 'Ranger', 3), -- Ford
('HATCH_COMPACTO', 'Tracker', 4), -- Chevrolet
('SEDAN_MEDIO', 'Altima', 5),  -- Nissan
('SEDAN_COMPACTO', 'Virtus', 6), -- Volkswagen
('HATCH_MEDIO', 'Kona', 7),    -- Hyundai
('ESPORTIVO', 'Stinger', 8),   -- Kia
('SEDAN_GRANDE', 'E-Class', 10), -- Mercedes-Benz
('HATCH_MEDIO', 'Corolla', 1), -- Toyota
('MINIVAN', 'Sienna', 2),      -- Honda
('UTILITARIO_COMERCIAL', 'F-150', 3), -- Ford
('HATCH_COMPACTO', 'Sonic', 4), -- Chevrolet
('SEDAN_MEDIO', 'Sentra', 5),  -- Nissan
('SEDAN_COMPACTO', 'Polo', 6), -- Volkswagen
('HATCH_MEDIO', 'Tucson', 7),  -- Hyundai
('ESPORTIVO', 'Stinger', 8),   -- Kia
('SEDAN_GRANDE', 'E-Class', 10); -- Mercedes-Benz

CREATE TABLE carros (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(10) NOT NULL,
    chassi VARCHAR(20) NOT NULL,
    cor VARCHAR(30) NOT NULL,
    valor_diaria FLOAT NOT NULL,
    reserva BOOLEAN DEFAULT FALSE,
    modelo_id BIGINT,
    url_imagem VARCHAR(255),
    FOREIGN KEY (modelo_id) REFERENCES modelos_carro(id) ON DELETE SET NULL
);

INSERT INTO carros (chassi, cor, placa, valor_diaria, modelo_id, reserva) VALUES
    ('1HGBH41JXMN109186', 'Preto', 'ABC1234', 150.00, 1, true),  -- Camry
    ('2HGEJ6672WH542178', 'Branco', 'DEF5678', 100.00, 2, false),  -- Fit
    ('3FAFP40367R186493', 'Vermelho', 'GHI9012', 250.00, 3, true),  -- Mustang
    ('1G1BC5SM7H7123456', 'Azul', 'JKL3456', 120.00, 4, false),   -- Onix
    ('1N6AA1EJ7LN123456', 'Cinza', 'MNO7890', 130.00, 5, true),   -- NV3500
    ('3VW2B7AJ5KM123456', 'Prata', 'PQR2345', 140.00, 6, false),   -- Jetta
    ('5NPE34AF6LH123456', 'Preto', 'STU6789', 115.00, 7, true),   -- Elantra
    ('5XYKT3A60EG123456', 'Branco', 'VWX1234', 135.00, 8, false),   -- Optima
    ('WBA5A7C51J7C12345', 'Azul', 'YZA5678', 275.00, 9, true),    -- Z4
    ('WDDUG8DB7LA123456', 'Vermelho', 'BCD8901', 300.00, 10, false),  -- S-Class
    ('1HGBH41JXMN109187', 'Cinza', 'EFG1234', 105.00, 11, true),   -- Yaris
    ('5FNYF6H52LB123456', 'Verde', 'HIJ5678', 140.00, 12, false),   -- Odyssey
    ('1FTEW1E43JK123456', 'Bege', 'JKL9012', 150.00, 13, true),    -- Ranger
    ('1G1PE5SB2G7312345', 'Prata', 'LMN3456', 125.00, 14, false),   -- Tracker
    ('1N4AL3AP6JC123456', 'Preto', 'OPQ7890', 145.00, 15, true),    -- Altima
    ('3VW2B7AJ4LM123456', 'Branco', 'RST1234', 120.00, 16, false),   -- Virtus
    ('5NPE24AF5LH123456', 'Azul', 'UVW5678', 110.00, 17, true),    -- Kona
    ('5XYPH4A34EG123456', 'Cinza', 'XYZ9012', 155.00, 18, false),    -- Stinger
    ('WBA8A5C5XJ7C12345', 'Verde', 'ABC2345', 290.00, 19, true),   -- E-Class
    ('5FNYF6H32LB123457', 'Vermelho', 'DEF6789', 145.00, 20, false), -- Corolla
    ('5FNYF6H52LB123458', 'Branco', 'GHI9012', 160.00, 21, true),   -- Sienna
    ('1FTFW1E53JK123457', 'Azul', 'JKL2345', 155.00, 22, false),     -- F-150
    ('1G1BC5SM9H7123457', 'Preto', 'MNO6789', 130.00, 23, true),    -- Sonic
    ('1N4AL3AP6JC123457', 'Prata', 'OPQ1234', 135.00, 24, false),     -- Sentra
    ('3VW2B7AJ5KM123457', 'Verde', 'STU5678', 125.00, 25, true),    -- Polo
    ('5NPE24AF4LH123457', 'Cinza', 'UVW9012', 140.00, 26, false),    -- Tucson
    ('5XYPH4A34EG123457', 'Bege', 'YZA5678', 165.00, 27, true),     -- Stinger
    ('WBA8A5C5XJ7C12346', 'Prata', 'BCD8901', 320.00, 28, false),   -- E-Class
    ('1HGBH41JXMN109188', 'Branco', 'EFG1235', 150.00, 1, true),   -- Camry
    ('2HGEJ6672WH542179', 'Vermelho', 'HIJ5679', 100.00, 2, false),  -- Fit
    ('3FAFP40367R186494', 'Azul', 'JKL3457', 250.00, 3, true),      -- Mustang
    ('1G1BC5SM7H7123457', 'Prata', 'LMN3457', 120.00, 4, false),    -- Onix
    ('1N6AA1EJ7LN123457', 'Cinza', 'MNO7891', 130.00, 5, true),    -- NV3500
    ('3VW2B7AJ5KM123457', 'Preto', 'PQR2346', 140.00, 6, false),    -- Jetta
    ('5NPE34AF6LH123457', 'Branco', 'STU6790', 115.00, 7, true),   -- Elantra
    ('5XYKT3A60EG123457', 'Verde', 'VWX1235', 135.00, 8, false),    -- Optima
    ('WBA5A7C51J7C12346', 'Cinza', 'YZA5679', 275.00, 9, true),    -- Z4
    ('WDDUG8DB7LA123457', 'Vermelho', 'BCD8902', 300.00, 10, false), -- S-Class
    ('1HGBH41JXMN109189', 'Azul', 'EFG1236', 105.00, 11, true),    -- Yaris
    ('5FNYF6H52LB123459', 'Bege', 'HIJ5680', 140.00, 12, false),    -- Odyssey
    ('1FTEW1E43JK123457', 'Verde', 'JKL9013', 150.00, 13, true),   -- Ranger
    ('1G1PE5SB2G7312346', 'Cinza', 'LMN3458', 125.00, 14, false),   -- Tracker
    ('1N4AL3AP6JC123457', 'Preto', 'OPQ7891', 145.00, 15, true),   -- Altima
    ('3VW2B7AJ4LM123457', 'Prata', 'RST1235', 120.00, 16, false),   -- Virtus
    ('5NPE24AF5LH123457', 'Azul', 'UVW5679', 110.00, 17, true),    -- Kona
    ('5XYPH4A34EG123458', 'Bege', 'XYZ9013', 155.00, 18, false),    -- Stinger
    ('WBA8A5C5XJ7C12348', 'Verde', 'ABC2346', 290.00, 19, true),   -- E-Class
    ('5FNYF6H32LB123463', 'Vermelho', 'DEF6790', 145.00, 20, false), -- Corolla
    ('5FNYF6H52LB123464', 'Branco', 'GHI9013', 160.00, 21, true),   -- Sienna
    ('1FTFW1E53JK123458', 'Azul', 'JKL2346', 155.00, 22, false),     -- F-150
    ('1G1BC5SM9H7123458', 'Preto', 'MNO6790', 130.00, 23, true),    -- Sonic
    ('1N4AL3AP6JC123458', 'Prata', 'OPQ1235', 135.00, 24, false),    -- Sentra
    ('3VW2B7AJ5KM123458', 'Verde', 'STU6791', 125.00, 25, true),    -- Polo
    ('5NPE24AF4LH123458', 'Cinza', 'UVW9013', 140.00, 26, false),    -- Tucson
    ('5XYPH4A34EG123459', 'Bege', 'YZA5680', 165.00, 27, true),    -- Stinger
    ('WBA8A5C5XJ7C12349', 'Prata', 'BCD8903', 320.00, 28, false);   -- E-Class

CREATE TABLE carro_acessorio (
    carro_id BIGINT,
    acessorio_id BIGINT,
    PRIMARY KEY (carro_id, acessorio_id),
    FOREIGN KEY (carro_id) REFERENCES carros(id) ON DELETE CASCADE,
    FOREIGN KEY (acessorio_id) REFERENCES acessorio(id) ON DELETE CASCADE
);


-- Carro 1
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (1, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (1, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (1, 9);

-- Carro 2
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (2, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (2, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (2, 7);

-- Carro 3
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (3, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (3, 5);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (3, 10);

-- Carro 4
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (4, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (4, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (4, 6);

-- Carro 5
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (5, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (5, 6);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (5, 8);

-- Carro 6
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (6, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (6, 7);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (6, 9);

-- Carro 7
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (7, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (7, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (7, 9);

-- Carro 8
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (8, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (8, 8);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (8, 10);

-- Carro 9
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (9, 5);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (9, 7);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (9, 10);

-- Carro 10
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (10, 6);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (10, 8);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (10, 10);

-- Carro 11
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (11, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (11, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (11, 9);

-- Carro 12
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (12, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (12, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (12, 7);

-- Carro 13
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (13, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (13, 5);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (13, 10);

-- Carro 14
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (14, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (14, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (14, 6);

-- Carro 15
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (15, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (15, 6);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (15, 8);

-- Carro 16
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (16, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (16, 7);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (16, 9);

-- Carro 17
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (17, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (17, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (17, 9);

-- Carro 18
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (18, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (18, 8);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (18, 10);

-- Carro 19
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (19, 5);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (19, 7);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (19, 10);

-- Carro 20
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (20, 6);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (20, 8);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (20, 10);

-- Carro 21
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (21, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (21, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (21, 9);

-- Carro 22
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (22, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (22, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (22, 7);

-- Carro 23
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (23, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (23, 5);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (23, 10);

-- Carro 24
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (24, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (24, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (24, 6);

-- Carro 25
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (25, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (25, 6);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (25, 8);

-- Carro 26
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (26, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (26, 7);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (26, 9);

-- Carro 27
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (27, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (27, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (27, 9);

-- Carro 28
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (28, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (28, 8);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (28, 10);

-- Carro 29
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (29, 5);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (29, 7);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (29, 10);

-- Carro 30
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (30, 6);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (30, 8);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (30, 10);

-- Carro 31
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (31, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (31, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (31, 9);

-- Carro 32
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (32, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (32, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (32, 7);

-- Carro 33
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (33, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (33, 5);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (33, 10);

-- Carro 34
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (34, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (34, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (34, 6);

-- Carro 35
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (35, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (35, 6);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (35, 8);

-- Carro 36
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (36, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (36, 7);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (36, 9);

-- Carro 37
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (37, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (37, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (37, 9);

-- Carro 38
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (38, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (38, 8);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (38, 10);

-- Carro 39
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (39, 5);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (39, 7);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (39, 10);

-- Carro 40
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (40, 6);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (40, 8);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (40, 10);

-- Carro 41
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (41, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (41, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (41, 9);

-- Carro 42
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (42, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (42, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (42, 7);

-- Carro 43
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (43, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (43, 5);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (43, 10);

-- Carro 44
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (44, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (44, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (44, 6);

-- Carro 45
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (45, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (45, 6);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (45, 8);

-- Carro 46
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (46, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (46, 7);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (46, 9);

-- Carro 47
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (47, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (47, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (47, 9);

-- Carro 48
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (48, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (48, 8);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (48, 10);

-- Carro 49
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (49, 5);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (49, 7);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (49, 10);

-- Carro 50
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (50, 6);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (50, 8);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (50, 10);

-- Carro 51
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (51, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (51, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (51, 9);

-- Carro 52
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (52, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (52, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (52, 7);

-- Carro 53
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (53, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (53, 5);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (53, 10);

-- Carro 54
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (54, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (54, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (54, 6);

-- Carro 55
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (55, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (55, 6);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (55, 8);

-- Carro 56
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (56, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (56, 7);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (56, 9);
