package br.com.currencyCalculator.convertion.implementation;

import br.com.currencyCalculator.convertion.Currency;
import br.com.currencyCalculator.convertion.FixedOperatingFeeCalculable;
import br.com.currencyCalculator.convertion.IOFCalculable;

import java.math.BigDecimal;

public class Euro extends Currency implements FixedOperatingFeeCalculable, IOFCalculable {
    private BigDecimal quotation = new BigDecimal("0.2");

    private String abbreviation = "EUR";

    public String getAbbreviation() {
        return this.abbreviation;
    }

    @Override
    public BigDecimal calculateFixedOperatingFee() {
        return new BigDecimal(6.0);
    }

    @Override
    public BigDecimal calculateIOF(BigDecimal amount) {
        return new BigDecimal("0.011").multiply(amount);
    }

    @Override
    public BigDecimal calculateOperatingFee(BigDecimal amount) {
        return calculateFixedOperatingFee();
    }

    @Override
    public BigDecimal calculateConversion(BigDecimal amount) {
        return quotation.multiply(amount.subtract(calculateIOF(amount)).subtract(calculateFixedOperatingFee()));
    }
}
