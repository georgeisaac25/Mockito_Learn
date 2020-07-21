package com.example.mockito_try;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MainActivityPresenterTest {

    MainActivityPresenter presenter;
    IRepository repository;
    User user;
    @Before
    public void setUp(){
         repository = mock(MyRepository.class);
         user = mock(User.class);

    }

    @Test
    public void Test_GetData_null(){
        //Given
        presenter = new MainActivityPresenter(user,repository);
        when(repository.getData()).thenReturn(null);
        //when
        presenter.getData();

        //then
        verify(user,times(1)).setEmail(null);
    }

}
