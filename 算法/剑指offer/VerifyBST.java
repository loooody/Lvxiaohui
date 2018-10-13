package date1013;

public class VerifyBST {

    public static boolean VerifySequenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int N = sequence.length;

        return VerifySequenceOfBST(sequence, 0, N - 1);
    }

    private static boolean VerifySequenceOfBST(int[] sequence, int left, int right) {
        if (left >= right) {
            return true;
        }

        int root = sequence[right];

        int i = left;
        for (; i < right - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        //如果右子树有元素小于root，返回false
        for (int j = i; j < right - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        return VerifySequenceOfBST(sequence, left, i - 1) && VerifySequenceOfBST(sequence, i, right - 1);
    }

    public static void main(String[] args) {
        int[] arr = {7,4,6,5};

        boolean flag = VerifySequenceOfBST(arr);
        System.out.println(flag);

    }
}
