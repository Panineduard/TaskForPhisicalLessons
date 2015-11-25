import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ������ on 24.11.15.
 */
public class OutputFile{
public void WriteResult(Student student){

        String path = "AnswersOnSurname\\"+student.getSurname()+".txt";
        Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd,MM,yyyy");
        String massege;
        if (student.getResultsPercent()<50){
                massege="Можно и лучьше!";
        }
        else massege ="Хорошо!";
        Calendar calendar = Calendar.getInstance();
        data=calendar.getTime();
        PrintStream out=null;
       try {
                out= new PrintStream(
                       new BufferedOutputStream(new FileOutputStream(path)));

               out.println(student.getSurname());
               out.println("Это файл прохождения теста по фамилии.");
               out.println("Дата прохождения - " + format.format(data));
               out.println("Процент прохождения = " + Math.round(student.getResultsPercent()));
               out.println("Список неправильных ответов");
               for (Answers answer : student.getAnswersStudent()) {
                       String answe="";
                      switch (answer.getAnswerOfQoestion()){
                              case (1):answe = "А";break;
                              case (2):answe ="Б";break;
                              case (3):answe ="В";break;
                              case (4):answe="Г";break;
                       }
                       if (!answer.getCorrectAnswer()) {
                               out.println("Вариант - " + answer.getNamberThem() + ". Вопрос номер - " + answer.getNamberOfQuestion());
                               out.println("Ответ студента -" + answe);
                       }
               }
               out.println(massege);


       }
       catch (FileNotFoundException e){
               System.out.println("Ошибка потока вывода");
       }
        finally {
               out.close();
       }
}
}
