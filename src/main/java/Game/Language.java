package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Language {
        int linesInCSV = 3;
        String[][] ImportedText = new String[linesInCSV][];
        public void loadFile(){
            try {
                File CSVFile = new File("src\\main\\GameTextInput.csv");
                Scanner Reader = new Scanner(CSVFile);
                String line;
                int i = 0;
                while(Reader.hasNextLine()) {
                    line = Reader.nextLine();
                    ImportedText[i] = line.split(";");
                    i++;
                }
                Reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        public String getText(int line, int row){
            return ImportedText[line][row];
        }
        public String[] getLine(int line){
            return ImportedText[line];
        }
    }