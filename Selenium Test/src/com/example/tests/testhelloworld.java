package com.example.tests;

import junit.framework.*;

import java.util.*;


public class testhelloworld extends TestCase {
    private HelloWorld hw;

    public void setUp() {
        hw = new HelloWorld();
    }

    public void testFirefox() {
        assertTrue("Firefox", hw.isBrowser("firefox"));
    }

    public void testOpera() {
        assertTrue("Opera", hw.isBrowser("opera"));
    }


public class HelloWorld {
    private String[] browsersList = new String[]{"firefox", "chrome", "opera", "safari"};

    public boolean isBrowser(String name) {
        return Arrays.asList(browsersList).contains(name);
    }
}}
