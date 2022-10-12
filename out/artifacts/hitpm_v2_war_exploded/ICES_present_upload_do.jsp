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
<jsp:useBean id="ICES_beans_variant" class="hitpm_v2.ICES_beans_variant.ShowVarient_String" scope="session"/>


<html>
  <head><title>处理上传的事件日志</title><script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"62988",secure:"51521"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  <body>
	<hr>
    
	<%
    		// 新建一个SmartUpload对象,此项是必须的
    	    	    	    			SmartUpload myupload = new SmartUpload();		
    	    	    	    			// 初始化,此项是必须的
    	    	    	    			myupload.initialize(pageContext);		
    	    	    	    			// 设定允许上传的文件（通过扩展名限制）
    	    	    	    			 myupload.setAllowedFilesList("xml,xes");		 
    	    	    	    			// 设定禁止上传的文件（通过扩展名限制）
    	    	    	    			 myupload.setDeniedFilesList("exe,bat,jsp,htm,html,");
    	    	    	    			
    	    	    	    			try{			
    	    	    	    		// 上传文件,此项是必须的
    	    	    	    		myupload.upload();			
    	    	    	    		// 统计上传文件的总数
    	    	    	    		int count = myupload.getFiles().getCount();
    	    	    	    		// 取得Request对象
    	    	    	    		Request myRequest = myupload.getRequest();
    	    	    	    		String rndFilename,fileExtName,fileName,filePathName,memo;
    	    	    	    	/* 			Date dt = null; 
    	    	    	    		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");  */



    	    	    	    		// 逐一提取上传文件信息，同时可保存文件
    	    	    	    		for (int i=0;i<count;i++){
    	    	    	    			//　取得一个上传文件
    	    	    	    			com.jspsmart.upload.File file = myupload.getFiles().getFile(i);				
    	    	    	    			// 若文件不存在则继续
    	    	    	    			if (file.isMissing()) continue;
    	    	    	    			// 取得文件全名
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

    	    	    	    			
    	    	    	    			String fp = SERVLET_CONTEXT_PATH+"upload/Sample.xes";
											System.out.println(4);

											java.io.FileInputStream file1 = ICES_beans_parser.convert(fp);
											System.out.println(5);
    	    	    	    			/* java.io.FileInputStream file1 = myParse.convert("./Simple12_10.xes"); */
    	    	    	    			/* out.println("该文件是否可以以事件日志形式导入："+myParse.canParser(file1)); */
    	    	    	    			XLog log = ICES_beans_parser.getLog(file1);




    	    	    	    			XEventNameClassifier classifier = new XEventNameClassifier();
    	    	    	    			ICES_beans_log.setLog(1);
    	    	    	    			ICES_beans_log.setEventKind(ICES_beans_parser.getLogInfo(log).getNameClasses().size());//以事件名划分，若以分类器划分.getEventClasses()
    	    	    	    			ICES_beans_log.setEventNum(ICES_beans_parser.getLogInfo(log).getNumberOfEvents());
    	    	    	    			ICES_beans_log.setTraceNum(ICES_beans_parser.getLogInfo(log).getNumberOfTraces());
    	    	    	    			ICES_beans_log.setActor(ICES_beans_parser.getLogInfo(log).getResourceClasses().size());//获得发起者数量，只计算org:resourse
    	    	    	    			ICES_beans_log.setStartTime(((XTimeBoundsImpl) ICES_beans_parser.getLogInfo(log).getLogTimeBoundaries()).getStartDate());
    	    	    	    			ICES_beans_log.setEndTime(((XTimeBoundsImpl) ICES_beans_parser.getLogInfo(log).getLogTimeBoundaries()).getEndDate());

    	    	    	    			Map attr=log.get(0).get(0).getAttributes();

    	    	    	    			ICES_beans_trace.setLog(log);
    	    	    	    	    	ICES_beans_variant.setLog(log);


    	    	    	    			ICES_beans_aa.setAaHash(ICES_activityActor_AaMiner.spvmMiner(out, log));
    	    	    	    			ICES_beans_aav.setList(ICES_beans_aavMiner.pvMiner(log));
    	    	    		
    	    	    			ICES_beans_IM.setILog(log);
    	    	    	    		}


    	    	    	    			}catch(Exception ex){
											ex.printStackTrace();
    	    	    	    		out.println("上传文件超过了限制条件，上传失败!<br>");
    	    	    	    		out.println("错误原因：<br>"+ex.toString());
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
