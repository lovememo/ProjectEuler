package net.lovememo.euler.Problem01_25;

public class Abundant {
    
    /** Creates a new instance of Abundant */
    public Abundant() {
    }
    
    int limit = 28123;
    
    int[] abNums = new int[limit+1];
    int[] nums = new int[limit+1];
    boolean[] abundant = new boolean[limit+1];
    int nAb = 0;
    
    public int getAnswer(){
        for (int n = 1; n <= limit; n++){
            nums[n] = n;
            abundant[n] = isAbundant(n);
            if (abundant[n]){
                abNums[nAb++] = n;
                //System.out.println("" + n);
            }
        }
        for (int n = 1; n <= limit; n++){
            int iAb=0;
            loop: while (iAb < nAb){
                if (n - abNums[iAb] < 12) 
                    break loop;
                if (abundant[n-abNums[iAb]]){
                    nums[n] = 0;
                    //System.out.println("" + n + " = " + (n-abNums[iAb]) + " + "
                    //  + abNums[iAb]);
                    break loop;
                }
                iAb++;
            }
        }
        int sum = 0;
        for (int i = 1; i <= limit; i++)
            sum += nums[i];
        return sum;
    }
    
    private boolean isAbundant(int n){
        return (sumOfDivisors(n) > n+n);
    }
    
    private int sumOfDivisors(int n){
        int prod=1;
        for(int k=2;k*k<=n;++k){
            int p=1;
            while(n%k==0){
                p=p*k+1;
                n/=k;
            }
            prod*=p;
        }
        if(n>1)
            prod*=1+n;
        return prod;
    }      
    
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        System.out.println("Answer: " + (new Abundant()).getAnswer());
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
    }
}