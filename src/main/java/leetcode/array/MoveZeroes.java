package leetcode.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                // swap(nums, j++, i);
                nums[j++]=nums[i];
            }
        }

        while(j<nums.length) {
            nums[j]=0;
            j++;
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
