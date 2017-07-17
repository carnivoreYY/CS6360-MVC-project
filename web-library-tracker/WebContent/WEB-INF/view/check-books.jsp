<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
   <title>List Books</title>
   
   <!-- reference our style sheet -->
   
   <link type="text/css" 
         rel="stylesheet" 
         href="${pageContext.request.contextPath}/resources/css/style.css" />
   
</head>

<body>

  <div id="wrapper">
    <div id="header">
      <h1>Check Information</h1>
    </div>
  </div>
  
  <div id="container">
    <div id="content">
    
    <!-- add out html table here -->
    
    <table>
       <tr>
         <th>Loan_id</th>
         <th>ISBN</th>
         <th>Card_id</th>
         <th>Date_out</th>
         <th>Due_date</th>
         <th>Date_in</th>
       </tr>
       
       <!-- loop over and print our customer -->
       <c:forEach var="tempLoan" items="${loans}">
       
       <c:url var="deleteLink" value="/book/showFormForDelete">
           <c:param name="loanId" value="${tempLoan.loan_id}" />
       </c:url>
               
        <tr>
           <td> ${tempLoan.loan_id}    </td>
           <td> ${tempLoan.isbn}       </td>
           <td> ${tempLoan.card_id}    </td>
           <td> ${tempLoan.date_out}   </td>
           <td> ${tempLoan.due_date}   </td>
           <td> ${tempLoan.date_in}    </td>
           <td>
                <a href="${deleteLink}">CheckIn</a>
           </td>
        </tr>	
        
       </c:forEach>

         
    </table>
    
    </div>
  </div>
            <form class="form-inline">
	        <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/book/show'; return false" class="btn btn-primary">Go Back</button>
            </form>
</body>

</html>