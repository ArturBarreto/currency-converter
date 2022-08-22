package br.com.currencyCalculator;

import br.com.currencyCalculator.convertion.Currency;
import br.com.currencyCalculator.convertion.implementation.CalculationFactory;

import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String option;
        Double amount;
        Double result = 0D;
        String abbreviation = "";

        do {
            amount = readNumber("Digite o valor em reais (R$) [0 para finalizar]: ");

            if (amount != 0) {
                option = readString("Digite a moeda de destino:\n\t1.Euro\n\t2.Dólar\n\t3.Peso Argentino\n\t4.Peso Chileno\n\t0.Sair\n-> ");

                result = calculate(amount, option);
                abbreviation = returnAbbreviation(option);

                System.out.println("Valor em reais -> R$ " + amount);
                System.out.println("IOF -> R$ " + returnIOF(amount,option));
                System.out.println("Taxa de Operação -> R$ "+ returnOperatingFee(amount,option));
                System.out.println("----------------------------");
                System.out.println("Total convertido -> R$ " + abbreviation + " " + result);
            }

        } while (amount != 0);
    }

    private static double calculate(Double amount, String operation) {
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

    private static double returnIOF(Double amount, String operation) {
        Optional<Currency> calculation = new CalculationFactory().create(operation);

        if (calculation.isEmpty()) {
            throw new IllegalArgumentException(operation);
        } else {
            return calculation.get().calculateIOF(amount);
        }
    }

    private static double returnOperatingFee(Double amount, String operation) {
        Optional<Currency> calculation = new CalculationFactory().create(operation);

        if (calculation.isEmpty()) {
            throw new IllegalArgumentException(operation);
        } else {
            return calculation.get().calculateOperatingFee(amount);
        }
    }

    private static double readNumber(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextDouble();
    }

    private static String readString(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextLine();
    }
}