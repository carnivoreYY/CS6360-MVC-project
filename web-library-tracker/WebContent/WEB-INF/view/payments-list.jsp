<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
   <title>List Payments</title>
   
   <!-- reference our style sheet -->
   
   <link type="text/css" 
         rel="stylesheet" 
         href="${pageContext.request.contextPath}/resources/css/style.css" />
   
</head>

<body>

  <div id="wrapper">
    <div id="header">
      <h1>All payments</h1>
    </div>
  </div>
  
  <div id="container">
    <div id="content">
    
    <!-- add out html table here -->
    
    <table>
       <tr>
         <th>Card_id</th>
         <th>Amount</th>
       </tr>
       
       <!-- loop over and print our customer -->
       <c:forEach var="tempPayment" items="${payments}">
               
        <tr>
           <td> ${tempPayment.card_no}    </td>
           <td> ${tempPayment.amount}     </td>
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