package calculator;

public class Controller {
    private Model model = new Model();
    private View view = new View();

    public Controller() {
        String inputStr = view.Input();
        model.setInputStr(inputStr);
        model.checkCustomDelimiter();
        model.parseStrToInt();
        model.parsedIntSum();
    }

}
