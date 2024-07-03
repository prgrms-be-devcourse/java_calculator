package hello.core.repository;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Component
public class CalculatorRepositoryV0 implements CalculatorRepository {

    private Map<String, Double> memory = new LinkedHashMap<>();

    @Override
    public void putHistory(String order, Double answer) {
        memory.put(order, answer);
    }

    @Override
    public Set<Map.Entry<String, Double>> getHistory() {
        Set<Map.Entry<String, Double>> entries = memory.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue().intValue());
        }
        return memory.entrySet();
    }
}
