package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    private static ArrayList<String> wordList= new ArrayList<String>();
    private static HashSet<String> wordSet = new HashSet<>();
    private static HashMap<String, ArrayList<String>> lettersToWord = new HashMap<>();
    private Set set = lettersToWord.entrySet();
    private Iterator i = set.iterator();




    public AnagramDictionary(InputStream wordListStream) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;



        while((line = in.readLine()) != null) {
            String word = line.trim();
            /*
            if(lettersToWord.containsKey(sortLetter(word)));
            {
                lettersToWord.put(sortLetter(word), word);
            }*/

            wordList.add(word);
        }
    }

    public boolean isGoodWord(String word, String base) {
        return true;
    }

    public ArrayList<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();

        String comparer = sortLetter(targetWord);
        String value= "";

        for(int i=0; i< wordList.size(); i++)
        {
            value = sortLetter(wordList.get(i));
            if(value.length()==comparer.length())
            {
                if(value.equalsIgnoreCase(comparer))
                {
                    result.add(wordList.get(i));
                }
            }
        }


       /*
       for(int i=0; i<result.size(); i++)
       {
           System.out.println(result.get(i));
       }
       */
        return result;
    }

    public String sortLetter(String word)
    {
        char[] sorter = word.toCharArray();
        Arrays.sort(sorter);
        word = new String(sorter);

        return word;
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }

    public String pickGoodStarterWord() {
        return "stop";
    }
}

