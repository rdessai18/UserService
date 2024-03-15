CREATE TABLE `role`
(
    role_id   BIGINT AUTO_INCREMENT NOT NULL,
    role_name VARCHAR(255) NULL,
    CONSTRAINT pk_role PRIMARY KEY (role_id)
);

CREATE TABLE user
(
    user_id         BIGINT AUTO_INCREMENT NOT NULL,
    name            VARCHAR(255) NULL,
    email           VARCHAR(255) NULL,
    email_verified  BIT(1) NOT NULL,
    hashed_password VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE user_roles
(
    role_role_id BIGINT NOT NULL,
    user_user_id BIGINT NOT NULL
);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_role_id) REFERENCES `role` (role_id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_user_id) REFERENCES user (user_id);