package org.dragon.practice.study.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/5/28
 **/
public class RearrangeWordsInSentence {

    public String arrangeWords(String text) {
        List<Word> wordList = new ArrayList<>();
        String word = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                wordList.add(new Word(word.length(), word));
                word = "";
            } else {
                word += text.charAt(i);
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
        }

        return text;
    }

    class Word {
        private int length;
        private String text;

        public Word(int length, String text) {
            this.length = length;
            this.text = text;
        }
    }


}
