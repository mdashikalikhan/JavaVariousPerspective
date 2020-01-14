package com.practice;

public class SherlockValidity {

	public static void main(String[] args) {
		String s = "aaaabbcc";
		
		
		//s = "dddeeffgghh";
		
		//s= "aabbccddeefghi";
		
		//s="aabbaddd";
		
		//s = "aaaabbcc";
		
		//s ="aaaaabc";
		
		//s = "abcdefghhgfedecba";
		
		//s="ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
		
		System.out.println(isValid(s));
	}
	
	static String isValid(String s) {
        if(s.length()==1) {
            
            return "YES";
        }
        
        int[] occurrences = new int[26];

        for(int i=0; i<s.length(); i++) {
            occurrences[s.charAt(i)-97]++;
            
        }
        
        for(int i=0; i<occurrences.length; i++) {
        	if(occurrences[i]==0) {
                continue;
            }
        	
        	System.out.println(i + "  " + occurrences[i]);
        }
        
        int max = 0, min = 1000001;
        for(int i=0; i<occurrences.length ; i++) {
            
            if(occurrences[i]==0) {
                continue;
            }
            if(occurrences[i]>max) {
                max = occurrences[i];
            }
            
            if(occurrences[i]<min) {
                min = occurrences[i];
            }
        }
        
        if(max==min) {
            return "YES";
        }
		
        int minCount = 0;
        int maxCount = 0;
        
        for(int i=0; i<occurrences.length; i++) {
        	if(occurrences[i]==0) {
                continue;
            }
        	if(occurrences[i]>min && occurrences[i]<max) {
        		return "NO";
        	}
        	if(occurrences[i]==min) {
        		minCount++;
        	} else if(occurrences[i]==max) {
        		maxCount++;
        	}
        }
        
        System.out.println("minCount " + minCount);
        System.out.println("maxCount " + maxCount);
        
        if(minCount==1 && min==1 ) {
        	return "YES";
        } else if(max-min>1) {
        	return "NO";
        } else if(minCount >1 && maxCount > 1) {
        	return "NO";
        }
        return "YES";
    }

}
