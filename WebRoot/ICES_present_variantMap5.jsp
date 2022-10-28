<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%-- <jsp:useBean id="spvm" class="spvm.Graph2BPMN"/> --%>

<html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>BPMNJS</title>
    <jsp:useBean id="ICES_beans_variantMap5" class="hitpm_v2.ICES_beans_variant.XMLtoJS" scope="session"/>
    <jsp:useBean id="ICES_beans_variantXML5" class="hitpm_v2.ICES_beans_variant.translator.testWriteXML" scope="session"/>
    <jsp:useBean id="ICES_beans_variantSource5" class="hitpm_v2.ICES_beans_variant.ShowVariant_String" scope="session"/>
    <jsp:useBean id="ICES_beans_variant5" class="hitpm_v2.ICES_beans_variant.ShowVariant_String" scope="session"/>
    <jsp:useBean id="ICES_beans_trace5" class="hitpm_v2.ICES_beans_processLog.ICES_processLog_TraceStatistics" scope="session"/>

    <link rel="stylesheet" href="https://unpkg.com/bpmn-js@7.3.0/dist/assets/diagram-js.css" />
    <link rel="stylesheet" href="https://unpkg.com/bpmn-js@7.3.0/dist/assets/bpmn-font/css/bpmn.css" />
    <%-- <script url=<%=spvm.getURL()+"Str.js"%>></script> --%>
    <script src=".\Model1.js"></script>
    <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"62988",secure:"51521"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body>
<%
    ICES_beans_variantXML5.testWriteXML(ICES_beans_variantSource5.variantBack(out, ICES_beans_variant5.getLog(), ICES_beans_trace5.printTraceTable1(out,ICES_beans_trace5.getLog()), 5));
%>
<%
    ICES_beans_variantMap5.writeXML("out/artifacts/hitpm_v2_war_exploded/Model1.js");
%>
<div id="canvas" style="height:80vh;"></div>

<script src="https://unpkg.com/bpmn-js@7.3.0/dist/bpmn-modeler.development.js"></script>
<!-- <script src="./AutoLayout.js"></script> -->


<script>
    var bpmnModeler = new BpmnJS({
        container: '#canvas'

    });


    bpmnModeler.importXML(Model1, function(err) {

        if (!err) {

            // è®©å¾è½èªéåºå±å¹
            var canvas = bpmnJS.get('canvas')

            canvas.zoom('fit-viewport')


        }else{
            return console.error('failed to load diagram', err);
        }
    });



    /* var autoLayout = new AutoLayout(); */


</script>

</body>
</html>