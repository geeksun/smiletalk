<%@ page  pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>jquery get</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="../js/jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
	     $(function(){
	            $('.sumbit').click(function(){
	                  if($('#account').val().length==0){
	                     $('.hint').html("�û�������λ�գ�����").css({"color":"#ffoo11","background":"blue"});
	                  }
	                  else{
	                      $.get("../jqueryAjax","account="+$('#account').val(),
	                           function(data){
	                            $('.hint').html(data).css({"color":"#ffoo11","background":"green"});
	                      });
	                  }
	            });
	     });
	</script>

  </head>
  
  <body>
        <h3 align="center">jquery AjaX</h3>
        <hr>
        <label>�������û��� ��</label>
        <input id="account" name="account" type="text">
        <input class="sumbit" type="button" value="���">
        <div class="hint">
        </div>
  </body>
</html>
