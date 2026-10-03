public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        int prefix = 1;

        // Product of elements to the left
        for (int i = 0; i < n; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;

        // Product of elements to the right
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
