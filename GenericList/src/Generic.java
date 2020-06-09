import java.lang.reflect.Field;

public class Generic<T> {
	private T tobject;

	public Generic(Class<T> tclass) 
	 throws InstantiationException, IllegalAccessException {
		this.tobject = (T) tclass.newInstance();
	}
	
	public T gettobject()
	{
		return this.tobject;
	}
	
	public void showDetail()
	{
		for (Field field : tobject.getClass().getDeclaredFields())
		{
			field.setAccessible(true);
			System.out.println(field.getName());
		}
	}
}
