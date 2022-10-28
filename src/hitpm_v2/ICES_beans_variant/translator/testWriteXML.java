package hitpm_v2.ICES_beans_variant.translator;

import hitpm_v2.ICES_beans_variant.writeXML.XMLWriter;

public class testWriteXML {
    public static void main(String[] args) {
        XMLWriter writer = new XMLWriter();
        DoTranslate doTranslate = new DoTranslate();
        writer.writeXmlFile(doTranslate.translate("Apply Repair-->User Identification-->Intelligent Response-->Manual Interaction-->Release Order-->Order Assignment-->[Repair-->Test Repair-->(Restart Repair)]*3-->Success-->Service Evaluation-->Archive"));
    }
    public void testWriteXML(String originalProcess){
        XMLWriter writer = new XMLWriter();
        DoTranslate doTranslate = new DoTranslate();
        writer.writeXmlFile(doTranslate.translate(originalProcess));
    }
}
