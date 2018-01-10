package com.test.guava;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
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
		String result = Joiner.on(" , ").withKeyValueSeparator(" = ")
				.join(salary);
		assertThat(result, containsString("John = 10000"));
		assertThat(result, containsString("Jane = 15000"));
	}

	@Test
	public void joinNestedCollections() {
		List<ArrayList<String>> nested = Lists.newArrayList(
				Lists.newArrayList("1", "2", "3"),
				Lists.newArrayList("4", "5", "6"));
		String result = Joiner.on(";").join(
				Iterables.transform(nested,
						new Function<List<String>, String>() {

							@Override
							public String apply(List<String> input) {
								return Joiner.on("-").join(input);
							}

						}));
		assertThat(result, containsString("1-2-3;4-5-6"));
	}

	@Test
	public void convertListToStringAndSkipNull() {
		List<String> names = Lists.newArrayList("Rahim", "Karim", "John", null);
		String result = Joiner.on(",").skipNulls().join(names);
		assertEquals(result, getValue("name.lst"));
	}

	@Test
	public void convertListToStringAndUseForNull() {
		List<String> names = Lists.newArrayList("Rahim", "Karim", "John", null);
		String result = Joiner.on(",").useForNull("///").join(names);
		assertEquals(result, getValue("name.lst.null"));
	}

	@Test
	public void createListFromString() {
		String input = "First - Second-Third";
		List<String> result = Splitter.on("-").trimResults().splitToList(input);
		assertThat(result, contains("First", "Second", "Third"));
	}

	@Test
	public void createMapFromString() {
		String input = "First=1, Second=2, Third=3";
		Map<String, String> result = Splitter.on(",").trimResults()
				.withKeyValueSeparator("=").split(input);
		assertEquals("1", result.get("First"));
		assertEquals("3", result.get("Third"));
	}

	@Test
	public void splitStringWithMultipleSeparator() {
		String input = "abc .def,ghi, ,.";
		List<String> result = Splitter.onPattern("[,|.]").trimResults()
				.omitEmptyStrings().splitToList(input);
		assertThat(result, contains("abc", "def", "ghi"));
	}

	@Test
	public void splitStringOnSpecificLength() {
		String input = "I LOVE MY COUNTRY";
		List<String> result = Splitter.fixedLength(3).splitToList(input);
		assertThat(result, contains("I L", "OVE", " MY", " CO", "UNT", "RY"));
	}
	
	@Test
	public void limitSplitting(){
		String input = "Ba,ng,la,de,s,h";
		List<String> result = Splitter.on(",").limit(3).splitToList(input);
		assertThat(result, contains("Ba", "ng", "la,de,s,h"));
	}
}
