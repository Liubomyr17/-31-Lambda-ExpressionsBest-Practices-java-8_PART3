package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    private String value = "Eclosing scope value";
    public static void main(String[] args) {

        new DemoApplication().scopeExperiment();
    }
    private void scopeExperiment() {
        Foo foo1 = new Foo() {
            private String value = "Inner Class value";
            @Override
            public String method() {
          return this.value;
            }
        };

        System.out.println(foo1.method());
        Foo foo2 =() ->{
            String value = "Lambda value";
            return this.value;
        };

        System.out.println(foo2.method());
    }
}

@FunctionalInterface
interface Foo {
    String method();
}
