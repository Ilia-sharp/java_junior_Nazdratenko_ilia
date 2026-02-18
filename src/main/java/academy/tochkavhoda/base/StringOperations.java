package academy.tochkavhoda.base;

import java.util.StringJoiner;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int total = 0;
        for (String s : strings) {
            total += s.length();
        }
        return total;
    }

    public static String getFirstAndLastLetterString(String string) {
        return "" + string.charAt(0) + string.charAt(string.length() - 1);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1 + string2;
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        int minLen = Math.min(string1.length(), string2.length());
        int i = 0;
        while (i < minLen && string1.charAt(i) == string2.charAt(i)) {
            i++;
        }
        return string1.substring(0, i);
    }

    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        return string.equals(reverse(string));
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return string.equalsIgnoreCase(reverse(string));
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String longest = "";
        for (String s : strings) {
            if (isPalindromeIgnoreCase(s) && s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (index + length > string1.length() || index + length > string2.length()) {
            return false;
        }
        String sub1 = string1.substring(index, index + length);
        String sub2 = string2.substring(index, index + length);
        return sub1.equals(sub2);
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1,
                                                        String string2, char replaceInStr2, char replaceByInStr2) {
        String result1 = string1.replace(replaceInStr1, replaceByInStr1);
        String result2 = string2.replace(replaceInStr2, replaceByInStr2);
        return result1.equals(result2);
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                     String string2, String replaceInStr2, String replaceByInStr2) {
        String result1 = string1.replace(replaceInStr1, replaceByInStr1);
        String result2 = string2.replace(replaceInStr2, replaceByInStr2);
        return result1.equals(result2);
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        String noSpaces = string.replace(" ", "");
        return isPalindromeIgnoreCase(noSpaces);
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        if (array.length == 0) return "";
        StringJoiner joiner = new StringJoiner(",");
        for (int n : array) {
            joiner.add(String.valueOf(n));
        }
        return joiner.toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        if (array.length == 0) return "";
        StringJoiner joiner = new StringJoiner(",");
        for (double d : array) {
            joiner.add(String.format("%.2f", d));
        }
        return joiner.toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) sb.append(",");
            sb.append(array[i]);
        }
        return sb;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) sb.append(",");
            sb.append(String.format("%.2f", array[i]));
        }
        return sb;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder sb = new StringBuilder(string);
        for (int i = positions.length - 1; i >= 0; i--) {
            sb.deleteCharAt(positions[i]);
        }
        return sb;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder sb = new StringBuilder(string);
        for (int i = 0; i < positions.length; i++) {
            sb.insert(positions[i] + i, characters[i]);
        }
        return sb;
    }
}