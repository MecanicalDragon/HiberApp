<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>
            Success!
        </title>
        <meta name="viewpoint" content="width=device-width, initial-scale=1">
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        </head>
<body>
  <div class="container">
     <div class="jumbotron" style="margin-top: 20px;">
       <div class="text text-center text-success">
           <h2>${msg} has come successfully!</h2>
       </div>
         <c:if test="${msg.equals('Congratulations! Registration')}">
            <div class="text text-center text-primary">
                We sent email on your email-address. Please, confirm it by following the link within.
            </div>
             <div class="text text-center text-success">
                 <h3>
                     <a href=${mail}>To your mail service.</a>
                 </h3>
             </div>
         </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
         <div class="text text-center text-primary">
             But you hardly find something interesting here for a while :)
         </div>
        </c:if>
         <div  class="text-primary text-right">
             <a href="../login">Back to the authorisation</a>
         </div>
         <div class="row justify-content-start">
             <a href="../adm1" class="btn btn-info btn-sm col-2" type="button">1 admin page</a>

             <a href="../adm2" class="btn btn-info btn-sm col-2" type="button">2 admin page</a>
         </div>
         <div class="row justify-content-start">
             <a href="../usr1" class="btn btn-warning btn-sm col-2" type="button">1 users page</a>

             <a href="../usr2" class="btn btn-warning btn-sm col-2" type="button">2 users page</a>
         </div>
     </div>
     <div class="footer">
         <p><a href="../dbfs">&copy; DBFS 20!8</a></p>
     </div>
 </div>
</body>
</html>
