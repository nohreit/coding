use Trulia_Real_Estate;
 insert ListingAgent(AgentID, FirstName, Lastname, MobileNumber, Email, CommissionRate)
 value('201',	'Miley', 'Cyrus',	'929-934-0911',	'mileycyrus@gmail.com',	'0.08'),
('202', 'Belcalis', 'MarlenisAlmánzar'	,'646-320-7844'	,'CardiB@gmail.com' ,'0.15'),
('203', 'Elton', 'John',	'442-473-6620',	'EltonJohn2@yahoo.com',	'0.15'),
('204','John','Legend','949-812-5377','JohnLegen@outlook.com', '0.125');

insert user(UserID, FirstName, LastName, City, Email, Password, MobileNumber, ProfilePicture, UserType, AgentID)
value('100', 'Denzel', 'Washington', 'New York', 'dwashny@gmail.com', 'dw34!@lc11209cd13#!nnms&1', '646-389-4509', 'NULL','Homebuyer','202'),
('101',	'Tom',	'Holland', 'Salt Lake City', 'tmholl@spidey.com', 's34ped!id!&elods$dmey',	'319-450-8977',	'NULL',	'Homebuyer',	'201'),
('102', 'Rosario', 'Dawson', 'New York', 'rodason12@outlook.com', 'roro23!$da!3C309!&sm2!!',	'646-290-4577',	'NULL',	'Renter', '202'),
('103', 'Robert', 'Downey JR', 'Los Angeles', 'rodojr@aol.com', 'I3$R2$Omh3Npl3A!mnd3!N',	'713-546-0988',	'NULL',	'Homebuyer',	'203'),
('104', 'Chris', 'Evans', 'Boston', 'capman43@gmail.com','Cap$R2$t3anpl45Ac!md$%nain',	'347-098-4599',	'NULL',	'Homebuyer',	'204'),
('105', 'Leonardo', 'DiCaprio', 'Boston', 'LeoDio!@hotmail.com', 'L90emn$!odbhdCap3Eio!$00',	'305-893-5610',	'NULL',	'Homeseller',	'203'),
('106', 'James', 'Earl Jones', 'Houston', 'JamesEarl99@aol.com', 'Je45ear!$lo67hjop2FFisi!&$78',	'615-983-8700',	'NULL','Homeseller',	'202'),
('107', 'Jamie', 'Chung', 'Denver', 'JChun100@gamil.com', 'J821ch!88odclok3hun!$7c1',	'929-210-3387',	'NULL',	'Homeseller',	'204'),
('108', 'Zoe', 'Saldana', 'San Francisco', 'ZoeSalds@avatar.com', 'za5678#oicePi390nevamind',	'713-932-1112',	'NULL',	'Homebuyer',	'203'),
('109', 'Mahershala', 'ALI', 'South Park', 'MahAlide@gmail.com', 'Ma67$!c390AL5600IMc2',	'646-723-5400',	'NULL',	'Homeseller',	'201'),
('110', 'Ken', 'Jeong', 'Salt Lake City', 'kenJeoMD@hangover.com', 'Ke$kno32ingccc3$$%hango2',	'405-689-4299',	'NULL',	'Homeseller',	'202'),
('111', 'Danny', 'Trejo','Austin', 'DanTrelo@mafia.com', 'D$390Can#903&0$Telod!ma',	'201-539-7713',	'NULL',	'Homeseller',	'201'),
('112', 'Zendaya', 'Stoermer', 'Austin', 'ZendaStoe@gmail.com', 'loZm%$dalokdnkj$!llionk',	'929-234-1735',	'NULL', 'Homeseller',	'203'),
('113', 'Shohreh', 'Aghdashloo', 'Reno', 'ShorAgh@hotmail.com', 'Smlhjcbgehbehk3459$!ok',	'705-145-6004',	'NULL',	'Homebuyer', '204'),
('114', 'Jennifer', 'Lawrence', 'Seattle', 'JenLawcs@outlook.com', 'Anjlp$gy&lawnjh3ren35$!@',	'646-454-6321',	'NULL',	'Homeseller', '204'),
('115', 'Will ', 'Smith', 'San Francisco', 'willSmi@entanglement.com', 'kl!$EnT5089ang323i$512!',	'403-333-2642',	'NULL',	'Homeseller', '202');

insert property(PropertyID, PropertyType, Address, City, State, Zipcode, PropertyPrice, PropertyListingDate, HoaAmount, NumberOfBedrooms, NumberOfBathrooms, PropertySQFT, Description, PropertyPicture, UserID, AgentID)
value('Condo100',	'Condo',	'10 Little West St #22D',	'New York',	'NY',	'10280',	'1174000',	'2019-12-15','1245',	'1',	'1', '807',	'Water front view with a view of the Statue of liberty and near transportation and close to bars and resturants', 'NULL',	'114', '204'),
('Condo2045',	'Condo',	'11948 E White Water Ln',	'Malibu',	'CA',	'90625',	'1350000',	'2019-12-15',	'398',	'2',	'2',	'1075',	'Beach front property with indoor gym and pool in malibu',	'NULL',	'115',	'202'),
('SingleF983',	'Single Family',	'3639 Diamond Head Rd',	'Honolulu',	'HI',	'96701',	'15800000',	'2020-01-02',	'0',	'3',	'5',	'3168',	'Beach front property with indoor gym and pool near shops and bars',	'NULL',	'106',	'202'),
('Condo201',	'Condo',	'56-155 E Kamehameha Hwy',	'Kahuku',	'HI',	'96731',	'2695000',	'2020-01-10',	'0',	'3',	'2',	'1292',	'Mountain view property in a quiet community',	'NULL',	'110',	'202'),
('TownH345',	'Town House',	'4005 San Donato Loop', 'Reno',	'NV',	'89502',	'537000',	'2020-01-16',	'270',	'3',	'3',	'2164',	'Small town living with a big heart.',	'NULL',	'111',	'201'),
('SingleF913',	'Single Family',	'1432 Palm Ave SW',	'Seatlle',	'WA',	'98116',	'2195000',	'2020-01-17',	'0',	'4',	'4',	'3815', 'Waterfront view with a backyard and moder appliances',	'NULL',	'112',	'204'),
('SingleF914',	'Single Family',	'466 Elizabeth St',	'San Francisco',	'CA',	'94132',	'2495000',	'2020-02-10',	'873',	'5',	'4.5',	'4170',	'Rear opportuntity to live a great city beautiful single family home in a LGBTQIA friendly community',	'NULL',	'115',	'202'),
('Condo5433',	'Condo',	'300 Pier 4 Blvd #7C',	'Boston',	'MA', '2115', '6988500',	'2020-02-14',	'4260',	'3',	'4',	'2255',	'Seaport views near historical grounds and harvard university',	'NULL',	'105',	'203'),
('TownH346',	'Town House',	'75 Howard St #307',	'San Francisco',	'CA',	'94105',	'1395000',	'2020-02-14',	'0',	'1',	'1', '917',	'Rear opportuntity to live a great city beautiful townhome in a LGBTQIA friendly community',	'NULL',	'109',	'201'),
('SingleF916',	'Single Family',	'10 W San Marino Dr',	'Miami Beach',	'FL',	'33139',	'23500000',	'2020-02-14',	'0',	'6',	'7',	'7159',	'Beach front property in a gate community',	'NULL',	'106',	'202'),
('Apartment101',	'Apartment',	'380 Rector Pl APT 17E',	'New York',	'NY',	'10280',	'3700',	'2020-02-14',	'0',	'1',	'1',	'735',	'Water front view in heart of new york city and public transportation and close to bars and resturants',	'NULL',	'NULL',	'202'),
('Apartment102',	'Apartment',	'2102 Paisano Rd',	'Austin',	'TX',	'78746',	'10000',	'2020-03-01',	'0',	'5',	'3.5',	'3346',	'City living in a great building with an indoor pool, doorman and gym',	'NULL',	'NULL',	'204'),
('Apartment103',	'Apartment',	'3411 Yoakum Blvd unit ',	'Houston',	'TX',	'77006',	'2600',	'2020-03-02',	'0',	'1',	'1',	'870', 'City living in a great building with an indoor pool, doorman and gym',	'NULL',	'NULL',	'201'),
('Apartment104',	'Apartment',	'2717 Western Ave',	'Seatlle',	'WA',	'98121',	'2900',	'2020-03-03',	'0',	'2',	'1',	'818',	'Beautiful mountain views in the heart of the town',	'NULL',	'NULL',	'203'),
('SingleF915',	'Single Family',	'7225 Birdview Ave',	'Malibu',	'CA',	'90265',	'18000000',	'2020-03-04',	'1194',	'5',	'6',	'4500',	'Beach from property in malibu near shops and resturants',	'NULL',	'105',	'203');

insert Feature(FeatureID, FeatureName, Description, PropertyID)
value('SF983',	'Sit, watch the sunset on the beach',	'Take a lounge chair,  watch the sunset just steps from your home or see the star', 'SingleF983'),
('SF915',	'Sit, watch the sunset on the beach in malibu',	'Take a lounge chair, go to the beach and watch the sunset just steps from your home', 'SingleF915'),
('TH346',	'Party and be free',	'Go party and be yourself and explore the town in this LGBTQIA community', 'TownH346'),
('CO100',	'View of the Statue of liberty as you wake up', 	'Step out in your balcony and watch the sunset with the statue of liberty as your muse', 'Condo100');


SELECT * FROM ListingAgent
WHERE CommissionRate < 10;
