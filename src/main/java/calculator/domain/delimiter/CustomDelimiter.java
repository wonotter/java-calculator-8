package calculator.domain.delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.)\n(.*)");

    @Override
    public boolean supports(String input) {
        return input.startsWith("//");
    }

    @Override
    public String[] split(String input) {
        String normalizedInput = input.replace("\\n", "\n");

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(normalizedInput);
        if (!matcher.find()) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }

        String customDelimiter = matcher.group(1);
        String numbers = matcher.group(2);

        if (numbers.isEmpty()) {
            return new String[]{};
        }

        // 커스텀 구분자가 정규식 특수문자인 경우 리터럴 문자열로 처리하도록 변환
        String literalDelimiter = Pattern.quote(customDelimiter);
        return numbers.split(literalDelimiter);
    }
}
