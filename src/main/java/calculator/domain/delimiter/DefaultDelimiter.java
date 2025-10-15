package calculator.domain.delimiter;

public class DefaultDelimiter implements Delimiter {

    private static final String DELIMITER_PATTERN = "[,:]";

    @Override
    public boolean supports(String input) {
        // 커스텀 구분자 형식이 아니면 기본 구분자를 사용
        return !input.startsWith("//");
    }

    @Override
    public String[] split(String input) {
        if (input.isEmpty()) {
            return new String[]{};
        }
        return input.split(DELIMITER_PATTERN);
    }
}
