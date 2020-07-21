package com.example.mockito_try;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MainActivityPresenterTest {

    MainActivityPresenter presenter;
    IRepository repository;
    User user;

    String NULL_VALUE = null;
    String CONSTANT_VALUE = "isa";
    @Before
    public void setUp(){
         repository = mock(MyRepository.class);
         user = mock(User.class);
    }

    @Test
    public void Test_GetData_null(){
        //Given
        presenter = new MainActivityPresenter(user,repository);
        when(repository.getData()).thenReturn(NULL_VALUE);

        //when
        presenter.getData();

        //then
        verify(user,times(1)).setEmail(NULL_VALUE);
    }

}
