package br.com.currencyCalculator.convertion.implementation;

import br.com.currencyCalculator.convertion.Currency;

import java.math.BigDecimal;

public class Euro extends Currency {

    public Euro() {
        quotation = new BigDecimal("0.2");
        abbreviation = "EUR";
    }

    @Override
    public BigDecimal calculateFixedOperatingFee() {
        return new BigDecimal("6.0");
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
