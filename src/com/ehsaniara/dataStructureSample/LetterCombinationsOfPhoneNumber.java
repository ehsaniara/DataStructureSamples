package com.ehsaniara.dataStructureSample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/30/17.
 * From http://www.ehsaniara.com
 */
public class LetterCombinationsOfPhoneNumber {
    static HashMap<Integer, String> map = new HashMap<>();

    static {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");
    }


    public List<String> letterCombinations(String digits) {

        digits = digits.replaceAll("[^0-9]", "")
                .replace("1", "");

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return result;

        List<Character> temp = new ArrayList<>();
        getData(digits, temp, result);

        return result;
    }

    public void getData(String digits, List<Character> temp, List<String> result) {
        if (digits.length() == 0) {
            char[] arr = new char[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                arr[i] = temp.get(i);
            }
            result.add(String.valueOf(arr));
            return;
        }

        Integer curr = Integer.valueOf(digits.substring(0, 1));
        String letters = map.get(curr);
        for (int i = 0; i < letters.length(); i++) {
            temp.add(letters.charAt(i));
            getData(digits.substring(1), temp, result);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("747 249 72 11"));
    }

}
