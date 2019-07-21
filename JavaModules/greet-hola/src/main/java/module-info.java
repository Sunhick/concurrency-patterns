module greet.hola.main {
    requires greet.intf.main;

    exports greet.hola;

    provides greet.intf.Greeter with greet.hola.Hola;
}