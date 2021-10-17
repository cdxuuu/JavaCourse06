package com.cdx.course.week02.demo;

public class Test {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        int[] resp = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                resp[k] = nums1[i];
                i++;
            }else {
                resp[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < nums1.length) {
            resp[k++] = nums1[i];
            i++;
        }
        while(j < nums2.length) {
            resp[k++] = nums2[j];
            j++;
        }
        for (int i1 = 0; i1 < resp.length; i1++) {


            System.out.println(resp[i1]);
        }
    }
}
