package cn.lv.algorithms.chapter01.task;

public class task {
    public static void main(String[] args) {
        System.out.println(task.isPalindrome("LeooeL"));
    }

    /**
     * 检查是否是回文字符串
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int N = s.length();
        for (int i = 0; i < N / 2; i++) {
            if (s.charAt(i) != s.charAt(N - 1 - i))
                return false;
        }
        return true;
    }
}
