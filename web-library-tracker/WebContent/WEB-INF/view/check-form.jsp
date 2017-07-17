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
        <h3>Checking Books</h3>
        <form:form action="saveLoan" modelAttribute="loan" method="POST">
          
          <form:hidden path="isbn" />
          <form:hidden path="loan_id" />
          
          <table>
             <tbody>
                <tr>
                <td><label>Card_id</label></td>
                <td><form:input path="card_id" /></td>
                </tr>
                <tr>
                   <td><label></label></td>
                   <td><input type="submit" value="Save" class="save" /></td>
                </tr>
             </tbody>
          </table>
          
        </form:form>
    </div>
</body>
</html>