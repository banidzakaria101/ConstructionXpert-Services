package com.ProjectService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponse {
    private Long id;
    private String projectName;
    private String projectDescription;
    private String projectLocation;
    private String projectType;
    private String projectStatus;
    private Task task;

}
