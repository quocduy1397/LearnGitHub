import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

	public static List<Person> list = new ArrayList<Person>();
	
	public static void main(String[] args) {
		
		//Make custom Number String
		int number = 14;
		String prefix = "ADMIN";
		System.out.println(String.format(prefix + "_%05d", number));
		
		//Get Fields of class
		Person person = new Person();
		try
		{
			for (Field field : person.getClass().getDeclaredFields())
			{
				System.out.println(field.getType().toString());
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//Get Generic Type of List, ArrayList
		try 
		{
			Field field = Main2.class.getDeclaredField("list");
			ParameterizedType typeList = (ParameterizedType) field.getGenericType();
			Class<?> GenericClass = (Class<?>) typeList.getActualTypeArguments()[0];
			System.out.println(GenericClass.toString());
		} 
		catch (NoSuchFieldException | SecurityException e) 
		{
			e.printStackTrace();
		}
		
	}

}
