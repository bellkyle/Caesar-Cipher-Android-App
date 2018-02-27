package com.example.kyle.encryptionapp;

/**
 * Created by Kyle on 1/31/2018.
 */

public class CaesarCipher {
    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String transformedAlphabet = "";
    private int key;
    private String word;

    public CaesarCipher(String word, int key) {
        this.word = word.toUpperCase();
        this.key = key;
        //cycle trough the alphabet and start the transformed alphabet with the
        //character of the alphabet with the index of the key
        for(int i = 0; i < alphabet.length(); i++) {
            transformedAlphabet += alphabet.charAt((key+i)%alphabet.length());//use a modolus to loop
        }
    }

    public String encrypt() {
        String encryptedWord = "";
        //cycle through the word and replace the letter in the alphabet with the letter with the same
        //index in the transformed alphabet
        for(int i = 0; i < word.length(); i++) {
            //if statement to delete spaces and special charaters
            if(alphabet.indexOf(word.charAt(i)) != -1)
                encryptedWord += transformedAlphabet.charAt(alphabet.indexOf(word.charAt(i)));
        }
        word = encryptedWord;
        return word;
    }

    public String decrypt() {
        String decryptedWord = "";
        //cycle through the word and replace the letter in the transformed alphabet with the letter with the same
        //index in the alphabet
        for(int i = 0; i < word.length(); i++) {
            //if statement ignore spaces and special characters because the format might not be known
            if(transformedAlphabet.indexOf(word.charAt(i)) == -1)
                decryptedWord += word.charAt(i);
            else
                decryptedWord += alphabet.charAt(transformedAlphabet.indexOf(word.charAt(i)));
        }
        word = decryptedWord;
        return word;
    }
    public void print() {
        //System.out.println("Transformed alphabet is " + transformedAlphabet);
        System.out.println("word is " + word);
    }

}
