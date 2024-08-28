package com.TaskService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Long id;
    private String projectName;
    private String projectDescription;
    private String projectLocation;
    private String projectType;
    private String projectStatus;
}
