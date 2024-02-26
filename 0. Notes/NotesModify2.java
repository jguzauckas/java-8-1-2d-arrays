public class NotesModify2 {
    public static void main(String[] args) {
        int[][] nums = new int[][] {{3, 7, 2, 11, 4}, {1, 5, 8, 15, 13}, {1, 2, 6, 5, 12}, {2, 5, 7, 23, 9}, {12, 10, 3, 5, 3}};
        nums[1][4] = 5;
        System.out.println(nums[1][4]);
        nums[3][1] += 6;
        System.out.println(nums[3][1]);
        nums[2][2] /= nums[1][0]; 
        System.out.println(nums[2][2]);
    }
}
