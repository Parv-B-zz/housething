import java.util.Scanner;
public class cli{
    static Scanner sc = new Scanner(System.in);
    static String divider = ("----------------------------------------");
    public static void mainMenu() {
        println(divider);
        println("Welcome to house");
        println(divider);
        println("1. Register person");
        println("2. Register item");
        println("3. Buy item");
        println("4. Sell item");
        println("5. View people");
        println("6. View items");
        println("7. Exit");
        println(divider);
    }
    public static void clear() {
        System.out.println('\u000C'); ///////
    }
    public static void printPeople(House h) {
        cli.clear();
        for (person p : h.people.values()) {
            println(divider);
            println("Name: " + p.name + "     Id: " + p.personId);
            println("Money: " + p.money);
        }
        println(divider);
    }
    public static void printItems(House h) {
        cli.clear();
        for (item i : h.items.values()) {
            String str;
            if(i.owner.personId==1111) str = "House";
            else str = i.owner.name;
            println(divider);
            println("Id: " + str + "     $" + i.value);
            println("Owner: " + i.owner.name);
            println("Description: " + i.description);
        }
        println(divider);
    }
    public static void println (String str) {
        System.out.println(str);
    }
    public static void registerPerson (House h){
        cli.clear();
        cli.println("Enter person's name");
        String nam = (new Scanner(System.in)).nextLine();
        cli.println("Enter person's deposit");
        long mon = sc.nextLong();
        cli.println("Enter person's id");
        int pId = sc.nextInt();
        if (h.validateNewPersonId(pId))
            h.addPerson(pId, nam, mon);
        else
            cli.println("The personId is already in use");
    }
    public static void registerItem(House h) {
        cli.clear();
        cli.println("Enter owner's ID");
        int ownerID = sc.nextInt();
        cli.println("Enter item's ID");
        int itemID = sc.nextInt();
        cli.println("Enter item's value");
        int value = sc.nextInt();
        cli.println("Enter item's description");
        String desc = (new Scanner(System.in)).nextLine();
        if (h.validateNewItemId(itemID))
            h.addItem(ownerID, itemID, value, desc);
        else
            cli.println("The itemID is already in use");
    }
    public static void buyItem(House h){
        System.out.println("Enter ID of item to be bought");
        int itemID = sc.nextInt();
        System.out.println("Enter ID of seller");
        int sellerID = sc.nextInt();
        h.buy(itemID, sellerID);
    }
    public static void sellItem(House h){
        System.out.println("Enter ID of item to be sold");
        int itemID = sc.nextInt();
        System.out.println("Enter ID of buyer");
        int buyerID = sc.nextInt();
        h.sell(itemID, buyerID);
    }
    public static void exitSeq(){
        System.out.println("Press 1 to confirm exit");
        int a = sc.nextInt();
        if(a == 1) System.exit(0);
    }
}
