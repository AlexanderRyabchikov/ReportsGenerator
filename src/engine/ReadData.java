package engine;


import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadData implements IReadData {

    public List<String[]> getMyEntries() {
        return myEntries;
    }

    @Override
    public boolean read(String fileName) {

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        try {
            myEntries  = reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private List<String[]> myEntries;
}
