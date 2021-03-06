package reetCodeAlgorithms.PermutationsII;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null || nums.length < 1) return new ArrayList<>();
		List<Integer> convert = Arrays.stream(nums).boxed().collect(Collectors.toList());
		
		Set<List<Integer>> set = new HashSet<>();
		permutation(set, convert, new ArrayList<>());
		List<List<Integer>> list = new ArrayList<>(set);
		
        Collections.sort(list, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				for (int i = 0; i < o1.size(); i++) {
					if (o1.get(i) == o2.get(i)) continue;
					else return Integer.compare(o1.get(i), o2.get(i));
				}
				return 0;
			}
		});
		
        System.out.println(list.toString());
		return list;
	}

	public void permutation(Set<List<Integer>> set, List<Integer> convert, List<Integer> save) {
		if (convert.isEmpty()) {
			set.add(save);
            return;
        }
		
        for (int i=0; i<convert.size(); i++) {
        	List<Integer> convertCopy = convert.stream().collect(Collectors.toList());
        	List<Integer> convertsava = save.stream().collect(Collectors.toList());
        	convertsava.add(convert.get(i));
        	convertCopy.remove(i);
        	permutation(set, convertCopy, convertsava);
        }
	}
	
	public static class TestClass {
		Solution s = new Solution();
		List<List<Integer>> list = new ArrayList<>();
		@Test
		public void test1() {
			assertThat(list, is(s.permuteUnique(new int[] {1,1,2})));
		}
		
		@Test
		public void test2() {
			assertThat(list, is(s.permuteUnique(new int[] {1,2,3})));
		}
		
		@Test
		public void test3() {
			assertThat(list, is(s.permuteUnique(new int[] {1,1,1,1})));
		}
		
		@Test
		public void test4() {
			assertThat(list, is(s.permuteUnique(new int[] {1,-1,-4})));
		}
	}
}
