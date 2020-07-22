package com.example.mockito_try;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MainActivityPresenterTest {

    MainActivityPresenter presenter;
    IRepository repository;
    User user;

    String NULL_VALUE = null;
    String CONSTANT_VALUE1 = "isa";
    String CONSTANT_VALUE2 = "moses";
    ArgumentCaptor<String> captor;

    @Before
    public void setUp() {
        repository = mock(MyRepository.class);
        user = mock(User.class);
        presenter = new MainActivityPresenter(user, repository);
        captor = ArgumentCaptor.forClass(String.class);
    }

    @Test
    public void Test_GetData_null() {
        //Given
        when(repository.getData(anyString())).thenReturn(NULL_VALUE);

        //when
        presenter.getData(1);

        //then
        verify(user, times(1)).setEmail(NULL_VALUE);
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
