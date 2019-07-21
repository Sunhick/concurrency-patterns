package greet.hola;

import greet.intf.Greeter;

public class Hola implements Greeter {
    @Override
    public String greet() {
        return "Hola Mundo";
    }
}
