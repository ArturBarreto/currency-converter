package br.com.currencyCalculator.convertion.implementation;

import br.com.currencyCalculator.convertion.Currency;
import br.com.currencyCalculator.convertion.FixedOperatingFeeCalculable;
import br.com.currencyCalculator.convertion.IOFCalculable;
import br.com.currencyCalculator.convertion.VariableOperatingFeeCalculable;

public class ChileanPeso extends Currency implements FixedOperatingFeeCalculable, VariableOperatingFeeCalculable, IOFCalculable {
    private double quotation = 174.17;

    private String abbreviation = "CLP";

    public String getAbbreviation() {
        return this.abbreviation;
    }

    @Override
    public double calculateFixedOperatingFee() {
        return 10.00;
    }

    @Override
    public double calculateIOF(double amount) {
        return 0.011 * amount;
    }

    @Override
    public double calculateVariableOperatingFee(double amount) {
        return 0.025 * amount;
    }

    @Override
    public double calculateOperatingFee(double amount) {
        return calculateFixedOperatingFee() + calculateVariableOperatingFee(amount);
    }

    @Override
    public double calculateConversion(double amount) {
        return quotation * (amount - calculateIOF(amount) - calculateFixedOperatingFee() -  calculateVariableOperatingFee(amount));
    }
}
