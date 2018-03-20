/**
 * Implementation of Fiboannci Using Dynamic Programming with Array used for storage
 * Created by ©Ameya on 2/19/2018 at 11:21 PM.
 */
public class FibonacciUsingDP {

    public static void main(String[] args) {
        System.out.println(fibonacciUsingDP(10));
    }

    /**
     * Fiboannaci series implementation using Dynamic Prgramming approach
     *
     * @param number whose Fibonaaci is needed
     * @return Fibonacci of the passed input parameter
     */

    private static int fibonacciUsingDP(int number) {
        int temp[] = new int[number + 1];
        temp[0] = 0;
        temp[1] = 1;
        for (int i = 2; i <= number; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp[number];
    }
}
