drop database if exists trulia_real_estate;

create schema trulia_real_estate charset utf8;

use trulia_real_estate;

Create Table ListingAgent (
	agentID char(10) not null Primary key, 
	firstName varchar(25) not null,
	lastName varchar(25),
	mobilenumber varchar(12),
	email VARCHAR(45) NOT NULL,  
	commissionRate DOUBLE

	#depending on input (number/words) INT/VARCHAR was assigned and not null as they are important. Iffatara Smaran
) engine = InnoDB;

CREATE TABLE User (
	userID char(10) primary key,  #UserID is unique for which it is not null and assigned as primary key.
	firstName varchar(25) not null,
	lastName varchar(25),
	city varchar(30) not null,
	email varchar(40) not null,
	password varchar(30) not null,  #using Varchar to get input that may include any charcter.
	mobilenumber varchar(12),#int for integers. Iffatara Smaran
	profilePicture BLOB NOT NULL, #using datatype blob for image storage. Iffatara Smaran
	agentID char(10) not null, #int for integers. Iffatara Smaran
	userType ENUM('Renter', 'Homebuyer', 'HomeSeller'), # using ENUM for specific answers from given options. Iffatara Smaran
	foreign key (agentID) references ListingAgent(agentID)
) engine = InnoDB;

Create table Property(
	propertyID char(20)not null primary key,
	propertyType varchar(25) not null,
	address varchar(50)not null,
	city varchar(25)not null,
	state varchar(25)not null,
	zipcode varchar(6)not null,
	propertyPrice double not null ,
	propertyListingDate Date not null ,
	hoaAmount double not null,
	numberOfBedrooms int not null,
	numberOfBathrooms Double not null,
	propertySQFT double not null,
	description varchar(200),
	propertyPicture BLOB not null,
	userID char(10) not null,
	agentID char(10) not null, 
	foreign key (userID) references User(userID),
	foreign key (agentID) references ListingAgent(agentID)
) engine = InnoDB;

Create Table Feature (
	featureID char(10) primary key,
	featureName varchar(60),
	description varchar(200),  # text is not case sensitive and can take large characters for descriptions. Iffatara Smaran
	propertyID char(10) not null,
	foreign key (propertyID) references Property (propertyID)
) engine = InnoDB; #depending on input (number/words) INT/VARCHAR was assigned and not null as they are important. Iffatara Smaran

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT;
SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS;
SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION;
SET SQL_NOTES=@OLD_SQL_NOTES; 
