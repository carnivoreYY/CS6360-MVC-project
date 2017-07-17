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
           <h2>BM - Book Manager</h2>
       </div>
    </div>
    <div id="container">
        <h3>Search Books</h3>
        <form:form action="saveBook" modelAttribute="book" method="POST">
        
          <table>
             <tbody>
                <tr>
                   <td><label>keywords</label></td>
                   <td><form:input path="title" /></td>	
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
        </form:form>
        
        <input type="button"  value="Add Borrower" 
                              onclick="window.location.href='add'; return false;"
                              class="add-button" />
        
        <input type="button" value="Update Fines" 
			                 onclick="window.location.href='searchLoan'; return false"
			                 class="add-button" />
			                 
	    <input type="button" value="Show Payments" 
			                 onclick="window.location.href='showPayments'; return false"
			                 class="add-button" />  
          
    </div>
</body>
</html>