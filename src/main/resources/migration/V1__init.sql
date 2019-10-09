
/*
CREATE table address (
id  bigint PRIMARY KEY AUTO_INCREMENT,

city varchar (20),
country varchar (20),
street varchar (20),
zip_code varchar (7)

);
CREATE table users  (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    address bigint,
    login varchar(255),
    first_name varchar(24),
    sure_name varchar(24),
    FOREIGN KEY (address) REFERENCES address(id)
);*/