CREATE TABLE post (
                      post_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      text VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL,
                      views INT NOT NULL,
                      likes INT NOT NULL
);

CREATE TABLE comment (
                         comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         author VARCHAR(255) NOT NULL,
                         text VARCHAR(255) NOT NULL,
                         likes INT NOT NULL,
                         post_id BIGINT NOT NULL,
                         FOREIGN KEY (post_id) REFERENCES post(post_id)
);

CREATE TABLE sub_comment (
                         sub_comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         author VARCHAR(255) NOT NULL,
                         text VARCHAR(255) NOT NULL,
                         likes INT NOT NULL,
                         comment_id BIGINT NOT NULL,
                         FOREIGN KEY (comment_id) REFERENCES comment(comment_id)
);