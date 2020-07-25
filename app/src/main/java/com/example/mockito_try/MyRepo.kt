package com.example.mockito_try

 class MyRepo : IRepository {
    override fun getData(i: String?): String {
       return "isa"
    }
}