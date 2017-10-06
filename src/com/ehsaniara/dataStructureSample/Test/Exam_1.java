package com.ehsaniara.dataStructureSample.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/21/17.
 * From http://www.ehsaniara.com
 */
public class Exam_1 {

    public static void main(String[] args) {

        List<List<String>> codeList = new ArrayList<>();

        List<String> code = new ArrayList<>();
        code.add("orange");

        codeList.add(code);

        code = new ArrayList<>();
        code.add("apple");
        code.add("apple");

        codeList.add(code);

        code = new ArrayList<>();
        code.add("banana");
        code.add("orange");
        code.add("apple");

        codeList.add(code);

        code = new ArrayList<>();
        code.add("banana");

        codeList.add(code);


        List<String> shoppingCart = new ArrayList<>();
        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("banana");


        System.out.println(new Exam_1().checkWinner(codeList, shoppingCart));

    }

    public int checkWinner(List<List<String>> codeList,
                           List<String> shoppingCart) {
        // WRITE YOUR CODE HERE
        int machCounter = 0;

        for (int i = 0; i < codeList.size(); i++) {
            List<String> codes = codeList.get(i);

            if (isMached(shoppingCart, codes)) {
                machCounter++;
            }
        }

        return machCounter == codeList.size() ? 1 : 0;
    }


    private boolean isMached(List<String> shoppingCard, List<String> codes) {

        for (int i = 0; i < shoppingCard.size() - codes.size(); i++) {
            int counter = 0;
            for (int j = 0; j < codes.size(); j++) {
                System.out.println(shoppingCard.get(j) + "--->" + codes.get(j));
                if (shoppingCard.get(j + i).equals(codes.get(j)) || codes.get(j).equals("anything")) {
                    counter++;
                }
            }
            if (counter == codes.size())
                return true;
        }

        return false;
    }


}
