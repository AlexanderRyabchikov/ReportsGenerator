package engine;


import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import java.io.File;
import java.util.List;

public class ReadData implements IReadData {

    public List<String[]> getMyEntries() {
        return myEntries;
    }

    @Override
    public boolean read(String fileName) {

        TsvParserSettings settings = new TsvParserSettings();
        TsvParser tsvParser = new TsvParser(settings);
        myEntries = tsvParser.parseAll(new File(fileName));
        return true;
    }

    private List<String[]> myEntries;
}
