package pro.sky.calculatorbyM23.services.imp;

import org.springframework.stereotype.Service;
import pro.sky.calculatorbyM23.services.CalcService;
import pro.sky.calculatorbyM23.services.ValidatorService;

@Service
public class CalcServiceImpl implements CalcService {
    private final ValidatorService validator;

    public CalcServiceImpl(ValidatorService validator) {
        this.validator = validator;
    }

    public String greetings() {
        String s = "<h2>Добро пожаловать в калькулятор!</h2>\n" +
                "                 Пример использования: /calculator/operation?num1=X&num2=X<br>\n" +
                "                 <h3>num1, num2 - значение <b>вводимых переменных</b></h3>" +
                "                 <h4>Доступные команды для operation:</h4>\n" +
                "                 <ul>\n" +
                "                 <li>plus - сложить;</li>\n" +
                "                 <li>minus - вычесть;</li>\n" +
                "                 <li>multiply - умножить;</li>\n" +
                "                 <li>divide - разделить;</li>\n" +
                "                 </ul>";
        return s;
    }

    @Override
    public int plus(Integer num1, Integer num2) {
        return validator.checkByNull(num1) +
                validator.checkByNull(num2);
    }

    @Override
    public int minus(Integer num1, Integer num2) {
        return validator.checkByNull(num1) -
                validator.checkByNull(num2);
    }

    @Override
    public int multiply(Integer num1, Integer num2) {
        return validator.checkByNull(num1) *
                validator.checkByNull(num2);
    }

    @Override
    public double divide(Integer num1, Integer num2) {
        return validator.checkByNull(num1) /
                (double) validator.checkByZero(validator.checkByNull(num2));
    }

}
