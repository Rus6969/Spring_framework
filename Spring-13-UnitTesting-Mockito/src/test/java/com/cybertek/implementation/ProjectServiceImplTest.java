package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.entity.Project;
import com.cybertek.enums.Status;
import com.cybertek.mapper.ProjectMapper;
import com.cybertek.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {
    @Mock
    ProjectRepository projectRepository;
    @Mock
    ProjectMapper mapper;
    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode() {

        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();

        when(projectRepository.findByProjectCode("PR01")).thenReturn(project);
        when(mapper.convertToDto(project)).thenReturn(projectDTO);

        ProjectDTO projectDTO1 = projectService.getByProjectCode("PR01");

        verify(projectRepository).findByProjectCode(Mockito.anyString());
        verify(mapper).convertToDto(Mockito.any(Project.class));

        assertNotNull(projectDTO1);
    }


    @Test
    void getByProjectCode_exception_test() {
         // assumption what we want to fet , no code runnong
        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project Not Found"));


         // here we are passing 2 things in assertThrows ( exception class and exe cution of a method , store in Throwble to do assertions in line55-56
        Throwable exception = assertThrows(RuntimeException.class, () -> projectService.getByProjectCode(""));
        // verification for Mock
        verify(projectRepository).findByProjectCode(Mockito.anyString());

        assertEquals(exception.getMessage(), "Project Not Found");

    }

    @Test
    void saveTest(){
        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();

        when(mapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        projectService.save(projectDTO);
       // veryfy is used for mocking tests check did repository executed
        verify(projectRepository).save(project);

    }
}