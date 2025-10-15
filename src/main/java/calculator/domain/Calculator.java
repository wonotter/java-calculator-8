package calculator.domain;

import calculator.validator.InputValidator;

public class Calculator {

    private final InputValidator validator;

    public Calculator() {
        this.validator = new InputValidator();
    }

    public int add(String[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int sum = 0;
        for (String number : numbers) {
            if (number.isEmpty()) {
                throw new IllegalArgumentException("구분자가 연속되거나 구분자로 시작하는 것은 허용하지 않습니다.");
            }
            sum += validator.validateAndParse(number);
        }
        return sum;
    }
}
