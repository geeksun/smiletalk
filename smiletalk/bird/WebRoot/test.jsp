  <%@   page   contentType="text/html"%>
  //js向jsp赋值
  <form   method=post>  
  <input   type=hidden   name=x   value=''>  
  <script>  
  function   _change()  
  {  
      document.all.x.value="this   is   a   test";  
  }  
  _change();  
  </script>  
  <%  
  String x=request.getParameter("x");  
  System.out.println("the   value   from   javascript   is   :   "+x);  
  %>  
  <input   type=submit>  
  </form>