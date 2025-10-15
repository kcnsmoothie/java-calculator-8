package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    public void input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();

        // 기본 구분자(쉼표,컬럼)로 문자열 분리
        String defaultDelimiter = ",|:";
        String[] parsedList = inputStr.split(defaultDelimiter);
    }
}
