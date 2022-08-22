package br.com.currencyCalculator.convertion;

public abstract class Currency {
    protected double quotation;
    protected String abbreviation;

    public abstract double calculateConversion(double amount);
    public abstract String getAbbreviation();
    public abstract double calculateIOF(double amount);
    public abstract double calculateOperatingFee(double amount);
}
