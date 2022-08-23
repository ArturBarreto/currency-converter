package br.com.currencyCalculator.convertion.memory;

import br.com.currencyCalculator.convertion.util.BigDecimalUtil;

import java.math.BigDecimal;

public class ConversionEntry {
    private static Long id = 0L;
    private Long entryId;
    private String abreviation;
    private BigDecimal amount;
    private BigDecimal result;

    public ConversionEntry(String abreviation, BigDecimal amount, BigDecimal result) {
        this.entryId = id++;
        this.abreviation = abreviation;
        this.amount = amount;
        this.result = result;
    }

    public Long getId() {
        return this.entryId;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Conversão: {" +
                "Valor em Real: R$ = " + BigDecimalUtil.format(amount) +
                "; Valor em " + abreviation + " = " + BigDecimalUtil.format(result) + '}';
    }
}
