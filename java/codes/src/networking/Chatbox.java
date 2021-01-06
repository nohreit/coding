package networking;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Chatbox extends JFrame{
    private JLabel textPaneMsgLog;
    private JPanel panel1;
    private JTextField textFieldMsg;
    private JButton buttonSend;


    public Chatbox() {
        textPaneMsgLog = new JLabel();
        panel1 = new JPanel();
        textFieldMsg = new JTextField();
        buttonSend = new JButton();

        view ();
        buttonSend.addActionListener(this::actionPerformed);

    }

    public void view(){
        
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(buttonSend)){
            this.textPaneMsgLog.setText(textFieldMsg.getText());
        }
    }

    public static void main (String [] args){
        Chatbox chatbox = new Chatbox();


    }




}
