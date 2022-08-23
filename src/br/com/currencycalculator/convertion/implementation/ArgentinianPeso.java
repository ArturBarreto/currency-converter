package br.com.currencycalculator.convertion.implementation;

import br.com.currencycalculator.convertion.Currency;
import br.com.currencycalculator.convertion.VariableOperatingFeeCalculable;

import java.math.BigDecimal;

public class ArgentinianPeso extends Currency implements VariableOperatingFeeCalculable {

    public ArgentinianPeso() {
        quotation = new BigDecimal("26.24");
        abbreviation = "ARS";
    }

    @Override
    public BigDecimal calculateFixedOperatingFee() {
        return new BigDecimal("2.5");
    }

    @Override
    public BigDecimal calculateVariableOperatingFee(BigDecimal amount) {
        return new BigDecimal("0.015").multiply(amount);
    }

    @Override
    public BigDecimal calculateOperatingFee(BigDecimal amount) {
        return calculateFixedOperatingFee().add(calculateVariableOperatingFee(amount));
    }

    @Override
    public BigDecimal calculateConversion(BigDecimal amount) {
        return quotation.multiply(amount.subtract(calculateIOF(amount)).subtract(calculateFixedOperatingFee().subtract(calculateVariableOperatingFee(amount))));
    }
}
