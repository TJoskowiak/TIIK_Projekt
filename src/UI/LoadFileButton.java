package UI;

import Crypto.LZ77;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LoadFileButton extends JButton implements ActionListener {

    public LoadFileButton(String text){
        super(text);
        addActionListener(this);
    }

    @Override
    public void actionPerformed (ActionEvent aEvent) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter ( "text files " , "txt");

        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            StatisticsTable.analyzedFile = fileChooser.getSelectedFile();
            LZ77 lz = new LZ77();
            try {
                lz.compress(fileChooser.getSelectedFile().toString());
                lz.unCompress(fileChooser.getSelectedFile().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
