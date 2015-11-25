

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.sun.prism.paint.*;
import sun.plugin2.message.ShowStatusMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by Эдуард on 24.11.15.
 */
public class Shower {
    JFrame f = new JFrame("Физика это просто!!!");
    private Student student = new Student();

    List<Answers> answersList = new ArrayList<>();
    private JTextArea textArea = new JTextArea("Фамилия",1,30);

    private Questions question=new Questions();
    Random random = new Random();

    public  Shower(){

        shows();
    }
    private void counterQuestions(Integer answer){

        int count = question.getNumberThem();
        if (count <= question.getMaxValueCount()) {
            Answers answers= new Answers();
            int nQ=1 + random.nextInt(5);
            question.setNumberQuestion(nQ);
            answers.setNamberThem(count);
            answers.setNamberOfQuestion(nQ);
            answers.setAnswerOfQoestion(answer);
            answersList.add(answers);
            count++;
            question.setNumberThem(count);
        }
        if(count>question.getMaxValueCount()){
            question.setNumberThem(100);
            question.setNumberQuestion(100);

        }
    }

    public void shows() {
        textArea.setBounds(0, 0, 350, 60);
        textArea.setBackground(Color.ORANGE);
        textArea.setFont(new Font("surname",10,20));

        JLabel background = new JLabel(new ImageIcon("src/img/background3.JPG")); //путь фона


        f.setSize(1000, 700);//Размер окна
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b1;
        JButton b2;
        JButton b3;
        JButton b4;
        JButton b5;
        b1 = new JButton("А");
        b1.setBounds(300, 400, 70, 70);
        b1.setBackground(Color.cyan);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterQuestions(1);
            }
        });
        b2 = new JButton("Б");
        b2.setBounds(300, 500, 70, 70);
        b2.setBackground(Color.cyan);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterQuestions(2);
            }
        });
        b3 = new JButton("В");
        b3.setBounds(600, 400, 70, 70);
        b3.setBackground(Color.cyan);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterQuestions(3);
            }
        });
        b4 = new JButton("Г");
        b4.setBounds(600, 500, 70, 70);
        b4.setBackground(Color.cyan);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterQuestions(4);
            }
        });
        b5=new JButton("Закончить");
        b5.setBounds(700, 550, 200, 60);
        b5.setBackground(Color.yellow);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                student.setSurname(textArea.getText());
                student.setAnswersStudent(answersList);
                new  CheckAnswers().mainChecResult(student);
                new OutputFile().WriteResult(student);
                String massege = "Поздравляю, уважаемый " + textArea.getText() + ". Вы прошли тест." +
                        "Ваш процент прохождения = " + Math.round(student.getResultsPercent());
                JOptionPane.showMessageDialog(b5, massege);



            }
        });

        background.add(b1);
        background.add(b2);
        background.add(b3);
        background.add(b4);
        background.add(b5);
        JLabel panel ;
        panel = question;
        panel.setBounds(20, 10, 900, 286);
        panel.setLayout(null);
        JPanel p=new JPanel();
        p.setBounds(10, 600, 200, 30);
        p.setBackground(Color.YELLOW);


        p.add(textArea);
        p.setLayout(null);
        background.add(p);

        background.add(panel);
        background.add(p);

        f.add(background);
        f.setVisible(true);
    }
}
