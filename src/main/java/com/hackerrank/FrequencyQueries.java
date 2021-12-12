package com.hackerrank;

import java.util.*;

public class FrequencyQueries {
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> returnList = new ArrayList<>();

		Map<Integer, Integer> occurrences = new HashMap<>();

		Map<Integer, Set<Integer>> countOccurrences = new HashMap<>();

		for (List<Integer> query : queries) {
			int queryType = query.get(0);
			int queryVal = query.get(1);
			Set<Integer> tmpSet = new HashSet<>();
			int occurrenceVal = 0;
			if (occurrences.containsKey(queryVal)) {
				occurrenceVal = occurrences.get(queryVal);
			}

			if (queryType == 1) {
				if (occurrenceVal == 0) {
					occurrences.put(queryVal, 1);
					if (countOccurrences.containsKey(1)) {
						tmpSet = countOccurrences.get(1);
						tmpSet.add(queryVal);
						countOccurrences.put(1, tmpSet);
					} else {
						tmpSet.add(queryVal);
						countOccurrences.put(1, tmpSet);
					}
				} else {
					occurrences.put(queryVal, occurrenceVal + 1);
					tmpSet = countOccurrences.get(occurrenceVal);
					tmpSet.remove(queryVal);
					countOccurrences.put(occurrenceVal, tmpSet);

					if (countOccurrences.containsKey(occurrenceVal + 1)) {
						tmpSet = countOccurrences.get(occurrenceVal + 1);
					} else {
						tmpSet = new HashSet<>();
					}
					tmpSet.add(queryVal);
					countOccurrences.put(occurrenceVal + 1, tmpSet);
				}
			} else if (queryType == 2) {
				if (occurrenceVal > 0) {
					occurrences.put(queryVal, occurrenceVal - 1);
					tmpSet = countOccurrences.get(occurrenceVal);
					tmpSet.remove(queryVal);
					countOccurrences.put(occurrenceVal, tmpSet);

					if (occurrenceVal - 1 > 0) {
						if (countOccurrences.containsKey(occurrenceVal - 1)) {
							tmpSet = countOccurrences.get(occurrenceVal - 1);
						} else {
							tmpSet = new HashSet<>();
						}
						tmpSet.add(queryVal);
						countOccurrences.put(occurrenceVal - 1, tmpSet);
					}

				}

			} else if (queryType == 3) {
				if (countOccurrences.containsKey(queryVal)) {
					tmpSet = countOccurrences.get(queryVal);
					if (tmpSet.size() > 0) {
						returnList.add(1);
					} else {
						returnList.add(0);
					}
				} else {
					returnList.add(0);
				}
			}
		}

		return returnList;

	}

}
