public class Dog extends Animal {
    private String breed;
    private String habit;
    private double boardingFee;

    public Dog(String name, String type, int age, String breed, String habit, double boardingFee) {
        super(name, type, age);
        this.breed = breed;
        this.habit = habit;
        this.boardingFee = boardingFee;
    }

    public double getBoardingFee() {
        return boardingFee;
    }

    public String getBreed() {
        return breed;
    }

    public String getHabit() {
        return habit;
    }
}