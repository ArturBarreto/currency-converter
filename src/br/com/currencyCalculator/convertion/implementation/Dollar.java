package br.com.currencyCalculator.convertion.implementation;

import br.com.currencyCalculator.convertion.Currency;
import br.com.currencyCalculator.convertion.FixedOperatingFeeCalculable;
import br.com.currencyCalculator.convertion.IOFCalculable;
import br.com.currencyCalculator.convertion.VariableOperatingFeeCalculable;

import java.math.BigDecimal;

public class Dollar extends Currency implements FixedOperatingFeeCalculable, VariableOperatingFeeCalculable, IOFCalculable {
    private BigDecimal quotation = new BigDecimal(0.19);

    private String abbreviation = "US$";

    @Override
    public String getAbbreviation() {
        return this.abbreviation;
    }

    @Override
    public BigDecimal calculateFixedOperatingFee() {
        return new BigDecimal(5.0);
    }

    @Override
    public BigDecimal calculateIOF(BigDecimal amount) {
        return new BigDecimal(0.011).multiply(amount);
    }

    @Override
    public BigDecimal calculateVariableOperatingFee(BigDecimal amount) {
        return new BigDecimal(0.03).multiply(amount);
    }

    @Override
    public BigDecimal calculateOperatingFee(BigDecimal amount) {
        return calculateFixedOperatingFee().add(calculateVariableOperatingFee(amount));
    }

    @Override
    public BigDecimal calculateConversion(BigDecimal amount) {
        return quotation.multiply(amount.subtract(calculateIOF(amount)).subtract(calculateFixedOperatingFee()).subtract(calculateVariableOperatingFee(amount)));
    }
}
