import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 7, 2, 8, 1};
		for (int i : filterDuplicates(array))
		{
			System.out.println(i);
		}
		
		for (int i : removeDuplicates(array))
		{
			System.out.print(i + " ");
		}
		
		System.out.println("\n" + calculateTotalPrice(10, 1, 3, 9, 5, 2));
		
		System.out.println(closestToZero(42, -5, 12, 21, 5, 24, -5));
	}

	public static int[] filterDuplicates(int[] data) {
		int numberDuplicate = 0;
		for (int i = 0; i < data.length; ++i)
		{
			for (int j = i + 1; j < data.length; ++j)
			{
				if (data[j] == data[i]) { numberDuplicate = numberDuplicate + 1; }		
			}
		}
		
		int[] position = new int[numberDuplicate];
		int index = 0;
		for (int i = 0; i < data.length; ++i)
		{
			for (int j = i + 1; j < data.length; ++j)
			{
				if (data[i] == data[j]) 
				{ 
					position[index] = j; 
					index = index + 1; 
				}
			}
		}
		
		int[] newArray = new int[data.length - numberDuplicate];
		index = 0;
		for (int i = 0; i < data.length; ++i)
		{
			int same = 0;
			for (int j = 0; j < position.length; ++j)
			{
				if (i == position[j]) { same = same + 1; }
			}
			if (same == 0) { newArray[index] = data[i]; index = index + 1; }
		}
		
		return newArray;
	}
	
	public static int[] removeDuplicates(int... datas) {
		return Arrays.stream(datas).distinct().toArray();
	}
	
	public static int calculateTotalPrice(int discount, int... prices) {
		int totalPrice = (int) Math.round(Arrays.stream(prices)
			  .mapToDouble(item -> 
			  { 
				  if (item == Arrays.stream(prices).asDoubleStream().max().getAsDouble()) 
				  {
					  return item*(1 - (double) discount/100);
				  } 
				  else 
				  {
					  return item;
				  }
			  }).sum());
		return totalPrice;
	}
	
	public static int closestToZero(int... temperatures) {
		if (temperatures.length == 0)
			return 0;
		
		int min = temperatures[0];
		int distant = Math.abs(temperatures[0] - 0);
		for (int temp : temperatures)
		{
			if (Math.abs(temp - 0) < distant)
			{
				distant = Math.abs(temp - 0);
				min = temp;
			}
			else
			{
				if (Math.abs(temp - 0) == distant)
				{
					if (temp > 0) min = temp;
				}
			}
		}
		return min;
	}
}
