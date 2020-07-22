package com.example.mockito_try;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTestWithAnnotations {




    String NULL_VALUE = null;
    String CONSTANT_VALUE1 = "isa";
    String CONSTANT_VALUE2 = "moses";

    @Mock
    IRepository repository;
    @Mock
    User user;

    @InjectMocks
    MainActivityPresenter presenter;

    @Captor
    ArgumentCaptor<String> captor;

    @Before
    public void setUp(){
        //ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    }

    @Test
    public void Test_GetData_null(){
        //Given
        when(repository.getData(CONSTANT_VALUE1)).thenReturn(NULL_VALUE);

        //when
        presenter.getData(1);

        //then
        verify(user,times(1)).setEmail(NULL_VALUE);
    }

    @Test
    public void Test_GetData_ArgToMockMethod() {
        //Given
        //when(repository.getData(CONSTANT_VALUE1)).thenReturn(NULL_VALUE);

        //when
        presenter.getData(1);




        verify(repository).getData(captor.capture());
        assertEquals(CONSTANT_VALUE2, captor.getValue());
        //then
        //verify(user,times(1)).setEmail(NULL_VALUE);
    }




}
