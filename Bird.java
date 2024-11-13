public class Bird extends Animal { // inheritance mewarisi class animal
    private String birdType;
    private double boardingFee;

    public Bird(String name, String type, int age, String birdType, double boardingFee) {
        super(name, type, age);
        this.birdType = birdType;
        this.boardingFee = boardingFee;
    }

    public String getBirdType() {
        return birdType;
    }

    public double getBoardingFee() {
        return boardingFee;
    }
}