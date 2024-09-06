CREATE TABLE project (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         project_name VARCHAR(255) NOT NULL,
                         project_description TEXT,
                         project_location VARCHAR(255),
                         project_type VARCHAR(50),
                         project_status VARCHAR(50)
);



