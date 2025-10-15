package calculator.validator;

public class InputValidator {

    public int validateAndParse(String numberStr) {
        try {
            int number = Integer.parseInt(numberStr.trim());

            if (number <= 0) {
                throw new IllegalArgumentException("양수만 입력 가능합니다: " + number);
            }

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다: " + numberStr);
        }
    }
}
