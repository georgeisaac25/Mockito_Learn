package com.example.mockito_try

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.stubbing.Answer

@RunWith(MockitoJUnitRunner::class)
class UtilityTest{
    lateinit var directUtil: DirectUtil
    @Mock
    lateinit var mockUtil: MyRepo;

    @Before
    fun setup(){
        directUtil = DirectUtil(mockUtil);
    }

    @Test
    fun providedNumber_isSum_true(){
        //val mockUtil = mock(MyRepo::class.java)
        `when`(mockUtil.getData(Mockito.any())).then(Answer { "isa" })
        var a = directUtil.add(2,4)
        assertEquals(6,a)
    }
}