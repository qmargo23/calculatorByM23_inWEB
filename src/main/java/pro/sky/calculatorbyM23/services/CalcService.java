package pro.sky.calculatorbyM23.services;

public interface CalcService {
    int plus(Integer num1, Integer num2);
    int minus(Integer num1, Integer num2);
    int multiply(Integer num1, Integer num2);
    double divide(Integer num1, Integer num2);

    String greetings();
}
