package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    private String inputStr;
    private String delimiter = ",|:";
    private String customDelimiter = "";
    private int endOfCustomDelimiter;

    public String Input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputStr = Console.readLine();
        return inputStr;
    }

    public void inputParse() {
        Input();
        System.out.println(inputStr);

        if (inputStr.startsWith("//") && inputStr.contains("|n")) {
            //커스텀 구분자가 끝나는 문자열의 index 위치 반환
            endOfCustomDelimiter = inputStr.indexOf("|");
            //사용자가 지정한 커스텀 구분자를 저장
            customDelimiter = inputStr.substring(2, endOfCustomDelimiter);
            // 구분자 안에 커스텀 구분자를 추가
            delimiter = delimiter.concat("|").concat(customDelimiter);
        }

        System.out.println(delimiter);

        //구분자로 정수 파싱 및 배열 저장
        String[] parsedList = inputStr.split(delimiter);
        System.out.println(parsedList.length);
    }
}
