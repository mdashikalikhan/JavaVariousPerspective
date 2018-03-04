package com.parser;

import java.util.ArrayList;
import java.util.List;

public class JSPUtility {

	private int commented = 0;
	private int tagStarted = 0;
	private int bodyTagStarted = 0;
	private String tag;
	private List<String> tagList  = new ArrayList();

	public List<String> getTagList() {
		return tagList;
	}

	public void doParse(String str) {
		tagList.clear();
		processContent(str);
		for(String txt : tagList) {
			System.out.println(txt);
		}
	}

	private void processContent(String str) {
		String actualContents = getUncommentedContents(str);
		removeNotRequiredContents(actualContents.toString());
		
	}

	private void removeNotRequiredContents(String str) {
		StringBuffer text = new StringBuffer(str);
		startExecution(text);
	}
	
	private void startExecution(StringBuffer txt) {
		while(true){
			setTagContent(txt.toString());
			if(checkTag()==1){
				tagList.add(tag);
			}
			txt = adjustText(txt);
			if(txt.toString().trim().equals("")) {
				break;
			}
		}
		 
	}
	
	private StringBuffer adjustText(StringBuffer txt) {
		
		String content;
		if(txt.indexOf(">")>=0) {
			content =  txt.substring(txt.indexOf(">")+1);
		} else {
			content= "";
		}
		return new StringBuffer(content);
	}
	
	private int checkTag() {
		int status = 0;
		
		if(!tag.trim().equals("") && tagStarted==0 && bodyTagStarted==0) {
			bodyTagStarted = bodayTagCheck();
		} 
		if(!tag.trim().equals("") && tagStarted==0 && bodyTagStarted==1){
			status = jspTagCheck();
		}
		return status;
	}
	
	private int bodayTagCheck() {
		int status = 0;
		String text[] = tag.split("\\s+"); 
		if(text[0].equalsIgnoreCase("body")) {
			status = 1;
		}
		return status;
	}
	
	private int jspTagCheck() {
		int status = 0;
		String text[] = tag.split("\\s+"); 
		if(text[0].contains(":") && !text[0].contains("/") && !text[0].contains("!")) {
			status = 1;
		}
		return status;
	}
	
	private void setTagContent(String str) {
		String content="";
		if(str.indexOf("<")>=0 && tagStarted==0) {
			if(str.indexOf(">", str.indexOf("<"))>=0) {
				content = str.substring(str.indexOf("<")+1, str.indexOf(">"));
			} else {
				content = str.substring(str.indexOf("<")+1);
				tagStarted++;
			}
			
		} else if(str.indexOf(">")>=0 && tagStarted==1) {
			content = str.substring(str.indexOf(">"));
			tagStarted--;
		}
		setTag(content);
	}
	
	
	private void setTag(String str) {
		if(tagStarted==0){
			tag = str;
		} else {
			tag += str;
		}
	}
	
	private String getUncommentedContents(String str) {
		String strText = removeComments(str);
		return strText.trim();
	}

	private String removeComments(String str) {
		StringBuffer text = new StringBuffer(str);
		while (isInLineComments(text) == 1) {
			text = removeHtmlInLineComments(text);
			text = removeJspInLineComments(text);
		}
		if (commented > 0) {
			if (hasEndCommentTag(text) == 1) {
				text = afterComment(text);
			} else {
				text.delete(0, text.length());
			}
		}
		if (hasStartCommentTag(text) == 1) {
			text = beforeComment(text);
		}
		return text.toString();
	}

	private int hasStartCommentTag(StringBuffer str) {
		int count = 0;
		if (str.indexOf("<!--") >= 0 || str.indexOf("<%") >= 0) {
			count = 1;
			commented++;
		}
		return count;
	}

	private int hasEndCommentTag(StringBuffer str) {
		int count = 0;
		if (str.indexOf("-->") >= 0 || str.indexOf("%>") >= 0) {
			count = 1;
			if (commented > 0) {
				commented--;
			}
		}
		return count;
	}

	private int isInLineComments(StringBuffer str) {
		int count = 0;
		if ((str.indexOf("<!--") >= 0 && str
				.indexOf("-->", str.indexOf("<!--")) >= 0)
				|| (str.indexOf("<%") >= 0 && str.indexOf("%>",
						str.indexOf("<%")) >= 0)) {
			count = 1;
		}
		return count;
	}

	private StringBuffer removeHtmlInLineComments(StringBuffer str) {
		if (str.indexOf("<!--") >= 0
				&& str.indexOf("-->", str.indexOf("<!--")) >= 0) {
			str.replace(str.indexOf("<!--"),
					str.indexOf("-->", str.indexOf("<!--")) + 3, "");
		}
		return str;
	}

	private StringBuffer removeJspInLineComments(StringBuffer str) {
		if (str.indexOf("<%") >= 0 && str.indexOf("%>", str.indexOf("<%")) >= 0) {
			str.replace(str.indexOf("<%"),
					str.indexOf("%>", str.indexOf("<%")) + 2, "");
		}
		return str;
	}

	private StringBuffer afterComment(StringBuffer str) {
		if (str.indexOf("-->") >= 0) {
			str.replace(0, str.lastIndexOf("-->") + 3, "");
		}
		if (str.indexOf("%>") >= 0) {
			str.replace(0, str.lastIndexOf("%>") + 2, "");
		}
		return str;
	}

	private StringBuffer beforeComment(StringBuffer str) {
		if (str.indexOf("<!--") >= 0) {
			str.replace(str.indexOf("<!--"), str.length(), "");
		}
		if (str.indexOf("<%") >= 0) {
			str.replace(str.indexOf("<%"), str.length(), "");
		}
		return str;
	}

}
