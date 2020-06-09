import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person a = new Person();
		System.out.println(a.getID());
		System.out.println(a.getName());
		System.out.println(a.getPhone());
		System.out.println(a.getBirthday());
		
		List<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i < 10; ++i)
		{
			b.add(i);
		}
		
		for (int i : b)
			System.out.println(i);
		
		try {
			Generic<Person> generic = new Generic<Person>(Person.class);
			generic.showDetail();
			Person c = generic.gettobject();
			System.out.println(c.getName());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
