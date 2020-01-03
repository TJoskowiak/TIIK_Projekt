package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnalyzeButton extends JButton implements ActionListener{

    public AnalyzeButton(String text){
        super(text);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StatisticsTable.getRows();
    }
}