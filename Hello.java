public class Hello {
    public static void main(String[] args) {
        addInts();
    }

    public static void addInts() {
        MyHandler adder = (k, i) -> k + i;
        MyHandler multiplier = (a, b) -> a * b;
        System.out.println(adder.handle(10, 20));
        System.out.println(multiplier.handle(5, 30));
        MyHandler divider = (x, y) -> x / y;
        System.out.println(divider.handle(20, 5));
        process(adder);
        process((m, n) -> m - n);
        process(Hello::computeRemainder);
        DelegateHandler delegateHandler = new DelegateHandler();
        process(delegateHandler::divide);
    }

    static int computeRemainder(int a, int b) {
        return a % b;
    }

    public static void process(MyHandler handler) {
        System.out.println(handler.handle(100, 10));
    }

    public static void typeInference() {
        var cust = new Customer(40L, "James");
        System.out.println(cust.name);

    }

    static class  Customer {
        public Long id;
        public String name;
        public Customer(Long id, String name) {
            this.id = id;
            this.name = name;
        }

    }
}
