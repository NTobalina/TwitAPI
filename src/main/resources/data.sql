DROP TABLE IF EXISTS tweet;

CREATE TABLE tweet(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user       VARCHAR(100) NOT NULL,
  tweet_text       VARCHAR(500) NOT NULL,
  location   VARCHAR(200),
  validation boolean DEFAULT FALSE
);

INSERT INTO tweet(user, tweet_text, location, validation)
VALUES ('NickTest', 'Mi primer tweet de prueba!', 'Madrid', FALSE);
