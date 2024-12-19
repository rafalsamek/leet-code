package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1046. Last Stone Weight
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 *
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 *
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
 * Example 2:
 *
 * Input: stones = [1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class LastStoneWeight {
    private List<Integer> stones;

    public LastStoneWeight(List<Integer> stones) {
        checkConstraints(stones);

        this.stones = stones;
    }

    public List<Integer> getStones() {
        return stones;
    }

    public static void main(String[] args) {
        LastStoneWeight game = new LastStoneWeight(convertArgsToListOfIntegers(args));

        while(game.makeTurn());

        System.out.println(game.getStones().get(0));
    }

    private static List<Integer> convertArgsToListOfIntegers(String[] args) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            result.add(Integer.parseInt(args[i]));
        }

        return result;
    }

    private static void checkConstraints(List<Integer> stones) {
        // 1 <= stones.length <= 30
        // 1 <= stones[i] <= 1000

        if (stones.size() < 1) {
            throw new IllegalArgumentException("numbers of stones is to small");
        }

        if (stones.size() > 30) {
            throw new IllegalArgumentException("numbers of stones is to big");
        }

        for (int i = 0; i < stones.size(); i++) {
            int weight = stones.get(i);
            if (weight < 1) {
                throw new IllegalArgumentException("stone is too light");
            }
            if (weight > 1000) {
                throw new IllegalArgumentException("stone is too heavy");
            }
        };
    }

    private boolean makeTurn() {
        if (this.stones.size() == 1) {
            return false;
        }

        System.out.println("before sort: " + Arrays.toString(this.stones.toArray()));
        this.stones = this.stones.stream()
                .sorted((a, b) -> a - b)
                .collect(Collectors.toList());
        System.out.println("after sort: " + Arrays.toString(this.stones.toArray()));

        int firstHaviestStone = this.stones.get(this.stones.size() - 1);
        int secondHaviestStone = this.stones.get(this.stones.size() - 2);

        this.stones = this.stones.subList(0, this.stones.size() - 2);
        System.out.println("after slicing: " + Arrays.toString(this.stones.toArray()));

        if (this.stones.isEmpty() && firstHaviestStone == secondHaviestStone) {
                this.stones.add(0);
        }
        if (firstHaviestStone != secondHaviestStone) {
            this.stones.add(firstHaviestStone - secondHaviestStone);
        }

        System.out.println("after adding: " + Arrays.toString(this.stones.toArray()));

        return this.stones.size() > 1;
    }
}
