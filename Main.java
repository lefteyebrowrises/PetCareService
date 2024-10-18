import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PetCareService petCareService = new PetCareService();
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
                            System.out.print("Masukkan breed anjing (small, medium, large): ");
                            String breed = scanner.nextLine();
                            
                            System.out.print("Masukkan kebiasaan anjing: ");
                            String habit = scanner.nextLine();
                            
                            boardingFee = calculateBoardingFeeForDog(breed, days);
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
                            System.out.print("Masukkan jenis bulu kucing (short, long): ");
                            String furType = scanner.nextLine();
                            
                            boardingFee = calculateBoardingFeeForCat(furType, days);
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
                            System.out.print("Masukkan jenis burung: ");
                            String birdType = scanner.nextLine();
                            
                            System.out.print("Masukkan ukuran kandang burung (small, medium, large): ");
                            int cageSize = scanner.nextInt();
                            scanner.nextLine();
                            
                            boardingFee = calculateBoardingFeeForBird(birdType, days);
                            petCareService.addPet(new Bird(name, type, age, birdType, cageSize, boardingFee));
                            System.out.println();
                            System.out.println("=============================================");
                            System.out.println("         Data yang Anda masukkan:");
                            System.out.println("=============================================");
                            System.out.println("Nama: " + name);
                            System.out.println("Jenis: " + type);
                            System.out.println("Umur: " + age);
                            System.out.println("Jenis burung: " + birdType);
                            System.out.println("Ukuran kandang: " + cageSize);
                            System.out.println("Biaya Penitipan: " + boardingFee);
                            System.out.println("=============================================");
                            System.out.println();
                            break;
                        default:
                            System.out.println("Invalid pet choice");
                    }
                    break;
                    case 2:
                        System.out.println();
                        System.out.println(petCareService.getPetInfo());
                        System.out.println();
                        break;
                    case 3:
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
        } else {
            return days * 35000.0; // large breed, high maintenance
        }
    }
    
    private static double calculateBoardingFeeForCat(String furType, int days) {
        if (furType.equals("Short")) {
            return days * 10000.0; // short fur, low maintenance
        } else if (furType.equals("Long")) {
            return days * 20000.0; // long fur, high maintenance
        } else {
            return days * 15000.0; // default, medium maintenance
        }
    }
    
    private static double calculateBoardingFeeForBird(String birdType, int days) {
        if (birdType.equals("Small")) {
            return days * 5000.0; // small bird, small cage
        } else if (birdType.equals("Medium")) {
            return days * 10000.0; // medium bird, medium cage
        } else {
            return days * 15000.0; // large bird, large cage
        }
    }
}

