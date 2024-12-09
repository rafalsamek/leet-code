package easy;

public class IntegerToBinary {
    public static void main(String[] args) {
        int number = 17;

        System.out.println(toBinaryString(number));
    }

    private static String toBinaryString(int number) {
        if (number == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();

        while (number > 0) {
            binary.append(number % 2);
            number /= 2;
        }

        return binary.reverse().toString();
    }
}
