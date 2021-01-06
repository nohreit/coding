package networking;

import javax.swing.*;

public class test extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public test() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        test dialog = new test();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
