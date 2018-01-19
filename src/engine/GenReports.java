package engine;

public class GenReports {


    public GenReports(ParseXML xml, ReadData data, String file) {
        this.parseXML = xml;
        this.readData = data;
        this.outFile = file;
    }

    public boolean generationReports(){

        String title = null;
        for (int i = 0, j = 0;
             i < getParseXML().getTitleColoum().length &&
             j < getParseXML().getWidthColoum().length;
             i++, j++){

            title += createString (getParseXML().getTitleColoum()[i],
                                    getParseXML().getWidthColoum()[j]);
        }
        title += "|";
        System.out.println(title);
        return true;
    }

    private String createString(String nameTitle, int width) {

        String string = "| ";
        for (int i = string.length(), j = 0; i < width; i++, j++){
            if (nameTitle.length() < j){
                string += " ";
            }
            else{
                string += nameTitle.charAt(j);
            }

        }

        return string;

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
}
