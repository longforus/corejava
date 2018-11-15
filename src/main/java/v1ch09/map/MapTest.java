package v1ch09.map;

import java.util.*;

/**
 * This program demonstrates the use of a map with key type String and value type Employee.
 * @version 1.12 2015-06-21
 * @author Cay Horstmann
 */
public class MapTest
{
   public static void main(String[] args)
   {
      Map<String, Employee> staff = new HashMap<>();
      staff.put("144-25-5464", new Employee("Amy Lee"));
      staff.put("567-24-2546", new Employee("Harry Hacker"));
      staff.put("157-62-7935", new Employee("Gary Cooper"));
      staff.put("456-62-5527", new Employee("Francesca Cruz"));

      // print all entries

      System.out.println(staff);

      // remove an entry

      staff.remove("567-24-2546");

      // replace an entry

      staff.put("456-62-5527", new Employee("Francesca Miller"));

      // look up a value

      System.out.println(staff.get("157-62-7935"));

      // iterate through all entries

      staff.forEach((k, v) -> 
         System.out.println("key=" + k + ", value=" + v));

      System.out.println("``````````````````");
      NavigableMap<String, Employee> nmap = new TreeMap<>(staff);
      SortedMap<String, Employee> headMap = nmap.headMap("157-62-7935");
      Collections.unmodifiableMap(headMap).forEach((k, v) ->
          System.out.println("key=" + k + ", value=" + v));
      //List<String> list = new ArrayList<>();
      //Object[] objects = list.toArray();
      //String[] strings = list.toArray(new String[0]);
      BitSet bitSet = new BitSet(3);
      System.out.println(bitSet.get(1));
      bitSet.set(1);
      System.out.println(bitSet.get(1));
      bitSet.clear(1);
      System.out.println(bitSet.get(1));
   }
}

