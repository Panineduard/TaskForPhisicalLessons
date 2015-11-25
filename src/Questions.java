import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Эдуард on 24.11.15.
 */
public class Questions extends JLabel implements ActionListener {
    Timer timer = new Timer(10,this);
    private int maxValueCount=12;
    public Questions(){
        timer.start();
    }
    private String path = "";
Random random = new Random();
    private int numberQuestion=1+random.nextInt(5);
    private int numberThem=1;

    public int getNumberThem() {
        return numberThem;
    }

    public void setNumberThem(int numberThem) {
        this.numberThem = numberThem;
    }

    public int getNumberQuestion() {
        return numberQuestion;
    }

    public int getMaxValueCount() {
        return maxValueCount;
    }

    public void setMaxValueCount(int maxValueCount) {
        this.maxValueCount = maxValueCount;
    }

    public void setNumberQuestion(int numberQuestion) {
        this.numberQuestion = numberQuestion;
    }

    public ImageIcon getImage(Integer number,Integer numberThem){
    path="src/img/tasks"+numberThem+"/"+number+".JPG";
        return new ImageIcon(path);
    }
    public void paint(Graphics g) {

        ImageIcon imageIcon = new Questions().getImage(numberQuestion,numberThem);
        Image question = imageIcon.getImage();
        g.drawImage(question, 100, 0, 658, 286, null);
    }


    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
