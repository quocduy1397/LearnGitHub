import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LearningThread {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		List<Thread> listThread = new ArrayList<>(); 
		while (true)
		{
			int i = 0;
			try { i = in.nextInt(); } 
			catch (Exception e) { i = 0; }
			
			int s = i;
			Thread thread = i == 1 
					? new Thread(() -> { System.out.println("ONE"); }) 
					: new Thread(() ->  
					{ 
						for (int j = 0; j < s; j++) 
						{ 
							try { Thread.sleep(2000); }
							catch (InterruptedException e) { e.printStackTrace(); } 
							System.out.println(s); 
						} 
					});	
			thread.start();
			
			listThread.add(thread);
			if (i == 0) 
			{
				listThread.forEach(t -> t.stop());
			}
		}
		 
	}

}
