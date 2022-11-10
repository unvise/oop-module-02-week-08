package com.unvise.oop.apps;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.unvise.oop.apps.PermutationApp.perms;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationAppTest {

    @Test
    void permsTest() {
        // given
        List<Integer> nums1 = List.of(1, 2, 3);
        List<List<Integer>> expNums1 = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        );
        List<Integer> nums2 = List.of(1, 2);
        List<List<Integer>> expNums2 = List.of(
                List.of(1, 2),
                List.of(2, 1)
        );
        List<Integer> nums3 = List.of(1);
        List<List<Integer>> expNums3 = List.of(
                List.of(1)
        );
        List<Integer> nums4 = List.of();
        List<List<Integer>> expNums4 = List.of();
        // then
        assertAll(
                () -> assertEquals(expNums1, perms(nums1)),
                () -> assertEquals(expNums2, perms(nums2)),
                () -> assertEquals(expNums3, perms(nums3)),
                () -> assertEquals(expNums4, perms(nums4))
        );
    }
}