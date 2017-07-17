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
      <h1>Added Successfully</h1>
    </div>
  </div>
  
  <div id="container">
    <div id="content">
    
    <!-- add out html table here -->
    
    <table>
       <tr>
         <th>Card_id</th>
         <th>All name</th>
         <th>SSN</th>
         <th>address</th>
         <th>phone</th>
       </tr>
       
       <!-- loop over and print our customer -->
       <c:forEach var="tempBorrower" items="${borrowers}">
               
        <tr>
           <td> ${tempBorrower.card_id}    </td>
           <td> ${tempBorrower.bname}      </td>
           <td> ${tempBorrower.ssn}        </td>
           <td> ${tempBorrower.address}    </td>
           <td> ${tempBorrower.phone}      </td>
        </tr>	
        
       </c:forEach>

         
    </table>
      	    <form class="form-inline">
	        <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/book/show'; return false" class="btn btn-primary">Go Back</button>
	        </form>  
    </div>
  </div>
   
</body>

</html>