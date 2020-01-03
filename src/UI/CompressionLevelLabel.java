package UI;

import javax.swing.JLabel;

public class CompressionLevelLabel extends JLabel {
    public CompressionLevelLabel() {
        super("Poziom kompresji: ");
    }

    public void updateLabel(String labelText){
        this.setText("Poziom kompresji: " + labelText);
    }
}
