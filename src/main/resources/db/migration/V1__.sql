CREATE TABLE category
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NOT NULL,
    name            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE join_table_instructor
(
    user_id BIGINT NOT NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_jointable_instructor PRIMARY KEY (user_id)
);

CREATE TABLE join_table_mentor
(
    user_id        BIGINT NOT NULL,
    no_of_sessions INT    NOT NULL,
    CONSTRAINT pk_jointable_mentor PRIMARY KEY (user_id)
);

CREATE TABLE join_table_ta
(
    user_id   BIGINT NOT NULL,
    grad_year INT    NOT NULL,
    CONSTRAINT pk_jointable_ta PRIMARY KEY (user_id)
);

CREATE TABLE join_table_user
(
    id    BIGINT NOT NULL,
    email VARCHAR(255) NULL,
    name  VARCHAR(255) NULL,
    CONSTRAINT pk_jointable_user PRIMARY KEY (id)
);

CREATE TABLE mapped_super_instructor
(
    id      BIGINT NOT NULL,
    email   VARCHAR(255) NULL,
    name    VARCHAR(255) NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_mappedsuper_instructor PRIMARY KEY (id)
);

CREATE TABLE mapped_super_mentor
(
    id             BIGINT NOT NULL,
    email          VARCHAR(255) NULL,
    name           VARCHAR(255) NULL,
    no_of_sessions INT    NOT NULL,
    CONSTRAINT pk_mappedsuper_mentor PRIMARY KEY (id)
);

CREATE TABLE mapped_super_ta
(
    id        BIGINT NOT NULL,
    email     VARCHAR(255) NULL,
    name      VARCHAR(255) NULL,
    grad_year INT    NOT NULL,
    CONSTRAINT pk_mappedsuper_ta PRIMARY KEY (id)
);

CREATE TABLE product
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NOT NULL,
    title           VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    `description`   VARCHAR(255) NULL,
    category_id     BIGINT NULL,
    image           VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE single_table_user
(
    id             BIGINT NOT NULL,
    user_type      INT NULL,
    email          VARCHAR(255) NULL,
    name           VARCHAR(255) NULL,
    company        VARCHAR(255) NULL,
    grad_year      INT    NOT NULL,
    no_of_sessions INT    NOT NULL,
    CONSTRAINT pk_singletable_user PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id      BIGINT NOT NULL,
    email   VARCHAR(255) NULL,
    name    VARCHAR(255) NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id             BIGINT NOT NULL,
    email          VARCHAR(255) NULL,
    name           VARCHAR(255) NULL,
    no_of_sessions INT    NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id        BIGINT NOT NULL,
    email     VARCHAR(255) NULL,
    name      VARCHAR(255) NULL,
    grad_year INT    NOT NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id    BIGINT NOT NULL,
    email VARCHAR(255) NULL,
    name  VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE join_table_instructor
    ADD CONSTRAINT FK_JOINTABLE_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES join_table_user (id);

ALTER TABLE join_table_mentor
    ADD CONSTRAINT FK_JOINTABLE_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES join_table_user (id);

ALTER TABLE join_table_ta
    ADD CONSTRAINT FK_JOINTABLE_TA_ON_USER FOREIGN KEY (user_id) REFERENCES join_table_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);