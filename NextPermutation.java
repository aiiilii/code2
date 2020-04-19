public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i --;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > 0 && nums[j] <= nums[i]) {
                j --;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private static void reverse(int[] nums, int start) {
        int low = start;
        int high = nums.length - 1;
        while (low < high) {
            swap(nums, low, high);
            low ++;
            high --;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}