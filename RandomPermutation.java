import java.util.Random;


public class RandomPermutation { 
    
    public static int[] generate(int n) {
        int[] perm = new int[n];
        Random rand = new Random();
        
        for (int i = 0; i < perm.length; i++) {
            int num = rand.nextInt(n) + 1;
            while (check(perm, num, i))
                num = rand.nextInt(n) + 1;
            perm[i] = num;
        }
        return perm;
    }
    
   
    private static boolean check(int[] array, int x, int index) {
        for (int i = 0; i < index && i < array.length; i++)
            if (array[i] == x)
                return true; 
        return false;
    }

}
