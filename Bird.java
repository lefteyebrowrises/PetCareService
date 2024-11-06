public class Bird extends Animal { // inheritance mewarisi class animal
    private String birdType;
    private String cageSize;
    private double boardingFee;

    public Bird(String name, String type, int age, String birdType, String cageSize, double boardingFee) {
        super(name, type, age);
        this.birdType = birdType;
        this.cageSize = cageSize;
        this.boardingFee = boardingFee;
    }

    public String getBirdType() {
        return birdType;
    }

    public String getCageSize() {
        return cageSize;
    }

    public double getBoardingFee() {
        return boardingFee;
    }
}