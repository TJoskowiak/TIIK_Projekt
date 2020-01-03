package Crypto;


import java.text.DecimalFormat;

public class TableRow {
    public String character;
    public int amount;
    public float probability;
    public double worth;

    public TableRow(String character, int amount, float probability, double worth)
    {
        this.character = character;
        this.amount = amount;
        this.probability = probability;
        this.worth = worth;
    }

    public TableRow(String character)
    {
        this.character = character;
        this.amount = 0;
        this.probability = 0;
        this.worth = 0;
    }

    public Object[] getRow()
    {
        return new Object[]{character,amount,new DecimalFormat("#.##").format(probability),new DecimalFormat("#.##").format(worth)};
    }

    public void calculateProbability(float charNumberInFile){
        probability = (float)amount/charNumberInFile;
    }

    public void calculateWorth()
    {
        worth = Math.log(1/probability)/ Math.log(2) + 1e-11;
    }
}
