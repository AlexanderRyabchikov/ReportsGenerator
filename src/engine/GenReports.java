package engine;

import java.util.List;

public class GenReports {


    public GenReports(ParseXML xml, ReadData data, String file) {
        this.parseXML = xml;
        this.readData = data;
        this.outFile = file;
    }

    public boolean generationReports(){


        System.out.println(createTitle());
        createLine();
        return true;
    }

    private void createLine(){

        String strResult = "";
        int count = 0, i = 0;
        for (String[] lineString : getReadData().getMyEntries()){
            for (String str: lineString ) {

                if (str.length() < getParseXML().getWidthColoum()[i] + NUM_SPEC_SYMBOLS) {
                    strResult += createString(str, getParseXML().getWidthColoum()[i] + NUM_SPEC_SYMBOLS);
                }
                else{
                    String[] stringOpt = str.split(" ");
                    for (int key = 0; key < stringOpt.length; key++) {
                        if (key > 0){
                            String strResultAdd = "";
                            for (int q = 0, j = 0;
                                 q < getParseXML().getTitleColoum().length &&
                                         j < getParseXML().getWidthColoum().length; q++, j++){
                                if (j < 2){
                                    strResultAdd += createString (" ",
                                        getParseXML().getWidthColoum()[j] + NUM_SPEC_SYMBOLS);
                                }
                                else{
                                    strResultAdd += createString (stringOpt[key],
                                            getParseXML().getWidthColoum()[j] + NUM_SPEC_SYMBOLS);
                                }

                            }
                            strResultAdd += "|";
                            System.out.println(strResultAdd);
                        }else{
                            strResult += createString(stringOpt[key], getParseXML().getWidthColoum()[i] + NUM_SPEC_SYMBOLS);
                        }

                    }
                }
                i++;
                if (i >= getParseXML().getWidthColoum().length) {
                    i = 0;
                }
            }
            strResult += "|";
            System.out.println(strResult);
            count++;
            if (count == getParseXML().getPageHeigth() - 2){
                System.out.println("~");
                count = 0;
            }
            strResult = "";
        }
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
