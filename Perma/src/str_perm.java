import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class str_perm {
	public static String number;
	public static StringBuilder builder;	
	public static LinkedList<Integer> list;
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		
		try {
			   list = new LinkedList<Integer>();
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
	        	   List<String> Listperma = new ArrayList<String>();
	        	   findPerms(Listperma, "", number);
	        	   
	        	   Collections.sort(Listperma);

	               for(int i=0; i<Listperma.size(); i++)
	               {
	   
	           	   builder.append(Listperma.get(i));
	   				builder.append(",");
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
	
	 public static void findPerms(List<String> permaList, String mystr, String chars) {

         if (chars.length() <= 1)
             permaList.add(mystr + chars);    
         else
         for (int i = 0; i < chars.length(); i++) 
         {
             String newString = chars.substring(0, i) + chars.substring(i + 1);
             findPerms(permaList, mystr + chars.charAt(i), newString);
         }

    }

	
}
