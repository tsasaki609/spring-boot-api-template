CREATE TABLE example (
  id INT AUTO_INCREMENT NOT NULL,
  property1 VARCHAR NOT NULL,
  property2 VARCHAR,
  PRIMARY KEY (id)
);

INSERT INTO example (property1) VALUES ('property1-value1');
INSERT INTO example (property1) VALUES ('property1-value2');
