package com.example.mockito_try;

public class MyRepository implements IRepository {
    Database mydatabase;
    public MyRepository(Database database){
        this.mydatabase = database;
    }

    public String getData(String notNeeded){
       return mydatabase.getData();
    }
}
