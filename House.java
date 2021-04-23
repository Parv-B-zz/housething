import java.util.HashMap;
public class House extends person {

    public House(long b) {
        personId = 1111;// id reserved for house
        money = b;
    }

    public HashMap<Integer, item> items = new HashMap<Integer, item>(); // itemId -> item
    public HashMap<Integer, person> people = new HashMap<Integer, person>(); // personId -> person

    public void sell(int itemId, int personId) {
        /**
         * itId - ID of item to be sold | perId - ID of seller
         */

        if (!(items.containsKey(itemId))) {
            System.out.println("Item does not exist");
            return;
        } else if (!(people.containsKey(personId))) {
            System.out.println("Person does not exist");
            return;
        }

        // get item from hashmap
        item it = items.get(itemId);
        // get person from hashmap
        person c = people.get(personId);

        // initialize failsafes
        item temp = it;
        person temp1 = c;

        // attempt transaction
        it.owner = c;
        this.money += it.value;
        c.money -= it.value;

        if (this.money < 0) {
            cli.println("Transaction failed");
            cli.println(c.name + " cannot afford item " + it.itemId);
            // return to failsafes
            it = temp;
            c = temp1;
        }
    }

    public void buy(int itemId, int personId) {
        /**
         * itId - ID of item to be sold | perId - ID of seller
         */

        if(!(items.containsKey(itemId))){
            System.out.println("Item does not exist");
            return;
        }
        else if(!(people.containsKey(personId))){
            System.out.println("Person does not exist");
            return;
        }

        // get item from hashmap
        item it = items.get(itemId);
        // get person from hashmap
        person c = people.get(personId);

        // initialize failsafes
        item temp = it;
        person temp1 = c;

        //attempt transaction
        it.owner = c;
        this.money -= it.value;
        c.money += it.value;

        if (this.money < 0) {
            cli.println("Transaction failed");
            cli.println("The house cannot afford item " + it.itemId);
            // return to failsafes
            it = temp;
            c = temp1;
        }
    }

    public void addItem(int personId, int itemId, long val, String desc) {
        item tmp = new item();
        tmp.owner = people.get(personId);
        tmp.itemId = itemId;
        tmp.value = val;
        tmp.description = desc;
        items.put(tmp.itemId, tmp);
    }

    public void addPerson(int perId, String n, long d) {
        person tmp = new person();
        tmp.personId = perId;
        tmp.name = n;
        tmp.money = d;
        people.put(perId, tmp);
    }

    public boolean validateNewPersonId(int x) {
        if(x==1111) return false; //1111 is reserved for the house
        return(!(people.containsKey(x)));
    }

    public boolean validateNewItemId(int x) {
        return (!(people.containsKey(x)));
    }
}
