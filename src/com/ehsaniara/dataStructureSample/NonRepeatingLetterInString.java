package com.ehsaniara.dataStructureSample;

import java.util.LinkedHashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/29/17.
 * From http://www.ehsaniara.com
 */
public class NonRepeatingLetterInString {
    private void findFirstNonRepeatingLetter(String s, Consumer<Character> callback) {
        s.chars()
                .mapToObj(i -> Character.valueOf((char) i))
                .collect(Collectors.groupingBy(identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findAny().map(c -> {
            callback.accept(c);
            return c;
        });
    }

    public static void main(String[] args) {
        new NonRepeatingLetterInString().findFirstNonRepeatingLetter("ehsaniara", System.out::println);





    }
}
