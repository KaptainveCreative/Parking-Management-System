CREATE TABLE companies
(
    id           INT AUTO_INCREMENT NOT NULL,
    company_name VARCHAR(45) NOT NULL,
    CONSTRAINT pk_companies PRIMARY KEY (id)
);

CREATE TABLE parkingspots
(
    id         INT AUTO_INCREMENT NOT NULL,
    zipcode    INT         NOT NULL,
    price      DOUBLE      NOT NULL,
    rating     INT         NOT NULL,
    status     VARCHAR(50) NOT NULL,
    state      VARCHAR(50) NOT NULL,
    date       datetime NULL,
    quantity   INT         NOT NULL,
    company_id INT         NOT NULL,
    CONSTRAINT pk_parkingspots PRIMARY KEY (id)
);

CREATE TABLE reservations
(
    id              INT AUTO_INCREMENT NOT NULL,
    zipcode         INT NOT NULL,
    date            datetime NULL,
    users_id        INT NOT NULL,
    parkingspots_id INT NOT NULL,
    CONSTRAINT pk_reservations PRIMARY KEY (id)
);

CREATE TABLE reviews
(
    id               INT AUTO_INCREMENT NOT NULL,
    customer_name    VARCHAR(255) NOT NULL,
    customer_reviews LONGTEXT NULL,
    company_id       INT NULL,
    CONSTRAINT pk_reviews PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
    id        INT AUTO_INCREMENT NOT NULL,
    user_id   INT NULL,
    user_role VARCHAR(255) NULL,
    CONSTRAINT pk_user_roles PRIMARY KEY (id)
);

CREATE TABLE users
(
    id             INT AUTO_INCREMENT NOT NULL,
    first_name     VARCHAR(255) NOT NULL,
    last_name      VARCHAR(255) NOT NULL,
    email          VARCHAR(255) NOT NULL,
    payment_method VARCHAR(255) NULL,
    phone_number   VARCHAR(255) NULL,
    date           datetime NULL,
    password       VARCHAR(64)  NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE parkingspots
    ADD CONSTRAINT FK_PARKINGSPOTS_ON_COMPANY FOREIGN KEY (company_id) REFERENCES companies (id);

ALTER TABLE reservations
    ADD CONSTRAINT FK_RESERVATIONS_ON_PARKINGSPOTS FOREIGN KEY (parkingspots_id) REFERENCES parkingspots (id);

ALTER TABLE reservations
    ADD CONSTRAINT FK_RESERVATIONS_ON_USERS FOREIGN KEY (users_id) REFERENCES users (id);

ALTER TABLE reviews
    ADD CONSTRAINT FK_REVIEWS_ON_COMPANY FOREIGN KEY (company_id) REFERENCES companies (id);