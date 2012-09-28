import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;


public class m2last {
	public static String number;
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
		           number = dis.readLine();

		           String delims = "[ ]+";
		           String[] tokens = number.split(delims);
		           String[] tokensnew = new String[tokens.length-1];
		           int lentoken = tokens.length-1;
		           int lencom = Integer.parseInt(tokens[lentoken]);
		           if(lencom <= tokens.length)
		           {
		        		  int count=0;
		        	   for(int i=tokens.length-2;i>=0;i--)
		        	  {
		        		  tokensnew[count] = tokens[i];
		        		  count++;
		        	  }
		        		  System.out.println(""+tokensnew[lencom-1]);
		        	  
		           }
	           }
	           fis.close();
	           bis.close();
	           dis.close();
		 	  }catch(Exception er)
		 	  {
		 		  er.printStackTrace();
		 	  }
		 
		 }

}
