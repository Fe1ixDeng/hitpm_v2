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
import hitpm_v2.ICES_beans_bpmn.model.FlowElement;
import hitpm_v2.ICES_beans_bpmn.model.Resource;
import hitpm_v2.ICES_beans_bpmn.model.UserTask;

/**

 */
public class ResourceParser implements BpmnXMLConstants {

  public void parse(XMLStreamReader xtr, BpmnModel model) throws Exception {
    String resourceId = xtr.getAttributeValue(null, ATTRIBUTE_ID);
    String resourceName = xtr.getAttributeValue(null, ATTRIBUTE_NAME);

    Resource resource;
    if (model.containsResourceId(resourceId)) {
      resource = model.getResource(resourceId);
      resource.setName(resourceName);
      for (hitpm_v2.ICES_beans_bpmn.model.Process process : model.getProcesses()) {
        for (FlowElement fe : process.getFlowElements()) {
          if (fe instanceof UserTask
              && ((UserTask) fe).getCandidateGroups().contains(resourceId)) {
            ((UserTask) fe).getCandidateGroups().remove(resourceId);
            ((UserTask) fe).getCandidateGroups().add(resourceName);
          }
        }
      }
    } else {
      resource = new Resource(resourceId, resourceName);
      model.addResource(resource);
    }

    BpmnXMLUtil.addXMLLocation(resource, xtr);
  }
}
