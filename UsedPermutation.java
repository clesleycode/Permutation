import java.util.Random;


public class UsedPermutation {
	

    public static int[] generate(int n) {
        int[] perm = new int[n];
        boolean[] used = new boolean[n + 1];
        Random rand = new Random();
        
        for (int i = 0; i < perm.length; i++) {
            int num = rand.nextInt(n) + 1;
            while (used[num])
                num = rand.nextInt(n) + 1;
            used[num] = true;
            perm[i] = num;
        }

        return perm;
    }
   
}
