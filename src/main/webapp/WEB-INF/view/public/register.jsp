<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>
            Registration
        </title>
        <meta name="viewpoint" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    </head>
<body>
  <div class="container">
     <div class="jumbotron" style="margin-top: 20px;">
       <div class="text-center">
         <h3>Registration process</h3>
         <p>First, enter your able login into this form:</p>

         <form:form class="form-Registration" method="post" modelAttribute="user" action="register">

             <spring:bind path="username">
                 <div class="row justify-content-center">
                 <form:input name="username" placeholder="Form for login" path="username" autofocus="true"
                             class="form-control col-8 col-sm-8 col-md-6 col-lg-4 col-xl-2"/>
                 </div>
                 <div class="secondary-text text-center text-danger">
                     <div class="font-italic">
                 <form:errors path="username"/>
                     </div>
                 </div>
             </spring:bind>

             <spring:bind path="email">
                 <div class="row justify-content-center">
                <form:input type="email" name="email" placeholder="Specify your e-mail here" path="email"
                       class="form-control col-8 col-sm-8 col-md-6 col-lg-4 col-xl-2"/>
             </div>
                 <div class="secondary-text text-center text-danger">
                     <div class="font-italic">
                 <form:errors path="email"/>
                 </div>
                 </div>
             </spring:bind>
             <spring:bind path="password">
                 <div class="row justify-content-center">
                <form:input type="password" name="password" placeholder="...and password here." path="password"
                       class="form-control col-8 col-sm-8 col-md-6 col-lg-4 col-xl-2"/>
             </div>
                 <div class="secondary-text text-center text-danger">
                     <div class="font-italic">
                 <form:errors path="password"/>
                     </div>
                 </div>
             </spring:bind>
             <spring:bind path="confirmPassword">
                 <div class="row justify-content-center">
                 <form:input type="password" name="confirmPassword" placeholder="confirm your password, and..."
                             path="confirmPassword" class="form-control col-8 col-sm-8 col-md-6 col-lg-4 col-xl-2"/>
             </div>
                 <div class="secondary-text text-center text-danger">
                     <div class="font-italic">
                 <form:errors path="confirmPassword"/>
                     </div>
                 </div>
             </spring:bind>
                 <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
             <br>
             <button class="btn btn-success">Register</button>
         </form:form>


           <br>
           <div  class="text-primary text-right">
             <a href="login">Back to the authorisation</a>
           </div>
       </div>
     </div>
     <div class="footer">
         <p><a href="dbfs">&copy; DBFS 20!8</a></p>
     </div>
 </div>
</body>
</html>
