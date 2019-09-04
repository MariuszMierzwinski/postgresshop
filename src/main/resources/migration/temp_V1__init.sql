CREATE table users  (
    id bigint PRIMARY KEY AUTO_INCREMENT,

    login varchar(255),
    first_name varchar(24),
    sure_name varchar(24)
);

CREATE table address (
id  bigint PRIMARY KEY AUTO_INCREMENT,
user bigint,
city varchar (20),
country varchar (20),
street varchar (20),
zip_code varchar (7),
FOREIGN KEY (user) REFERENCES users(id)
);
