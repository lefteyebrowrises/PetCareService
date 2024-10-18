public class Cat extends Animal {
    private String furType;
    private double boardingFee;

    public Cat(String name, String type, int age, String furType, double boardingFee) {
        super(name, type, age);
        this.furType = furType;
        this.boardingFee = boardingFee;
    }

    public double getBoardingFee() {
        return boardingFee;
    }

    public String getFurType() {
        return furType;
    }
}