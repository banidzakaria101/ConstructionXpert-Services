CREATE TABLE PROJECT
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    project_name VARCHAR(255) NOT NULL,
    project_description VARCHAR(255) NOT NULL,
    project_location VARCHAR(255),
    project_status VARCHAR(255),
    project_type VARCHAR(255)
)