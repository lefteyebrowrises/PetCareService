public class Bird extends Animal {
    private String birdType;
    private int cageSize;
    private double boardingFee;

    public Bird(String name, String type, int age, String birdType, int cageSize, double boardingFee) {
        super(name, type, age);
        this.birdType = birdType;
        this.cageSize = cageSize;
        this.boardingFee = boardingFee;
    }

    public String getBirdType() {
        return birdType;
    }

    public int getCageSize() {
        return cageSize;
    }

    public double getBoardingFee() {
        return boardingFee;
    }
}