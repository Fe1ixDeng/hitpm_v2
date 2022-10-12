package hitpm_v2.ICES_beans_variant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//使用方法见测试类
//测试数据见测试类
public class MineCircularRelationship {
  public String showVariant(String originProcess){
      CircularParser circularParser = new CircularParser();
      List<Activity> originList = circularParser.splitProcess(originProcess, "-->");  //分割字符串，生成originList
      List<Activity> markedList = circularParser.HandleCircular(originList);  //生成标记好的markedList
      String variant_String = circularParser.stringModel2String(markedList); //生成最终的流程变体字符串

      return variant_String;
  }
}
