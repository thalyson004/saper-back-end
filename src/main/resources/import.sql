INSERT INTO CLIENT(NAME, LOGIN, PASSWORD) VALUES ('Thalyson','thalyson','$2a$10$2ODjUI91o0GT5ljchh36t.FuuS8t129qGOFNFLIJP6bA2mPITHdTW');
INSERT INTO STUDENT(PAID, REGISTRATION, CLIENT_ID) VALUES (0, '20220001', 1);

INSERT INTO CLIENT(NAME, LOGIN, PASSWORD) VALUES ('Saulo','saulo', '$2a$10$2ODjUI91o0GT5ljchh36t.FuuS8t129qGOFNFLIJP6bA2mPITHdTW');
INSERT INTO STUDENT(PAID, REGISTRATION, CLIENT_ID) VALUES (0, '20220002', 2);

INSERT INTO CLIENT(NAME, LOGIN, PASSWORD) VALUES ('Adriano', 'adriano', '$2a$10$2ODjUI91o0GT5ljchh36t.FuuS8t129qGOFNFLIJP6bA2mPITHdTW');
INSERT INTO STUDENT(PAID, REGISTRATION, CLIENT_ID) VALUES (0, '20220003', 3);

INSERT INTO BOX(CAPACITY, CREATED_BY, NAME) VALUES (30,'Thalyson','BinoBox');
INSERT INTO BOX(CAPACITY, CREATED_BY, NAME) VALUES (20,'Thalyson','BinoBox Fortaleza');
INSERT INTO BOX(CAPACITY, CREATED_BY, NAME) VALUES (50,'Saulo','SaBox');

INSERT INTO TEAM(SCHEDULE, BOX_ID) VALUES ('246_19', 1);
INSERT INTO TEAM(SCHEDULE, BOX_ID) VALUES ('35_09', 2);
INSERT INTO TEAM(SCHEDULE, BOX_ID) VALUES ('35_19', 1);