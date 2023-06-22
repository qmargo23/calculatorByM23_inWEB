package pro.sky.calculatorbyM23;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

public String welcome() {
    String s = "<h2>Добро пожаловать в калькулятор!</h2>\n" +
            "                 Пример использования: /calculator/operation?num1=X&num2=X<br>\n" +
            "                 num1, num2 - значение <b>вводимых переменных</b>" +
            "                 <h4>Доступные команды для operation:</h4>\n" +
            "                 <ul>\n" +
            "                 <li>plus - сложить;</li>\n" +
            "                 <li>minus - вычесть;</li>\n" +
            "                 <li>multiply - умножить;</li>\n" +
            "                 <li>divide - разделить;</li>\n" +
            "                 </ul>";
    return s;
}

    public String plus(Integer x,Integer y) {
        if (y == null | x == null) {
            return "<h2>ошибка</h2>\n введено некорректное значение";
        }
        int res = x + y;
        return String.valueOf(res);
    }

    public String minus(Integer x,Integer y) {
        if (y == null | x == null) {
            return "<h2>ошибка</h2>\n введено некорректное значение";
        }
        int res = x - y;
        return String.valueOf(res);
    }

    public String multiply(Integer x,Integer y) {
        if (y == null | x == null) {
            return "<h2>ошибка</h2>\n введено некорректное значение";
        }
        int res = x * y;
        return String.valueOf(res);
    }
    public String divide(Double x,Double y) {
        if (y == null | x == null || y == 0) {
            return "<h2>ошибка</h2>\n введено некорректное значение.\n <h2>деление на 0 запрещено</h2>";
        }
        double res = x / y;
        return String.valueOf(res);
    }

}
