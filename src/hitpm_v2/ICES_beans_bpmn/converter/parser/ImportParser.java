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
import hitpm_v2.ICES_beans_bpmn.model.BpmnModel;
import hitpm_v2.ICES_beans_bpmn.model.Import;

/**

 */
public class ImportParser implements BpmnXMLConstants {

  public void parse(XMLStreamReader xtr, BpmnModel model) throws Exception {
    Import importObject = new Import();
    BpmnXMLUtil.addXMLLocation(importObject, xtr);
    importObject.setImportType(xtr.getAttributeValue(null, ATTRIBUTE_IMPORT_TYPE));
    importObject.setNamespace(xtr.getAttributeValue(null, ATTRIBUTE_NAMESPACE));
    importObject.setLocation(xtr.getAttributeValue(null, ATTRIBUTE_LOCATION));
    model.getImports().add(importObject);
  }
}
