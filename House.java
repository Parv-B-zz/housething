import java.util.HashMap;
public class House extends person {

    public House(long b) {
        personId = 1111;// id reserved for
        money = b;
    }

    public HashMap<Integer, item> items = new HashMap<Integer, item>(); // itemId -> item
    public HashMap<Integer, person> people = new HashMap<Integer, person>(); // personId -> person

    public void sell(int itemId, int personId) {
        /**
         * itId - ID of item to be sold perId - ID of buyer
         */

        // get item from hashmap
        item it = items.get(itemId);
        // get person from hashmap
        person c = people.get(personId);

        // initialize failsafes
        item temp = it;
        person temp1 = c;

        // attempt transaction
        try {
            it.owner = c;
            this.money += it.value;
            c.money -= it.value;
            assert c.money >= 0 : (c.name + " cannot afford item " + it.itemId);
        } catch (Exception e) {
            // return to failsafes
            it = temp;
            c = temp1;
        }
    }

    public void buy(int itemId, int personId) {
        /**
         * itId - ID of item to be sold | perId - ID of seller
         */

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
            System.out.println("The house cannot afford item " + it.itemId);
            // return to failsafes
            it = temp;
            c = temp1;
        }
    }

    public void registerItem(int personId, int itemId, long val, String desc) {
        item tmp = new item();
        person per = people.get(personId);
        tmp.owner = per;
        tmp.itemId = itemId;
        tmp.value = val;
        tmp.description = desc;
        items.put(tmp.itemId, tmp);
    }

    public void registerPerson(int perId, String n, long d) {
        person tmp = new person();
        tmp.personId = perId;
        tmp.name = n;
        tmp.money = d;
        people.put(perId, tmp);
    }

    public boolean validateNewPersonId(int x) {
        if(people.containsKey(x))  return true;
        else return false;
    }

}
