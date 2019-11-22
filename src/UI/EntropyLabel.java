package UI;


import javax.swing.JLabel;

public class EntropyLabel extends JLabel {
    public EntropyLabel() {
        super("Entropy: ");
    }

    public void updateLabel(String labelText){
        this.setText("Entropy: " + labelText);
    }

}
