package UI;

import Crypto.LZ77;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class CompressButton extends JButton implements ActionListener {

    public static CompressionLevelLabel compressionLevelLabel;

    public CompressButton(String text){
        super(text);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LZ77 lz = new LZ77();
        try {
            lz.compress(StatisticsTable.analyzedFile.toString());
            long uncompressedLength = StatisticsTable.analyzedFile.length();
            long compressedLength =  new File(StatisticsTable.analyzedFile.toString() + ".lz77").length();

            if(compressedLength>0) {
                float compressionLevel = ((float)uncompressedLength / (float)compressedLength);
                compressionLevelLabel.updateLabel(new DecimalFormat("#.##").format(compressionLevel));
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }


    }
}