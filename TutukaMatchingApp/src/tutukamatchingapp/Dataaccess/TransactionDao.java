/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutukamatchingapp.Dataaccess;


import java.util.ArrayList;
import tutukamatchingapp.models.Transaction;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 *
 * @author Pale
 */

public class TransactionDao {
    
    public ArrayList<Transaction> readFileContents(String filePath) throws Exception
    {
        //Declaring an arraylist of transaction class to capture records
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        
        //Transaction object declaration
        Transaction transactionObj;
        
        //instantiating the reader to read the files
        BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
        //Now we read 1st line.
        String line = csvReader.readLine();
        
        //read second line to start capturing the records
        line = csvReader.readLine();
        int x = 0;
        while(line != null)
        {
          //store records in a temporary string array
          String[] record = line.split(",");
          
          
          //loading values to our arraylist
          if(record.length != 8)
          {
                transactionObj = new Transaction(record[0], record[1], Double.parseDouble(record[2]), record[3], record[4], Long.parseLong(record[5]), record[6]);
                transactions.add(transactionObj);
                line = csvReader.readLine();
          }
          else
          {
            transactionObj = new Transaction(record[0], record[1], Double.parseDouble(record[2]), record[3], record[4], Long.parseLong(record[5]), record[6], record[7]);
            transactions.add(transactionObj);
            line = csvReader.readLine();
          }
        }
        
        return transactions;
    }
    
}
