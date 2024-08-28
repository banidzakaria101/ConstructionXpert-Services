package com.ProjectService.Services;


import com.ProjectService.Repository.ProjectRepository;
import com.ProjectService.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    public Project createProject(Project project) {
        return projectRepo.save(project);
    }

    public Project getProject(Long id) {
        return projectRepo.findById(id).get();
    }

    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Project updateProject(Long id, Project project) {
        Project oldProject = getProject(id);
        oldProject.setProjectName(project.getProjectName());
        return projectRepo.save(oldProject);
    }

}
