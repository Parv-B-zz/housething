public class cli{
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
        println(divider);
    }
    public static void clear() {
        System.out.println('\u000C');
    }
    public static void printPeople(House h) {
        for (person p : h.people.values()) {
            println(divider);
            println(p.name + "     " + p.personId);
            println(p.money +"");
        }
        println(divider);
    }
    public void printItems(House h) {
        for (item i : h.items.values()) {
            println(divider);
            println(i.itemId + "     " + i.value);
            println(i.description);
        }
        println(divider);
    }
    public static void println (String str) {
        System.out.println(str);
    }
}
