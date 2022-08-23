package br.com.currencyCalculator.convertion;

import java.math.BigDecimal;

public abstract class Currency implements IOFCalculable, FixedOperatingFeeCalculable {
    protected BigDecimal quotation;
    protected String abbreviation;

    public abstract BigDecimal calculateConversion(BigDecimal amount);
    public abstract BigDecimal calculateOperatingFee(BigDecimal amount);

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public BigDecimal calculateIOF(BigDecimal amount) {
        return new BigDecimal("0.011").multiply(amount);
    }

}
