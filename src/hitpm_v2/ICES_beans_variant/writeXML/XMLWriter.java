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
//现在的问题：1命名空间（：怎么打印）可以解决https://blog.csdn.net/neweastsun/article/details/108144382之后再解决2反括号的问题3最后多了一个executable
public class XMLWriter {
    public void writeXmlFile(Definitions definitions) {
        ObjectMapper mapper = new XmlMapper().configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        try {
            File file = new File("/Users/silver-brick/Documents/ProcessMining/项目20220905/备份测试的项目/hitpm_v2/src/hitpm_v2/ICES_beans_variant/testWrite.xml");
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
