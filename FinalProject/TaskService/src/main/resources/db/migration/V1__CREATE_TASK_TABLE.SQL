CREATE TABLE task (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description TEXT,
                      priority INT NOT NULL,
                      status VARCHAR(50),
                      project_id BIGINT
);
