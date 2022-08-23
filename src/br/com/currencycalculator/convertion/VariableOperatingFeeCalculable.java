package br.com.currencycalculator.convertion;

import java.math.BigDecimal;

public interface VariableOperatingFeeCalculable {
    public BigDecimal calculateVariableOperatingFee(BigDecimal amount);
}
