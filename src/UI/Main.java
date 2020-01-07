package UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JFrame frame = new JFrame("TiIK");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(false);
        Border blackLine = BorderFactory.createLineBorder(Color.black);

        StatisticsTable st = new StatisticsTable();

        JTextArea fileArea = new JTextArea(18, 1);
        fileArea.setEditable(false);

        JPanel topPanel = new JPanel();
        JPanel btnPanel = new JPanel();
        JPanel labelPanel = new JPanel();

        topPanel.setLayout(new BorderLayout());
        frame.getContentPane().add(topPanel, BorderLayout.CENTER);
        frame.getContentPane().add(labelPanel, BorderLayout.NORTH);
        frame.getContentPane().add(btnPanel, BorderLayout.SOUTH);

        JScrollPane statisticsScrollPane = new JScrollPane(st);
        JScrollPane fileScrollPane = new JScrollPane(fileArea);
        statisticsScrollPane.setBorder(blackLine);
        fileScrollPane.setBorder(blackLine);

        topPanel.add(statisticsScrollPane, BorderLayout.NORTH);
        topPanel.add(fileScrollPane, BorderLayout.SOUTH);

        LoadFileButton loadFileButton = new LoadFileButton("Wczytaj plik");
        AnalyzeButton analyzeButton = new AnalyzeButton("Analizuj");
        CompressButton compressButton = new CompressButton("Kompresuj");
        DecompressButton decompressButton = new DecompressButton("Dekompresuj");

        EntropyLabel entropyLabel = new EntropyLabel();
        CompressionLevelLabel compressionLevelLabel = new CompressionLevelLabel();

        StatisticsTable.entropyLabel = entropyLabel;
        CompressButton.compressionLevelLabel = compressionLevelLabel;
        LoadFileButton.fileArea = fileArea;

        labelPanel.add(entropyLabel);
        labelPanel.add(compressionLevelLabel);

        btnPanel.add(loadFileButton);
        btnPanel.add(analyzeButton);
        btnPanel.add(compressButton);
        btnPanel.add(decompressButton);


        frame.setVisible(true);
    }
}
