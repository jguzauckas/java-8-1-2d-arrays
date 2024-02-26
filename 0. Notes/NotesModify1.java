public class NotesModify1 {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 7, 2, 11, 4};
        nums[2] = 5;
        System.out.println(nums[2]);
        nums[4] -= 1;
        System.out.println(nums[4]);
        nums[1] *= nums[0];
        System.out.println(nums[1]);
    }
}
