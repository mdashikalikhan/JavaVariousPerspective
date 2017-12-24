package com.test.guava;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.test.TestInitialize;

public class GuavaJoinSplitTest extends TestInitialize {
	@Test
	public void convertListToString() {
		List<String> names = Lists.newArrayList("Rahim", "Karim", "John");
		String result = Joiner.on(",").join(names);
		assertEquals(result, getValue("name.lst"));
	}
	
	@Test
	public void convertMapToString() {
		String result = Joiner.on(" , ").withKeyValueSeparator(" = ").join(salary);
		assertThat(result, containsString("John = 10000"));
		assertThat(result, containsString("Jane = 15000"));
	}
	
	public void joinNestedCollections() {
		
	}
}
