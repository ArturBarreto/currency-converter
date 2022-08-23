package br.com.currencycalculator.memory;

import br.com.currencycalculator.util.BigDecimalUtil;

import java.math.BigDecimal;

public class ConversionEntry {
    private final String abbreviation;
    private final BigDecimal amount;
    private final BigDecimal result;

    public ConversionEntry(String abbreviation, BigDecimal amount, BigDecimal result) {
        this.abbreviation = abbreviation;
        this.amount = amount;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Conversão: {" +
                "Valor em Real: R$ = " + BigDecimalUtil.format(amount) +
                "; Valor em " + abbreviation + " = " + BigDecimalUtil.format(result) + '}';
    }
}
