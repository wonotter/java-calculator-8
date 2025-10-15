package calculator.parser;

import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.DefaultDelimiter;
import calculator.domain.delimiter.Delimiter;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private final List<Delimiter> delimiters;

    public InputParser() {
        // 커스텀 구분자를 먼저 확인해보고, 그 다음으로 기본 구분자를 확인
        this.delimiters = Arrays.asList(new CustomDelimiter(), new DefaultDelimiter());
    }

    public String[] parse(String input) {
        for (Delimiter delimiter : delimiters) {
            if (delimiter.supports(input)) {
                return delimiter.split(input);
            }
        }
        throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
    }
}
