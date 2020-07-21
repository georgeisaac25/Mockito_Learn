package com.example.mockito_try;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTestWithAnnotations {




    String NULL_VALUE = null;
    String CONSTANT_VALUE = "isa";

    @Mock
    IRepository repository;
    @Mock
    User user;

    @InjectMocks
    MainActivityPresenter presenter;

    @Captor
    ArgumentCaptor captor;

    @Before
    public void setUp(){

    }

    @Test
    public void Test_GetData_null(){
        //Given
        when(repository.getData()).thenReturn(NULL_VALUE);

        //when
        presenter.getData();

        //then
        verify(user,times(1)).setEmail(NULL_VALUE);
    }
}
