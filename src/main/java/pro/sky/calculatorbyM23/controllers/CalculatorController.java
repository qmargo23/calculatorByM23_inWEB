package pro.sky.calculatorbyM23.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.calculatorbyM23.exceptions.ArgumentIsNotNumberException;
import pro.sky.calculatorbyM23.exceptions.ArgumentIsZeroException;
import pro.sky.calculatorbyM23.exceptions.NoArgumentSpecifiedException;
import pro.sky.calculatorbyM23.services.CalcService;

@RestController
@RequestMapping( "/calculator")
public class CalculatorController {
    private final CalcService calcService;

    public CalculatorController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping()
    public String greetings(){
        return calcService.greetings();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Integer num1,
                       @RequestParam(required = false) Integer num2) {
        return buildView(num1, num2, calcService.plus(num1, num2), "+");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Integer num1,
                        @RequestParam(required = false) Integer num2) {
        return buildView(num1, num2, calcService.minus(num1, num2), "-");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Integer num1,
                           @RequestParam(required = false) Integer num2) {
        return buildView(num1, num2, calcService.multiply(num1, num2), "*");
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Integer num1,
                         @RequestParam(required = false) Integer num2) {
        return buildView(num1, num2, calcService.divide(num1, num2), "/");
    }

    private String buildView(Integer num1,
                             Integer num2,
                             Number result,
                             String operation) {
        return num1 + " " + operation + " " + num2 + " = " + result;
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String handleIsNotNumberException() {
        return "Вычисление выражения невозможно - Аргумент не число!";
    }
    @ExceptionHandler({ArgumentIsZeroException.class})
    public String handleZeroException() {
        return "Деление на ноль запрещено";
    }
    @ExceptionHandler({NoArgumentSpecifiedException.class})
    public String handleNullException() {
        return "Аргумент не задан";
    }
}
