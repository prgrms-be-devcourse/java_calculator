package hello.core.repository;

import java.util.Map;
import java.util.Set;

public interface CalculatorRepository {
    void putHistory(String order, Double answer);
    Set<Map.Entry<String, Double>> getHistory();
}
