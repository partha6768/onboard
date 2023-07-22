DROP TABLE BOOKING_CANCELLATION;
DROP TABLE SHOW_CALENDAR_SEAT_BOOKING;
DROP TABLE BOOKING;
DROP TABLE BOOKING_STATUS;
DROP TABLE SHOW_CALENDAR_PRICE;
DROP TABLE SHOW_CALENDAR;
DROP TABLE `SHOW`;
DROP TABLE MOVIE_VIEW_TYPE;
DROP TABLE MOVIE;
DROP TABLE SEAT;
DROP TABLE SCREEN_SEAT_TYPE;
DROP TABLE SCREEN;
DROP TABLE THEATER;
DROP TABLE USER;
DROP TABLE CITY;
DROP TABLE REFUND_STATUS;
DROP TABLE USER_TYPE;
DROP TABLE VIEW_TYPE;
DROP TABLE AUDIO_TYPE;
DROP TABLE MOVIE_TYPE;
DROP TABLE `LANGUAGE`;
DROP TABLE SEAT_TYPE;
DROP TABLE SEAT_STATUS;


-- DROP TABLE USER_TYPE;
CREATE TABLE USER_TYPE(NAME VARCHAR(15) NOT NULL PRIMARY KEY,BUSINESS_CATEGORY VARCHAR(7) NOT NULL, created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP());
INSERT INTO USER_TYPE(NAME,BUSINESS_CATEGORY) VALUES('Vendor', 'B2B');
INSERT INTO USER_TYPE(NAME, BUSINESS_CATEGORY) VALUES('Customer', 'B2C');

-- DROP TABLE VIEW_TYPE;
CREATE TABLE VIEW_TYPE(NAME VARCHAR(7) NOT NULL PRIMARY KEY,created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP());
INSERT INTO VIEW_TYPE(NAME) VALUES('2D');
INSERT INTO VIEW_TYPE(NAME) VALUES('3D');

-- DROP TABLE AUDIO_TYPE;
CREATE TABLE AUDIO_TYPE(NAME VARCHAR(15) NOT NULL PRIMARY KEY,created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP());
INSERT INTO AUDIO_TYPE(NAME) VALUES('Standard');
INSERT INTO AUDIO_TYPE(NAME) VALUES('DOLBY');


-- DROP TABLE MOVIE_TYPE;
CREATE TABLE MOVIE_TYPE(NAME VARCHAR(31) NOT NULL PRIMARY KEY,created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP());
INSERT INTO MOVIE_TYPE(NAME) VALUES('Movie');
INSERT INTO MOVIE_TYPE(NAME) VALUES('Cricket Match');


-- DROP TABLE `LANGUAGE`;
CREATE TABLE `LANGUAGE`(NAME VARCHAR(15) NOT NULL PRIMARY KEY,created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP());
INSERT INTO `LANGUAGE`(NAME) VALUES('English');
INSERT INTO `LANGUAGE`(NAME) VALUES('Hindi');

-- DROP TABLE SEAT_TYPE;
CREATE TABLE SEAT_TYPE(NAME VARCHAR(15) NOT NULL PRIMARY KEY,created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP());
INSERT INTO SEAT_TYPE(NAME) VALUES('Standard');
INSERT INTO SEAT_TYPE(NAME) VALUES('Elite');
INSERT INTO SEAT_TYPE(NAME) VALUES('Club');


-- DROP TABLE CITY;
CREATE TABLE CITY(
                     ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                     NAME VARCHAR(31) NOT NULL,
                     STATE VARCHAR(31) NOT NULL,
                     COUNTRY VARCHAR(31) NOT NULL,
                     IS_ACTIVE BOOL NOT NULL,
                     CREATED_TS DATETIME NOT NULL,
                     UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

INSERT INTO CITY(NAME, STATE, COUNTRY, IS_ACTIVE,CREATED_TS) VALUES ('Bhuabneswar', 'Odisha', 'India', TRUE, CURRENT_TIMESTAMP());
INSERT INTO CITY(NAME, STATE, COUNTRY, IS_ACTIVE,CREATED_TS) VALUES ('Bengaluru', 'Karnataka', 'India', TRUE, CURRENT_TIMESTAMP());
INSERT INTO CITY(NAME, STATE, COUNTRY, IS_ACTIVE,CREATED_TS) VALUES ('Chennai', 'Tamil Nadu', 'India', TRUE, CURRENT_TIMESTAMP());

-- DROP TABLE USER;
CREATE TABLE USER(
                     ID VARCHAR(255) NOT NULL PRIMARY KEY,
                     NAME VARCHAR(255) NOT NULL,
                     USER_TYPE_NAME VARCHAR(63) NOT NULL,
                     EMAIL VARCHAR(255) NOT NULL,
                     MOBILE VARCHAR(31) NOT NULL,
                     IS_ACTIVE BOOL NOT NULL,
                     CREATED_TS DATETIME NOT NULL,
                     UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                     FOREIGN KEY (USER_TYPE_NAME) REFERENCES USER_TYPE(NAME)
);

INSERT INTO USER(ID, NAME,USER_TYPE_NAME,EMAIL,MOBILE,IS_ACTIVE,CREATED_TS) VALUES ('parthasarathi6768@gmail.com', 'Partha', 'Customer', 'parthasarathi6768@gmail.com', '9600575822', TRUE, CURRENT_TIMESTAMP());
INSERT INTO USER(ID, NAME,USER_TYPE_NAME,EMAIL,MOBILE,IS_ACTIVE,CREATED_TS) VALUES ('parthasarathi8676@gmail.com', 'Vendor Partha', 'Vendor', 'parthasarathi8676@gmail.com','9600575822', TRUE, CURRENT_TIMESTAMP());

-- DROP TABLE THEATER;
CREATE TABLE THEATER(
                        ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        NAME VARCHAR(255) NOT NULL,
                        DISPLAY_NAME VARCHAR(255) NOT NULL,
                        VENDOR_ID VARCHAR(255) NOT NULL,
                        CITY_ID INT NOT NULL,
                        ADDRESS VARCHAR(4000) NOT NULL,
                        LATITUDE VARCHAR(31) NOT NULL,
                        LONGITUDE VARCHAR(31) NOT NULL,
                        CREATED_TS DATETIME NOT NULL,
                        UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                        FOREIGN KEY (CITY_ID) REFERENCES CITY(ID),
                        FOREIGN KEY (VENDOR_ID) REFERENCES USER(ID)
);

INSERT INTO THEATER (NAME, DISPLAY_NAME, VENDOR_ID, CITY_ID, ADDRESS, LATITUDE, LONGITUDE, CREATED_TS) VALUES
    ('INOX-DN Regalia', 'INOX-DN Regalia', 'parthasarathi8676@gmail.com',1,
     '2nd Floor DN Regalia, Kalinga Vihar, Patrapada, Bhubaneswar, Odisha 751019', '20.24166813170983', '85.75803606136671', CURRENT_TIMESTAMP());

INSERT INTO THEATER (NAME, DISPLAY_NAME, VENDOR_ID, CITY_ID, ADDRESS, LATITUDE, LONGITUDE, CREATED_TS) VALUES
    ('PVR Cinemas Phoenix Marketcity Mall', 'PVR Cinemas Phoenix Marketcity Mall', 'parthasarathi8676@gmail.com',2,
     'Phoenix Marketcity Mall Whitefield Main Road Mahadevpura, Krishnarajapura, Bengaluru, Karnataka 560048',
     '12.998590573071976', '77.69581741534168', CURRENT_TIMESTAMP());


-- DROP TABLE SCREEN;
CREATE TABLE SCREEN(
                       NAME VARCHAR(15) NOT NULL,
                       THEATER_ID INT NOT NULL,
                       VIEW_TYPE_NAME VARCHAR(15) NOT NULL,
                       AUDIO_TYPE_NAME VARCHAR(15) NOT NULL,
                       CREATED_TS DATETIME NOT NULL,
                       UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                       FOREIGN KEY (THEATER_ID) REFERENCES THEATER(ID),
                       PRIMARY KEY (NAME, THEATER_ID)
);

INSERT INTO SCREEN(NAME, THEATER_ID, VIEW_TYPE_NAME, AUDIO_TYPE_NAME, CREATED_TS) VALUES
    ('Screen 1',1, '2D', 'Standard', CURRENT_TIMESTAMP());
INSERT INTO SCREEN(NAME, THEATER_ID, VIEW_TYPE_NAME, AUDIO_TYPE_NAME, CREATED_TS) VALUES
    ('Screen 2',1, '3D', 'DOLBY', CURRENT_TIMESTAMP());

INSERT INTO SCREEN(NAME, THEATER_ID, VIEW_TYPE_NAME, AUDIO_TYPE_NAME, CREATED_TS) VALUES
    ('Screen 1',2, '2D', 'DOLBY', CURRENT_TIMESTAMP());
INSERT INTO SCREEN(NAME, THEATER_ID, VIEW_TYPE_NAME, AUDIO_TYPE_NAME, CREATED_TS) VALUES
    ('Screen 2',2, '3D', 'Standard', CURRENT_TIMESTAMP());
INSERT INTO SCREEN(NAME, THEATER_ID, VIEW_TYPE_NAME, AUDIO_TYPE_NAME, CREATED_TS) VALUES
    ('Screen 3',2, '3D', 'DOLBY', CURRENT_TIMESTAMP());





-- DROP TABLE SCREEN_SEAT_TYPE;
CREATE TABLE SCREEN_SEAT_TYPE(
                                 ID INT PRIMARY KEY AUTO_INCREMENT,
                                 SCREEN_NAME VARCHAR(15),
                                 THEATER_ID INT,
                                 SEAT_TYPE_NAME VARCHAR(15),
                                 CREATED_TS DATETIME NOT NULL,
                                 UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                                 FOREIGN KEY (SCREEN_NAME,THEATER_ID) REFERENCES SCREEN(NAME,THEATER_ID),
                                 FOREIGN KEY (SEAT_TYPE_NAME) REFERENCES SEAT_TYPE(NAME)
);

INSERT INTO SCREEN_SEAT_TYPE ( SCREEN_NAME, THEATER_ID, SEAT_TYPE_NAME, CREATED_TS) VALUES
    ( 'Screen 1', 1, 'Standard', CURRENT_TIMESTAMP());
INSERT INTO SCREEN_SEAT_TYPE (SCREEN_NAME, THEATER_ID, SEAT_TYPE_NAME, CREATED_TS) VALUES
    ('Screen 1', 1, 'Elite', CURRENT_TIMESTAMP());

INSERT INTO SCREEN_SEAT_TYPE ( SCREEN_NAME, THEATER_ID, SEAT_TYPE_NAME, CREATED_TS) VALUES
    ( 'Screen 2', 1, 'Standard', CURRENT_TIMESTAMP());
INSERT INTO SCREEN_SEAT_TYPE (SCREEN_NAME, THEATER_ID, SEAT_TYPE_NAME, CREATED_TS) VALUES
    ('Screen 2', 1, 'Club', CURRENT_TIMESTAMP());

INSERT INTO SCREEN_SEAT_TYPE ( SCREEN_NAME, THEATER_ID, SEAT_TYPE_NAME, CREATED_TS) VALUES
    ( 'Screen 1', 2, 'Standard', CURRENT_TIMESTAMP());
INSERT INTO SCREEN_SEAT_TYPE (SCREEN_NAME, THEATER_ID, SEAT_TYPE_NAME, CREATED_TS) VALUES
    ('Screen 1', 2, 'Elite', CURRENT_TIMESTAMP());

INSERT INTO SCREEN_SEAT_TYPE ( SCREEN_NAME, THEATER_ID, SEAT_TYPE_NAME, CREATED_TS) VALUES
    ( 'Screen 2', 2, 'Standard', CURRENT_TIMESTAMP());
INSERT INTO SCREEN_SEAT_TYPE (SCREEN_NAME, THEATER_ID, SEAT_TYPE_NAME, CREATED_TS) VALUES
    ('Screen 2', 2, 'Club', CURRENT_TIMESTAMP());

INSERT INTO SCREEN_SEAT_TYPE (SCREEN_NAME, THEATER_ID, SEAT_TYPE_NAME, CREATED_TS) VALUES
    ('Screen 3', 2, 'Club', CURRENT_TIMESTAMP());

-- DROP TABLE SEAT;
CREATE TABLE SEAT(
                     ID INT PRIMARY KEY AUTO_INCREMENT,
                     SCREEN_SEAT_TYPE_ID INT,
                     ROW_NUM INT NOT NULL,
                     COLUMN_NUM INT NOT NULL,
                     IS_SPACE BOOL DEFAULT FALSE,
                     CREATED_TS DATETIME NOT NULL,
                     UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                     FOREIGN KEY (SCREEN_SEAT_TYPE_ID) REFERENCES SCREEN_SEAT_TYPE(ID),
                     UNIQUE(ROW_NUM,COLUMN_NUM,SCREEN_SEAT_TYPE_ID)
);


INSERT INTO SEAT(SCREEN_SEAT_TYPE_ID, ROW_NUM, COLUMN_NUM,CREATED_TS) VALUES(1, 0, 1, CURRENT_TIMESTAMP());
INSERT INTO SEAT(SCREEN_SEAT_TYPE_ID, ROW_NUM, COLUMN_NUM,CREATED_TS) VALUES(1, 0, 2, CURRENT_TIMESTAMP());
INSERT INTO SEAT(SCREEN_SEAT_TYPE_ID, ROW_NUM, COLUMN_NUM,CREATED_TS) VALUES(2, 1, 3, CURRENT_TIMESTAMP());
INSERT INTO SEAT(SCREEN_SEAT_TYPE_ID, ROW_NUM, COLUMN_NUM,CREATED_TS) VALUES(2, 1, 4, CURRENT_TIMESTAMP());

INSERT INTO SEAT(SCREEN_SEAT_TYPE_ID, ROW_NUM, COLUMN_NUM,CREATED_TS) VALUES(5, 0, 1, CURRENT_TIMESTAMP());
INSERT INTO SEAT(SCREEN_SEAT_TYPE_ID, ROW_NUM, COLUMN_NUM,CREATED_TS) VALUES(5, 0, 2, CURRENT_TIMESTAMP());
INSERT INTO SEAT(SCREEN_SEAT_TYPE_ID, ROW_NUM, COLUMN_NUM,CREATED_TS) VALUES(5, 0, 3, CURRENT_TIMESTAMP());
INSERT INTO SEAT(SCREEN_SEAT_TYPE_ID, ROW_NUM, COLUMN_NUM,CREATED_TS) VALUES(5, 0, 4, CURRENT_TIMESTAMP());
INSERT INTO SEAT(SCREEN_SEAT_TYPE_ID, ROW_NUM, COLUMN_NUM,IS_SPACE,CREATED_TS) VALUES(6, 1, 0,TRUE, CURRENT_TIMESTAMP());
INSERT INTO SEAT(SCREEN_SEAT_TYPE_ID, ROW_NUM, COLUMN_NUM,CREATED_TS) VALUES(6, 1, 1, CURRENT_TIMESTAMP());
INSERT INTO SEAT(SCREEN_SEAT_TYPE_ID, ROW_NUM, COLUMN_NUM,CREATED_TS) VALUES(6, 1, 2, CURRENT_TIMESTAMP());
INSERT INTO SEAT(SCREEN_SEAT_TYPE_ID, ROW_NUM, COLUMN_NUM,IS_SPACE,CREATED_TS) VALUES(6, 1, 3,TRUE, CURRENT_TIMESTAMP());

-- DROP TABLE MOVIE;
CREATE TABLE MOVIE(
                      ID INT PRIMARY KEY AUTO_INCREMENT,
                      TITLE VARCHAR(255) NOT NULL,
                      DESCRIPTION VARCHAR(4000) NOT NULL,
                      MOVIE_TYPE_NAME VARCHAR(31) NOT NULL,
                      DURATION VARCHAR(7) NOT NULL,
                      RELEASE_TS DATETIME NOT NULL,
                      GENERE VARCHAR(31) NOT NULL,
                      THUMBNAIL_URL VARCHAR(2048) NOT NULL,
                      TRAILER_URL VARCHAR(2048) NOT NULL,
                      CREATED_TS DATETIME NOT NULL,
                      UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                      FOREIGN KEY (MOVIE_TYPE_NAME) REFERENCES MOVIE_TYPE(NAME)
);


INSERT INTO MOVIE(TITLE, DESCRIPTION, MOVIE_TYPE_NAME, DURATION, RELEASE_TS, GENERE, THUMBNAIL_URL, TRAILER_URL, CREATED_TS) VALUES
    ('Mission: Impossible – Dead Reckoning Part 1', 'Ethan Hunt and the IMF team must track down a terrifying new weapon that threatens all of humanity if it falls into the wrong hands. With control of the future and the fate of the world at stake, a deadly race around the globe begins. Confronted by a mysterious, all-powerful enemy, Ethan is forced to consider that nothing can matter more than the mission -- not even the lives of those he cares about most.',
     'Movie', '2h 43m', CURRENT_TIMESTAMP(), 'Action', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRPunAXQI8_X7p1MYVmiRF-hSOinkCiCqca8p9_0vB22qS2ttjx',
     'https://www.youtube.com/watch?v=avz06PDqDbM', CURRENT_TIMESTAMP());


INSERT INTO MOVIE(TITLE, DESCRIPTION, MOVIE_TYPE_NAME, DURATION, RELEASE_TS, GENERE, THUMBNAIL_URL, TRAILER_URL, CREATED_TS) VALUES
    ('Oppenheimer', 'A feature documentary exploring how one man\'s brilliance, hubris and relentless drive changed the nature of war forever, led to the deaths of hundreds of thousands of people and unleashed mass hysteria, and how, subsequently, the same man\'s attempts to co.',
     'Movie', '3h', CURRENT_TIMESTAMP(), 'War/Drama', 'https://pbs.twimg.com/media/FvUVt3hXgAAxP1H?format=jpg&name=900x900',
     'https://www.youtube.com/watch?v=SdHe-JseJfQ', CURRENT_TIMESTAMP());


-- DROP TABLE MOVIE_VIEW_TYPE;
CREATE TABLE movie_view_type(
                                ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                MOVIE_ID INT,
                                VIEW_TYPE_NAME VARCHAR(7) NOT NULL,
                                LANGUAGE_NAME VARCHAR(15) NOT NULL,
                                CREATED_TS DATETIME NOT NULL,
                                UNIQUE(MOVIE_ID,VIEW_TYPE_NAME,LANGUAGE_NAME),
                                FOREIGN KEY (MOVIE_ID) REFERENCES MOVIE(ID),
                                FOREIGN KEY (VIEW_TYPE_NAME) REFERENCES VIEW_TYPE(NAME),
                                FOREIGN KEY (LANGUAGE_NAME) REFERENCES `LANGUAGE`(NAME)
);

INSERT INTO MOVIE_VIEW_TYPE(MOVIE_ID,VIEW_TYPE_NAME,LANGUAGE_NAME,CREATED_TS) VALUES (1, '3D','English', CURRENT_TIMESTAMP());
INSERT INTO MOVIE_VIEW_TYPE(MOVIE_ID,VIEW_TYPE_NAME,LANGUAGE_NAME,CREATED_TS) VALUES (1, '2D','Hindi', CURRENT_TIMESTAMP());
INSERT INTO MOVIE_VIEW_TYPE(MOVIE_ID,VIEW_TYPE_NAME,LANGUAGE_NAME,CREATED_TS) VALUES (2, '3D','English', CURRENT_TIMESTAMP());


-- DROP TABLE `SHOW`;
CREATE TABLE `SHOW`(
                       ID INT PRIMARY KEY AUTO_INCREMENT,
                       MOVIE_ID INT NOT NULL,
                       MOVIE_TITLE VARCHAR(255) NOT NULL,
                       GENERE VARCHAR(31) NOT NULL,
                       LANGUAGE_NAME VARCHAR(15) NOT NULL,
                       VIEW_TYPE_NAME VARCHAR(7) NOT NULL,
                       DURATION  VARCHAR(7) NOT NULL,
                       SCREEN_NAME VARCHAR(15) NOT NULL,
                       THEATER_ID INT NOT NULL,
                       THEATER_DISPLAY_NAME VARCHAR(255) NOT NULL,
                       CITY_ID INT NOT NULL,
                       START_TS DATETIME NOT NULL,
                       END_TS DATETIME NOT NULL,
                       CREATED_TS DATETIME NOT NULL,
                       UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                       FOREIGN KEY (MOVIE_ID) REFERENCES MOVIE(ID),
                       FOREIGN KEY (LANGUAGE_NAME) REFERENCES `LANGUAGE`(NAME),
                       FOREIGN KEY (SCREEN_NAME,THEATER_ID) REFERENCES SCREEN(NAME,THEATER_ID),
                       FOREIGN KEY (CITY_ID) REFERENCES CITY(ID),
                       FOREIGN KEY (VIEW_TYPE_NAME) REFERENCES VIEW_TYPE(NAME)
);

INSERT INTO `SHOW`(MOVIE_ID, MOVIE_TITLE, GENERE, LANGUAGE_NAME, VIEW_TYPE_NAME, DURATION, SCREEN_NAME,
                   THEATER_ID, THEATER_DISPLAY_NAME, CITY_ID, START_TS, END_TS, CREATED_TS ) VALUES
    (1,'Mission: Impossible – Dead Reckoning Part 1', 'Action', 'English', '3D' ,'2h 43m', 'Screen 1',
     1, 'INOX-DN Regalia', 1, CURRENT_TIMESTAMP(), DATE_ADD(CURRENT_TIMESTAMP(), INTERVAL 20 DAY),  CURRENT_TIMESTAMP());

INSERT INTO `SHOW`(MOVIE_ID, MOVIE_TITLE, GENERE, LANGUAGE_NAME, VIEW_TYPE_NAME, DURATION, SCREEN_NAME,
                   THEATER_ID, THEATER_DISPLAY_NAME, CITY_ID, START_TS, END_TS, CREATED_TS ) VALUES
    (1,'Mission: Impossible – Dead Reckoning Part 1', 'Action', 'Hindi', '2D' ,'2h 43m', 'Screen 2',
     1, 'INOX-DN Regalia', 1, CURRENT_TIMESTAMP(), DATE_ADD(CURRENT_TIMESTAMP(), INTERVAL 20 DAY),  CURRENT_TIMESTAMP());


--  DROP TABLE SHOW_CALENDAR;

CREATE TABLE SHOW_CALENDAR(
                              ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                              SHOW_ID INT,
                              SHOW_RUN_DATE DATE NOT NULL,
                              START_TIME DATETIME NOT NULL,
                              END_TIME DATETIME NOT NULL,
                              CREATED_TS DATETIME NOT NULL,
                              UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                              FOREIGN KEY (SHOW_ID) REFERENCES `SHOW`(ID),
                              UNIQUE(ID, START_TIME, END_TIME)
);


INSERT INTO SHOW_CALENDAR (SHOW_ID, SHOW_RUN_DATE, START_TIME, END_TIME, CREATED_TS) VALUES
    (1, CURRENT_DATE(), CURRENT_TIMESTAMP(), DATE_ADD(CURRENT_TIMESTAMP(), INTERVAL 3 HOUR), CURRENT_TIMESTAMP());
INSERT INTO SHOW_CALENDAR (SHOW_ID, SHOW_RUN_DATE, START_TIME, END_TIME, CREATED_TS) VALUES
    (1, CURRENT_DATE(), DATE_ADD(CURRENT_TIMESTAMP(), INTERVAL 4 HOUR), DATE_ADD(CURRENT_TIMESTAMP(), INTERVAL 7 HOUR), CURRENT_TIMESTAMP());
INSERT INTO SHOW_CALENDAR (SHOW_ID, SHOW_RUN_DATE, START_TIME, END_TIME, CREATED_TS) VALUES
    (2, CURRENT_DATE(), DATE_ADD(CURRENT_TIMESTAMP(), INTERVAL 4 HOUR), DATE_ADD(CURRENT_TIMESTAMP(), INTERVAL 7 HOUR), CURRENT_TIMESTAMP());


-- DROP TABLE SHOW_CALENDAR_PRICE;
CREATE TABLE SHOW_CALENDAR_PRICE (
                                     ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                     SHOW_CALENDAR_ID INT,
                                     SCREEN_SEAT_TYPE_ID INT,
                                     PRICE DOUBLE NOT NULL,
                                     PRICE_BEFORE_TAX DOUBLE NOT NULL,
                                     GST DOUBLE NOT NULL,
                                     CGST DOUBLE NOT NULL,
                                     SGST DOUBLE NOT NULL,
                                     CREATED_TS DATETIME NOT NULL,
                                     UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                                     UNIQUE(SHOW_CALENDAR_ID, SCREEN_SEAT_TYPE_ID),
                                     FOREIGN KEY (SHOW_CALENDAR_ID) REFERENCES SHOW_CALENDAR(ID),
                                     FOREIGN KEY (SCREEN_SEAT_TYPE_ID) REFERENCES SCREEN_SEAT_TYPE(ID)
);

INSERT INTO SHOW_CALENDAR_PRICE(SHOW_CALENDAR_ID, SCREEN_SEAT_TYPE_ID, PRICE, PRICE_BEFORE_TAX, GST, CGST, SGST, CREATED_TS ) VALUES
    (1, 1, 200, 160, 40, 20, 20, CURRENT_TIMESTAMP());

INSERT INTO SHOW_CALENDAR_PRICE(SHOW_CALENDAR_ID, SCREEN_SEAT_TYPE_ID, PRICE, PRICE_BEFORE_TAX, GST, CGST, SGST, CREATED_TS ) VALUES
    (1, 2, 300, 240, 60, 30, 30, CURRENT_TIMESTAMP());


INSERT INTO SHOW_CALENDAR_PRICE(SHOW_CALENDAR_ID, SCREEN_SEAT_TYPE_ID, PRICE, PRICE_BEFORE_TAX, GST, CGST, SGST, CREATED_TS ) VALUES
    (2, 1, 200, 160, 40, 20, 20, CURRENT_TIMESTAMP());

INSERT INTO SHOW_CALENDAR_PRICE(SHOW_CALENDAR_ID, SCREEN_SEAT_TYPE_ID, PRICE, PRICE_BEFORE_TAX, GST, CGST, SGST, CREATED_TS ) VALUES
    (2, 2, 300, 240, 60, 30, 30, CURRENT_TIMESTAMP());

INSERT INTO SHOW_CALENDAR_PRICE(SHOW_CALENDAR_ID, SCREEN_SEAT_TYPE_ID, PRICE, PRICE_BEFORE_TAX, GST, CGST, SGST, CREATED_TS ) VALUES
    (3, 3, 200, 160, 40, 20, 20, CURRENT_TIMESTAMP());

INSERT INTO SHOW_CALENDAR_PRICE(SHOW_CALENDAR_ID, SCREEN_SEAT_TYPE_ID, PRICE, PRICE_BEFORE_TAX, GST, CGST, SGST, CREATED_TS ) VALUES
    (1, 4, 100, 80, 20, 10, 10, CURRENT_TIMESTAMP());

-- DROP TABLE BOOKING_STATUS;
CREATE TABLE BOOKING_STATUS(NAME VARCHAR(15) NOT NULL PRIMARY KEY,created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP());
INSERT INTO BOOKING_STATUS(NAME) VALUES('PENDING');
INSERT INTO BOOKING_STATUS(NAME) VALUES('SUCCESS');
INSERT INTO BOOKING_STATUS(NAME) VALUES('FAILED');
INSERT INTO BOOKING_STATUS(NAME) VALUES('CANCELLED');

-- DROP TABLE BOOKING;
CREATE TABLE BOOKING(
                        ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        USER_ID VARCHAR(255) NOT NULL,
                        SHOW_ID INT NOT NULL,
                        SHOW_CALENDAR_ID INT NOT NULL,
                        SCREEN_SEAT_TYPE_ID INT NOT NULL,
                        NUMBER_OF_TICKET INT NOT NULL,
                        UNIT_PRICE DOUBLE NOT NULL,
                        TOTAL_PRICE DOUBLE NOT NULL,
                        PRICE_BEFORE_TAX DOUBLE NOT NULL,
                        GST DOUBLE NOT NULL,
                        CGST DOUBLE NOT NULL,
                        SGST DOUBLE NOT NULL,
                        `STATUS` VARCHAR(15) NOT NULL,
                        PAYMENT_TRANSACTION_ID VARCHAR(255),
                        CREATED_TS DATETIME NOT NULL,
                        UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                        FOREIGN KEY (USER_ID) REFERENCES `USER`(ID),
                        FOREIGN KEY (SHOW_ID) REFERENCES `SHOW`(ID),
                        FOREIGN KEY (SHOW_CALENDAR_ID,SCREEN_SEAT_TYPE_ID) REFERENCES SHOW_CALENDAR_PRICE(SHOW_CALENDAR_ID, SCREEN_SEAT_TYPE_ID),
                        FOREIGN KEY (`STATUS`) REFERENCES BOOKING_STATUS(NAME)
);

-- DROP TABLE SEAT_STATUS;
CREATE TABLE SEAT_STATUS(NAME VARCHAR(15) NOT NULL PRIMARY KEY,created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP());
INSERT INTO SEAT_STATUS(NAME) VALUES('Pending');
INSERT INTO SEAT_STATUS(NAME) VALUES('Reserved');
INSERT INTO SEAT_STATUS(NAME) VALUES('Cancelled');

-- DROP TABLE SHOW_CALENDAR_SEAT_BOOKING;
CREATE TABLE SHOW_CALENDAR_SEAT_BOOKING(
                                           ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                           SHOW_CALENDAR_ID INT NOT NULL,
                                           SEAT_ID INT NOT NULL,
                                           SEAT_STATUS VARCHAR(15) NOT NULL,
                                           BOOKING_ID INT,
                                           CREATED_TS DATETIME NOT NULL,
                                           UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                                           FOREIGN KEY (SHOW_CALENDAR_ID) REFERENCES SHOW_CALENDAR(ID),
                                           FOREIGN KEY (SEAT_STATUS) REFERENCES SEAT_STATUS(NAME),
                                           FOREIGN KEY (BOOKING_ID) REFERENCES BOOKING(ID)
);


-- DROP TABLE REFUND_STATUS;
CREATE TABLE REFUND_STATUS(`STATUS` VARCHAR(15) NOT NULL PRIMARY KEY,created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP());
INSERT INTO REFUND_STATUS(`STATUS`) VALUES('PENDING');
INSERT INTO REFUND_STATUS(`STATUS`) VALUES('INITIATED');
INSERT INTO REFUND_STATUS(`STATUS`) VALUES('SUCCESS');
INSERT INTO REFUND_STATUS(`STATUS`) VALUES('FAILED');

-- DROP TABLE BOOKING_CANCELLATION;

CREATE TABLE BOOKING_CANCELLATION(
                                     BOOKING_ID INT NOT NULL PRIMARY KEY,
                                     USER_ID VARCHAR(255) NOT NULL,
                                     TOTAL_PRICE DOUBLE NOT NULL,
                                     CANCELLATION_CHARGES DOUBLE NOT NULL,
                                     REFUND_AMOUNT DOUBLE NOT NULL,
                                     `REFUND_STATUS` VARCHAR(15) NOT NULL,
                                     REFUND_TRANSACTION_ID VARCHAR(255),
                                     CREATED_TS DATETIME NOT NULL,
                                     UPDATED_TS DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                                     FOREIGN KEY (BOOKING_ID) REFERENCES BOOKING(ID),
                                     FOREIGN KEY (USER_ID) REFERENCES `USER`(ID)
)

-- ALTER TABLE SHOW_CALENDAR_PRICE MODIFY SHOW_CALENDAR_ID INT;
