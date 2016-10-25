package com.epam;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Nashorn {

    public static void main(String[] args) throws ScriptException, FileNotFoundException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("print('Hello World!');");
        
        URL resource = Nashorn.class.getClassLoader().getResource("filter.js");
        System.out.println(resource);
        
        engine.eval(new InputStreamReader(Nashorn.class.getClassLoader().getResourceAsStream("filter.js")));
    }

}
