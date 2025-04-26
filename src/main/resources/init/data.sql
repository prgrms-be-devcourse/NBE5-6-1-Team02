insert into `COFFEE`

(`COFFEE_ID`, `COFFEE_IMG`, `COFFEE_NAME`, `PRICE`)
VALUES (1001, 'product/ColumbiaNarino.jpeg', 'ColumbiaNarino', 5500),
       (1002, 'product/BrazilSerraDoCaparao.jpg','BrazilSerraDoCaparao', 9400),
       (1003, 'product/ColumbiaQUindio.jpg', 'ColumbiaQUindio', 10400),
       (1004, 'product/EthiopiaSidamo.jpg','EthiopiaSidamo', 8800);

INSERT INTO MEMBER (
    USER_Email,
    PASSWORD,
    ROLE,
    TEL,
    ADDRESS,
    ZIPCODE,
    ACTIVATED
) VALUES (
             'super@aaa.aaa',
             '{bcrypt}$2a$10$DLmC62iFtw6t/XTcLHhU/ONfwogNazrbae9PsnZ9DWz4/lIFr2jFK',
             'ROLE_ADMIN',
             '01022223333',
             NULL,
             NULL,
             TRUE
         );
