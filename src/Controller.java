import java.util.Iterator;

public class Controller {
    public static void main(String []args){
        SearchList<Integer> searchL= new SearchList<>();
        SearchList<String> searchList2= new SearchList<>();

        searchL.add(3);
        searchL.add(7);
        searchL.add(6);
        searchL.add(5);
        searchL.add(5);
        searchL.add(4);
        searchL.add(42);
        searchL.add(10);
        searchL.add(100);
        searchL.add(100);

        searchList2.add("Wo");
        searchList2.add("Alter");
        searchList2.add("Ist");
        searchList2.add("Mein");
        searchList2.add("Bachelor");


        searchList2.ausgabe();

        Iterator<Node> iterator= searchL.iterator();

        while(iterator.hasNext()){
          System.out.println(iterator.next());
        }

        System.out.println("Die Anzahl der Objekte in der Liste beträgt: "+searchL.noWords());
      System.out.println("Die Anzahl des gesuchten Objektes ist: "+searchL.count(100));
      searchL.remove(7);

      searchL.ausgabe();
        System.out.println("Die Anzahl der Objekte in der Liste beträgt: "+searchL.noWords());
      System.out.println("Die Summe der Vorkommen beträgt: "+searchL.noOccurences());

    }
}
