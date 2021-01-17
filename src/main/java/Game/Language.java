package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Louis
 */
public class Language {
        private int linesInCSV = 58;
        private String[][] importedText = new String[linesInCSV][];
        public void loadFile(){
            try {
                File CSVFile = new File("GameTextInput.csv");
                Scanner Reader = new Scanner(CSVFile,"UTF-8");
                String line;
                int i = 0;
                while(Reader.hasNextLine()) {
                    line = Reader.nextLine();
                    importedText[i] = line.split(",");
                    i++;
                }
                Reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        public String getText(int line, int column){
            return importedText[line-1][column-1];
        }
        public String[] getLine(int column){
            return importedText[column-1];
        }
    }
