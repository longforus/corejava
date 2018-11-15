package v1ch08.pair3;

/**
 * @version 1.01 2012-01-26
 * @author Cay Horstmann
 */
public class PairTest3
{
   public static void main(String[] args)
   {
      Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
      Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);
      Pair<Manager> buddies = new Pair<>(ceo, cfo);      
      printBuddies(buddies);

      ceo.setBonus(1000000);
      cfo.setBonus(500000);
      Manager[] managers = { ceo, cfo };
      //
      //List<? extends Employee> eList = new ArrayList<>();
      //List<? extends Manager> mList = new ArrayList<>();
      //eList = mList;//OK ,可以把一个List<? extends Manager> 或者 List<Manager>赋值给他
      //Employee employee = new Employee("e", 1, 1, 1, 1);
      //eList.add(employee);//error 也不能添加Employee的对象
      //eList.add(ceo);//error 也不能添加Manager的对象
      //boolean b = eList.addAll(mList);//error,不能添加Manager类型的对象或者list到里面,
      //Employee e = eList.get(0);//但是获取到的对象的是Employee类型

      //List<? super Employee> eList = new ArrayList<>();
      //List<Manager> mList = new ArrayList<>();
      //eList = mList;//error ,不可以把一个List<? extends Manager> 或者 List<Manager>赋值给他
      //Employee employee = new Employee("e", 1, 1, 1, 1);
      //eList.add(employee);//ok
      //eList.add(ceo);//ok
      //eList.addAll(mList);//ok
      //Object object = eList.get(0);//但是获取到的对象的是Object类型
      //TestSuper testSuper = null;
      //eList.add(testSuper);

      //Pair<Employee> result = new Pair<>();
      //minmaxBonus(managers, result);
      //System.out.println("first: " + result.getFirst().getName()
      //   + ", second: " + result.getSecond().getName());
      //maxminBonus(managers, result);
      //System.out.println("first: " + result.getFirst().getName()
      //   + ", second: " + result.getSecond().getName());
   }

   public static void printBuddies(Pair<? extends Employee> p)
   {
      Employee first = p.getFirst();
      Employee second = p.getSecond();
      System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
   }

   public static void minmaxBonus(Manager[] a, Pair<? super Manager> result)
   {
      if (a.length == 0) return;
      Manager min = a[0];
      Manager max = a[0];
      for (int i = 1; i < a.length; i++)
      {
         if (min.getBonus() > a[i].getBonus()) min = a[i];
         if (max.getBonus() < a[i].getBonus()) max = a[i];
      }
      result.setFirst(min);
      result.setSecond(max);
   }

   public static void maxminBonus(Manager[] a, Pair<? super Manager> result)
   {
      minmaxBonus(a, result);
      PairAlg.swap(result); // OK--swapHelper captures wildcard type
   }
   // Can't write public static <T super manager> ...
}

class PairAlg
{
   public static boolean hasNulls(Pair<?> p)
   {
      return p.getFirst() == null || p.getSecond() == null;
   }

   public static void swap(Pair<?> p) {
      swapHelper(p);
   }

   public static <T> void swapHelper(Pair<T> p)
   {
      T t = p.getFirst();
      p.setFirst(p.getSecond());
      p.setSecond(t);
   }
}


