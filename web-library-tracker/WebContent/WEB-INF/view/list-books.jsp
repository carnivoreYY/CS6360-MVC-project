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
      <h2>BM - Book Manager</h2>
    </div>
  </div>
  
  <div id="container">
    <div id="content">
    
    <!-- add out html table here -->
    
    <table>
       <tr>
         <th>ISBN</th>
         <th>Title</th>
         <th>Authors</th>
         <th>Status</th>
       </tr>
       
       <!-- loop over and print our customer -->
       <c:forEach var="tempBook" items="${books}">
               
       <c:url var="addLink" value="/book/showFormForAdd">
           <c:param name="bookId" value="${tempBook.isbn}" />
       </c:url>
        <tr>
           <td> ${tempBook.isbn}    </td>
           <td> ${tempBook.title}   </td>
           <td> ${tempBook.name}    </td>
           <td>
                <a href="${addLink}">CheckOut</a>
           </td>
        </tr>	
        
       </c:forEach>
      
    </table>
    
    </div>
  </div>
   
</body>

</html>