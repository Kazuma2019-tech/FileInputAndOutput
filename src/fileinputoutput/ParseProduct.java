/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileinputoutput;

import java.io.*;
/**
 *
 * @author olade
 */
public class ParseProduct {
    
//Main method
    
    public static void main (String[] args) {
        
    //Declare file reader stream
    
    FileReader frs = null;
    
    //Declare streamTokenizer 
    
    StreamTokenizer in = null;
    
    //Three input file fields: product code, product desciption and product price
    
    String product_code = null;
    
    String product_desc = null;
    
    double product_price = 0;
    
    try {
         //Create file input stream
         
         frs = new FileReader("product.dat");
         
         //Create a stream tokenizer wrapping file input stream
         
         in = new StreamTokenizer(frs);
         
         //Read first token
         
         in.nextToken();
         
         //Process a record
         
         while (in.ttype != StreamTokenizer.TT_EOF) {
        
         //Get product code
         
         if(in.ttype == StreamTokenizer.TT_WORD)
             
         product_code = in.sval;
         
         else
             System.out.println("Bad file format");
         
         //Get product product description
         
         if(in.nextToken() == StreamTokenizer.TT_WORD)
             
             product_desc = in.sval;
         
         else
             System.out.println("Bad file format");
         
         //Get product price
         
         if (in.nextToken() == StreamTokenizer.TT_NUMBER)
             
             product_price = in.nval;
         
         else
             System.out.println("Bad file format");
         
         in.nextToken();
         
         System.out.println("Product Code: " + product_code );

         System.out.println("Product Description: " + product_desc);
         
         System.out.println("Product Price: " + product_price);
    }
  }
   catch (FileNotFoundException ex) {
        
       System.out.println("File not found: product.dat");
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

