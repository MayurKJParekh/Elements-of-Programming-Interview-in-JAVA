public class ReverseWordsInASentence {

    /*
    7.6

    Since we spend 0(1) per character, the time complexity is0(n),where n is the length
of s. If strings are mutable, we can perform the computation in place, i.e., the
additional space complexity is 0(1). If the string cannot be changed, the additional
space complexity is0(n),since we need to create a new string of length n
    */

    public static void reverseWords(char[] input) {
// Reverses the whole string first.
        reverse(input, 0, input.length);
        int start = 0, end;
        while ((end = find(input, ' ', start)) != -1) {
// Reverses each word in the string.
            reverse(input, start, end);
            start = end + 1;
        }
        // Reverses the last word.
        reverse(input, start, input.length);
    }

    public static void reverse(char[] array, int start, int stoplndex) {
        if (start >= stoplndex) {
            return;
        }
        int last = stoplndex - 1;
        for (int i = start; i <= start + (last - start) / 2; i++) {
            char tmp = array[i];
            array[i] = array[last - i + start];
            array[last - i + start] = tmp;
        }
    }

    public static int find(char[] array, char c, int start) {
        for (int i = start; i < array.length; i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }
}
