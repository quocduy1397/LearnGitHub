import java.util.Scanner;

public class TestLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		while (true)
		{
			int remain = in.nextInt();
			if (remain == 0) break;
			
			System.out.println(remain--);
		}
	}

}
