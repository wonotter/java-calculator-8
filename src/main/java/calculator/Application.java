package calculator;

import calculator.domain.Calculator;
import calculator.parser.InputParser;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        InputParser parser = new InputParser();
        Calculator calculator = new Calculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String[] numbers = parser.parse(input);
        int result = calculator.add(numbers);

        System.out.println("결과 : " + result);
    }
}
