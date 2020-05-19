package leetcode.array;

import java.util.*;

/**
 * 两个数组的交集Ⅱ
 */
public class Intersect {

        public static int[] intersect(int[] nums1, int[] nums2) {
//            List<Integer> list = new ArrayList<>();
//            Set<Integer> set = new HashSet<>();
//            for(int i = 0; i < nums1.length; i++) {
//                for(int j = 0; j < nums2.length; j++) {
//                    if(nums1[i]==nums2[j]) {
//                        if(!set.contains(j)) {
//                            list.add(nums2[j]);
//                            set.add(j);
//                        }
//                    }
//                }
//            }
//            return list.stream().mapToInt(Integer::intValue).toArray();

            Map<Integer, Integer> count = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums1.length; i++) {
                count.put(nums1[i], count.getOrDefault(nums1[i], 0) + 1);
            }
            for(int i = 0; i < nums2.length; i++) {
                if(count.containsKey(nums2[i]) && count.get(nums2[i]) > 0) {
                    list.add(nums2[i]);
                    count.put(nums2[i], count.get(nums2[i]) - 1);
                }
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

  public static void main(String[] args) {
//    intersect(new int[]{1,2,2,1}, new int[]{2,2});
    intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
  }
}
