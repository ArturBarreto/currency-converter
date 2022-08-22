package br.com.currencyCalculator.convertion;

import java.math.BigDecimal;

public abstract class Currency {
    protected BigDecimal quotation;
    protected String abbreviation;

    public abstract BigDecimal calculateConversion(BigDecimal amount);
    public abstract String getAbbreviation();
    public abstract BigDecimal calculateIOF(BigDecimal amount);
    public abstract BigDecimal calculateOperatingFee(BigDecimal amount);
}
