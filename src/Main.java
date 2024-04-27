import javax.imageio.IIOImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.interfaces.DSAKey;

class Calculator extends JFrame implements ActionListener{
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equalButton, delButton , clrButton;
    JPanel Display,Buttons, Action;
    Double num1,num2,result;
    char operator;

    Calculator() {
        initFrame();
        display();
        operators();
    }

    public void initFrame() {
        new Frame("Calculator");
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(750,250,420,500);
        setLayout(null);
        setResizable(false);
        setBackground(Color.BLACK);
        getContentPane().setBackground(Color.black);
        ImageIcon titleImage = new ImageIcon(getClass().getResource("/Images/gai.png"));
        setIconImage(titleImage.getImage());
    }
    public void display(){
        Display = new JPanel();
        Display.setLayout(null);
        Display.setBackground(new Color(44,44,44));
        Display.setBounds(0,0,420,80);
        textField = new JTextField();
        textField.setBorder(null);
        textField.setBounds(21,20,418-50,50);
        textField.setFont(new Font("Arial", Font.PLAIN, 45));
        textField.setEditable(false);
        textField.setBackground(new Color(44,44,44));
        textField.setForeground(Color.white);
        Display.add(textField);
    }

    public void operators(){
        Buttons = new JPanel();
        Buttons.setBounds(20,200,405-40,250);
        Buttons.setLayout(new GridLayout(4,4,10,10));
        Buttons.setBackground(Color.black);


        ImageIcon add = new ImageIcon(getClass().getResource("/Images/add.png"));
        ImageIcon sub = new ImageIcon(getClass().getResource("/Images/sub.png"));
        ImageIcon mul = new ImageIcon(getClass().getResource("/Images/mul.png"));
        ImageIcon div = new ImageIcon(getClass().getResource("/Images/div.png"));
        ImageIcon equal = new ImageIcon(getClass().getResource("/Images/equal.png"));
        ImageIcon dec = new ImageIcon(getClass().getResource("/Images/dec.png"));
        ImageIcon cel = new ImageIcon(getClass().getResource("/Images/cel.png"));
        ImageIcon del = new ImageIcon(getClass().getResource("/Images/del.png"));

        addButton = new JButton(add);
        subButton = new JButton(sub);
        mulButton = new JButton(mul);
        divButton = new JButton(div);
        decButton = new JButton(dec);
        equalButton = new JButton(equal);
        delButton = new JButton(del);
        clrButton = new JButton(cel);

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].setFocusable(false);
            functionButtons[i].setFont(new Font("Arial",Font.PLAIN,20));
            functionButtons[i].setSize(10,7);
            functionButtons[i].setBackground(Color.black);
            functionButtons[i].setBorder(null);
            functionButtons[i].addActionListener(this);
        }

        ImageIcon[] num = new ImageIcon[14];
        for (int i = 0; i < 10; i++) {
            num[i] = new ImageIcon(getClass().getResource("/Images/"+i+".png"));
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(num[i]);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(new Font("Arial",Font.PLAIN,20));
            numberButtons[i].setSize(50,30);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(Color.black);
            numberButtons[i].setOpaque(false);
            numberButtons[i].setFocusPainted(false);
            numberButtons[i].setBorder(null);
            numberButtons[i].setFocusPainted(false);
        }

        Action = new JPanel();
        Action.setBounds(103,120,280,80);
        Action.setBackground(Color.black);
        Action.setLayout(new GridLayout(1,2,5,0));
        Action.add(functionButtons[7]);
        Action.add(functionButtons[6]);


        Buttons.add(numberButtons[7]);
        Buttons.add(numberButtons[8]);
        Buttons.add(numberButtons[9]);
        Buttons.add(divButton);
        Buttons.add(numberButtons[4]);
        Buttons.add(numberButtons[5]);
        Buttons.add(numberButtons[6]);
        Buttons.add(mulButton);
        Buttons.add(numberButtons[1]);
        Buttons.add(numberButtons[2]);
        Buttons.add(numberButtons[3]);
        Buttons.add(subButton);
        Buttons.add(decButton);
        Buttons.add(numberButtons[0]);
        Buttons.add(equalButton);
        Buttons.add(addButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) textField.setText(textField.getText().concat(String.valueOf(i)));
        }
        if (e.getSource() == decButton) textField.setText(textField.getText().concat("."));
        if (e.getSource() == clrButton) textField.setText("");
        if (e.getSource() == addButton){
            num1= Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            System.out.println(num1);
        }
        if (e.getSource() == subButton){
            num1= Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            System.out.println(num1);
        }
        if (e.getSource() == mulButton){
            num1= Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
            System.out.println(num1);
        }
        if (e.getSource() == divButton){
            num1= Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            System.out.println(num1);
        }
        if (e.getSource() == equalButton){
            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == delButton){
            String text = textField.getText();
            if (text.length() != 0){
                String newText = text.substring(0,text.length()-1);
                textField.setText(newText);
            }
        }


    }

    public void runApp(){
        this.add(Display);
        this.add(Action);
        this.add(Buttons);
        setVisible(true);
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.runApp();
    }
}