import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner scanner;
    private Random random;
    private int round;
    private String[] wordsArray;
    private long timeStart;

    public Game() {
        scanner = new Scanner(System.in);
        random = new Random();
        wordsArray = UtilsWords.WORDS.split(" ");
    }


    public void start() {
        round = 0;
        printMenu();


    }

    private void printMenu() {
        System.out.println("Witaj w magicznej grze");
        System.out.println("Musisz odgadnac zapisane wyrazy");

        timeStart = System.currentTimeMillis();
        for(int i = 0; i < 12; i++){
            nextWord();
        }

        System.out.println("Koniec gry!");
        System.out.println("Twoj czas to: " + (System.currentTimeMillis() - timeStart)/1000  + " s");
    }

    private String getRandomWord(){
        return wordsArray[random.nextInt(wordsArray.length-1)];
    }

    private String hashWord(String word){
        for(int i = 0; i <= 1; i++) {
            char randomChar = word.charAt(random.nextInt(word.length()));
            if(randomChar != '*') {
                word = word.replaceFirst(String.valueOf(randomChar), "*");
            }
        }
        return word;
    }

    private void nextWord() {
        String originalWord = getRandomWord();

        System.out.println("Twój wyraz: " + hashWord(originalWord));
        System.out.print("Podaj słowo: ");
        String typedWord = scanner.nextLine();

        if(!typedWord.equalsIgnoreCase(originalWord)){
            timeStart -= 5 * 1000;
            System.out.println("BLAD!");
        }
    }

}
