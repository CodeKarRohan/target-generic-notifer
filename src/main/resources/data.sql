INSERT INTO TOPIC (NAME) VALUES
('WORKFLOW'),
('ORDER');


INSERT INTO CONSUMER (NAME, EMAIL_ID, SLACK_ID, NOTIFICATION_TYPE, TOPIC_ID)
VALUES
('Customer1', 'abcd@gmail.com', 'slack1', 3, 1),
('Customer2', 'xyz@gmail.com', 'slack3', 3, 1),
('Customer3', 'tes@gmail.com', '', 1, 2),
('Customer4', 'pqr@gmail.com', 'slack4', 2, 1),
('Customer5', 'main1@gmail.com', 'slack5', 1, 2);