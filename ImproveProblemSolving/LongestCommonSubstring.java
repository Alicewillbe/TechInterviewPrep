/**
* date: 10/30/2018
* interview: Robert
* company: indeed
*
* solving process:
*    1. asking requirement
*           edge cases
*           What characterize a good solution? (*)
*                Don't require time, space efficiency
*                Need code easy to understand
*                Dynamic programing is a bad approach here,
*                not easy to understand
*
*    2. test cases
*           table format is good
*           ask test examples from interviewers
*                to understand the question more (*)
*                if there is multiple answers...
*                
*    3. writing out the solution
*           (edge cases)
*           func body written in a clear way is good
*           check the answer in the end
*
*    4. What's the bad thing about this algorithm?
*           func specific
*
*    5. what's the big-oh of it? O(n^3*m)
*           hidden loop kills people 
*/
public class LongestCommonSubstring {
	public static String poorSolution(String s1, String s2) {
		String reuslt = "";
		for (int i = 0; i < s1.length(); i++) {
			// bug here if you want to use substring
			for (int j = s1.length() - 1; j >= i; j--) {
				// but here if you want to use substring
				if (s2.contains(s1.substring(i,j))) {
					// bug here
					if (result.length() < s1.substring(i,j).length()) {
						result = s1.substring(i,j);
					}
				}
			}
		}
		return result;
	}
	
	public static String bugFixedNotOptimal(String s1, String s2) {
		String reuslt = "";
		for (int i = 0; i < s1.length(); i++) {
			// in substring, we want range [i, j] be valid
			// i < j to ensure no empty string case
			// j is initially s1.length() to cover all cases
			for (int j = s1.length(); j > i; j--) {
				if (s2.contains(s1.substring(i,j))) {
					if (result.length() < s1.substring(i,j).length()) {
						result = s1.substring(i,j);
					}
				}
			}
		}
		return result;
	}
	
	// The big flaw during this interview is that I start coding
	// without thinking too much.
	// The very first thing I should do is to make sure I understand
	// the question and already have several high level solution to begin with
	// confirmed with interviewers, and start coding at once
	
	// Big picture:
	// Question: longest_common_subseq
	// Input: String s1, String s2
	// Output: String - null if one is null
	//                - "" if no common subseq
	//                - found some subseq
	//
	// Tests:
	// str1       str2        expect
	// "abvcd"    "abcd"      "ab"
	// "abcd"     "abcd"      "abcd"
	// some null		  null
	
	// Questions:
	// 1. duplicate answers, which to return?
	// 2. null case?
	// 3. what characterize a good solution?
	
	// Soln1: get all possible substrings from 1 input
	//	  check whether substring is contained in
	//        the other input
	// Soln2: get all possible substrings from the shorter input
	//        check whether they are contained in the longer input
	//        better if length of substring is in decreasing order
	
	public static String solution(String s1, String s2) {
		if (s1 == null || s2 == null) return null;
		if (s1.isEmpty() || s2.isEmpty()) return "";
		if (s1.length() > s2.length()) return solution(s2,s1);
		
		for (int i = s1.length(); i >= 1; i--) { // O(n)
			for (int j = 0; j < s1.length() + 1 - i; j++) { // worst case O(n)
				// take out the valid substring
				String curr = s1.substring(j, j + i);
				if (s2.contains(curr)) {  // O(i)
					return curr;
				}
			}
		}
		
		return ""; // not found
	}
}
