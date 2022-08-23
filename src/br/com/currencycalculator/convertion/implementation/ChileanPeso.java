package br.com.currencycalculator.convertion.implementation;

import br.com.currencycalculator.convertion.Currency;
import br.com.currencycalculator.convertion.VariableOperatingFeeCalculable;

import java.math.BigDecimal;

public class ChileanPeso extends Currency implements VariableOperatingFeeCalculable {

    public ChileanPeso() {
        quotation = new BigDecimal("174.17");
        abbreviation = "CLP";
    }

    @Override
    public BigDecimal calculateFixedOperatingFee() {
        return new BigDecimal("10.00");
    }

    @Override
    public BigDecimal calculateVariableOperatingFee(BigDecimal amount) {
        return new BigDecimal("0.025").multiply(amount);
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
