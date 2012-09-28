import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class prime_less {
	
	public static String number;
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
			 
	        	   number = dis.readLine();
	        	   builder = new StringBuilder();
	        	   int i,j;
	        	   int num = Integer.parseInt(number);
	        	   for (i=1; i < num; i++ )
	        	   {
	        		   for (j=2; j<i; j++)
	        		   {
	        		   int n = i%j;
	        		   if (n==0)
	        		   {
	        		   break;
	        		   }
	        	   }
	        		   if(i == j)
	        		   {
	        			
	        			builder.append(i);
	       				builder.append(",");
	       				
	        		   }
	        		   	        	   
	        	   }
	        	   String delim = builder.toString();
      		        String delimmm = removeLastChar(delim);
      		        System.out.println(""+delimmm);

	           
	           }
	           fis.close();
	           bis.close();
	           dis.close();
		 }catch(Exception er)
		 {
			 er.printStackTrace();
		 }
	       System.exit(0);
	}
	
	public static String removeLastChar(String s) {
	    if (s == null || s.length() == 0) {
	        return s;
	    }
	    return s.substring(0, s.length()-1);
	}
	
	
	
	}
