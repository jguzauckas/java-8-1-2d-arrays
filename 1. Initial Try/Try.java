public class Try {
    public static void main (String[] args){
        String[][] strs = new String[][] {"a", "b", "c", "d", "e", "f", "g", "h", "i"}; // Should be 3 rows of 3 letters each
        System.out.println(strs[2, 2]); // Print out the bottom right string
        strs[1, 2]; // Set it to "z" instead of "f"
        System.out.println(strs[1, 2]); // Print out "z" from the array
        strs[0, 0]; // Add another "a" so that it is "aa"
        System.out.println(strs[0, 0]) // Print out "aa" from the array
    }
}
