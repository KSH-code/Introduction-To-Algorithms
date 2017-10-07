import java.util.Arrays;

class Test{
    public static void main(String[] args) {
        int b,a;
        b = a = 0;
        int A[] = new int[]{6, 5, 4, 3, 2, 1};
        for(int i = 1; i<A.length; i++){
            int key = A[i];
            int j = i - 1;
            b++;
            while(j >= 0 && A[j] > key){
                j--;
                a++;
            }
        }
        System.out.println(b); // n - 1
        System.out.println(a); // n - 1 + (1 to n - 1)
    }
}