create database Trulia_Real_Estate;
#drop database Trulia_Real_Estate;
use Trulia_Real_Estate;



Create Table ListingAgent (
AgentID char(10) not null Primary key, 
FirstName varchar(25) not null,
LastName varchar(25),
mobilenumber varchar(12),
Email VARCHAR(45) NOT NULL,  
CommissionRate DOUBLE

#depending on input (number/words) INT/VARCHAR was assigned and not null as they are important. Iffatara Smaran
);

CREATE TABLE User (
userID char(10) primary key,  #UserID is unique for which it is not null and assigned as primary key.
FirstName varchar(25) not null,
LastName varchar(25),
City varchar(30) not null,
email varchar(40) not null,
Password varchar(30) not null,  #using Varchar to get input that may include any charcter.
mobilenumber varchar(12),#int for integers. Iffatara Smaran
ProfilePicture BLOB NOT NULL, #using datatype blob for image storage. Iffatara Smaran
AgentID char(10) not null, #int for integers. Iffatara Smaran
UserType ENUM('Renter', 'Homebuyer', 'HomeSeller'), # using ENUM for specific answers from given options. Iffatara Smaran
foreign key(AgentID) references ListingAgent(AgentID)
);

Create table Property(
PropertyID char(20)not null primary key,
PropertyType varchar(25) not null,
address varchar(50)not null,
City varchar(25)not null,
state varchar(25)not null,
Zipcode varchar(6)not null,
PropertyPrice double not null ,
PropertyListingDate Date not null ,
HoaAmount double not null,
NumberOfBedrooms int not null,
NumberOfBathrooms Double not null,
PropertySQFT double not null,
Description varchar(200),
PropertyPicture BLOB not null,
 userID char(10) not null,
 AgentID char(10) not null, 
 foreign key(userID) references User(userID),
 foreign key(AgentID) references ListingAgent(AgentID)
);



Create Table Feature (
FeatureID char(10) primary key,
FeatureName varchar(60),
description varchar(200),  # text is not case sensitive and can take large characters for descriptions. Iffatara Smaran
PropertyID char(10) not null, 
foreign key(PropertyID) references Property (PropertyID)
); #depending on input (number/words) INT/VARCHAR was assigned and not null as they are important. Iffatara Smaran

