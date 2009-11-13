	function lTrim(str) 
	{ 
	  if (str.charAt(0) == " ") 
	  { 
	    //如果字串左边第一个字符为空格 
	    str = str.slice(1);//将空格从字串中去掉 
	    //这一句也可改成 str = str.substring(1, str.length); 
	    str = lTrim(str);    //递归调用 
	  } 
	  return str; 
	} 
	//rTrim()去掉字串右边的空格 
	function rTrim(str) 
	{ 
	  var iLength; 
	  iLength = str.length; 
	  if (str.charAt(iLength - 1) == " ") 
	  { 
	    //如果字串右边第一个字符为空格 
	    str = str.slice(0, iLength - 1);//将空格从字串中去掉 
	    //这一句也可改成 str = str.substring(0, iLength - 1); 
	    str = rTrim(str);    //递归调用 
	  } 
	  return str; 
	} 
	//trim()去掉字串两边的空格 
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