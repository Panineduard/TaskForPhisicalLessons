/**
 * Created by Эдуард on 25.11.15.
 */
public class Answers {
    private Integer namberThem;
    private Integer namberOfQuestion;
    private Integer AnswerOfQoestion;
    private boolean correctAnswer;

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Integer getNamberThem() {
        return namberThem;
    }

    public void setNamberThem(Integer namberThem) {
        this.namberThem = namberThem;
    }

    public Integer getNamberOfQuestion() {
        return namberOfQuestion;
    }

    public void setNamberOfQuestion(Integer namberOfQuestion) {
        this.namberOfQuestion = namberOfQuestion;
    }

    public Integer getAnswerOfQoestion() {
        return AnswerOfQoestion;
    }

    public void setAnswerOfQoestion(Integer answerOfQoestion) {
        AnswerOfQoestion = answerOfQoestion;
    }
}
