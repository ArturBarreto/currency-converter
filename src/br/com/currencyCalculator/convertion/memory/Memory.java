package br.com.currencyCalculator.convertion.memory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Memory {
    private static Memory singleInstance = null;
    private Map<Long, ConversionEntry> memory;

    private Memory() {
        this.memory = new HashMap<>();
    }

    public static Memory getInstance() {
        if (singleInstance == null) {
            singleInstance = new Memory();
            return singleInstance;
        }
        return singleInstance;
    }

    public Map<Long, ConversionEntry> getConversions() {
        return Collections.unmodifiableMap(memory);
    }

    public void add(ConversionEntry conversionEntry) {
        this.memory.put(conversionEntry.getId(), conversionEntry);
    }
}
