package com.leetcode.practice;

public class TextEditor {
	StringBuilder sb ;
	int pos = 0;
	public TextEditor() {
        sb = new StringBuilder("|");
    }
    
    public void addText(String text) {
        sb.insert(pos, text);
        pos = pos + text.length();
        System.out.println(sb + "  " + pos);
        //sb.delete(4, 8);
        //System.out.println(sb);
    }
    
    public int deleteText(int k) {
    	int deletedLength = k>pos ? pos : k;
    	sb.delete(pos-deletedLength, pos);
    	System.out.println(sb + "   "  + deletedLength);
    	pos = pos - deletedLength;
        return deletedLength;
    }
    
    public String cursorLeft(int k) {
    	int movePos = k>pos ? pos : k;
    	
    	sb.deleteCharAt(pos);
    	pos -= movePos;
    	sb.insert(pos, "|");
    	
    	System.out.println(sb);
    	
    	
    	int length = Math.min(10, pos);
    	
    	int beginIndex = pos - length;
    	int endIndex = beginIndex + length;
    	String s = sb.substring(beginIndex, endIndex);
    	System.out.println(s + "  " + beginIndex + "  " + endIndex);
        return s;
    }
    
    public String cursorRight(int k) {
    	int movePos = sb.length()-1 - pos;
    	movePos = k>movePos ? movePos : k;
    	sb.deleteCharAt(pos);
    	pos += movePos;
    	sb.insert(pos, "|");
    	System.out.println(sb);
    	int length = Math.min(pos, 10);
    	int beginIndex = pos - length;
    	int endIndex = beginIndex + length;
    	String s = sb.substring(beginIndex, endIndex);
    	System.out.println(s + "  " + beginIndex + "  " + endIndex);
        return s;
    }
    public static void main(String[] args) {
    	TextEditor app = new TextEditor();
    	app.addText("leetcode");
    	app.deleteText(4);
    	app.addText("practice");
    	app.cursorRight(3);
    	app.cursorLeft(8);
    	app.deleteText(10);
    	app.cursorLeft(2);
    	app.cursorRight(6);
	}
}
