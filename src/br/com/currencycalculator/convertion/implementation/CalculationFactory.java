package br.com.currencycalculator.convertion.implementation;

import br.com.currencycalculator.convertion.Currency;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CalculationFactory {
    private Map<String, Currency> calculationMap;

    public CalculationFactory() {
        calculationMap = new HashMap<>();
        calculationMap.put("1", new Euro());
        calculationMap.put("2", new Dollar());
        calculationMap.put("3", new ArgentinianPeso());
        calculationMap.put("4", new ChileanPeso());
    }

    public Optional<Currency> create(String operation) {
        return Optional.ofNullable(calculationMap.get(operation));
    }
}
