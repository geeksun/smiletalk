<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<!-- ���뵭������ʽ -->
		<style  type="text/css">
			<!-- 
			.trans_msg
			    {
			    filter:alpha(opacity=100,enabled=1) revealTrans(duration=.2,transition=1) blendtrans(duration=.2);
			    }
			-->
		</style>
	<script type="text/javascript">
		//--��ʼ������--
		var rT=true;//����ͼ�����
		var bT=true;//����ͼ���뵭��
		
		var endaction=false;//��������
		
		var ns4 = document.layers;
		var ns6 = document.getElementById && !document.all;
		var ie4 = document.all;
		
		var toolTipSTYLE="";
		function initToolTips()
		{
		  if(ns4||ns6||ie4)
		  {
		    if(ns4) toolTipSTYLE = document.toolTipLayer;
		    else if(ns6) toolTipSTYLE = document.getElementById("toolTipLayer").style;
		    else if(ie4) toolTipSTYLE = document.all.toolTipLayer.style;
		    if(ns4) document.captureEvents(Event.MOUSEMOVE);
		    else
		    {
		      toolTipSTYLE.visibility = "visible";
		      toolTipSTYLE.display = "none";
		    }
		  }
		}
		function toolTip(name)
		{
		  if(toolTip.arguments.length < 1) // hide
		  {
		  	
		    if(ns4) 
		    {
		    toolTipSTYLE.visibility = "hidden";
			document.form1.error.value="0";
		    }
		    else 
		    {
		      
		      //--ͼ����ɣ���������--
		      if (!endaction) {toolTipSTYLE.display = "none";}
		      if (rT) document.all("msg1").filters[1].Apply();
		      if (bT) document.all("msg1").filters[2].Apply();
		      document.all("msg1").filters[0].opacity=0;
		      if (rT) document.all("msg1").filters[1].Play();
		      if (bT) document.all("msg1").filters[2].Play();
		      if (rT){ 
		      if (document.all("msg1").filters[1].status==1 || document.all("msg1").filters[1].status==0){  
		      toolTipSTYLE.display = "none";}
		      }
		      if (bT){
		      if (document.all("msg1").filters[2].status==1 || document.all("msg1").filters[2].status==0){  
		      toolTipSTYLE.display = "none";}
		      }
		      if (!rT && !bT) toolTipSTYLE.display = "none";
		      //----------------------
		    }
		  }
		  else // show
		  {
			var tw=120;//��ʾ����
			var x=document.all[name].offsetLeft;
		    var y=document.all[name].offsetTop;
		    //alert(x + "    " + y);
			offsetX = 110;
		    offsetY = 55;
			
			if(name=="tdname1"){
		      offsetX=10;
			  offsetY=-10;
			}
			if(name=="tdname2"){
		      offsetX=10;
			  offsetY=-10;
			}
			if(name=="tdname3"){
		      offsetX=10;
			  offsetY=-10;
			}
		
			var msg=getMessage(name);
		    var fg = "#777777";//getFontColor();
		    var bg = "#eeeeee";//getBgColor();
		    var content =
		    '<table id="msg1" name="msg1" border="0" cellspacing="0" cellpadding="1" bgcolor="' + fg + '" class="trans_msg"><td>' +
		    '<table border="0" cellspacing="0" cellpadding="3" bgcolor="' + bg + 
		    '"><td width=' + tw + '><font face="Arial" color="' + fg +
		    '" size="-2">' + msg +
		    '&nbsp;\;</font></td></table></td></table>';
			
		    if(ns4)
		    {
		      toolTipSTYLE.document.write(content);
		      toolTipSTYLE.document.close();
		      toolTipSTYLE.visibility = "visible";
			
		      toolTipSTYLE.left = x + offsetX;
		      toolTipSTYLE.top = y + offsetY;
		    }
		    if(ns6)
		    {
		      document.getElementById("toolTipLayer").innerHTML = content;
		      toolTipSTYLE.display='block'
			 
		      toolTipSTYLE.left = x + offsetX;
		      toolTipSTYLE.top = y + offsetY;
		    }
		    if(ie4)
		    {
		      document.all("toolTipLayer").innerHTML=content;
		      toolTipSTYLE.display='block';
			 
		      toolTipSTYLE.left = x + offsetX;
		      toolTipSTYLE.top = y + offsetY;
		      //--ͼ����ɣ����봦��--
		      var cssopaction=document.all("msg1").filters[0].opacity;
		      document.all("msg1").filters[0].opacity=0
		      if (rT) document.all("msg1").filters[1].Apply();
		      if (bT) document.all("msg1").filters[2].Apply();
		      document.all("msg1").filters[0].opacity=cssopaction;
		      if (rT) document.all("msg1").filters[1].Play();
		      if (bT) document.all("msg1").filters[2].Play();
		      //----------------------
		    }
		  }
		}
		function getMessage(tdname){
			var msg="";
			if(tdname=="tdname1" || tdname=="tdname2" || tdname=="tdname3")
				msg="����д�û���";
			return msg;
		}
	
		function sub(obj) {
			var my_tab = document.all("budgetTbl");
			//alert(my_tab.rows.length);
			if(my_tab.rows.length == 3) {
				alert("���ٱ���һ��");
			} else {
				deleteRow(budgetTbl,obj.parentElement.parentElement.rowIndex);
			}
		}
		function checkrow() {
		 	insertRow(budgetTbl,budgetModel,-1);
		}
		//��ָ�����ģ��������ݲ���һ��
		//opTbl:Ҫ�����еı�����
		//modelTbl:ģ����
		//index:Ҫ�����λ�ã�-1��ʾ��ӵ����λ��
		function insertRow(opTbl,modelTbl,index)
		{
			var rowObj;
			var rowAlign;
			var cellHtml;
			var cellClass;
			var cellAlign;
			var cellNoWarp;
			var cellObj;
			var cellColspan;
			for(var i=0;modelTbl!=null && i<modelTbl.rows.length;i++)
			{
				if(index!=null && index>=0)
				{
					rowObj=opTbl.insertRow(index);
					
				}else
				{
					rowObj=opTbl.insertRow();
				}
				rowObj.className=modelTbl.rows[i].className;
				rowObj.align=modelTbl.rows[i].align;
				for(var j=0;modelTbl.rows[i].cells!=null && j<modelTbl.rows[i].cells.length;j++)
				{			
					cellHtml=modelTbl.rows[i].cells[j].innerHTML;
					cellClass=modelTbl.rows[i].cells[j].className;
					cellAlign=modelTbl.rows[i].cells[j].align;
					cellNoWarp=modelTbl.rows[i].cells[j].noWarp;
					//��һ��colspan���缸��
					cellColspan=modelTbl.rows[i].cells[j].colSpan;
					//alert(cellAlign);
					//alert(cellColspan);
					
					cellObj=rowObj.insertCell();
					cellObj.align=cellAlign;
					cellObj.className=cellClass;
					cellObj.noWarp=cellNoWarp;
					cellObj.innerHTML=cellHtml;
					cellObj.colSpan = cellColspan;
				}		
			}
		}
		//ɾ��ָ������һ��
		//opTbl:Ҫ�����ı�����
		//index:Ҫɾ������λ��,-1��ʾɾ���һ��
		function deleteRow(opTbl,index)
		{
			if(opTbl==null)return;
			if(index==-1)
			{
				if(opTbl.rows.length>1){opTbl.deleteRow(opTbl.rows.length-1);}
			}
			else
			{
				opTbl.deleteRow(index);
			}
		}
	</script>
  </head>
  
  <body>
  	<!-- ��ʼ������ -->
  	<div id="toolTipLayer" style="position:absolute; visibility: hidden"></div>
  	<p>
	  <script>initToolTips()</script>
	</p>
    <form action="" method="post" name="form1">
    	<table id="budgetTbl" border="1">
    		<tr>
    			<td><input type="button" name="btn" value="����һ��" onclick="checkrow()"></td>
    		</tr>
    		<tr align="center">
    			<td>����</td>
    			<td id="tdname1" colspan="2">����1</td>
    			<td id="tdname2">����2</td>
    			<td id="tdname3">����3</td>
    		</tr>
    		<tr align="center">
    			<td><input type="button" name="btn" value="ɾ��" onclick="sub(this)"></td>
    			<td colspan="2"><input type="text" name="name1" onfocus="toolTip('tdname1')" onblur="toolTip()"></td>
    			<td><input type="text" name="name2" onfocus="toolTip('tdname2')" onblur="toolTip()"></td>
    			<td><input type="text" name="name3" onfocus="toolTip('tdname3')" onblur="toolTip()"></td>
    		</tr>
    	</table>
    </form>
    <!-- ģ���� -->
    <table style="position:absolute; display: none" id="budgetModel">
    	<tr align="center">
    		<td><input type="button" name="btn" value="ɾ��" onclick="sub(this)"></td>
    		<td colspan="2"><input type="text" name="name1" onfocus="toolTip('tdname1')" onblur="toolTip()"></td>
   			<td><input type="text" name="name2" onfocus="toolTip('tdname2')" onblur="toolTip()"></td>
   			<td><input type="text" name="name3" onfocus="toolTip('tdname3')" onblur="toolTip()"></td>
    	</tr>
    </table>
  </body>
</html>

