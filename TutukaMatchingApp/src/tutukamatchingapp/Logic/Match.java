/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutukamatchingapp.Logic;

import java.util.ArrayList;
import tutukamatchingapp.models.Transaction;

/**
 *
 * @author Pale
 */
public class Match {
    //Results of the 1st file contents
    private static int fileOneRecords;
    private static int fileOneUnmatch;
    private static int fileOneMatch;
    private static ArrayList<Transaction> UnMatchingFiles1;
    
    //Results of the 2nd file contents
    private static int fileTwoRecords;
    private static int fileTwoUnmatch;
    private static int fileTwoMatch;
    private static ArrayList<Transaction> UnMatchingFiles2;
    
    

    public void setFileOneRecords(int fileOneRecords) {
        this.fileOneRecords = fileOneRecords;
    }

    public void setFileOneUnmatch(int fileOneUnmatch) {
        this.fileOneUnmatch = fileOneUnmatch;
    }

    public void setFileOneMatch(int fileOneMatch) {
        this.fileOneMatch = fileOneMatch;
    }

    public void setFileTwoRecords(int fileTwoRecords) {
        this.fileTwoRecords = fileTwoRecords;
    }

    public void setFileTwoUnmatch(int fileTwoUnmatch) {
        this.fileTwoUnmatch = fileTwoUnmatch;
    }

    public void setFileTwoMatch(int fileTwoMatch) {
        this.fileTwoMatch = fileTwoMatch;
    }

    public void setUnMatchingFiles1(ArrayList<Transaction> UnMatchingFiles1) {
        Match.UnMatchingFiles1 = UnMatchingFiles1;
    }

    public void setUnMatchingFiles2(ArrayList<Transaction> UnMatchingFiles2) {
        Match.UnMatchingFiles2 = UnMatchingFiles2;
    }
    
    

    public int getFileOneRecords() {
        return fileOneRecords;
    }

    public int getFileOneUnmatch() {
        return fileOneUnmatch;
    }

    public int getFileOneMatch() {
        return fileOneMatch;
    }

    public int getFileTwoRecords() {
        return fileTwoRecords;
    }

    public int getFileTwoUnmatch() {
        return fileTwoUnmatch;
    }

    public int getFileTwoMatch() {
        return fileTwoMatch;
    }

    public  ArrayList<Transaction> getUnMatchingFiles1() {
        return UnMatchingFiles1;
    }

    public  ArrayList<Transaction> getUnMatchingFiles2() {
        return UnMatchingFiles2;
    }
    
    
    
}
