import javax.swing.*;
import java.io.IOException;

/**
 * Created by Эдуард on 25.11.15.
 */
public class TestClass {
       JFrame f = new JFrame("Test");
    public void test(){
        f.setSize(100, 50);//Размер окна
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p=new JPanel();
        p.setBounds(10, 600, 150, 29);
        JTextArea textArea = new JTextArea("Фамилия",1,17);
        textArea.setBounds(0,0,130,20);
        p.setLayout(null);
        p.add(textArea);
        f.getContentPane().add(p);

        f.setVisible(true);

    }
    public static void main(String...args) throws IOException {
//       CheckAnswers checkAnswers = new CheckAnswers();
//        System.out.println(checkAnswers.checkResults(2,3,1));
new TestClass().test();
    }
}
