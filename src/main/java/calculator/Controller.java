package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    public void input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();

        // 기본 구분자(쉼표,컬럼)로 문자열 분리
        String defaultDelimiter = ",|:";
        String[] parsedList = inputStr.split(defaultDelimiter);

        //커스텀 구분자로 문자열 분리
        String customDelimiter;
        int endOfCustomDelimiter;
        if (inputStr.startsWith("//") && inputStr.contains("|n")) {
            //커스텀 구분자가 끝나는 문자열의 index 위치 반환
            endOfCustomDelimiter = inputStr.indexOf("|");
            customDelimiter = inputStr.substring(2, endOfCustomDelimiter);
            System.out.println(customDelimiter);
        }
    }
}
