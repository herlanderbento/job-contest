package Domain.Entity;

public class InternalContest extends Contest{
    private int numberOfQuestions;

    public InternalContest(String name, String type, int quantityVacancies, int numberOfQuestions) {
        super(name, type, quantityVacancies);
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
}
