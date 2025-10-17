package calculator;

public class Model {

    private String delimiter = ",|:";
    private String customDelimiter = "";
    private int endOfCustomDelimiter;
    private String[] parsedList = new String[3];
    int[] parsedInt = new int[parsedList.length];
    private String parsedStr;

    private String inputStr;

    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public void checkCustomDelimiter() {
        if (inputStr.startsWith("//") && inputStr.contains("|n")) {
            //커스텀 구분자가 끝나는 문자열의 index 위치 반환
            endOfCustomDelimiter = inputStr.indexOf("|");
            //사용자가 지정한 커스텀 구분자를 저장
            customDelimiter = inputStr.substring(2, endOfCustomDelimiter);
            // 구분자 안에 커스텀 구분자를 추가
            delimiter = delimiter.concat("|").concat(customDelimiter);
            // 커스텀 구분자가 끝나는 지점부터 inputStr을 변환
            inputStr = inputStr.substring(endOfCustomDelimiter + 2, inputStr.length());
            System.out.println(inputStr);
        }
        System.out.println(delimiter);
    }

    public void parseStrToInt() {
        //구분자로 정수 파싱 및 배열 저장
        parsedList = inputStr.split(delimiter);
        System.out.println(parsedList.length);

        //문자열 리스트를 정수형 리스트로 재저장
        for (int i = 0; i < parsedList.length; i++) {
            parsedInt[i] = Integer.parseInt(parsedList[i]);
            System.out.println(parsedInt[i]);
        }
    }

    public void parsedIntSum() {
        int sum = 0;
        for (int i = 0; i < parsedList.length; i++) {
            sum += parsedInt[i];
        }
        System.out.println(sum);
    }
}
