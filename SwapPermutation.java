import java.util.Random;


public class SwapPermutation {
	
    public static int[] generate(int n) {
        int[] perm = new int[n];
        Random rand = new Random();
        
        for (int i = 0; i < perm.length; i++)
            perm[i] = i + 1;

        for (int i = 1; i < n; i ++)
            swapReferences(perm, i, rand.nextInt(i));
        
        return perm;
    }

    private static void swapReferences(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
