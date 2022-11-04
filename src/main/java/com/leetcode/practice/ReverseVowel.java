package com.leetcode.practice;

public class ReverseVowel {
    public static void main(String[] args) {
        String s = "aZAebBc";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb);
        int i = 0;
        int lastvowel = sb.length() - 1;
        while (lastvowel >= 0 &&
                !isVowel( sb.charAt(lastvowel))) {
            lastvowel--;
        }
        while (i < lastvowel) {

            if (!isVowel (sb.charAt(i))) {
                i++;
                continue;
            }

            char t = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(lastvowel));

            sb.setCharAt(lastvowel, t);

            i++;
            lastvowel--;



            while (lastvowel > i &&
                    !isVowel(sb.charAt(lastvowel))) {
                lastvowel--;
            }
            
           

            if (!isVowel( sb.charAt(lastvowel))) {
                
                break;
            }

        }
        System.out.println(sb.toString());

    }

    private static boolean isVowel(char c){
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;     
        }
    }
}