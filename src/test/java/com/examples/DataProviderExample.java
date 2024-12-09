package com.examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
   @DataProvider(name = "testData")
   public Object[][] list(){
       return new Object[][]{
               {23,"Ahmet"},
               {15,"Ali"},
               {18,"Aliye"}
       };
   }
    @Test(dataProvider = "testData")
    public void testMethod(int age,String name){
        System.out.println("Name: "+name+" Age: "+age);

    }

    }

