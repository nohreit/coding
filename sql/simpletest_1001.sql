drop database if exists simpletest1001;

create schema if not exists simpletest1001;

use simpletest1001;

CREATE TABLE T1 (
    P INT PRIMARY KEY NOT NULL,
    N VARCHAR(10),
    I INT
);

insert into T1 values 
	(001, 'entry1', 101),
	(002, 'entry2', 102),
	(003, 'entry3', 103);

CREATE TABLE T2 (
    P INT PRIMARY KEY NOT NULL,
    N VARCHAR(10),
    I INT
);

insert into T2 values
	(101, 'row1', 001),
    (102, 'row2', 002),
    (103, 'row3', 003);

SELECT 
    *
FROM
    T1
        JOIN
    T2 ON T1.P = T2.I;
    
    
    
    
    
    