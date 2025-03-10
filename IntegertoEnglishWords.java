// TC: O(log n) as the input number is traversed by length 3 at a time, using recursion.
// SC: O(1) no extra space is used

// Runs successfully on leetcode
// Number is fetched by length 3 from behind and converted to string using the global array
public class IntegertoEnglishWords {

    public static void main(String[] args) {
        System.out.println(numberToWords(123)); // One Hundred Twenty Three
        System.out.println(numberToWords(12345)); // Twelve Thousand Three Hundred Forty Five
        System.out.println(numberToWords(1234567)); // One Million Two Hundred Thirty Four Thousand Five Hundred Sixty
                                                    // Seven
    }

    static String[] thousands = { "", "Thousand ", "Million ", "Billion " };
    static String[] below_20 = { "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ",
            "Ten ",
            "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
            "Nineteen " };
    static String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    static StringBuilder sb;

    public static String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        int i = 0;
        sb = new StringBuilder();
        while (num > 0) {
            if (num % 1000 != 0)
                sb.insert(0, recurse(num % 1000) + thousands[i]);
            i++;
            num /= 1000;
        }
        return sb.toString().trim();
    }

    private static String recurse(int num) {
        if (num == 0)
            return "";
        else if (num < 20) {
            return below_20[num];
        } else if (num < 100) {
            return tens[num / 10] + " " + below_20[num % 10];
        } else {
            return below_20[num / 100] + "Hundred " + recurse(num % 100);
        }
    }

}