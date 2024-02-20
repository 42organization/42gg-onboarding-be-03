drop table if exists CRUD;

-- Post 테이블 생성
CREATE TABLE Post (
                      postId INT PRIMARY KEY,
                      title VARCHAR(255),
                      content TEXT,
                      author VARCHAR(100),
                      likeCnt INT
);

-- Comment 테이블 생성
CREATE TABLE Comment (
                         commentId INT PRIMARY KEY,
                         postId INT,
                         content TEXT,
                         author VARCHAR(100),
                         likeCnt INT,
                         FOREIGN KEY (postId) REFERENCES Post(postId)
);

-- Subcomment 테이블 생성
CREATE TABLE Subcomment (
                            subcommentId INT PRIMARY KEY,
                            commentId INT,
                            content TEXT,
                            author VARCHAR(100),
                            likeCnt INT,
                            FOREIGN KEY (commentId) REFERENCES Comment(commentId)
);
