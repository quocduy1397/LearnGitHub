import java.util.Scanner;

public class GameLoop {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int lightX = in.nextInt();
        int lightY = in.nextInt();
        int initialTx = in.nextInt();
        int initialTy = in.nextInt();
		
        while (true)
        {
        	int remainingTurns = in.nextInt();
        	if (remainingTurns == 0)
        		break;
        	
        	
        	if (initialTx < lightX && initialTy == lightY) 
            {
                System.out.println(lightX + " " + lightY + " " + (initialTx + 1) + " " + initialTy + " " + (remainingTurns - 1));
            }
            if (initialTx > lightX && initialTy == lightY) 
            {
            	System.out.println(lightX + " " + lightY + " " + (initialTx - 1) + " " + initialTy + " " + (remainingTurns - 1));
            }
            if (initialTx == lightX && initialTy > lightY) 
            {
            	System.out.println(lightX + " " + lightY + " " + initialTx + " " + (initialTy - 1) + " " + (remainingTurns - 1));
            }
            if (initialTx == lightX && initialTy < lightY) 
            {
            	System.out.println(lightX + " " + lightY + " " + initialTx + " " + (initialTy + 1) + " " + (remainingTurns - 1));
            }

            if (initialTx < lightX && initialTy > lightY) 
            {
            	System.out.println(lightX + " " + lightY + " " + (initialTx + 1) + " " + (initialTy - 1) + " " + (remainingTurns - 1));
            }
            if (initialTx < lightX && initialTy < lightY) 
            {
            	System.out.println(lightX + " " + lightY + " " + (initialTx + 1) + " " + (initialTy + 1) + " " + (remainingTurns - 1));
            }
            if (initialTx > lightX && initialTy > lightY) 
            {
            	System.out.println(lightX + " " + lightY + " " + (initialTx - 1) + " " + (initialTy - 1) + " " + (remainingTurns - 1));
            }
            if (initialTx > lightX && initialTy < lightY) 
            {
            	System.out.println(lightX + " " + lightY + " " + (initialTx - 1) + " " + (initialTy + 1) + " " + (remainingTurns - 1));
            }
        }
	}

}
