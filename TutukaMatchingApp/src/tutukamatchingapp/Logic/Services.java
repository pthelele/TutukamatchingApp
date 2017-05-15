/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutukamatchingapp.Logic;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import tutukamatchingapp.Dataaccess.TransactionDao;
import tutukamatchingapp.models.Transaction;

/**
 *
 * @author Pale
 */
public class Services {
    
        
    private TransactionDao transaction;
    private ArrayList<TransactionDao> transactionRecords;
    private Transaction transaction1Obj;
     private Transaction transaction2Obj;
    
 
    public  String fileChooser()
    {
        JFileChooser fileDir = new JFileChooser();
        fileDir.showOpenDialog(null);
        File file = fileDir.getSelectedFile();
        String filePath = file.getAbsolutePath();
        
        return filePath;
    }
    
    public Match matchTransactions(String file1, String file2) throws Exception
    {
        transaction = new TransactionDao();
        transaction1Obj = new Transaction();
        transaction2Obj = new Transaction();
        
        Match matchResults = new Match();
        
        ArrayList<Transaction> file1Contents = transaction.readFileContents(file1);
        ArrayList<Transaction> file2Contents = transaction.readFileContents(file2);
        
        ArrayList<Transaction> noMatch = new ArrayList<>();
        ArrayList<Transaction> noMatch2 = new ArrayList<>();
        
        String results = "";
        int matchingRecords = 0;
        int nonMatchingRecords = 0;
        
        boolean match;
         
        //Matching the contents of 
        for(int i = 0; i < file1Contents.size(); i++)
        {
            match = false;
            transaction1Obj = file1Contents.get(i);
            for(int x = 0; x < file2Contents.size(); x ++)
            {
               transaction2Obj = file2Contents.get(x);
                if(matchAmount(transaction1Obj.getTransactionAmt(), transaction2Obj.getTransactionAmt()) == true)
                {
                     if(matchTransactionId(transaction1Obj.getTransactionId(), transaction2Obj.getTransactionId()) == true)
                     {
                         if(matchReference(transaction1Obj.getTransactionRef(), transaction2Obj.getTransactionRef()) == true)
                         {
                            if(matchDate(transaction1Obj.getTransactionDate(), transaction2Obj.getTransactionDate()) == true)
                             {
                                  match = true;
                             }
                            
                         }
                     }
                }
                

            }
            if(match == true)
            {
                matchingRecords ++;
            }
            else
            {
                nonMatchingRecords ++;
                noMatch.add(transaction1Obj);
            }
        }
        
                  matchResults.setFileOneMatch(matchingRecords);
                  matchResults.setFileOneUnmatch(nonMatchingRecords);
                  matchResults.setFileOneRecords(file1Contents.size());
                  matchResults.setUnMatchingFiles1(noMatch);
                  
                  
                  matchingRecords = 0;
                  nonMatchingRecords = 0;
                  
        for(int i = 0; i < file2Contents.size(); i++)
        {
            match = false;
            transaction2Obj = file2Contents.get(i);
            for(int x = 0; x < file1Contents.size(); x ++)
            {
                transaction1Obj = file1Contents.get(x);
                if(matchAmount(transaction1Obj.getTransactionAmt(), transaction2Obj.getTransactionAmt()) == true)
                {
                     if(matchTransactionId(transaction1Obj.getTransactionId(), transaction2Obj.getTransactionId()) == true)
                     {
                         if(matchReference(transaction1Obj.getTransactionRef(), transaction2Obj.getTransactionRef()) == true)
                         {
                            if(matchDate(transaction1Obj.getTransactionDate(), transaction2Obj.getTransactionDate()) == true)
                             {
                                 if(matchTime(transaction1Obj.getTransactionDate(), transaction2Obj.getTransactionDate()).equalsIgnoreCase("Success"))
                                     {
                                        match = true;
                                     }
                                  
                             }
                            
                         }
                     }
                }
                

            }
            if(match == true)
            {
                matchingRecords ++;
                
                
                
            }
            else
            {
                nonMatchingRecords ++;
                noMatch2.add(transaction2Obj);
            }
        }

        
                  matchResults.setFileTwoMatch(matchingRecords);
                  matchResults.setFileTwoUnmatch(nonMatchingRecords);
                  matchResults.setFileTwoRecords(file2Contents.size());
                  matchResults.setUnMatchingFiles2(noMatch2);
        
        return matchResults;
    }
    
    private String matchTime(String date1, String date2)
    {
        String status = "Fail";
        String[] splitTime1 = extractTime(date1).split(":");
        String[] splitTime2 = extractTime(date2).split(":");
        
        
            int compareHours = splitTime1[0].compareTo(splitTime2[0]);
            int compareMinutes = splitTime1[1].compareTo(splitTime2[1]);
            
           
            
            int secDiff;
            
            int seconds1 = Integer.parseInt(splitTime1[2].substring(0, 1)+""+ splitTime1[2].substring(2, 1));
            int seconds2 = Integer.parseInt(splitTime2[2].substring(0, 1)+""+ splitTime2[2].substring(2, 1));
            
            if(compareHours != 0)
            {
                status = "Fail";
            }
            else if(compareMinutes != 0)
            {
                 status = "Fail";
            }
            else if(seconds1 == seconds2)
            {
                status = "Success";
            }
            else if(seconds1 > seconds2)
            {
                secDiff = seconds1 - seconds2;
                if(secDiff > 5 && secDiff < 10)
                {
                     status = "possible match";
                }
                else if(secDiff <= 5)
                {
                    status = "Success";
                }
            }
            else if(seconds2 > seconds1)
            {
                secDiff = seconds2 - seconds1;
                if(secDiff > 5 && secDiff < 10)
                {
                     status = "possible match:";
                }
                else if(secDiff <= 5)
                {
                    status = "Success";
                }
            }
        return status;
    }
    
    private boolean matchDate(String date1, String date2)
    {
        
        
        return date1.equalsIgnoreCase(date2);
        
    }
    
    private boolean matchAmount(double amount1, double amount2)
    {
        return amount1 == amount2;
    }
    
    private boolean matchReference(String referenceOne, String referenceTwo)
    {
        return !referenceOne.equalsIgnoreCase(referenceTwo);
    }
    
    private boolean matchTransactionId(long transIdOne, long transIdTwo )
    {
        return transIdOne == transIdTwo;
    }
    
    private String extractDate(String date)
    {
        String[] extractedDate = date.split(" ");
        return extractedDate[0];
    }
    
     private String extractTime(String date)
    {
        String[] time = date.split(" ");
        return time[1];
    }
    
    public Date convertDate(String stringDate)
    {
        Date date = new Date();
         DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
         try {
            date = (Date)formatter.parse(stringDate);
        } catch (ParseException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return date;
    }
    
}
