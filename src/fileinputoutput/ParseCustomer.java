package fileinputoutput;

import java.io.*;
/**
 *
 * @author oladele
 */
public class ParseCustomer {
    
    public static void main(String[] args) {
       
         FileReader frs = null;
    
    //Declare streamTokenizer 
    
    StreamTokenizer in = null;
    
    //Three input file fields: customer number, customer name, customer Town
    /*and customer county */
   
    int customer_number = 0;
    
    String customer_name = null;
    
    String customer_town = null;
    
    String customer_county = null;
    
    try {
         //Create file input stream
         
         frs = new FileReader("customer.dat");
         
        //Create a stream tokenizer wrapping file input stream
         
         in = new StreamTokenizer(frs);
         
         //Read first token
         
         in.nextToken();
         
         //Process a record
         
         while (in.ttype != StreamTokenizer.TT_EOF) {
             
             
         //Get customer number
         
        if (in.ttype == StreamTokenizer.TT_NUMBER)
            customer_number = (int) in.nval;
        else
                System.out.println("Bad File format");
        
        
        //Get product customer name
         
         if(in.nextToken() == StreamTokenizer.TT_WORD)
             
             customer_name = in.sval;
         
         else
             System.out.println("Bad file format");
         
        
        //Get product customer town
         
         if(in.nextToken() == StreamTokenizer.TT_WORD)
             
             customer_town = in.sval;
         
         else
             System.out.println("Bad file format");
         
         
        //Get product customer county
         
         if(in.nextToken() == StreamTokenizer.TT_WORD)
             
             customer_county = in.sval;
         
         else
             System.out.println("Bad file format");
         
         
         System.out.println("Customer Number: " + customer_number);
         
         System.out.println("Customer Name: " + customer_name);
         
         System.out.println("Customer Town: " + customer_town);
         
         System.out.println("Customer County: " + customer_county);
 
    }   
    
}
 catch (FileNotFoundException ex) {
        
       System.out.println("File not found: customer.dat");
 }
 catch (IOException ex) {
        System.out.println(ex.getMessage());
 }
 finally {
        
        try {
            
            if(frs != null) frs.close();
        }
        catch (IOException ex) {
            
            System.out.println(ex);
        }
    }
  }
}

  