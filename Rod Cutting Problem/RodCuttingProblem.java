import java.util.HashMap;

/**
 * This program implements the Rod Cutting Dynamic Algorithm.
 * We are provided with an array of profits such that when the rod is cut
 * at ith index the profit will be profit[i].
 * Our main goal is to cut the rod in such a way that the total profit
 * is maximized for the given length of rod.
 *
 * Created by ©Ameya on 3/18/2018 at 12:25 PM.
 */
public class RodCuttingProblem {
    /**
     * An array which gives the profit when the rod is cut at ith index
     */
    private static int[] profit = {0, 1, 5, 8, 10, 13, 17, 17, 20, 24, 26};

    public static void main(String[] args) {
        int n = profit.length - 1;
        HashMap hm;
        hm = generateRCP(profit);
        int[] maxProfit = (int[]) hm.get("profit");
        System.out.println(maxProfit[profit.length - 1]);
        System.out.println("The rod will give optimal solution at following lenghs :-");
        int[] size = (int[]) hm.get("size");
        while (n > 0) {
            System.out.println(size[n]);
            n -= size[n];
        }
    }

    /**
     * It implements the Rod cutting recursion and finds the optimal profit as well as sizes to be cut
     * @param profit array of profits for each cut
     * @return a hashmap which contains the max profit array as well as size array
     */
    private static HashMap generateRCP(int[] profit) {
        HashMap<String, Object> hm = new HashMap<>();
        int[] maxProfit = new int[profit.length];
        int[] size = new int[profit.length];

        for (int i = 0; i < profit.length; i++) {
            int q = 0;
            for (int j = 0; j <= i; j++) {
                if (q < (profit[j] + maxProfit[i - j])) {
                    q = (profit[j] + maxProfit[i - j]);
                    size[i] = j;
                }

            }
            maxProfit[i] = q;
        }
        hm.put("profit", maxProfit);
        hm.put("size", size);
        return hm;
    }
}
