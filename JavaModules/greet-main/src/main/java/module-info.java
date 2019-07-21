module greet.main.main {
    requires static lombok;
    requires greet.intf.main;
    requires org.slf4j;
    requires greet.hola.main;

    uses greet.intf.Greeter;
}