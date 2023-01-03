--liquibase formatted sql

--changeset Lucas Machado:1
--comment: Project Start
CREATE TABLE my_bank.user (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date TIMESTAMP NOT NULL,
    created_date TIMESTAMP NOT NULL
);

CREATE TABLE my_bank.account_type (
    id SERIAL PRIMARY KEY,
    description VARCHAR(50) NOT NULL
);

CREATE TABLE my_bank.account (
    id SERIAL PRIMARY KEY,
    id_type INT NOT NULL,
    id_user INT NOT NULL,
    money DECIMAL(15,2) NOT NULL,
    authorized BOOLEAN NOT NULL,
    created_date TIMESTAMP NOT NULL,
    FOREIGN KEY (id_type) REFERENCES my_bank.account_type (id),
    FOREIGN KEY (id_user) REFERENCES my_bank.user (id)
);

INSERT INTO my_bank.account_type(description) VALUES ('Saving');
INSERT INTO my_bank.account_type(description) VALUES ('Checking');