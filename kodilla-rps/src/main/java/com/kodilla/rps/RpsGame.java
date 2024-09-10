package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsGame {
    private String playerName;
    private int roundsToWin;
    private int playerScore;
    private int computerScore;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void start() {
        System.out.println("Witaj w grze papier, kamien, nozyce!");
        System.out.print("Podaj swoje imie: ");
        playerName = scanner.nextLine();
        System.out.print("Do ilu wygranych chcesz grac? ");
        roundsToWin = scanner.nextInt();
        scanner.nextLine();

        play();
    }

    private void play() {
        boolean end = false;

        while (!end) {
            System.out.println("\nWybierz swoj ruch:");
            System.out.println("1 - Kamien, 2 - Papier, 3 - Nozyce, x - Zakoncz, n - Nowa gra");
            String playerChoice = scanner.nextLine();

            if (playerChoice.equals("x")) {
                end = confirmExit();
            } else if (playerChoice.equals("n")) {
                end = confirmNewGame();
                if (!end) {
                    resetGame();
                }
            } else {
                playRound(playerChoice);
            }

            if (playerScore == roundsToWin || computerScore == roundsToWin) {
                end = true;
                System.out.println("\nGra zakończona! Wynik: " + playerScore + " - " + computerScore);
                System.out.println(playerScore > computerScore ? playerName + " wygrał!" : "Komputer wygrał!");
            }
        }
    }

    private boolean confirmExit() {
        System.out.print("Czy na pewno chcesz zakończyć grę? (tak/nie): ");
        return scanner.nextLine().equalsIgnoreCase("tak");
    }

    private boolean confirmNewGame() {
        System.out.print("Czy na pewno chcesz rozpocząć nową grę? (tak/nie): ");
        return scanner.nextLine().equalsIgnoreCase("tak");
    }

    private void resetGame() {
        playerScore = 0;
        computerScore = 0;
    }

    private void playRound(String playerChoice) {
        int playerMove = convertPlayerChoice(playerChoice);
        if (playerMove == -1) {
            System.out.println("Nieprawidlowy wybor, spróbuj ponownie.");
            return;
        }

        int computerMove = random.nextInt(3) + 1;
        displayMoves(playerMove, computerMove);
        determineWinner(playerMove, computerMove);
        displayScores();
    }

    private int convertPlayerChoice(String playerChoice) {
        switch (playerChoice) {
            case "1":
                return 1; // Kamień
            case "2":
                return 2; // Papier
            case "3":
                return 3; // Nożyce
            default:
                return -1;
        }
    }

    private void displayMoves(int playerMove, int computerMove) {
        System.out.println(playerName + " wybrał: " + moveName(playerMove));
        System.out.println("Komputer wybrał: " + moveName(computerMove));
    }

    private String moveName(int move) {
        switch (move) {
            case 1:
                return "Kamień";
            case 2:
                return "Papier";
            case 3:
                return "Nożyce";
            default:
                return "Nieznany";
        }
    }

    private void determineWinner(int playerMove, int computerMove) {
        if (playerMove == computerMove) {
            System.out.println("Remis!");
        } else if ((playerMove == 1 && computerMove == 3) ||
                (playerMove == 2 && computerMove == 1) ||
                (playerMove == 3 && computerMove == 2)) {
            System.out.println(playerName + " wygrywa rundę!");
            playerScore++;
        } else {
            System.out.println("Komputer wygrywa rundę!");
            computerScore++;
        }
    }

    private void displayScores() {
        System.out.println("Wynik: " + playerName + " " + playerScore + " - " + computerScore + " Komputer");
    }
}
