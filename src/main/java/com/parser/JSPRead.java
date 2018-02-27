package com.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JSPRead {
	
	public static String deserializeString(File file)
			  throws IOException {
			      int len;
			      char[] chr = new char[4096];
			      final StringBuffer buffer = new StringBuffer();
			      final FileReader reader = new FileReader(file);
			      try {
			          while ((len = reader.read(chr)) > 0) {
			              buffer.append(chr, 0, len);
			          }
			      } finally {
			          reader.close();
			      }
			      return buffer.toString();
			  }

}
