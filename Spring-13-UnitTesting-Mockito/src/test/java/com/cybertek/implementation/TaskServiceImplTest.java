package com.cybertek.implementation;

import com.cybertek.dto.TaskDTO;
import com.cybertek.entity.Task;
import com.cybertek.mapper.TaskMapper;
import com.cybertek.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;
    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskService;


//    @Test
//    void findById() {
//        Task task = new Task();
//        TaskDTO taskDTO = new TaskDTO();
//
//        // since a task is optional we need to wrap it up
//        when(taskRepository.findById(2L)).thenReturn(Optional.of(task));
//        when(taskMapper.convertToDto(task)).thenReturn(taskDTO);
//
//        taskService.findById(2L);
//        // here we check mock
//        verify(taskRepository).findById(2L);

    /// Parameterized values

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    void findById(Long arg) {
        Task task = new Task();
        TaskDTO taskDTO = new TaskDTO();
        // since a task is optional we need to wrap it up
        when(taskRepository.findById(arg)).thenReturn(Optional.of(task));
        when(taskMapper.convertToDto(task)).thenReturn(taskDTO);
        taskService.findById(arg);
        // here we check mock
        verify(taskRepository).findById(arg);
    }
        @Test
        void findByIdBddTest(){

            //given
            Task task1 = new Task();
            given(taskRepository.findById(Mockito.anyLong())).willReturn(Optional.of(task1));
            given(taskMapper.convertToDto(task1)).willReturn(new TaskDTO());

            //when
            taskService.findById(Mockito.anyLong());

            //then
            then(taskRepository).should().findById(Mockito.anyLong());
            then(taskRepository).should(never()).findById(-5L);

        }
    }
