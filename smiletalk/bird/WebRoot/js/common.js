	function lTrim(str) 
	{ 
	  if (str.charAt(0) == " ") 
	  { 
	    //����ִ���ߵ�һ���ַ�Ϊ�ո� 
	    str = str.slice(1);//���ո���ִ���ȥ�� 
	    //��һ��Ҳ�ɸĳ� str = str.substring(1, str.length); 
	    str = lTrim(str);    //�ݹ���� 
	  } 
	  return str; 
	} 
	//rTrim()ȥ���ִ��ұߵĿո� 
	function rTrim(str) 
	{ 
	  var iLength; 
	  iLength = str.length; 
	  if (str.charAt(iLength - 1) == " ") 
	  { 
	    //����ִ��ұߵ�һ���ַ�Ϊ�ո� 
	    str = str.slice(0, iLength - 1);//���ո���ִ���ȥ�� 
	    //��һ��Ҳ�ɸĳ� str = str.substring(0, iLength - 1); 
	    str = rTrim(str);    //�ݹ���� 
	  } 
	  return str; 
	} 
	//trim()ȥ���ִ����ߵĿո� 
	function trim(str) 
	{ 
	  return lTrim(rTrim(str)); 
	} 
	function showError(successid,id,msg)
	{
		$(successid).innerHTML="";
		$(id).innerHTML=msg;
		$(id).className="noteawoke";
	}
  	function doEnhance(id){
  		var elem = $(id);
		elem.className="notetrue";
  	}