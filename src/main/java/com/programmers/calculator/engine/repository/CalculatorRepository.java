package com.programmers.calculator.engine.repository;

public interface CalculatorRepository {
	void save(String formula, String answer);

	void clear();

	int size();

	String values();

	boolean alreadyCalculated(String formula);

	String findByFormula(String formula);
}
