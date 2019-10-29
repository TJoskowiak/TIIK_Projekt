package Crypto;

public class TableRow {
    public char character;
    public int amount;
    public float probability;
    public double worth;

    public TableRow(char character, int amount, float probability, double worth)
    {
        this.character = character;
        this.amount = amount;
        this.probability = probability;
        this.worth = worth;
    }

    public TableRow(char character)
    {
        this.character = character;
        this.amount = 0;
        this.probability = 0;
        this.worth = 0;
    }

    public Object[] getRow()
    {
        return new Object[]{character,amount,probability,worth};
    }

    public void calculateProbability(float charNumberInFile){
        probability = (float)amount/charNumberInFile;
    }

    public void calculateWorth()
    {
        worth = Math.log(1/probability)/ Math.log(2) + 1e-11;
    }
}
