CREATE TABLE users
(ID INT,
name VARCHAR,
surname VARCHAR,
grpnumber VARCHAR,
login VARCHAR,
password VARCHAR,
role VARCHAR);

CREATE TABLE lessons
(id SERIAL PRIMARY KEY,
week VARCHAR,
dayweek VARCHAR,
pairnumber VARCHAR,
timestart TIME,
timeend  TIME,
classroomnumber VARCHAR,
object VARCHAR,
typeobject VARCHAR,
educator VARCHAR,
groups VARCHAR);
