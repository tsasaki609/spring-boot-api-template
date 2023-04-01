CREATE TABLE demo (
  id INT AUTO_INCREMENT NOT NULL,
  property1 VARCHAR NOT NULL,
  property2 VARCHAR,
  PRIMARY KEY (id)
);

INSERT INTO demo (property1) VALUES ('property1-value1');
