<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Search Title</title>
   <link type="text/css"
         rel="stylesheet"
         href="${pageContext.request.contextPath}/resources/css/style.css">
   <link type="text/css"
         rel="stylesheet"
         href="${pageContext.request.contextPath}/resources/css/add-book-style.css">
</head>
<body>
    <div id="wrapper">
       <div id="header">
           <h2>LM - Loan Manager</h2>
       </div>
    </div>
    <div id="container">
        <h3>Search Loans</h3>
        
        <form:form action="showLoan" modelAttribute="loan" method="POST">
        
          <table>
             <tbody>
                <tr>
                   <td><label>keywords</label></td>
                   <td><form:input path="date_out" /></td>	
                </tr>
                <tr>
                   <td><label></label></td>
                   <td><input type="submit" value="Search" class="save" /></td>
                </tr>
             </tbody>
          </table>
          <br>
          <br>
          <br>
          <br>
          
        </form:form>
        
    </div>
</body>
</html>