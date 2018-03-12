package com.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.apache.commons.lang3.ArrayUtils;

@SuppressWarnings("unused")
public class JSPRead {

	private String message;
	private JSPUtility jspUtility;
	private Queue<Tags> tagQueue = new LinkedList<Tags>();
	private int lineNumber = 0;
	private int isDuplicate = 0;
	
	private String fileName=""; 

	private class Tags {
		int lineNumber;
		List<String> tagList = new ArrayList<String>();

		public int getLineNumber() {
			return lineNumber;
		}

		public void setLineNumber(int lineNumber) {
			this.lineNumber = lineNumber;
		}

		public List<String> getTagList() {
			return tagList;
		}

		public void setTagList(List<String> tagList) {
			this.tagList = tagList;
		}

		@Override
		public String toString() {
			return "Tags [lineNumber=" + lineNumber + ", tagList=" + tagList
					+ "]";
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
	public int parseJSP(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		fileName = file.getName();
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			doProcess(line);
		}
		isDuplicate = 0;
		duplicateCheck();
		return isDuplicate;
	}

	private void doProcess(String line) {
		lineNumber++;
		/*System.out.println(lineNumber);*/
		jspUtility.doParse(line);
		Tags tags = new Tags();
		tags.setLineNumber(lineNumber);
		if (jspUtility.getTagList().size() > 0) {
			for (String tag : jspUtility.getTagList()) {
				tags.getTagList().add(tag);
			}
		}
		tagQueue.add(tags);
	}

	private void duplicateCheck() {
		Tags tags;
		while ((tags = tagQueue.poll()) != null) {
			if (tags.getTagList().size() > 0) {
				for (String text : tags.getTagList()) {
					//System.out.println(text);
					Map<String, String> mapAttributes = new HashMap();
					String key="", value="";
					for (String attribute : getTagAttributes(text)) {
						if (attribute.contains("=")) {
							String[] attributeArray = attribute.split("=");
							key = attributeArray[0].trim();
							if(attributeArray.length>1) {
								value = attributeArray[1].trim();
							}
							
							/*if (attributeArray.length > 2) {
								System.out.println("Line "
										+ tags.getLineNumber()
										+ " has attribute space problem" + attributeArray[2]);
							}*/
							if (mapAttributes.containsKey(key)) {
								isDuplicate++;
								PrintWriter pw = null;
								try {
									pw = new PrintWriter(new FileOutputStream("d:/duplicateAttribute.txt", true), true);
									String message = "File: " + fileName + ", Duplicate attribute [" + key
											+ "] has been found on line "
											+ tags.getLineNumber() + " of tag "
											+ getTagName(text)+"\n";
									pw.append(message);
									pw.close();
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} finally {
									pw.close();
								}
								
							} else {
								mapAttributes.put(key, value);
							}
						}

					}
				}
			}
		}
	}

	private String[] getTagAttributes(String txt) {
		while (txt.indexOf("= ") >= 0) {
			txt = txt.replace("= ", "=");
		}
		while (txt.indexOf(" =") >= 0) {
			txt = txt.replace(" =", "=");
		}
		txt = txt.trim();
		String[] textArray = txt.split("\\s+");
		return textArray;
	}

	private String getTagName(String txt) {
		String[] textArray = txt.split("\\s+");

		return "<" + textArray[0] + ">";
	}

}
