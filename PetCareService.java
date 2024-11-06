import java.util.ArrayList;
import java.util.List;

public class PetCareService {
    private List<Animal> pets; // enkapsulasi atribute private namun dapat di akses dengan bantuan metode
                               // public, seperti getPetInfo

    public PetCareService() {
        pets = new ArrayList<>();
    }

    public void addPet(Animal pet) {
        pets.add(pet);
    }

    public String getPetInfo() {
        StringBuilder info = new StringBuilder();

        System.out.println("=============================================");
        System.out.println("               Informasi Hewan");
        System.out.println("=============================================");
        if (pets.isEmpty()) {
            System.out.println("        Tidak ada hewan yang dititipkan");
            System.out.println("=============================================");
            return "";
        }
        for (Animal pet : pets) {
            info.append("Nama: ").append(pet.getName()).append("\n");
            info.append("Jenis: ").append(pet.getType()).append("\n");
            info.append("Umur: ").append(pet.getAge()).append("\n");

            if (pet instanceof Dog) {
                Dog dog = (Dog) pet;
                info.append("Breed: ").append(dog.getBreed()).append("\n");
                info.append("Kebiasaan: ").append(dog.getHabit()).append("\n");
                info.append("Biaya Penitipan: ").append(dog.getBoardingFee()).append("\n");
            } else if (pet instanceof Cat) {
                Cat cat = (Cat) pet;
                info.append("Jenis bulu: ").append(cat.getFurType()).append("\n");
                info.append("Biaya Penitipan: ").append(cat.getBoardingFee()).append("\n");
            } else if (pet instanceof Bird) {
                Bird bird = (Bird) pet;
                info.append("Jenis burung: ").append(bird.getBirdType()).append("\n");
                info.append("Ukuran kandang: ").append(bird.getCageSize()).append("\n");
                info.append("Biaya Penitipan: ").append(bird.getBoardingFee()).append("\n");
            }

            info.append("\n");
        }

        info.append("=============================================\n");
        return info.toString();
    }

    public String calculateTotalCost() {
        int totalDogs = 0;
        int totalCats = 0;
        int totalBirds = 0;
        int totalAnimals = 0;
        double totalDogFee = 0;
        double totalCatFee = 0;
        double totalBirdFee = 0;
        double totalFee = 0;

        for (Animal pet : pets) {
            totalAnimals++;

            if (pet instanceof Dog) {
                totalDogs++;
                Dog dog = (Dog) pet;
                totalDogFee += dog.getBoardingFee();
            } else if (pet instanceof Cat) {
                totalCats++;
                Cat cat = (Cat) pet;
                totalCatFee += cat.getBoardingFee();
            } else if (pet instanceof Bird) {
                totalBirds++;
                Bird bird = (Bird) pet;
                totalBirdFee += bird.getBoardingFee();
            }
        }

        totalFee = totalDogFee + totalCatFee + totalBirdFee;

        System.out.println("=============================================");
        System.out.println("               Total Hewan");
        System.out.println("=============================================");
        System.out.println("Total Dogs: " + totalDogs);
        System.out.println("Total Cats: " + totalCats);
        System.out.println("Total Birds: " + totalBirds);
        System.out.println("Total Animals: " + totalAnimals);
        System.out.println("=============================================");
        System.out.println("               Total Fee");
        System.out.println("=============================================");
        System.out.println("Total Dog Fee: " + totalDogFee);
        System.out.println("Total Cat Fee: " + totalCatFee);
        System.out.println("Total Bird Fee: " + totalBirdFee);
        System.out.println("Total Fee: " + totalFee);
        System.out.println("=============================================");
        return "";
    }
}