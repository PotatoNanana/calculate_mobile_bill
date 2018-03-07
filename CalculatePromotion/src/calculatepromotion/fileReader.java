package calculatepromotion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Napat Jintanakosol
 */
class fileReaderWriter {
    public fileReaderWriter(String inputFileName , String outputFileName, String line) throws ParseException, IOException{
        
        String findSymbol = "|";
        String date = null,ST = null,ET = null;
        Date startTime;
        Date endTime;
        String phoneNo = null;
        String Promotion;
        double price;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        long totalMinute,totalSecond;
        FileWriter fileWriter = new FileWriter(outputFileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("[");
        try {
            
            FileInputStream fstream = new FileInputStream(inputFileName);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fstream))) {
                
                while ((line = bufferedReader.readLine()) != null) {
                        
                        // input value to parameter
                        date = line.substring(0,10);
                        ST = line.substring(11,19);
                        ET = line.substring(20,28);
                        phoneNo = line.substring(29,39);
                        Promotion = line.substring(40,42);
                        
                        //Calculate time
                        startTime = format.parse(ST);
                        endTime = format.parse(ET);
                        totalMinute = (endTime.getTime() - startTime.getTime())/(60 * 1000) % 60;
                        totalSecond = (endTime.getTime() - startTime.getTime())/1000 % 60;
                        
                        if(Promotion.equals("P1")){
                            if(totalMinute>=1){
                                price = 3.00 + (totalMinute-1.00) + (totalSecond / 100.00);
                            }

                            else if(totalSecond>0){
                                price = (totalSecond / 100.00);
                            }
                            else{
                                price = 0.00;
                            }
                        }
                        else{
                            price = 0.00;
                        }
                        printWriter.printf("{");
                        printWriter.printf("\"phone\" : \"%s\"", phoneNo);
                        printWriter.printf(",");
                        printWriter.printf("\"total\" : \"%.2f\"", price);
                        printWriter.printf("}");
                        if(phoneNo.equals("0833497075")){}
                        else
                            printWriter.printf(",\n");
                        

                }
                fstream.close();
            }
            
            printWriter.print("]");
            printWriter.close();
        }
        
        catch(FileNotFoundException ex) {
            System.out.println("Cannot find file : " + inputFileName + "");                
        }
        
        catch(IOException ex) {
            System.out.println("Cannot read file '" + inputFileName + "'");
        }
    }
}
