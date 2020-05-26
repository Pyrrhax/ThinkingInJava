package generics;

public class MultipleInterfaceVariants {
    interface Payable{}

    class Employee implements Payable{}
    class Hourly extends  Employee implements Payable{}
}
