package com.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class JSPRead {

	private String message;
	private JSPUtility jspUtility;
	private Queue<Tags> tagQueue = new LinkedList<Tags>();
	
	private class Tags {
		int lineNumber;
		String tagContents;
		public int getLineNumber() {
			return lineNumber;
		}
		public void setLineNumber(int lineNumber) {
			this.lineNumber = lineNumber;
		}
		public String getTagContents() {
			return tagContents;
		}
		public void setTagContents(String tagContents) {
			this.tagContents = tagContents;
		}
		
	}
	
	
	public JSPRead() {
		jspUtility = new JSPUtility();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@SuppressWarnings("resource")
	public void parseJSP(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while((line=bufferedReader.readLine())!=null) {
			doProcess(line);
		}

	}
	
	private void doProcess(String line) {
		jspUtility.doParse(line);
	}

}
