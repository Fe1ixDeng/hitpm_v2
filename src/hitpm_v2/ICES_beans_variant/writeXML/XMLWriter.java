package hitpm_v2.ICES_beans_variant.writeXML;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import hitpm_v2.ICES_beans_variant.bpmnElement.Definitions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//���ڵ����⣺1�����ռ䣨����ô��ӡ�����Խ��https://blog.csdn.net/neweastsun/article/details/108144382֮���ٽ��2�����ŵ�����3������һ��executable
public class XMLWriter {
    public void writeXmlFile(Definitions definitions) {
        ObjectMapper mapper = new XmlMapper().configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        try {
            File file = new File("/Users/silver-brick/Documents/ProcessMining/��Ŀ20220905/���ݲ��Ե���Ŀ/hitpm_v2/src/hitpm_v2/ICES_beans_variant/testWrite.xml");
            if (!file.exists()) {file.createNewFile();}

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(definitions));
            bw.close();
        }
        catch (JsonProcessingException e) {e.printStackTrace();}
        catch (IOException e) {throw new RuntimeException(e);}
    }
}
