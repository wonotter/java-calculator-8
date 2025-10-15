package calculator.domain.delimiter;

public interface Delimiter {

    boolean supports(String input);

    String[] split(String input);
}
