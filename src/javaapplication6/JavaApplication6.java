

package javaapplication6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;  
import javax.print.DocFlavor;
public class JavaApplication6 {

    
  
    static String readFile(String address)
    {
        try {
              File myObj = new File(address);
              Scanner myReader = new Scanner(myObj);
              String lines="";      
              while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                
                lines=lines+"\n\r"+data;        
              }
              myReader.close();
              return lines.toLowerCase();
            } catch (FileNotFoundException e) {
               System.out.println("An error occurred."+" "+"\n\r"+e);
              return null;
            }
    }
    static boolean matchText(String reg,String input)
    {
        try
          {
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(input);    
             if (m.find()==true){
                return true;
             }
             else
             {
                return false;
             }
          }
    catch(Exception e)
          {
             System.out.println("An error occurred."+" "+"\n\r"+e);
             return false;
          }
    }
    static void find(String directory,String reg)
    {
        try
        {
              File dir=new File(directory);
              for(File name:dir.listFiles())
              {

                  System.out.println(name);
                  System.out.println( matchText(reg, readFile(name.getAbsolutePath())));
              }
        
        }catch(Exception e)
        {
              System.out.println("An error occurred."+" "+"\n\r"+e);
        }
    }
    static String makeregx(String searchText)
    {
        try
        {
         String reg = "";
                String[] sp = searchText.toLowerCase().split(" ");
                for (String item : sp)
                {
                    if (item.equals("or"))
                    {
                        reg = reg + "|";
                    }
                    else if (item.equals("and") )
                    {
                        reg = reg + "\\s*";
                    }
                    else if (item.equals("")) continue;
                    else
                    {
                        reg = reg + "(" + item + ")";
                    }
                }
                System.out.println(reg);
                return reg;
        }
        catch(Exception e)
        {
             System.out.println("An error occurred."+" "+"\n\r"+e);
             return null;
        }
    }
    
    public static void main(String[] args) {
      try
      {
         Scanner in = new Scanner(System.in); 
         System.out.println("\\\\Please enter directory address : ");
         String address,searchText;
         address=in.nextLine();
          System.out.println("\\\\Please enter your keywords : ");
         searchText=in.nextLine();         
         find(address,makeregx(searchText));
      }
      catch(Exception e)
      {
       System.out.println("An error occurred."+" "+"\n\r"+e);
      }
         
         
     
    }
    
}
