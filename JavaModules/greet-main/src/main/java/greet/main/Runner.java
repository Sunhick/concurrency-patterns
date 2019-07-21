package greet.main;

import greet.hola.Hola;
import greet.intf.Greeter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ServiceLoader;

public class Runner {
    private static Logger log = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        ServiceLoader<Greeter> greeter1 = ServiceLoader.load(Greeter.class);

        greeter1.forEach(provider -> log.info(provider.greet()));

        Greeter f = new Hola();
        log.info(f.greet());
    }
}
