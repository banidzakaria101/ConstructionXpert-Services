package com.ProjectService.services;


import com.ProjectService.repository.ProjectRepository;
import com.ProjectService.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepo;
    @Autowired
    private RestTemplate restTemplate;

    public Project createProject(Project project) {
        return projectRepo.save(project);
    }

    public Optional<Project> getProject(Long projectId) {
        return projectRepo.findById(projectId);
    }

    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

//    public Project updateProject(Long id, Project project) {
//        Project oldProject = getProject(id);
//        oldProject.setProjectName(project.getProjectName());
//        return projectRepo.save(oldProject);
//    }

}
