package calculator;

public class Controller {
    private Model model;
    private View view = new View();

    public Controller() {
        model = new Model(view.Input());

        int result = model.parsedIntSum();
        view.output(result);
    }

}
