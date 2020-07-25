package com.example.mockito_try;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
//step1
@RunWith(Parameterized.class)
public class MainActivityPresenterWithMultipleParameters {

    MainActivityPresenter presenter;
    IRepository repository;
    User user;

    String NULL_VALUE = null;
    String CONSTANT_VALUE1 = "isa";
    String CONSTANT_VALUE2 = "moses";
    ArgumentCaptor<String> captor;

    private Integer inputNumber;
    private String expectedResult;

    //step2
    public MainActivityPresenterWithMultipleParameters(Integer inputNumber, String expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    //step3
    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                { 1, "moses" },
                { 6, "isaac" }
        });
    }

    @Before
    public void setUp() {
        repository = mock(MyRepository.class);
        user = mock(User.class);
        presenter = new MainActivityPresenter(user, repository);
        captor = ArgumentCaptor.forClass(String.class);
    }
    @Test
    public void Test_GetData_ArgToMockMethod() {
        //Given
        //when(repository.getData(CONSTANT_VALUE1)).thenReturn(NULL_VALUE);

        //when
        presenter.getData(inputNumber);




        verify(repository).getData(captor.capture());
        assertEquals(expectedResult, captor.getValue());
        //then
        //verify(user,times(1)).setEmail(NULL_VALUE);
    }
}
