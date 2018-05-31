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
         <form class="form-Registration" method="post" action="/registrationDone">
             <div class="row justify-content-center">
                 <input name="username" placeholder="Form for login" class="form-control col-8 col-sm-8 col-md-6 col-lg-4 col-xl-2">
             </div>
            <div class="row justify-content-center">
                <input type="email" name="email" placeholder="Specify your e-mail here" class="form-control col-8 col-sm-8 col-md-6 col-lg-4 col-xl-2">
             </div>
             <div class="row justify-content-center">
                <input type="password" name="password" placeholder="...and password here." class="form-control col-8 col-sm-8 col-md-6 col-lg-4 col-xl-2">
             </div>
             <div class="row justify-content-center">
                 <input type="password" name="passwordConfirm" placeholder="confirm your password, and..." class="form-control col-8 col-sm-8 col-md-6 col-lg-4 col-xl-2">
             </div>
             <br>
             <button class="btn btn-success">Register</button>
         </form>
           <br>
           <div  class="text-primary text-right">
             <a href="/login">Back to the authorisation</a>
           </div>
       </div>
     </div>
     <div class="footer">
         <p><a href="/dbfs">&copy; DBFS 20!8</a></p>
     </div>
 </div>
</body>
</html>
