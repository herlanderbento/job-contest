package Domain.Entity;

import java.util.UUID;

public class PublicContest extends Contest{
    private int numberOfQuestions;
    public PublicContest(UUID id, String name, String type, int quantityVacancies, int numberOfQuestions) {
        super(id, name, type, quantityVacancies);
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

}
