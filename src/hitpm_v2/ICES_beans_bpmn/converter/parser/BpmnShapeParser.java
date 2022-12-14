/*
 * Copyright 2010-2020 Alfresco Software, Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hitpm_v2.ICES_beans_bpmn.converter.parser;

import javax.xml.stream.XMLStreamReader;

import hitpm_v2.ICES_beans_bpmn.constants.BpmnXMLConstants;
import hitpm_v2.ICES_beans_bpmn.converter.util.BpmnXMLUtil;
import hitpm_v2.ICES_beans_bpmn.model.BaseElement;
import hitpm_v2.ICES_beans_bpmn.model.BpmnModel;
import hitpm_v2.ICES_beans_bpmn.model.GraphicInfo;

/**


 */
public class BpmnShapeParser implements BpmnXMLConstants {

  public void parse(XMLStreamReader xtr, BpmnModel model) throws Exception {

    String id = xtr.getAttributeValue(null, ATTRIBUTE_DI_BPMNELEMENT);
    GraphicInfo graphicInfo = new GraphicInfo();

    String strIsExpanded = xtr.getAttributeValue(null, ATTRIBUTE_DI_IS_EXPANDED);
    if ("true".equalsIgnoreCase(strIsExpanded)) {
      graphicInfo.setExpanded(true);
    }

    BpmnXMLUtil.addXMLLocation(graphicInfo, xtr);
    while (xtr.hasNext()) {
      xtr.next();
      if (xtr.isStartElement() && ELEMENT_DI_BOUNDS.equalsIgnoreCase(xtr.getLocalName())) {
        graphicInfo.setX(Double.valueOf(xtr.getAttributeValue(null, ATTRIBUTE_DI_X)));
        graphicInfo.setY(Double.valueOf(xtr.getAttributeValue(null, ATTRIBUTE_DI_Y)));
        graphicInfo.setWidth(Double.valueOf(xtr.getAttributeValue(null, ATTRIBUTE_DI_WIDTH)));
        graphicInfo.setHeight(Double.valueOf(xtr.getAttributeValue(null, ATTRIBUTE_DI_HEIGHT)));

        model.addGraphicInfo(id, graphicInfo);
        break;
      } else if (xtr.isEndElement() && ELEMENT_DI_SHAPE.equalsIgnoreCase(xtr.getLocalName())) {
        break;
      }
    }
  }

  public BaseElement parseElement() {
    return null;
  }
}
