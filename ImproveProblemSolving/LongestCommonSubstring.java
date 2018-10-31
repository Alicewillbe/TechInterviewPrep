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
	public static String solution(String s1, String s2) {
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
}