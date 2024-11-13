import java.util.ArrayList;
import java.util.List;

public class PetCareService {
    private List<Animal> pets; // Enkapsulasi atribut private namun dapat diakses dengan bantuan metode publik
                               // (addPet, getPetInfo, calculateTotalCost)

    public PetCareService() { // Constructor Di Java, konstruktor adalah metode khusus yang dipanggil saat
                              // objek kelas dipakai. Ini digunakan untuk menginisialisasi objek.
        pets = new ArrayList<>();
    }

    public void addPet(Animal pet) { // contoh method yang tidak mengembalikan value apapun
        pets.add(pet); // Menambahkan hewan ke daftar pets.
    }

    public String getPetInfo() { // contoh method yang mengembalikan value string
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
            // Menggunakan metode dari kelas Animal
            info.append("Nama: ").append(pet.getName()).append("\n");
            info.append("Jenis: ").append(pet.getType()).append("\n");
            info.append("Umur: ").append(pet.getAge()).append("\n");

            // Polimorfisme: Memeriksa tipe spesifik dari objek pet
            if (pet instanceof Dog) {
                Dog dog = (Dog) pet; // Casting ke tipe Dog
                info.append("Breed: ").append(dog.getBreed()).append("\n");
                info.append("Kebiasaan: ").append(dog.getHabit()).append("\n");
                info.append("Biaya Penitipan: ").append(dog.getBoardingFee()).append("\n");
            } else if (pet instanceof Cat) {
                Cat cat = (Cat) pet; // Casting ke tipe Cat
                info.append("Jenis bulu: ").append(cat.getFurType()).append("\n");
                info.append("Biaya Penitipan: ").append(cat.getBoardingFee()).append("\n");
            } else if (pet instanceof Bird) {
                Bird bird = (Bird) pet; // Casting ke tipe Bird
                info.append("Jenis burung: ").append(bird.getBirdType()).append("\n");
                // info.append("Ukuran kandang: ").append(bird.getCageSize()).append("\n");
                info.append("Biaya Penitipan: ").append(bird.getBoardingFee()).append("\n");
            }

            info.append("\n");
        }

        info.append("=============================================\n");
        return info.toString();
    }

    public String calculateTotalCost() { // contoh method yang mengembalikan value string
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

            // Polimorfisme: Memeriksa tipe spesifik dari objek pet
            if (pet instanceof Dog) {
                totalDogs++;
                Dog dog = (Dog) pet; // Casting ke tipe Dog
                totalDogFee += dog.getBoardingFee();
            } else if (pet instanceof Cat) {
                totalCats++;
                Cat cat = (Cat) pet; // Casting ke tipe Cat
                totalCatFee += cat.getBoardingFee();
            } else if (pet instanceof Bird) {
                totalBirds++;
                Bird bird = (Bird) pet; // Casting ke tipe Bird
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