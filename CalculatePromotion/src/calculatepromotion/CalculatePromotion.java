package calculatepromotion;

import java.text.ParseException;

/**
 *
 * @author Napat Jintanakosol
 */
public class CalculatePromotion {
    
    public static void main(String[] args) throws ParseException {
        // input file name of use
        String inputFileName = "promotion1.log";
        String outputFileName = "promotion1.json";
        // a line of text
        String line = null;
        
        fileReaderWriter reader = new fileReaderWriter(inputFileName, outputFileName, line);
        
    }
    
}
