
public class Person implements Comparable<Person>
{
    String name;
    public Person(String n)
    {
        name = n;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int compareTo(Person other)
    {
        return this.name.compareTo(other.name);
    }
    
    public static void mainMethod(String[] args)
    {
        Person p1 = new Person("Kris");
        
        System.out.println();
    }
}