package br.com.currencycalculator;

import br.com.currencycalculator.convertion.Currency;
import br.com.currencycalculator.convertion.implementation.CalculationFactory;
import br.com.currencycalculator.memory.ConversionEntry;
import br.com.currencycalculator.memory.Memory;
import br.com.currencycalculator.util.BigDecimalUtil;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String option;
        BigDecimal amount;
        BigDecimal result;
        String abbreviation;
        Memory memory = Memory.getInstance();

        do {
            amount = readNumber("Digite o valor em reais (R$) [0 para finalizar]: ");

            if (amount.compareTo(BigDecimal.ZERO) != 0) {
                option = readString("Digite a moeda de destino:\n\t1.Euro\n\t2.Dólar\n\t3.Peso Argentino\n\t4.Peso Chileno\n-> ");

                result = calculate(amount, option);
                abbreviation = returnAbbreviation(option);

                System.out.println("Valor em reais   -> R$ " + BigDecimalUtil.format(amount));
                System.out.println("IOF              -> R$ " + BigDecimalUtil.format(returnIOF(amount, option)));
                System.out.println("Taxa de Operação -> R$ "+ BigDecimalUtil.format(returnOperatingFee(amount, option)));
                System.out.println("-".repeat(30));
                System.out.println("Total convertido -> " + abbreviation + " " + BigDecimalUtil.format(result));

                memory.add(new ConversionEntry(abbreviation, amount, result));
            }

        } while (amount.compareTo(BigDecimal.ZERO) != 0);

        System.out.println("\n------Histórico------");
        memory.getConversions().forEach(System.out::println);
    }

    private static BigDecimal calculate(BigDecimal amount, String operation) {
        Optional<Currency> calculation = new CalculationFactory().create(operation);

        if (calculation.isEmpty()) {
            throw new IllegalArgumentException(operation);
        } else {
            return calculation.get().calculateConversion(amount);
        }
    }

    private static String returnAbbreviation(String operation) {
        Optional<Currency> calculation = new CalculationFactory().create(operation);

        if (calculation.isEmpty()) {
            throw new IllegalArgumentException(operation);
        } else {
            return calculation.get().getAbbreviation();
        }
    }

    private static BigDecimal returnIOF(BigDecimal amount, String operation) {
        Optional<Currency> calculation = new CalculationFactory().create(operation);

        if (calculation.isEmpty()) {
            throw new IllegalArgumentException(operation);
        } else {
            return calculation.get().calculateIOF(amount);
        }
    }

    private static BigDecimal returnOperatingFee(BigDecimal amount, String operation) {
        Optional<Currency> calculation = new CalculationFactory().create(operation);

        if (calculation.isEmpty()) {
            throw new IllegalArgumentException(operation);
        } else {
            return calculation.get().calculateOperatingFee(amount);
        }
    }

    private static BigDecimal readNumber(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextBigDecimal();
    }

    private static String readString(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextLine();
    }

}