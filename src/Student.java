import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Panin Eduard on 25.11.15.
 */
public class Student {
    private String surname;
    private double resultsPercent;
    private File result;
    private List<Answers> answersStudent;

    public List<Answers> getAnswersStudent() {
        return answersStudent;
    }

    public void setAnswersStudent(List<Answers> answersStudent) {
        this.answersStudent = answersStudent;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getResultsPercent() {
        return resultsPercent;
    }

    public void setResultsPercent(double resultsPercent) {
        this.resultsPercent = resultsPercent;
    }

    public File getResult() {
        return result;
    }

    public void setResult(File result) {
        this.result = result;
    }


}
