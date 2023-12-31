CREATE TABLE _user
(
    id         INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email      VARCHAR(255),
    password   VARCHAR(255),
    role       VARCHAR(255),
    CONSTRAINT pk__user PRIMARY KEY (id)
);

ALTER TABLE _user
    ADD CONSTRAINT uc__user_email UNIQUE (email);