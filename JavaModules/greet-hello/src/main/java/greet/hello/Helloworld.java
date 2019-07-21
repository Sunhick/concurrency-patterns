package greet.hello;

import greet.intf.Greeter;

public class Helloworld implements Greeter {
    @Override
    public String greet() {
        return "Hello World! Welcome to this world";
    }
}
