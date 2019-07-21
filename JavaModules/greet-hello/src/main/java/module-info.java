module greet.hello.main {
    requires greet.intf.main;

    provides greet.intf.Greeter with greet.hello.Helloworld;
}