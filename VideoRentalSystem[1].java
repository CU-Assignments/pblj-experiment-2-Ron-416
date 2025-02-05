// Ronit | 23BCS80019

import java.util.ArrayList;
import java.util.Scanner;

class Video {
    private String title;
    private boolean isRented;

    public Video(String title) {
        this.title = title;
        this.isRented = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rentVideo() {
        if (!isRented) {
            isRented = true;
            System.out.println(title + " has been rented.");
        } else {
            System.out.println(title + " is already rented.");
        }
    }

    public void returnVideo() {
        if (isRented) {
            isRented = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not rented.");
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Status: " + (isRented ? "Rented" : "Available");
    }
}


class VideoStore {
    private ArrayList<Video> inventory = new ArrayList<>();

    public void addVideo(String title) {
        inventory.add(new Video(title));
        System.out.println(title + " has been added to the inventory.");
    }

    public void rentVideo(String title) {
        for (Video video : inventory) {
            if (video.getTitle().equalsIgnoreCase(title)) {
                video.rentVideo();
                return;
            }
        }
        System.out.println("Video not found in inventory.");
    }

    public void returnVideo(String title) {
        for (Video video : inventory) {
            if (video.getTitle().equalsIgnoreCase(title)) {
                video.returnVideo();
                return;
            }
        }
        System.out.println("Video not found in inventory.");
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("No videos in inventory.");
        } else {
            for (Video video : inventory) {
                System.out.println(video);
            }
        }
    }
}


public class VideoRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoStore store = new VideoStore();
        
        while (true) {
            System.out.println("\n1. Add Video");
            System.out.println("2. Rent Video");
            System.out.println("3. Return Video");
            System.out.println("4. Show Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.print("Enter video title to add: ");
                    String titleToAdd = scanner.nextLine();
                    store.addVideo(titleToAdd);
                    break;
                case 2:
                    System.out.print("Enter video title to rent: ");
                    String titleToRent = scanner.nextLine();
                    store.rentVideo(titleToRent);
                    break;
                case 3:
                    System.out.print("Enter video title to return: ");
                    String titleToReturn = scanner.nextLine();
                    store.returnVideo(titleToReturn);
                    break;
                case 4:
                    store.showInventory();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
