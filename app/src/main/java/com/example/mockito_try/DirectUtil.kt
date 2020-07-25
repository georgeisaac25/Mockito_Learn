package com.example.mockito_try

 class DirectUtil(var i:IRepository) {

    fun add(a: Int, b: Int): Int {
        i.getData("isa")

        return a + b;
    }

}