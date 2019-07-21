module greet.main.main {
    requires static lombok;
    requires greet.intf.main;
    requires org.slf4j;

    uses greet.intf.Greeter;
}