package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseTable implements BaseCase {
    @Override
    public void run() {
        int[][] arr = new int[3][2];
        arr[0] = new int[]{2,0};
        arr[1] = new int[]{0,2};
        arr[2] = new int[]{1,2};
        System.out.println(canFinish(3, arr));
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        List<Integer> arr = new ArrayList<>();
        List<Integer> list1;
        for(int[] val : prerequisites){
            if (val[1] == val[0]) {
                return false;
            }

            indegree[val[1]]++;
            list1 = list.get(val[0]);
            list1.add(val[1]);
            list.set(val[0], list1);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                arr.add(i);
            }
        }

        if (arr.isEmpty()) {
            return false;
        } else {
            Set<Integer> set = new HashSet<>();
            while (!arr.isEmpty()) {
                set.add(arr.getFirst());
                for (int j :  list.get(arr.getFirst())) {
                    if (set.contains(j)) {
                        return false;
                    } else {
                        indegree[j]--;
                        if (indegree[j] == 0) {
                            arr.add(j);
                        }
                    }
                }
                arr.removeFirst();
            }

            if (set.size() != numCourses) {
                return false;
            } else {
                return true;
            }
        }
    }
}
