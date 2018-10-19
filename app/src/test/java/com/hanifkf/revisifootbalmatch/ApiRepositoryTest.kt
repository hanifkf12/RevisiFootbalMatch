package com.hanifkf.revisifootbalmatch

import com.hanifkf.revisifootbalmatch.ApiRepository.ApiRepository
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ApiRepositoryTest{
    @Test
    fun testRequest(){
        val apiRepository = mock(ApiRepository::class.java)
        var url ="https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328"
        apiRepository.doRequest(url)
        verify(apiRepository).doRequest(url)
    }
}