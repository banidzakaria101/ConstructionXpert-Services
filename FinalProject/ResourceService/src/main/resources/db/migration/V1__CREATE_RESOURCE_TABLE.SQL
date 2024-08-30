CREATE TABLE resource (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          resource_name VARCHAR(255) NOT NULL,
                          resource_type VARCHAR(255) NOT NULL,
                          task_id BIGINT
);