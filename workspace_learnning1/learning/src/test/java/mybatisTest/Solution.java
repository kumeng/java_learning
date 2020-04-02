package mybatisTest;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fibonacci = new Solution().fibonacci(47);
		System.out.println(fibonacci);
	}

    public int fibonacci(int n) {
        // write your code here
        switch(n){
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                return fibonacci(n-1)+fibonacci(n-2);
        }
    }	
}
