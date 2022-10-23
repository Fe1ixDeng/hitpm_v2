public class testWriteXML {
    public static void main(String[] args) {
        XMLWriter writer = new XMLWriter();
        DoTranslate doTranslate = new DoTranslate();
        writer.writeXmlFile(doTranslate.translate());
    }
    public void testWriteXML(){
        XMLWriter writer = new XMLWriter();
        DoTranslate doTranslate = new DoTranslate();
        writer.writeXmlFile(doTranslate.translate());
    }
}
