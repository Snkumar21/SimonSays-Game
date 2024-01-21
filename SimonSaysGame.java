import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SimonSaysGame {
    private List<String> sequence;
    private Scanner scanner;

    public SimonSaysGame() {
        this.sequence = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to Simon Says Game!");
        System.out.println("Remember and repeat the sequence.");

        while (true) {
            addToSequence();
            displaySequence();
            getUserInput();
            if (!checkUserInput()) {
                System.out.println("Game Over! You made a mistake.");
                break;
            }
            System.out.println("Correct! Next round.");
        }
        scanner.close();
    }

    private void addToSequence() {
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        String color = getColorFromNumber(randomNumber);
        sequence.add(color);
    }

    private void displaySequence() {
        for (String color : sequence) {
            System.out.print(color + " ");
            sleep(1000); // Display each color for 1 second
        }
        System.out.println();
        sleep(500); // Pause for 0.5 seconds before user input
    }

    private void getUserInput() {
        System.out.println("Your turn. Enter the sequence (e.g., R G B Y):");
        String userInput = scanner.nextLine().trim().toUpperCase();
        sequence.clear(); // Clear the sequence for the next round
        String[] userColors = userInput.split(" ");
        for (String color : userColors) {
            sequence.add(color);
        }
    }

    private boolean checkUserInput() {
        if (sequence.size() != 0 && sequence.size() <= 4) {
            for (int i = 0; i < sequence.size(); i++) {
                if (!sequence.get(i).equals(getColorFromNumber(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private String getColorFromNumber(int number) {
        switch (number) {
            case 0:
                return "R"; // Red
            case 1:
                return "G"; // Green
            case 2:
                return "B"; // Blue
            case 3:
                return "Y"; // Yellow
            default:
                return "";
        }
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SimonSaysGame simonSaysGame = new SimonSaysGame();
        simonSaysGame.startGame();
    }
}
