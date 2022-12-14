<%@page import="hitpm_v2.ICES_beans_activityActor.ICES_activityActor_AaMiner"%>
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="com.jspsmart.upload.*"%>
<%@ page import="org.deckfour.xes.model.XLog"%>
<%@ page import="org.deckfour.xes.classification.XEventNameClassifier"%>
<%@ page import="org.deckfour.xes.classification.XEventClasses"%>
<%@ page import="org.deckfour.xes.classification.XEventClass"%>
<%@ page import="org.processmining.plugins.InductiveMiner.efficienttree.EfficientTree"%>
<%@ page import="org.processmining.plugins.inductiveminer2.plugins.InductiveMinerDialog" %>>
<%@ page import="org.processmining.plugins.inductiveminer2.logs.IMLog"%>
<%@ page import="org.processmining.plugins.inductiveminer2.logs.IMLogImpl"%>
<%@ page import="org.processmining.plugins.inductiveminer2.mining.MiningParameters"%>
<%@ page import="org.processmining.framework.packages.PackageManager.Canceller"%>
<%@ page import="org.deckfour.xes.model.impl.XAttributeTimestampImpl"%>
<%@ page import="java.io.File"%>
<%@ page import="org.deckfour.xes.info.impl.XTimeBoundsImpl"%>



<jsp:useBean id="ICES_beans_parser" class="hitpm_v2.ICES_beans_xml.ICES_xml_parser"/>

<jsp:useBean id="ICES_beans_log" class="hitpm_v2.ICES_beans_processLog.ICES_processLog_logInfo" scope="session"/>
<jsp:useBean id="ICES_beans_aa" class="hitpm_v2.ICES_beans_activityActor.ICES_activityActor_Aabean" scope="session"/>
<jsp:useBean id="ICES_beans_aav" class="hitpm_v2.ICES_beans_activityActorValue.ICES_activityActorValue_Aavbean" scope="session"/>
<jsp:useBean id="ICES_beans_aavMiner" class="hitpm_v2.ICES_beans_activityActorValue.ICES_activityActorValue_AavMiner"/>
<jsp:useBean id="ICES_beans_IM" class="hitpm_v2.ICES_beans_xes2bpmn.MyIMBean"/>
<jsp:useBean id="ICES_beans_trace" class="hitpm_v2.ICES_beans_processLog.ICES_processLog_TraceStatistics" scope="session"/>
<jsp:useBean id="ICES_beans_variant" class="hitpm_v2.ICES_beans_variant.ShowVariant_String" scope="session"/>
<jsp:useBean id="ICES_beans_variant1" class="hitpm_v2.ICES_beans_variant.ShowVariant_String" scope="session"/>
<jsp:useBean id="ICES_beans_trace1" class="hitpm_v2.ICES_beans_processLog.ICES_processLog_TraceStatistics" scope="session"/>
<jsp:useBean id="ICES_beans_variant2" class="hitpm_v2.ICES_beans_variant.ShowVariant_String" scope="session"/>
<jsp:useBean id="ICES_beans_trace2" class="hitpm_v2.ICES_beans_processLog.ICES_processLog_TraceStatistics" scope="session"/>
<jsp:useBean id="ICES_beans_variant3" class="hitpm_v2.ICES_beans_variant.ShowVariant_String" scope="session"/>
<jsp:useBean id="ICES_beans_trace3" class="hitpm_v2.ICES_beans_processLog.ICES_processLog_TraceStatistics" scope="session"/>
<jsp:useBean id="ICES_beans_variant4" class="hitpm_v2.ICES_beans_variant.ShowVariant_String" scope="session"/>
<jsp:useBean id="ICES_beans_trace4" class="hitpm_v2.ICES_beans_processLog.ICES_processLog_TraceStatistics" scope="session"/>
<jsp:useBean id="ICES_beans_variant5" class="hitpm_v2.ICES_beans_variant.ShowVariant_String" scope="session"/>
<jsp:useBean id="ICES_beans_trace5" class="hitpm_v2.ICES_beans_processLog.ICES_processLog_TraceStatistics" scope="session"/>

<html>
  <head><title>??????????????????</title><script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"62988",secure:"51521"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  <body>
	<hr>
    
	<%
    		// ????????SmartUpload????,????????????
    	    	    	    			SmartUpload myupload = new SmartUpload();		
    	    	    	    			// ??????,????????????
    	    	    	    			myupload.initialize(pageContext);		
    	    	    	    			// ????????????????????????????????????
    	    	    	    			 myupload.setAllowedFilesList("xml,xes");		 
    	    	    	    			// ????????????????????????????????????
    	    	    	    			 myupload.setDeniedFilesList("exe,bat,jsp,htm,html,");
    	    	    	    			
    	    	    	    			try{			
    	    	    	    		// ????????,????????????
    	    	    	    		myupload.upload();			
    	    	    	    		// ??????????????????
    	    	    	    		int count = myupload.getFiles().getCount();
    	    	    	    		// ????Request????
    	    	    	    		Request myRequest = myupload.getRequest();
    	    	    	    		String rndFilename,fileExtName,fileName,filePathName,memo;
    	    	    	    	/* 			Date dt = null; 
    	    	    	    		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");  */



    	    	    	    		// ????????????????????????????????????
    	    	    	    		for (int i=0;i<count;i++){
    	    	    	    			//??????????????????
    	    	    	    			com.jspsmart.upload.File file = myupload.getFiles().getFile(i);				
    	    	    	    			// ??????????????????
    	    	    	    			if (file.isMissing()) continue;
    	    	    	    			// ????????????
    	    	    	    			filePathName = file.getFilePathName();
    	    	    	    			fileExtName = file.getFileExt();
    	    	    	    			
    	    	    	    			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();  
    	    	    	       			if (classLoader == null) {  
    	    	    	           			classLoader = ClassLoader.getSystemClassLoader();  
    	    	    	       			}
    	    	    	       			java.net.URL url = classLoader.getResource("");
										   System.out.println(url + "1");
    	    	    	      			String ROOT_CLASS_PATH = url.getPath() + "/";
											System.out.println(ROOT_CLASS_PATH + "2");
    	    	    	       			File rootFile = new File(ROOT_CLASS_PATH);
											System.out.println(rootFile + "3");
    	    	    	       			String WEB_INFO_DIRECTORY_PATH = rootFile.getParent() + "/";
											System.out.println(WEB_INFO_DIRECTORY_PATH + "4");
    	    	    	       			File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);
										   	System.out.println(webInfoDir + "5");
    	    	    	       			String SERVLET_CONTEXT_PATH = webInfoDir.getParent() + "/"; 
    	    	    	       				System.out.println(SERVLET_CONTEXT_PATH + "6");

    	    	    	    			String name="Sample"+"."+fileExtName;
											System.out.println("/upload/" + name);
										file.saveAs("/upload/" + name, myupload.SAVE_VIRTUAL);
											System.out.println(2);
    	    	    	    			filePathName="/upload/"+name;
											System.out.println(3);

    	    	    	    			
    	    	    	    			String fp = SERVLET_CONTEXT_PATH+"upload/Sample.xes";	//win or eclipse????\\???????
											System.out.println(4);

											java.io.FileInputStream file1 = ICES_beans_parser.convert(fp);
											System.out.println(5);
    	    	    	    			/* java.io.FileInputStream file1 = myParse.convert("./Simple12_10.xes"); */
    	    	    	    			/* out.println("??????????????????????????????????"+myParse.canParser(file1)); */
    	    	    	    			XLog log = ICES_beans_parser.getLog(file1);




    	    	    	    			XEventNameClassifier classifier = new XEventNameClassifier();
    	    	    	    			ICES_beans_log.setLog(1);
    	    	    	    			ICES_beans_log.setEventKind(ICES_beans_parser.getLogInfo(log).getNameClasses().size());//????????????????????????????.getEventClasses()
    	    	    	    			ICES_beans_log.setEventNum(ICES_beans_parser.getLogInfo(log).getNumberOfEvents());
    	    	    	    			ICES_beans_log.setTraceNum(ICES_beans_parser.getLogInfo(log).getNumberOfTraces());
    	    	    	    			ICES_beans_log.setActor(ICES_beans_parser.getLogInfo(log).getResourceClasses().size());//??????????????????????org:resourse
    	    	    	    			ICES_beans_log.setStartTime(((XTimeBoundsImpl) ICES_beans_parser.getLogInfo(log).getLogTimeBoundaries()).getStartDate());
    	    	    	    			ICES_beans_log.setEndTime(((XTimeBoundsImpl) ICES_beans_parser.getLogInfo(log).getLogTimeBoundaries()).getEndDate());

    	    	    	    			Map attr=log.get(0).get(0).getAttributes();

    	    	    	    			ICES_beans_trace.setLog(log);
    	    	    	    	    	ICES_beans_variant.setLog(log);
										ICES_beans_trace1.setLog(log);
										ICES_beans_variant1.setLog(log);
										ICES_beans_trace2.setLog(log);
										ICES_beans_variant2.setLog(log);
										ICES_beans_trace3.setLog(log);
										ICES_beans_variant3.setLog(log);
										ICES_beans_trace4.setLog(log);
										ICES_beans_variant4.setLog(log);
										ICES_beans_trace5.setLog(log);
										ICES_beans_variant5.setLog(log);


    	    	    	    			ICES_beans_aa.setAaHash(ICES_activityActor_AaMiner.spvmMiner(out, log));
    	    	    	    			ICES_beans_aav.setList(ICES_beans_aavMiner.pvMiner(log));
    	    	    		
    	    	    			ICES_beans_IM.setILog(log);
    	    	    	    		}


    	    	    	    			}catch(Exception ex){
											ex.printStackTrace();
    	    	    	    		out.println("Upload file exceeds the limit, upload failed!<br>");
    	    	    	    		out.println("error reason:<br>"+ex.toString());
    	    	    	    			}
    	%>
    	
    	<%
    	if(true)
    	{
    		response.sendRedirect("ICES_present_top.html");
    	}
    	%>
  </body> 
</html>
