package hitpm_v2.ICES_beans_variant;

import hitpm_v2.ICES_beans_bpmn.converter.BpmnXMLConverter;
import hitpm_v2.ICES_beans_bpmn.model.BpmnModel;
import org.apache.commons.compress.utils.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import  java.nio.file.Paths;
import java.net.URL;
import java.text.ParseException;
import java.util.Arrays;

public class XMLtoJS {
    public static void main(String[] args) throws Exception{
        String str1 = "var Model1 = `";
        String str2 = "`";
        String str3="src/hitpm_v2/ICES_beans_variant/testWrite.xml";
        FileInputStream fs = new FileInputStream(new File("src/hitpm_v2/ICES_beans_variant/testWrite.xml"));
        byte[] b3 = IOUtils.toByteArray(fs);



        byte[] b1 = str1.getBytes("UTF8");
        byte[] b2 = str2.getBytes("UTF8");
        // byte[] b3 = bpmnXMLConverter.convertToXML(model);
        byte[] bytes = byteMergerAll(new byte[][] { b1, b3, b2 });
        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        if (classLoader == null)
            classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource("");
        String ROOT_CLASS_PATH = String.valueOf(url.getPath()) + "/";
        File rootFile = new File(ROOT_CLASS_PATH);
        String WEB_INFO_DIRECTORY_PATH = String.valueOf(rootFile.getParent()) + "/";
        File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);
        String SERVLET_CONTEXT_PATH = String.valueOf(webInfoDir.getParent()) + "/";
        File file = new File("out/artifacts/hitpm_v2_war_exploded/Model1.js");
        if (file.exists())
            file.delete();
        if (!file.getParentFile().exists()) {
            boolean mkdir = file.getParentFile().mkdirs();
            if (!mkdir)
                throw new RuntimeException();
        }
        file.createNewFile();
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeXML(String path) throws IOException, ParseException {

      //  BpmnXMLConverter bpmnXMLConverter = new BpmnXMLConverter();
        String str1 = "var Model1 = `";
        String str2 = "`";
        String str3="src/hitpm_v2/ICES_beans_variant/testWrite.xml";
        FileInputStream fs = new FileInputStream(new File("C:\\Users\\Lenovo\\IdeaProjects\\hitpm_v2\\src\\hitpm_v2\\ICES_beans_variant\\testWrite.xml"));
        byte[] b3 = IOUtils.toByteArray(fs);



        byte[] b1 = str1.getBytes("UTF8");
        byte[] b2 = str2.getBytes("UTF8");
       // byte[] b3 = bpmnXMLConverter.convertToXML(model);
        byte[] bytes = byteMergerAll(new byte[][] { b1, b3, b2 });
        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        if (classLoader == null)
            classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource("");
        String ROOT_CLASS_PATH = String.valueOf(url.getPath()) + "/";
        File rootFile = new File(ROOT_CLASS_PATH);
        String WEB_INFO_DIRECTORY_PATH = String.valueOf(rootFile.getParent()) + "/";
        File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);
        String SERVLET_CONTEXT_PATH = String.valueOf(webInfoDir.getParent()) + "/";
        File file = new File("out/artifacts/hitpm_v2_war_exploded/Model1.js");
        if (file.exists())
            file.delete();
        if (!file.getParentFile().exists()) {
            boolean mkdir = file.getParentFile().mkdirs();
            if (!mkdir)
                throw new RuntimeException();
        }
        file.createNewFile();
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    private static byte[] byteMergerAll(byte[]... values) {
        int length_byte = 0;
        for (int i = 0; i < values.length; i++)
            length_byte += (values[i]).length;
        byte[] all_byte = new byte[length_byte];
        int countLength = 0;
        for (int j = 0; j < values.length; j++) {
            byte[] b = values[j];
            System.arraycopy(b, 0, all_byte, countLength, b.length);
            countLength += b.length;
        }
        return all_byte;
    }


}
