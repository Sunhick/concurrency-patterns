module greet.hello.main {
    requires greet.intf.main;
    exports greet.hello;

    provides greet.intf.Greeter with greet.hello.Helloworld;
}