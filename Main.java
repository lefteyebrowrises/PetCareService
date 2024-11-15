import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Enkapsulasi ditunjukkan oleh kelas PetCareService, yang menjaga daftar hewan
        // peliharaannya tetap private dan menyediakan metode public untuk berinteraksi
        // dengannya, memastikan bahwa keadaan internal terlindungi dan hanya dapat
        // dimodifikasi melalui metode yang ditentukan.
        PetCareService petCareService = new PetCareService(); // Create an instance of PetCareService
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Tambah Hewan Baru (Dog, Cat, atau Bird)");
                System.out.println("2. Lihat Informasi Hewan");
                System.out.println("3. Hitung Total Penitipan");
                System.out.println("4. Keluar dari Program");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println();
                        System.out.println("Pilih jenis hewan:");
                        System.out.println("1. Dog");
                        System.out.println("2. Cat");
                        System.out.println("3. Bird");

                        int petChoice = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println();
                        System.out.print("Masukkan nama hewan: ");
                        String name = scanner.nextLine();

                        System.out.print("Masukkan jenis hewan: ");
                        String type = scanner.nextLine();

                        System.out.print("Masukkan umur hewan (tahun): ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan jumlah hari penitipan: ");
                        int days = scanner.nextInt();
                        scanner.nextLine();

                        double boardingFee = 0;

                        switch (petChoice) {
                            case 1:
                                // Creating a Dog object
                                System.out.print("Masukkan breed anjing (small, medium, large): ");
                                String breed = scanner.nextLine();

                                System.out.print("Masukkan kebiasaan anjing: ");
                                String habit = scanner.nextLine();

                                boardingFee = calculateBoardingFeeForDog(breed, days);
                                // Menggunakan polimorfisme untuk menambahkan objek dog ke the petCareService
                                petCareService.addPet(new Dog(name, type, age, breed, habit, boardingFee));
                                System.out.println();
                                System.out.println("=============================================");
                                System.out.println("Data yang Anda masukkan:");
                                System.out.println("=============================================");
                                System.out.println("Nama: " + name);
                                System.out.println("Jenis: " + type);
                                System.out.println("Umur: " + age);
                                System.out.println("Breed: " + breed);
                                System.out.println("Kebiasaan: " + habit);
                                System.out.println("Biaya Penitipan: " + boardingFee);
                                System.out.println("=============================================");
                                System.out.println();
                                break;
                            case 2:
                                // Creating a Cat object
                                System.out.print("Masukkan jenis bulu kucing (short, long): ");
                                String furType = scanner.nextLine();

                                boardingFee = calculateBoardingFeeForCat(furType, days);
                                // Menggunakan polimorfisme untuk menambahkan objek cat ke the petCareService
                                petCareService.addPet(new Cat(name, type, age, furType, boardingFee));
                                System.out.println();
                                System.out.println("=============================================");
                                System.out.println("Data yang Anda masukkan:");
                                System.out.println("=============================================");
                                System.out.println("Nama: " + name);
                                System.out.println("Jenis: " + type);
                                System.out.println("Umur: " + age);
                                System.out.println("Jenis bulu: " + furType);
                                System.out.println("Biaya Penitipan: " + boardingFee);
                                System.out.println("=============================================");
                                System.out.println();
                                break;
                            case 3:
                                // Creating a Bird object
                                System.out.print("Masukkan ukuran burung (small, medium, large): ");
                                String birdType = scanner.nextLine();

                                boardingFee = calculateBoardingFeeForBird(birdType, days);
                                // Menggunakan polimorfisme untuk menambahkan objek bird ke the petCareService
                                petCareService.addPet(new Bird(name, type, age, birdType, boardingFee));
                                System.out.println();
                                System.out.println("=============================================");
                                System.out.println("         Data yang Anda masukkan:");
                                System.out.println("=============================================");
                                System.out.println("Nama: " + name);
                                System.out.println("Jenis: " + type);
                                System.out.println("Umur: " + age);
                                System.out.println("Ukuran burung: " + birdType);
                                System.out.println("Biaya Penitipan: " + boardingFee);
                                System.out.println("=============================================");
                                System.out.println();
                                break;
                            default:
                                System.out.println("Invalid pet choice");
                        }
                        break;
                    case 2:
                        // Displaying information about all pets
                        System.out.println();
                        System.out.println(petCareService.getPetInfo());
                        System.out.println();
                        break;
                    case 3:
                        // Calculating and displaying the total boarding cost
                        System.out.println();
                        System.out.println(petCareService.calculateTotalCost());
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("Keluar dari program");
                        scanner.close(); // close the scanner
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } finally {
            scanner.close(); // close the scanner in case of an exception
        }
    }

    private static double calculateBoardingFeeForDog(String breed, int days) {
        if (breed.equals("Small")) {
            return days * 15000.0; // small breed, low maintenance
        } else if (breed.equals("Medium")) {
            return days * 25000.0; // medium breed, medium maintenance
        } else if (breed.equals("Large")) {
            return days * 35000.0; // large breed, high maintenance
        } else {
            throw new IllegalArgumentException("Invalid breed: " + breed);
        }
    }

    private static double calculateBoardingFeeForCat(String furType, int days) {
        if (furType.equals("Short")) {
            return days * 10000.0; // short fur, low maintenance
        } else if (furType.equals("Long")) {
            return days * 20000.0; // long fur, high maintenance
        } else if (furType.equals("Medium")) {
            return days * 15000.0; // default, medium maintenance
        } else {
            throw new IllegalArgumentException("Invalid breed: " + furType);
        }
    }

    private static double calculateBoardingFeeForBird(String birdType, int days) {
        if (birdType.equals("Small")) {
            return days * 5000.0; // small bird, small cage
        } else if (birdType.equals("Medium")) {
            return days * 10000.0; // medium bird, medium cage
        } else if (birdType.equals("Large")) {
            return days * 15000.0; // large bird, large cage
        } else {
            throw new IllegalArgumentException("Invalid breed: " + birdType);
        }
    }
}