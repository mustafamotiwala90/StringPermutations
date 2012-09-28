import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;


public class lcs {
	public static StringBuilder builder;
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		
		 try {
	           FileInputStream fis = null;
	           BufferedInputStream bis = null;
	           DataInputStream dis = null;

		           File file = new File(args[0]);
	        	  fis = new FileInputStream(file);
	           bis = new BufferedInputStream(fis);
	           dis = new DataInputStream(bis);
	           while (dis.available() != 0) 
	           {
	        	   String number = dis.readLine();
	        	   
	        	   String delims = "[;]+";
		           String[] tokens = number.split(delims); 
		           
		           String result = lcstr(tokens[0],tokens[1]);
		           System.out.println(""+result);
		           
	           }
		
	           fis.close();
	           bis.close();
	           dis.close();
	           
		 }catch(Exception er)
		 {
			 er.printStackTrace();
		 }
		
		
	}
	
	public static String lcstr(String first,String second)
	{
	    int[][] lcsarr = new int[first.length()+1][second.length()+1];

	    for (int i = 0; i < first.length(); i++)
	        for (int j = 0; j < second.length(); j++)
	            if (first.charAt(i) == second.charAt(j))
	                lcsarr[i+1][j+1] = lcsarr[i][j] + 1;
	            else
	                lcsarr[i+1][j+1] =
	                    Math.max(lcsarr[i+1][j], lcsarr[i][j+1]);		

	    StringBuffer builder = new StringBuffer();
		for(int x =first.length(),y =second.length();x!=0&&y!=0;)
		{
			if (lcsarr[x][y] == lcsarr[x-1][y])
	            x--;
	        else if (lcsarr[x][y] == lcsarr[x][y-1])
	            y--;
	        else {
	            assert first.charAt(x-1) == second.charAt(y-1);
	            builder.append(first.charAt(x-1));
	            x--;
	            y--;
		}
		
		
		
		
	}
	
		return builder.reverse().toString();
		
	}	
	
}
