package com.cybertek;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class UnitTestingImplTest {
    @Mock
    DataRepository dataRepository;

    @InjectMocks
    UnitTestingImpl unitTesting;


    @Test
    void calculateSum() {
        UnitTestingImpl unitTesting = new UnitTestingImpl();
        int actual = unitTesting.calculateSum(new int[]{1, 2, 3});
        assertEquals(6, actual);
    }

    // hardcoded optiong brining data from db bad option
    @Test
    public void calculateSumUsingDataService() {
        DataRepositoryImpl dataRepository = new DataRepositoryImpl();
        UnitTestingImpl unitTesting = new UnitTestingImpl(dataRepository);
        int actual = unitTesting.calculateSumUsingDataService();
        assertEquals(6, actual);
    }
/// unit test shortest way assuming repository works fine , we are mockin repository layer
@Test
void calculateSumUsingDataService_Mock(){

    when(dataRepository.findAll()).thenReturn(new int[]{1,2,3}).thenReturn(new int[]{5,5,5});

    int actual = unitTesting.calculateSumUsingDataService();
    int actual2 = unitTesting.calculateSumUsingDataService();

    assertEquals(6,actual);
    assertEquals(15,actual2);
}
   @Test
void calculateSumUsingServiceMock_with_parameters(){
        when(dataRepository.findById(anyInt())).thenReturn(new int[]{10,10,10});
        int actual = unitTesting.calculateSumUsingDataService_withParameter();
        assertEquals(30,actual);
}

    }

