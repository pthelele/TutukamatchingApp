/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutukamatchingapp.models;

import tutukamatchingapp.Logic.Services;

/**
 *
 * @author Pale
 */
public class Transaction {
    
    //Class Attributes
    private String transactionName = "";
    private String transactionDate = "";
    private double transactionAmt = 0.0;
    private String transactionNarrative = "";
    private String transactionDescription = "";
    private long transactionId = 0;
    private String transactionType = "";
    private String transactionRef = "";
    private Services convertDate;
    
    public Transaction() {
    }
    
     public Transaction(String transactionName, String transactionDate, double transactionAmt, String transactionNarrative, String transactionDescription,long transactionId, String transactionType, String transactionRef) {
         
         this.transactionName = transactionName;
         this.transactionDate = transactionDate;
        /*try {
            this.transactionDate = (Date)formatter.parse(transactionDate);
            JOptionPane.showMessageDialog(null,  this.transactionDate);
        } catch (ParseException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        this.transactionAmt = transactionAmt;
        this.transactionNarrative = transactionNarrative;
        this.transactionDescription = transactionDescription;
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionRef = transactionRef;
        
    } 
     
     //Overloaded constructor for testing purposes
        public Transaction(String transactionName, String transactionDate, double transactionAmt, String transactionNarrative, String transactionDescription,long transactionId, String transactionType) {
         this.transactionName = transactionName;
        /*try {
            this.transactionDate = (Date)formatter.parse(transactionDate);
        } catch (ParseException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        this.transactionAmt = transactionAmt;
        this.transactionNarrative = transactionNarrative;
        this.transactionDescription = transactionDescription;
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        
        
    }
 

    public String getTransactionName() {
        return transactionName;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public double getTransactionAmt() {
        return transactionAmt;
    }

    public String getTransactionNarrative() {
        return transactionNarrative;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getTransactionRef() {
        return transactionRef;
    }
    
    
    
    
   
    
    
    
}
