package pro.sky.calculatorbyM23.services.imp;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.calculatorbyM23.exceptions.ArgumentIsNotNumberException;
import pro.sky.calculatorbyM23.exceptions.ArgumentIsZeroException;
import pro.sky.calculatorbyM23.exceptions.NoArgumentSpecifiedException;
import pro.sky.calculatorbyM23.services.ValidatorService;

@Service
public class ValidatorServiceImpl implements ValidatorService {
    @Override
    public int checkByNull(Integer num) {
        if (num == null) {
            throw new NoArgumentSpecifiedException("Аргумент не задан");
        }
        return num;
    }

    @Override
    public int checkByZero(Integer num) {
        if (num == 0) {
            throw new ArgumentIsZeroException("деление на НОЛЬ!");
        }
        return num;
    }
}
