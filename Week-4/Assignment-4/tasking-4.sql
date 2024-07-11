CREATE TABLE user (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE articles (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(45) NOT NULL UNIQUE,
    content text NOT NULL,
    author_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES user(id)
)

-- 1. Write an SQL statement to select all articles with their author’s email.
SELECT articles.title, articles.content,user.email  
FROM articles
INNER JOIN user
ON articles.author_id = user.id;

--@block
-- 2. Write another SQL statement to select articles from 7th to 12th sorted by id.
SELECT * FROM articles
ORDER BY id 
LIMIT 6 OFFSET 6;




