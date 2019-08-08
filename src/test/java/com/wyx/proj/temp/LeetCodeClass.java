package com.wyx.proj.temp;

import java.util.*;

public class LeetCodeClass {


    public static void main(String[] args) {


        int aaa[] = {3, -4, -5, 5, 3, 6, 8, 3, -6, 7, 5, -5, 3, 3, 10};


        System.out.println(fourSum(aaa, -26));
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        Map<String, List<Integer>> resultMap = new HashMap<>();

        if (nums.length < 4) {
            return resultList;
        }

        String start = "1111";
        String end = "1111";
        for (int i = 5; i <= nums.length; i++) {
            end += "0";
        }

        //System.out.println("-       你      -----"+start);
        //System.out.println("------"+end);

        int startNum = Integer.valueOf(start, 2);
        int endNum = Integer.valueOf(end, 2);

        //System.out.println("------"+startNum);
        //System.out.println("------"+endNum);


        for (int i = startNum; i <= endNum; i++) {
            String bb = Integer.toBinaryString(i);

            int bbLength = bb.length();
            if (bbLength < nums.length) {
                for (int k = 0; k < nums.length - bbLength; k++) {
                    bb = "0" + bb;
                }
            }

            if (bb.length() - bb.replace("1", "").length() == 4) {
                List<Integer> tempList = new ArrayList<Integer>();
                int suMnum = 0;

                for (int j = 0; j < bb.length(); j++) {

                    if (bb.charAt(j) == '1') {
                        suMnum += nums[j];
                        tempList.add(nums[j]);
                    }
                }

                if (suMnum == target) {
                    tempList.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 == o2 ? 0 : (o1 > o2 ? 1 : -1);
                        }
                    });

                    resultMap.put(tempList.toString(), tempList);
                }
            }
        }


        resultList.addAll(resultMap.values());

        return resultList;
    }


}
