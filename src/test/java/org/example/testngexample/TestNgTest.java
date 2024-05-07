package org.example.testngexample;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class TestNgTest extends BaseTest{

//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("BeforeMethod");
//    }
//
//    @BeforeClass
//    public void beforeClass() {
//        System.out.println("BeforeClass");
//    }
//
//    @BeforeTest
//    public void beforetest() {
//        System.out.println("Beforetest");
//    }

//    @Parameters({"key"})
//    @Test()
//    public void secondTest(@Optional("key") String key1) {
//        System.out.println(key1);
//    }
    int count = 0;

    @Test()
    public void firstTest() {
        count++;
        assertEquals(3, count);
    }


//    @DataProvider(name = "data")
//    public Object[][] getData() {
//        return new Object[][] {
//                {"Ivan", "123", "Password is too short"},
//                {"", "12313vwervw", "Username is empty"},
//                {"Ivan", "", "Password is empty"}
//        };
//    }
//
//    @Test(dataProvider = "data")
//    public void firstTest(String name, String password, String errorMessage) throws Exception {
//        System.out.println(name + " " + password + " " + errorMessage);
//
//    }







}
