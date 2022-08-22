package br.com.currencyCalculator.convertion;

import java.math.BigDecimal;

public interface VariableOperatingFeeCalculable {
    public BigDecimal calculateVariableOperatingFee(BigDecimal amount);
}
