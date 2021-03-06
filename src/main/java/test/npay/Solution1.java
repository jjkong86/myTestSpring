package test.npay;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class Solution1 {

	public int solution(int[] A) {
		// 두자리수의 합을 구하는 문제
		if (A == null || A.length == 0)
			return 0;

		return Arrays.stream(A).filter(i -> isTwoDigit(i) == true).sum();
	}

	public boolean isTwoDigit(int num) {
		return (num >= 10 && num <= 99) || (num >= -99 && num <= -10);
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.solution(new int[] { 1, 1000, 80, -91 }));
		System.out.println(s.solution(new int[] { 100, 1000, 80, -9, -10, -99 }));
	}

	public static class SolutionTest {

		Solution1 s = new Solution1();

		@Test
		public void test1() {
			assertThat(s.solution(new int[] { 1, 1000, 80, -91 }), is(-11));
		}

	}
}
