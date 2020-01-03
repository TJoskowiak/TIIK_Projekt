package UI;


import javax.swing.JLabel;

public class EntropyLabel extends JLabel {
    public EntropyLabel() {
        super("Entropia: ");
    }

    public void updateLabel(String labelText){
        this.setText("Entropia: " + labelText);
    }

}
