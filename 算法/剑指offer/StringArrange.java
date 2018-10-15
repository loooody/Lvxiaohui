package date1015;

public class StringArrange {

    public void recursion(char[] arrayA, int start, int end) {
        if (end <= 1) {
            return;
        }
        if (start == end) {
            for (int i = 0; i < arrayA.length; i++) {
                System.out.print(arrayA[i]);
            }
            System.out.println();
        }else{
            for (int i = start; i <= end; i++) {
                swap(arrayA, i, start);
                recursion(arrayA, start + 1, end);
                swap(arrayA, i, start);
            }
        }
    }

    private void swap(char[] arrayA, int m, int n) {
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }


    public static void main(String[] args) {
        StringArrange test = new StringArrange();
        String A = "abc";
        char[] array = A.toCharArray();
        test.recursion(array, 0, array.length - 1);

    }
}
