show variables like 'autocommit';
set autocommit = 0;

start transaction;

CREATE DATABASE IF NOT EXISTS BOLSAVALORES;
USE BOLSAVALORES;

DROP TABLE IF EXISTS CATEGORIAS;
CREATE TABLE CATEGORIAS (
	COD_CAT      VARCHAR(10)  NOT NULL,
	DESCRIPCION  VARCHAR(50)  NOT NULL,
	URL          VARCHAR(100) NOT NULL,
	FORMATOFECHA VARCHAR(10)  NOT NULL,
	COMODIN      VARCHAR(10),
	EXTENSION    VARCHAR(5),
	PRIMARY KEY (COD_CAT)
);

INSERT INTO CATEGORIAS (COD_CAT, DESCRIPCION, URL, FORMATOFECHA, COMODIN, EXTENSION) VALUES ('MERCONT', 'MERCADO CONTINUO', 'http://www.megabolsa.com/cierres/', 'YYMMDD', '' , '.txt');
INSERT INTO CATEGORIAS (COD_CAT, DESCRIPCION, URL, FORMATOFECHA, COMODIN, EXTENSION) VALUES ('IND'    , 'INDICES'         , 'http://www.megabolsa.com/cierres/', 'YYMMDD', 'I', '.txt');



DROP TABLE IF EXISTS PATRON_DATOS;
CREATE TABLE PATRON_DATOS (
	COD_CAMPO VARCHAR(10) NOT NULL,
	ORDEN     TINYINT     NOT NULL,
	TIPO_DATO VARCHAR(10) NOT NULL,
	PRIMARY KEY (COD_CAMPO)
);
INSERT INTO PATRON_DATOS (COD_CAMPO, ORDEN, TIPO_DATO) VALUES ('COD_VALOR', 1, 'VARCHAR(10)');
INSERT INTO PATRON_DATOS (COD_CAMPO, ORDEN, TIPO_DATO) VALUES ('FECHA'    , 2, 'DATE');
INSERT INTO PATRON_DATOS (COD_CAMPO, ORDEN, TIPO_DATO) VALUES ('APERTURA' , 3, 'DECIMAL');
INSERT INTO PATRON_DATOS (COD_CAMPO, ORDEN, TIPO_DATO) VALUES ('MAXIMO'   , 4, 'DECIMAL');
INSERT INTO PATRON_DATOS (COD_CAMPO, ORDEN, TIPO_DATO) VALUES ('MINIMO'   , 5, 'DECIMAL');
INSERT INTO PATRON_DATOS (COD_CAMPO, ORDEN, TIPO_DATO) VALUES ('CIERRE'   , 6, 'DECIMAL');
INSERT INTO PATRON_DATOS (COD_CAMPO, ORDEN, TIPO_DATO) VALUES ('VOLUMEN'  , 7, 'BIGINT');

DROP TABLE IF EXISTS OPERACIONES;
CREATE TABLE OPERACIONES (
	COD_VALOR     VARCHAR(10)    NOT NULL,
	VOLUMEN       DOUBLE         NOT NULL,
	DES_OPERACION VARCHAR(20)    NOT NULL,
	FECH_APERTURA DATE           NOT NULL,
	PREC_APERTURA DECIMAL(10, 3) NOT NULL,
	FECH_CIERRE   DATE,
	PREC_CIERRE   DECIMAL(10, 3),
	TASAS         DECIMAL(10, 3),
	BENEFICIO     DECIMAL(10, 3)
);


DROP TABLE IF EXISTS VALORES;
CREATE TABLE VALORES (
	COD_VALOR   VARCHAR(10) NOT NULL,
	COD_CAT     VARCHAR(10) NOT NULL,
	DECIMALES   TINYINT     NOT NULL DEFAULT 3,
	DESCRIPCION VARCHAR(50) NOT NULL,
	PRIMARY KEY (COD_VALOR),
	CONSTRAINT CATEGORIA_1 FOREIGN KEY (COD_CAT) REFERENCES CATEGORIAS (COD_CAT)
);

INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ABG'  , 'MERCONT', 3, 'ABENGOA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ABE'  , 'MERCONT', 3, 'ABERTIS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ANA'  , 'MERCONT', 3, 'ACCIONA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ACX'  , 'MERCONT', 3, 'ACERINOX');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ACS'  , 'MERCONT', 3, 'ACS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ADZ'  , 'MERCONT', 3, 'ADOLFO DOMINGUEZ');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('AGS'  , 'MERCONT', 3, 'AGS.BARCELONA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ALD'  , 'MERCONT', 3, 'ALDEASA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ALT'  , 'MERCONT', 3, 'ALTADIS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('AMS'  , 'MERCONT', 3, 'AMADEUS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XAMXL', 'MERCONT', 3, 'AMERICA MOVILES');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('AMP'  , 'MERCONT', 3, 'AMPER');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('A3TV' , 'MERCONT', 3, 'ANTENA 3TV');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XARAB', 'MERCONT', 3, 'ARACRUZ');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ARA'  , 'MERCONT', 3, 'ARAGONESAS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('LOR'  , 'MERCONT', 3, 'ARCELOR');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('AZC'  , 'MERCONT', 3, 'ASTURIANA DEL ZINC');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('AUM'  , 'MERCONT', 3, 'AUMAR');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('AVZ'  , 'MERCONT', 3, 'AVANZIT');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('AFR'  , 'MERCONT', 3, 'AYF. AZCOITIA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('AZK'  , 'MERCONT', 3, 'AZKOYEN');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('EVA'  , 'MERCONT', 3, 'AZUCARERA EBRO PULEVA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XBFR' , 'MERCONT', 3, 'B. FRANCES');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('AND'  , 'MERCONT', 3, 'B.ANDALUCIA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ATL'  , 'MERCONT', 3, 'B.ATLANTICO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XBBDC', 'MERCONT', 3, 'B. BRADESCO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CAS'  , 'MERCONT', 3, 'B.CASTILLA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CBL'  , 'MERCONT', 3, 'B.CTO.BALEAR');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ESF'  , 'MERCONT', 3, 'B.ESFINGE');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('GAL'  , 'MERCONT', 3, 'B.GALICIA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('GUI'  , 'MERCONT', 3, 'B.GUIPUZCOANO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('HRR'  , 'MERCONT', 3, 'B.HERRERO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('PAS'  , 'MERCONT', 3, 'B.PASTOR');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('POP'  , 'MERCONT', 3, 'B.POPULAR');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XBRSB', 'MERCONT', 3, 'B.R. PLATA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SAB'  , 'MERCONT', 3, 'B.SABADELL');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BVA'  , 'MERCONT', 3, 'B.VALENCIA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('VAS'  , 'MERCONT', 3, 'B.VASCONIA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ZRG'  , 'MERCONT', 3, 'B.ZARAGOZANO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XGFBB', 'MERCONT', 3, 'BANCOMER');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BTO'  , 'MERCONT', 3, 'BANESTO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BKT'  , 'MERCONT', 3, 'BANKINTER');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BDL'  , 'MERCONT', 3, 'BARON DE LEY');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BAY'  , 'MERCONT', 3, 'BAYER A.G.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BBVA' , 'MERCONT', 3, 'BBVA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BMA'  , 'MERCONT', 3, 'BEFESA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('RIO'  , 'MERCONT', 3, 'BO.RIOJANAS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BYB'  , 'MERCONT', 3, 'BODEGAS Y BEBIDAS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XBRPO', 'MERCONT', 3, 'BRADESPAR OR');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XBRPP', 'MERCONT', 3, 'BRADESPAR PR');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XSBP' , 'MERCONT', 3, 'BS PUERTO RICO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SAN'  , 'MERCONT', 3, 'BSCH');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CAF'  , 'MERCONT', 3, 'C.A.F.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CUN'  , 'MERCONT', 3, 'C.V.N.E.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CPF'  , 'MERCONT', 3, 'CAMPOFRIO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CRF'  , 'MERCONT', 3, 'CARREFOUR');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('GCO'  , 'MERCONT', 3, 'CAT. OCCIDENTE');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CPL'  , 'MERCONT', 3, 'CEM. PORTLAND');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CEP'  , 'MERCONT', 3, 'CEPSA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CIE'  , 'MERCONT', 3, 'CIE AUTOMOTIVE');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CIN'  , 'MERCONT', 3, 'CINTRA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ALB'  , 'MERCONT', 3, 'CORP.FI.ALBA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAP'  , 'MERCONT', 3, 'CORP.MAPFRE');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CTF'  , 'MERCONT', 3, 'CORTEFIEL');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CRI'  , 'MERCONT', 3, 'CRISTALERIA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MDF'  , 'MERCONT', 3, 'D.FELGUERA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('DIN'  , 'MERCONT', 3, 'DINAMIA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('DGI'  , 'MERCONT', 3, 'DOGI');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('EAD'  , 'MERCONT', 3, 'EADS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ENO'  , 'MERCONT', 3, 'ELECNOR');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XELTO', 'MERCONT', 3, 'ELECTROBRAS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XELTB', 'MERCONT', 3, 'ELECTROBRAS/B');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ENA'  , 'MERCONT', 3, 'ENACO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ENC'  , 'MERCONT', 3, 'ENCE');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ELE'  , 'MERCONT', 3, 'ENDESA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('EPC'  , 'MERCONT', 3, 'EPPIC');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ECR'  , 'MERCONT', 3, 'ERCROS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ZNC'  , 'MERCONT', 3, 'ESPA�OLA ZINC');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('PAC'  , 'MERCONT', 3, 'EUROPAC');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('EUR'  , 'MERCONT', 3, 'EUROPISTAS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('FAD'  , 'MERCONT', 3, 'FADESA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('FAE'  , 'MERCONT', 3, 'FAES');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('FTX'  , 'MERCONT', 3, 'FASTIBEX');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('FCC'  , 'MERCONT', 3, 'FCC');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('FER'  , 'MERCONT', 3, 'FERROVIAL');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('FIL'  , 'MERCONT', 3, 'FILO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('FUN'  , 'MERCONT', 3, 'FUNESPA�A');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('GAM'  , 'MERCONT', 3, 'GAMESA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('GAS'  , 'MERCONT', 3, 'GAS NATURAL');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CGI'  , 'MERCONT', 3, 'GE.INVERSION');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('GSW'  , 'MERCONT', 3, 'GLOBAL STELL');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XGLCP', 'MERCONT', 3, 'GLOBO CABO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CAR'  , 'MERCONT', 3, 'GRUPO INMOCARAL');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('HKN'  , 'MERCONT', 3, 'HEINEKEN');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CAN'  , 'MERCONT', 3, 'HIDROCANTABRICO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IBE'  , 'MERCONT', 3, 'IBERDROLA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IBLA' , 'MERCONT', 3, 'IBERIA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IBG'  , 'MERCONT', 3, 'IBERPAPEL');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IBP'  , 'MERCONT', 3, 'IBERPISTAS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XIMPT', 'MERCONT', 3, 'IMPSAT');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BES'  , 'MERCONT', 3, 'INBESOS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ITX'  , 'MERCONT', 3, 'INDITEX');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IDO'  , 'MERCONT', 3, 'INDO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IDR'  , 'MERCONT', 3, 'INDRA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BAM'  , 'MERCONT', 3, 'INM. BAMI');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('COL'  , 'MERCONT', 3, 'INM.COLONIAL');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IZB'  , 'MERCONT', 3, 'INM.ZABALBURU');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('JAZ'  , 'MERCONT', 3, 'JAZZTEL');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('KOI'  , 'MERCONT', 3, 'KOIPE');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SED'  , 'MERCONT', 3, 'LA SEDA B.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('LGT'  , 'MERCONT', 3, 'LINGOTES');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('LOG'  , 'MERCONT', 3, 'LOGISTA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MPV'  , 'MERCONT', 3, 'MAPFRE VIDA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MLX'  , 'MERCONT', 3, 'MECALUX');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MVC'  , 'MERCONT', 3, 'METROVACESA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MIA'  , 'MERCONT', 3, 'MIA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MCM'  , 'MERCONT', 3, 'MIQUEL COSTA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('NTC'  , 'MERCONT', 3, 'NATRACEUTICAL');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('NMQ'  , 'MERCONT', 3, 'N.MONTA�A');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('NAT'  , 'MERCONT', 3, 'NATRA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('NHH'  , 'MERCONT', 3, 'NH HOTELES');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('NEA'  , 'MERCONT', 3, 'NICOLAS CORREA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('OHL'  , 'MERCONT', 3, 'OBR.H.LAIN');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('OMS'  , 'MERCONT', 3, 'OMSA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('PQR'  , 'MERCONT', 3, 'PARQUES REU.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('PAT'  , 'MERCONT', 3, 'PATERNINA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('PVA'  , 'MERCONT', 3, 'PESCANOVA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('VDR'  , 'MERCONT', 3, 'PORTLAND V.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('PIN'  , 'MERCONT', 3, 'PRIMA INMOB.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('PRS'  , 'MERCONT', 3, 'PRISA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('PSG'  , 'MERCONT', 3, 'PROSEGUR');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BIO'  , 'MERCONT', 3, 'PULEVA BIOTECH');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('REC'  , 'MERCONT', 3, 'RECOLETOS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('REE'  , 'MERCONT', 3, 'REDESA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('RDM'  , 'MERCONT', 3, 'RENO M.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('REP'  , 'MERCONT', 3, 'REPSOL');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SYV'  , 'MERCONT', 3, 'SACYR-VALLEHERMOSO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SNC'  , 'MERCONT', 3, 'SNIACE');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SPS'  , 'MERCONT', 3, 'SERVICE POINT SOLUTIONS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SGC'  , 'MERCONT', 3, 'SOGECABLE');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SOL'  , 'MERCONT', 3, 'SOL MELIA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SOS'  , 'MERCONT', 3, 'SOS ARANA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('STG'  , 'MERCONT', 3, 'SOTOGRANDE');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SUP'  , 'MERCONT', 3, 'SUPERDIPLO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XSUZP', 'MERCONT', 3, 'SUZANO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TFI'  , 'MERCONT', 3, 'TAFISA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ASA'  , 'MERCONT', 3, 'TAVEX ALGOD.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CIB'  , 'MERCONT', 3, 'TECNOCOM');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TL5'  , 'MERCONT', 3, 'TELECINCO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TEM'  , 'MERCONT', 3, 'TELEF. MOVILES');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TEF'  , 'MERCONT', 3, 'TELEFONICA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TPZ'  , 'MERCONT', 3, 'TELEPIZZA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XTMXL', 'MERCONT', 3, 'TELMEX');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TRR'  , 'MERCONT', 3, 'TERRA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TST'  , 'MERCONT', 3, 'TESTA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TPI'  , 'MERCONT', 3, 'TPI');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TAZ'  , 'MERCONT', 3, 'TRANSP. AZKAR');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TUB'  , 'MERCONT', 3, 'TUBACEX');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TRG'  , 'MERCONT', 3, 'TUBOS REUNIDOS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TUD'  , 'MERCONT', 3, 'TUDOR');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('UND'  , 'MERCONT', 3, 'UNILAND CEM.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('UNF'  , 'MERCONT', 3, 'UNION FENOSA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('UPL'  , 'MERCONT', 3, 'UNIPAPEL');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('URA'  , 'MERCONT', 3, 'URALITA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('UBS'  , 'MERCONT', 3, 'URBAS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('URB'  , 'MERCONT', 3, 'URBIS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XVALP', 'MERCONT', 3, 'VALE RIO 12');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('VID'  , 'MERCONT', 3, 'VIDRALA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('VLE'  , 'MERCONT', 3, 'VILESA');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('VIS'  , 'MERCONT', 3, 'VISCOFAN');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XVOLB', 'MERCONT', 3, 'VOLCAN C.M.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('VWG'  , 'MERCONT', 3, 'VOLKSWAGEN');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ZOT'  , 'MERCONT', 3, 'ZARDOYA OTIS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ZEL'  , 'MERCONT', 3, 'ZELTIA');

INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IBX'  , 'IND'    , 3, 'Ibex 35');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('NYK'  , 'IND'    , 3, 'Dow Jones');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SYP'  , 'IND'    , 3, 'S&P');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAD'  , 'IND'    , 3, 'Indice Gral. Madrid');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('LFT'  , 'IND'    , 3, 'Footsie');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TKN'  , 'IND'    , 3, 'Nikkei');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('DXF'  , 'IND'    , 3, 'Dax Floor');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IC'   , 'IND'    , 3, 'Ibex Complementario');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IF'   , 'IND'    , 3, 'Ibex Financiero');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IV'   , 'IND'    , 3, 'Ibex Industrial');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IU'   , 'IND'    , 3, 'Ibes Utilit.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('EP'   , 'IND'    , 3, 'Eurotop 300');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('EU'   , 'IND'    , 3, 'Eurotop 100');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('CAC'  , 'IND'    , 3, 'CAC-40 PARIS');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('HK'   , 'IND'    , 3, 'HONG KONG');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('NE'   , 'IND'    , 3, 'NUEVO MERCADO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MXI'  , 'IND'    , 3, 'MEXICO IPC');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('QQ'   , 'IND'    , 3, 'NASDAQ 100');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BV'   , 'IND'    , 3, 'BOVESPA SAO PAULO');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SMI'  , 'IND'    , 3, 'SWISS MARKET');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IT'   , 'IND'    , 3, 'MIBTEL MILAN');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IM'   , 'IND'    , 3, 'MIB 30');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('I5E'  , 'IND'    , 3, 'DJ EURO STOXX 50 ');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('I5P'  , 'IND'    , 3, 'DJ STOXX 50');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('LX'   , 'IND'    , 3, 'LATIBEX');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IXIC' , 'IND'    , 3, 'NASDAQ COMPOSITE ');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('AEX'  , 'IND'    , 3, 'General Index Holanda');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('NYA'  , 'IND'    , 3, 'NYSE Composite ');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('XAX'  , 'IND'    , 3, 'Amex Composite');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('AORD' , 'IND'    , 3, 'All Ordinaries Index Australia ');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TSE'  , 'IND'    , 3, 'TSE 300 Index Toronto');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('BFX'  , 'IND'    , 3, 'BEL-20 Index Belgica ');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('ATG'  , 'IND'    , 3, 'General Share Index Grecia');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SAX'  , 'IND'    , 3, 'SX All Share Index Suecia ');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('TWII' , 'IND'    , 3, 'Taiwan Weighted Index Taiwan');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SSEB' , 'IND'    , 3, 'SSEB Share Index Shanghai');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('SZSB' , 'IND'    , 3, 'SZSB Share Index Shenzhen  ');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('KS11' , 'IND'    , 3, 'Seoul Composite Index Korea');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('KLSE' , 'IND'    , 3, 'KLSE Composite Index Malaysia');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('STI'  , 'IND'    , 3, 'Straits Times Index Singapore');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('NZ40' , 'IND'    , 3, 'NZSE 40 Index New Zealand');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('IBC'  , 'IND'    , 3, 'IBC Index Venezuela');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB2' , 'IND'    , 3, 'Mate. Basi. Indus. y constr..');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB2A', 'IND'    , 3, 'Aeroespacial');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB2C', 'IND'    , 3, 'Construcci�n');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB2F', 'IND'    , 3, 'Fabri. Monta. B. equipo');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB2I', 'IND'    , 3, 'Ingenieria y otros');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB2M', 'IND'    , 3, 'Mine. Metal. y Tra. Pro. Met.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB2Q', 'IND'    , 3, 'Industria Quimica');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB2T', 'IND'    , 3, 'Materiales de construcci�n');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB3' , 'IND'    , 3, 'Bienes de consumo');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB3A', 'IND'    , 3, 'Alimentaci�n y bebidas');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB3F', 'IND'    , 3, 'Prod. Farmaceu. y Bio.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB3O', 'IND'    , 3, 'Otros Bienes de consumo');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB3P', 'IND'    , 3, 'Papel y Artes Graficas');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAB3T', 'IND'    , 3, 'Textil, Vestido y calzado');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAE1' , 'IND'    , 3, 'Petr�leo y Energ�a');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAE1A', 'IND'    , 3, 'Agua y otros');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAE1E', 'IND'    , 3, 'Electricidad y Gas');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAE1P', 'IND'    , 3, 'Petroleo');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS4' , 'IND'    , 3, 'Servicios de consumo');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS4A', 'IND'    , 3, 'Aparcamientos y autopista');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS4C', 'IND'    , 3, 'Comercio');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS4H', 'IND'    , 3, 'Ocio, Turismo y Hostel.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS4M', 'IND'    , 3, 'Medios de com. y Publi.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS4O', 'IND'    , 3, 'Otros servicios');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS4T', 'IND'    , 3, 'Transporte y Distrib.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS5' , 'IND'    , 3, 'Serv. Fin. e Inmob.');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS5B', 'IND'    , 3, 'Banca');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS5C', 'IND'    , 3, 'Soc. Cartera y holding');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS5O', 'IND'    , 3, 'Inmobiliarias y otros');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS5S', 'IND'    , 3, 'Seguros');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS6' , 'IND'    , 3, 'Tecnolog�a y comunicaci�n');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS6E', 'IND'    , 3, 'Electronica y Software');
INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES ('MAS6T', 'IND'    , 3, 'Telecomunic. y otros');

DROP TABLE IF EXISTS DATOS_VALORES;
CREATE TABLE DATOS_VALORES (
	COD_VALOR VARCHAR(10)    NOT NULL,
	FECHA     DATE           NOT NULL,
	APERTURA  DECIMAL(10, 3) NOT NULL,
	MAXIMO    DECIMAL(10, 3) NOT NULL,
	MINIMO    DECIMAL(10, 3) NOT NULL,
	CIERRE    DECIMAL(10, 3),
	VOLUMEN   BIGINT         NOT NULL,
	PRIMARY KEY (COD_VALOR, FECHA),
	CONSTRAINT COD_VALOR_1 FOREIGN KEY (COD_VALOR) REFERENCES VALORES (COD_VALOR)
);


DROP TABLE IF EXISTS INDICADORES;
CREATE TABLE INDICADORES (
    NOMBRE      VARCHAR(20) NOT NULL,
    DESCRIPCION VARCHAR(200),
    FORMULA     VARCHAR(200),
    PRIMARY KEY (NOMBRE)
);

INSERT INTO INDICADORES (NOMBRE, DESCRIPCION, FORMULA) VALUES ('PIVOT POINT', 'PIVOT POINT', '(([CIERRE] + [MAXIMO] + [MINIMO]) / 3)');
INSERT INTO INDICADORES (NOMBRE, DESCRIPCION, FORMULA) VALUES ('R1', 'Resistencia 1', '((([CIERRE] + [MAXIMO] + [MINIMO]) / 3) - [MINIMO])');
INSERT INTO INDICADORES (NOMBRE, DESCRIPCION, FORMULA) VALUES ('S1', 'Soporte 1', '((([CIERRE] + [MAXIMO] + [MINIMO]) / 3) - [MAXIMO])');
INSERT INTO INDICADORES (NOMBRE, DESCRIPCION, FORMULA) VALUES ('R2', 'Resistencia 2', '((([CIERRE] + [MAXIMO] + [MINIMO]) / 3) - ((([CIERRE] + [MAXIMO] + [MINIMO]) / 3) - [MAXIMO]) + ((([CIERRE] + [MAXIMO] + [MINIMO]) / 3) - [MINIMO]))');
INSERT INTO INDICADORES (NOMBRE, DESCRIPCION, FORMULA) VALUES ('S2', 'Resistencia 2', '((([CIERRE] + [MAXIMO] + [MINIMO]) / 3) - ((([CIERRE] + [MAXIMO] + [MINIMO]) / 3) - [MINIMO]) + ((([CIERRE] + [MAXIMO] + [MINIMO]) / 3) - [MAXIMO]))');

DROP TABLE IF EXISTS FICHEROS_TRATADOS;
CREATE TABLE FICHEROS_TRATADOS(
    FICHERO VARCHAR(100) NOT NULL,
    NUM_REG SMALLINT     NOT NULL,
    FECHA   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (FICHERO)
);


COMMIT;