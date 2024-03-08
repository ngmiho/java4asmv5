----CREATE DATABASE----
CREATE DATABASE oe

----USE DATABASE----
USE oe
----CREATE TABLE----


CREATE TABLE [Users] (
	Id varchar(5) primary key,
	Username varchar(10) unique NOT NULL,
	Password varchar(50) NOT NULL,
	Email varchar(100) unique NOT NULL,
	FirstName nvarchar(10) NOT NULL,
	LastName nvarchar(30) NOT NULL, 
	Gender int NOT NULL,
	Birthday date NOT NULL,
	Role bit NOT NULL
)

CREATE TABLE Videos (
	Id varchar(5) primary key,
	Title nvarchar(100) NOT NULL,
	Detail nvarchar(255),
	[Status] int NOT NULL,
	Note nvarchar(255),
	Href varchar(255) NOT NULL
)

CREATE TABLE [Likes] (
	Id int PRIMARY KEY IDENTITY,
	UserId varchar(5) NOT NULL,
	VideoId varchar(5) NOT NULL,
	LikeDate date NOT NULL,
	CONSTRAINT UserLikeId FOREIGN KEY (UserId) REFERENCES Users(Id),
	CONSTRAINT VideoLikeId FOREIGN KEY (VideoId) REFERENCES Videos(Id)
)

CREATE TABLE Shares (
	Id int PRIMARY KEY IDENTITY,
	UserId varchar(5) NOT NULL,
	VideoId varchar(5) NOT NULL,
	Emails varchar(255) NOT NULL,
	ShareDate date NOT NULL,
	CONSTRAINT UserShareId FOREIGN KEY (UserId) REFERENCES Users(Id),
	CONSTRAINT VideoShareId FOREIGN KEY (VideoId) REFERENCES Videos(Id)
)


CREATE TABLE Edits (
	Id int PRIMARY KEY IDENTITY,
	UserId varchar(5) NOT NULL,
	VideoID varchar(5) NOT NULL,
	CreateDay date NOT NULL,
	Editor varchar(5) NOT NULL, 
	EditDay date NOT NULL,
	CONSTRAINT UserEditId FOREIGN KEY (UserId) REFERENCES Users(Id),
	CONSTRAINT VideoEditId FOREIGN KEY (VideoID) REFERENCES Videos(Id)
)


SELECT v.Id, v.Title, v.Href, sum(cast(l.IsLike as int)) as totalLike
FROM Videos v left join Likes l on v.id = l.VideoId
WHERE v.Status = 1
GROUP BY v.Id, v.Title, v.Href
ORDER BY sum(cast(l.IsLike as int)) DESC