package date1015;

public class MoreHalf {

    public static int MoreHalf(int[] nums) {
        int result = 0;
        int count = 1;
        if (nums.length == 0) {
            return -1;
        }
        result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
                continue;
            }
            if (result == nums[i]) {
                count++;
            }
            else
                count--;
        }
        count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (result == nums[i]) {
                count++;
            }
            if (count > nums.length / 2) {
                return result;
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 1, 2, 2, 4, 2,2, 7};

        System.out.println(MoreHalf(array));
    }
}
