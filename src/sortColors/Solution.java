public class Solution {
    public void sortColors(int[] A) {
        int n = A.length;
        int zero = -1, one = 0, two = n;
        while (one < two) {
            switch (A[one]) {
            case 0:
                zero++;
                A[one] = A[zero];
                A[zero] = 0;
                one++;
                break;
            case 1:
                one++;
                break;
            case 2:
                two--;
                A[one] = A[two];
                A[two] = 2;
                break;
            }
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr;
        arr = new int[] {1, 0 , 2, 0, 0, 1, 1};
        s.sortColors(arr);
        for (int i : arr) {
            System.out.format("%d ", i);
        }
        System.out.println(" ");
        arr = new int[] {1, 2, 0};
        s.sortColors(arr);
        for (int i : arr) {
            System.out.format("%d ", i);
        }
        System.out.println(" ");
        arr = new int[] {0};
        s.sortColors(arr);
        for (int i : arr) {
            System.out.format("%d ", i);
        }
        System.out.println(" ");
        arr = new int[] {0, 2, 1};
        s.sortColors(arr);
        for (int i : arr) {
            System.out.format("%d ", i);
        }
        System.out.println(" ");
        arr = new int[] {2};
        s.sortColors(arr);
        for (int i : arr) {
            System.out.format("%d ", i);
        }
        System.out.println(" ");
        arr = new int[] {2, 0};
        s.sortColors(arr);
        for (int i : arr) {
            System.out.format("%d ", i);
        }
        System.out.println(" ");
    }
}