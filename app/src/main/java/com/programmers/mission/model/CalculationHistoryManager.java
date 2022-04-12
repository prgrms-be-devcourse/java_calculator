package com.programmers.mission.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculationHistoryManager implements HistoryManager<CalculationResult> {
	private static int id = 1;
	private static final Map<Integer, CalculationResult> histories = new HashMap<>();

	@Override
	public void save(CalculationResult calculationResult) {
		histories.put(id++, calculationResult);
	}

	@Override
	public List<CalculationResult> getHistories() {
		return histories.values().stream().toList();
	}
}
