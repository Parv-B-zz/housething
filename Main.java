import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cli.println("Enter house deposit");
        House h = new House(sc.nextLong());
        cli.println("House petty cash: " + h.money);
        for (;;) {
            cli.mainMenu();
            switch (sc.nextInt()) {
            case 1:
                cli.registerPerson(h);
                break;
            case 2:
                cli.registerItem(h);
                break;
            case 3:
                cli.buyItem(h);
                break;
            case 4:
                cli.sellItem(h);
                break;
            case 5:
                cli.printPeople(h);
                break;
            case 6:
                cli.printItems(h);
                break;
            case 7:
                cli.exitSeq();
            }

        }
    }
}
