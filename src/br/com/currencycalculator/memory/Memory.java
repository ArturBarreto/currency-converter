package br.com.currencycalculator.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Memory {
    private static Memory singleInstance = null;
    private final List<ConversionEntry> memory;

    private Memory() {
        this.memory = new ArrayList<>();
    }

    public static Memory getInstance() {
        if (singleInstance == null) {
            singleInstance = new Memory();
            return singleInstance;
        }
        return singleInstance;
    }

    public List<ConversionEntry> getConversions() {
        return Collections.unmodifiableList(memory);
    }

    public void add(ConversionEntry conversionEntry) {
        this.memory.add(conversionEntry);
    }
}
