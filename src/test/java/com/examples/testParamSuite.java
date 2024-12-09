package com.examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testParamSuite {

    @Parameters({"browser","baseURL"})
    @Test
    public void test01(String browser,String baseURL){
        System.out.println(browser);
        System.out.println(baseURL);
    }
}

