package ElementsOfProgrammingInterview.StacksAndQueues;

public class StackWithMaxAPI_1 {
    public static void main(String[] args) {
        StackMax stackMax = new StackMax();
        stackMax.push(-1);
        System.out.printf("Expected is -1 actual is %s%n", stackMax.getMax());
        stackMax.push(3);
        System.out.printf("Expected is 3 actual is %s%n", stackMax.getMax());
        stackMax.push(-5);
        System.out.printf("Expected is 3 actual is %s%n", stackMax.getMax());
        stackMax.push(-4);
        System.out.printf("Expected is 3 actual is %s%n", stackMax.getMax());
        stackMax.push(-10);
        System.out.printf("Expected is 3 actual is %s%n", stackMax.getMax());
        stackMax.push(5);
        System.out.printf("Expected is 5 actual is %s%n", stackMax.getMax());
    }
}
