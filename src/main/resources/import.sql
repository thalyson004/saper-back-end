INSERT INTO ROLE(ROLE) VALUES ('ROLE_ADMIN');
INSERT INTO ROLE(ROLE) VALUES ('ROLE_PROFESSOR');
INSERT INTO ROLE(ROLE) VALUES ('ROLE_USER');

INSERT INTO CLIENT(NAME, LOGIN, PASSWORD) VALUES ('Thalyson','thalyson','$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
INSERT INTO STUDENT(PAID, REGISTRATION, CLIENT_ID) VALUES (0, '20220001', 1);
INSERT INTO CLIENT_ROLE(CLIENT_ID, ROLE_ID) VALUES (1, 1);

INSERT INTO CLIENT(NAME, LOGIN, PASSWORD) VALUES ('Saulo','saulo', '$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
INSERT INTO STUDENT(PAID, REGISTRATION, CLIENT_ID) VALUES (0, '20220002', 2);
INSERT INTO CLIENT_ROLE(CLIENT_ID, ROLE_ID) VALUES (2, 2);

INSERT INTO CLIENT(NAME, LOGIN, PASSWORD) VALUES ('Adriano', 'adriano', '$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
INSERT INTO STUDENT(PAID, REGISTRATION, CLIENT_ID) VALUES (0, '20220003', 3);
INSERT INTO CLIENT_ROLE(CLIENT_ID, ROLE_ID) VALUES (3, 3);

INSERT INTO BOX(CAPACITY, CREATED_BY, NAME) VALUES (1,'Thalyson','BinoBox');
INSERT INTO BOX(CAPACITY, CREATED_BY, NAME) VALUES (2,'Thalyson','BinoBox Fortaleza');
INSERT INTO BOX(CAPACITY, CREATED_BY, NAME) VALUES (50,'Saulo','SaBox');

INSERT INTO TEAM(SCHEDULE, BOX_ID) VALUES ('246_19', 1);
INSERT INTO TEAM(SCHEDULE, BOX_ID) VALUES ('35_09', 2);

INSERT INTO ENROLLMENT(STUDENT_ID, TEAM_ID) VALUES (2, 1);
INSERT INTO ENROLLMENT(STUDENT_ID, TEAM_ID) VALUES (2, 2);