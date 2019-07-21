package greet.main;

import greet.intf.Greeter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ServiceLoader;

public class Runner {
    private static Logger log = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        Greeter greeter = () -> "Fuck you";
        log.info(greeter.greet());

        Greeter greeter1 = ServiceLoader.load(Greeter.class).findFirst().orElseThrow(RuntimeException::new);
        log.info(greeter1.greet());
    }
}
