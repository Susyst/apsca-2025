package sorting;

public class Main {
    public static void main(String[] args)
    {
        // Generate a random array of any size you want.
        int[] testInput = randomArray(20);   // example: 20 random numbers

        // Increase loops once everything works.
        TestSuite.run(testInput, 10000);
        // TestSuite.run(testInput, 1);   // for quick debugging
    }

    public static int[] randomArray(int length)
    {
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = (int)(Math.random() * 100);   // values 0–99
        }
        return a;
    }
}
