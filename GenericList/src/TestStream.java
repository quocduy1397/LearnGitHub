import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {

	public static void main(String[] args) {
		
		List<Person> list = new ArrayList<>();
		list.add(new Person());
		list.add(new Person(1,"AN","09988",LocalDate.now()));
		list.add(new Person(2,"BINH","09923",LocalDate.now()));
		list.add(new Person(3,"CUONG","099882344",LocalDate.now()));
		
		List<String> listName = list.stream().map(Person::getName).collect(Collectors.toList());
		List<String> listNameModify = list.stream().map(p -> { return p.getName() + " Modify"; }).collect(Collectors.toList());
		listName.forEach(System.out::println);
		listNameModify.forEach(System.out::println);
		listNameModify.forEach(o -> { listNameModify.set(listNameModify.indexOf(o), o = o + " Setting"); });
		listNameModify.forEach(System.out::println);
		
		List<Person> modifyList = new ArrayList<>(list);
//		List<Person> modifyList = list;
//		List<Person> modifyList = new ArrayList<>(list);
		modifyList.add(new Person(1,"AN","09988",LocalDate.now()));
		modifyList.add(new Person(2,"BINH","09923",LocalDate.now()));
		modifyList.add(new Person(3,"CUONG","099882344",LocalDate.now()));
		
		
//		modifyList.addAll(list);
		
		list.forEach(model -> 
		{
			int index = list.indexOf(model);
			model.setPhone("000231233");
			if (index < modifyList.size())
			{
				modifyList.set(index, model);
			}
		});
		
		modifyList.forEach(o -> System.out.println(o.getPhone()));
		System.out.println(testArray("A","B"));
		
	}
	
	public static String s = "";
	
	public static String testArray(String ...strings)
	{
		String a = "";
		for (String i : strings)
		{
			a = a + "Added " + i + " ";
		}
		Arrays.asList(strings).forEach(item -> { s = s + "Added " + item + " ";});
		return s;
	}

}
