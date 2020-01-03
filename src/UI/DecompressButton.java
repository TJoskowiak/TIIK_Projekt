package UI;

import Crypto.LZ77;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DecompressButton extends JButton implements ActionListener {

    public DecompressButton(String text){
        super(text);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LZ77 lz = new LZ77();
        try {
            lz.unCompress(StatisticsTable.analyzedFile.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}