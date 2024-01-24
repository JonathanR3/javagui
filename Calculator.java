import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {

    JFrame frame;
    JTextField text;
    JButton[] buttonNum = new JButton[10];
    JButton[] buttonOp = new JButton[6];
    JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    JPanel panel; 

    Font font = new Font("Comic Sans", Font.BOLD, 35);

    double num1 = 0, num2 = 0, total = 0;
    char operation;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setLayout(null);

        text = new JTextField();
        text.setBounds(45,30, 500,50);
        text.setFont(font);
        text.setEditable(false);
        text.setForeground(Color.decode("#242732"));
        text.setBackground(Color.decode("#EBBCA8"));

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        buttonOp[0] = addButton;
        buttonOp[1] = subButton;
        buttonOp[2] = mulButton;
        buttonOp[3] = divButton;
        buttonOp[4] = eqButton;
        buttonOp[5] = clrButton;

        for (int i = 0; i < buttonOp.length; i++) {
            buttonOp[i].addActionListener(this);
            buttonOp[i].setBackground(Color.decode("#989085"));
            buttonOp[i].setFont(font);
            buttonOp[i].setFocusable(false);
        }

        for (int i = 0; i < buttonNum.length; i++) {
            buttonNum[i] = new JButton(String.valueOf(i));
            buttonNum[i].addActionListener(this);
            buttonNum[i].setBackground(Color.decode("#508AA1"));
            buttonNum[i].setFont(font);
            buttonNum[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(45, 100, 500, 550);
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        panel.add(buttonNum[7]);
        panel.add(buttonNum[8]);
        panel.add(buttonNum[9]);
        panel.add(divButton);

        panel.add(buttonNum[4]);
        panel.add(buttonNum[5]);
        panel.add(buttonNum[6]);
        panel.add(mulButton);

        panel.add(buttonNum[1]);
        panel.add(buttonNum[2]);
        panel.add(buttonNum[3]);
        panel.add(subButton);

        panel.add(buttonNum[0]);
        panel.add(clrButton);
        panel.add(eqButton);
        panel.add(addButton);
        panel.setBackground(Color.LIGHT_GRAY);

        frame.getContentPane().setBackground(Color.decode("#283C44"));
        frame.add(panel);
        frame.add(text);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == buttonNum[i]) {
                text.setText(text.getText() + String.valueOf(i));
            }
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(text.getText());
            operation = '+';
            text.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(text.getText());
            operation = '-';
            text.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(text.getText());
            operation = '*';
            text.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(text.getText());
            operation = '/';
            text.setText("");
        }
        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(text.getText());
            switch(operation) {
                case '+':
                    total = num1 + num2;
                    break;
                case '-':
                    total = num1 - num2;
                    break;
                case '*':
                    total = num1 * num2;
                    break;
                case '/':
                    total = num1 / num2;
                    break;
            }
            text.setText("" + total);
            num1 = total;
            num2 = 0;
            total = 0;
        }
        if (e.getSource() == clrButton) {
            text.setText("");
            operation = ' ';
            num1 = 0;
            num2 = 0;
            total = 0;
        }
    }
}