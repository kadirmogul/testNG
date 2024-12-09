package com.examples;

import org.testng.annotations.Test;

public class groupExample {
   @Test(groups = {"Duman","Regresyon"})
   public void test01(){
       System.out.println("Smoke test");
   }
   @Test(groups = "Duman")
    public void test02(){
       System.out.println("Regresyon test");
   }

}
