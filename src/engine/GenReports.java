package engine;

public class GenReports {


    public GenReports(ParseXML xml, ReadData data, String file) {
        this.parseXML = xml;
        this.readData = data;
        this.outFile = file;
    }

    public boolean generationReports(){


        System.out.println(createTitle());
        return true;
    }

    private String createString(String nameTitle, int width) {

        String string = "| ";
        for (int i = string.length() - 1, j = 0; i < width; i++, j++){
            if (nameTitle.length() <= j){
                string += " ";
            }
            else{
                string += nameTitle.charAt(j);
            }

        }
        return string;

    }

    private String createTitle(){
        String title = "";
        for (int i = 0, j = 0;
             i < getParseXML().getTitleColoum().length &&
                     j < getParseXML().getWidthColoum().length;
             i++, j++){

            title += createString (getParseXML().getTitleColoum()[i],
                    getParseXML().getWidthColoum()[j] + NUM_SPEC_SYMBOLS);
        }
        title += "|";
        return title;
    }

    public ParseXML getParseXML() {
        return parseXML;
    }

    public ReadData getReadData() {
        return readData;
    }

    public String getOutFile() {
        return outFile;
    }

    private ParseXML parseXML;
    private ReadData readData;
    private String outFile;
    public static final int NUM_SPEC_SYMBOLS = 2;
}
