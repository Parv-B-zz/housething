import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        cli.println("Enter house deposit");
        House h = new House(sc.nextLong());
        cli.println("House petty cash: " + h.money);
        for (;;) {
            cli.mainMenu();
            switch (sc.nextInt()) {
                case 1:
                    cli.clear();
                    cli.println(cli.divider);
                    cli.println("Enter person's name");
                    String nam = (new Scanner (System.in)).nextLine();
                    cli.println("Enter person's deposit");
                    long mon = sc.nextLong();
                    cli.println("Enter person's id");
                    int pId = sc.nextInt();
                    if(h.validateNewPersonId(pId)){
                        h.registerPerson(pId, nam, mon);
                    }
                    else cli.println("The personId is already in use");
                break;
                case 6:
                    cli.printPeople(h);
            }
        }
    }
}
