<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Search Title</title>
   
   <style>
       .error {color:red}
   </style>
   
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
           <h2>BM - Borrower Manager</h2>
       </div>
    </div>
    <div id="container">
        <h3>Add Borrowers</h3>
        <form:form action="saveBorrower" modelAttribute="borrower" method="POST">
        
          <table>
             <tbody>
                <tr>
                   <td><label>SSN</label></td>
                   <td><form:input path="ssn" />
                       <form:errors path="ssn" cssClass="error" />
                   </td>	
                </tr>
                <tr>
                <td><label>Name</label></td>
                <td><form:input path="bname" />
                    <form:errors path="bname" cssClass="error" />
                </td>
                </tr>
                <tr>
                <td><label>address</label></td>
                <td><form:input path="address" />
                    <form:errors path="address" cssClass="error" />
                </td>
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