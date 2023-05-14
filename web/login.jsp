<%-- 
    Document   : login
    Created on : Apr 13, 2023, 3:19:13 PM
    Author     : duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    </head>
    <body style="margin:0px;">
        <header style="background-color: green!important">
            <%@include file="header.jsp" %>
        </header>
        <div class="page">
            <div class="container">
                <div class="login-page">
                    <div class="form" >
                        
                        <form action="mainController" method="post" class="login-form" id="form">
                            <input type="text" placeholder="Username" name="userid" required=""/>
                            <input type="password" placeholder="password" name="password" required=""/>

                            <div class="g-recaptcha" data-sitekey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI"></div>
                            <div id="error"></div>
                            <input type="hidden" name="action" value="Login" />
                            <input style="cursor:pointer" type="submit" name="action" value="Login"/></br>

                            <input style="cursor:pointer" type="reset" value="Reset"/></br>
                            ${requestScope.USER_ERROR.errorError}
                            
                            <p class="message">Not registered? <a href="createUser.jsp">Create an account</a></p>
                        </form>
                            <form   action="mainController" method="POST">
                                <input class="btn btn-info" type="submit" name="action" value="Login With Google"/><br/>
                            </form>
                            <form action="mainController" method="post">
                                <input type="submit" name="action" value="User"/>
                            </form>
                    </div>
                </div> 
            </div>
        </div>

        <style>
            body > div > div > div > div > form.login-form > input[type=reset]:nth-child(3):hover{
                opacity: 0.5;
            }
        </style>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script>
                        window.onload = function (){
                                let isValid = false;
                                const form = document.getElementById("form");
                                const error = document.getElementById("error");
				
                                form.addEventListener("submit", function (event){
                                        event.preventDefault();
                                        const response = grecaptcha.getResponse();
                                        if (response){
                                                form.submit();
                                        } else {
                                                error.innerHTML = "Please check";
                                        }
                });
            }
        </script>
        ${requestScope.ERROR}
        <footer  style="background-color: green!important">
            <%@include file="footer.jsp" %>
        </footer>
        <style>
            /*@import url(https://fonts.googleapis.com/css?family=Roboto:300);*/

            .login-page {
                width: 360px;
                padding: 8% 0 0;
                margin: auto;
            }
            .form {
                position: relative;
                z-index: 1;
                background: #FFFFFF;
                max-width: 360px;
                margin: 0 auto 100px;
                padding: 45px;
                text-align: center;
                box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
            }
            .form input {
                font-family: "Roboto", sans-serif;
                outline: 0;
                background: #f2f2f2;
                width: 100%;
                border: 0;
                margin: 0 0 15px;
                padding: 15px;
                box-sizing: border-box;
                font-size: 14px;
            }
            .form button {
                font-family: "Roboto", sans-serif;
                text-transform: uppercase;
                outline: 0;
                background: #4CAF50;
                width: 100%;
                border: 0;
                padding: 15px;
                color: #FFFFFF;
                font-size: 14px;
                -webkit-transition: all 0.3 ease;
                transition: all 0.3 ease;
                cursor: pointer;
            }
            .form button:hover,.form button:active,.form button:focus {
                background: #43A047;
            }
            .form .message {
                margin: 15px 0 0;
                color: #b3b3b3;
                font-size: 12px;
            }
            .form .message a {
                color: #4CAF50;
                text-decoration: none;
            }
            .form .register-form {
                display: none;
            }
            .container {
                position: relative;
                z-index: 1;
                max-width: 300px;
                margin: 0 auto;
            }
            .container:before, .container:after {
                content: "";
                display: block;
                clear: both;
            }
            .container .info {
                margin: 50px auto;
                text-align: center;
            }
            .container .info h1 {
                margin: 0 0 15px;
                padding: 0;
                font-size: 36px;
                font-weight: 300;
                color: #1a1a1a;
            }
            .container .info span {
                color: #4d4d4d;
                font-size: 12px;
            }
            .container .info span a {
                color: #000000;
                text-decoration: none;
            }
            .container .info span .fa {
                color: #EF3B3A;
            }
            body {
                background: #4CAF50;
                font-family: "Roboto", sans-serif;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;      
            }
        </style>

        <script>
            $('.message a').click(function () {
                $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
            });
        </script>

    </body>


</html>
