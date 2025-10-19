package calculator;

import java.util.ArrayList;

public class Model {

    private String delimiter = ",|:";
    ArrayList<Integer> parsedInt = new ArrayList<>();
    private String inputStr;

    public Model(String input) {
        inputStr = input;
        isValidInputStr(inputStr);
        checkCustomDelimiter();
        parseStrToInt();
        parsedIntSum();
    }

    public void isValidInputStr(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            throw new IllegalArgumentException("공백이나 null값을 입력받을 수 없습니다.");
        }
    }

    public void checkCustomDelimiter() {
        String customDelimiter = "";
        int endOfCustomDelimiter;
        if (inputStr.startsWith("//") && inputStr.contains("\\n")) {
            //커스텀 구분자가 끝나는 문자열의 index 위치 반환
            endOfCustomDelimiter = inputStr.indexOf("\\");
            //사용자가 지정한 커스텀 구분자를 저장
            customDelimiter = inputStr.substring(2, endOfCustomDelimiter);
            // 구분자 안에 커스텀 구분자를 추가
            delimiter = delimiter.concat("\\").concat(customDelimiter);
            // 커스텀 구분자가 끝나는 지점부터 inputStr을 변환
            inputStr = inputStr.substring(endOfCustomDelimiter + 2);
        }
    }

    public void parseStrToInt() {
        //구분자로 정수 파싱 및 배열 저장
        String[] parsedList = inputStr.split(delimiter);

        int number;
        //문자열 리스트를 정수형 리스트로 재저장
        for (String string : parsedList) {
            try {
                number = Integer.parseInt(string);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("문자는 계산할 수 없습니다.");
            }
            parsedInt.add(number);
        }
    }

    public int parsedIntSum() {
        int result = 0;
        for (Integer integer : parsedInt) {
            if (integer < 0) {
                throw new IllegalArgumentException("음수는 계산할 수 없습니다.");
            }
            result += integer;
        }
        return result;

    }
}
