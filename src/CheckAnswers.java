import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

/**
 * Created by Эдуард on 24.11.15.
 */
public class CheckAnswers {
    private Map<Integer, String> answers = new TreeMap<>();
    private boolean checkHelper(Integer ques,Integer answer,Map<Integer,String> mapAnswers){
            if (mapAnswers.get(ques)!=null){
                char  txt=mapAnswers.get(ques).charAt(0);
                char  txt1=mapAnswers.get(ques).charAt((mapAnswers.get(ques).toCharArray().length)-1);
                char [] helpArray=new char[]{txt};

            if(new Integer(new String(helpArray)).equals(ques)){
                 helpArray[0]=txt1;
                if(new Integer(new String(helpArray)).equals(answer)){
                    return true;
                }
            }
        }
       return false;
    }

    //if this mesthod If this method returns 0(answer is not ok),1 (answer is ok), 2(not found txt.file),3(InputStreamException)
    private int checkResults(Integer ques, Integer answer,Integer namberVariant)  {
        int res = 0;
        BufferedReader bufferedReader = null;
//        System.out.println("Вопрос"+ques+"Ответ"+answer+"Номер варианта"+namberVariant);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src\\resourse\\answers"+namberVariant+".txt")));
            String word;
            Integer namerQues = 1;
            while ((word = bufferedReader.readLine()) != null) {
               answers.put(namerQues,word);
                namerQues++;
            }
           if(checkHelper(ques,answer,answers)){
               res=1;
           }
        } catch (IOException e) {
           res= 2;
        } finally {
            try {
                bufferedReader.close();
            }
            catch (Exception e){
                res=3;
            }
        }
        return res;
    }
public Student mainChecResult(Student student) {
    List<Answers> answers = student.getAnswersStudent();
    int i=1;
    double resultsPercent=(double)100/(new Questions().getMaxValueCount());

    for (Answers answer : answers) {

        Integer check=checkResults(answer.getNamberOfQuestion(),answer.getAnswerOfQoestion(),answer.getNamberThem());
    if (check==1) {
        student.setResultsPercent(student.getResultsPercent() + resultsPercent);
        answer.setCorrectAnswer(true);
        continue;
    }
        if (check==0){
            answer.setCorrectAnswer(false);

        }

       if(check==2||check==3){
    System.out.println("Файл не найден");
        }
    }
return student;
}
}