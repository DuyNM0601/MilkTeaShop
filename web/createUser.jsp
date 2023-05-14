<%-- 
    Document   : createUser
    Created on : Apr 15, 2023, 3:27:53 PM
    Author     : duy
--%>


<%@page import="sample.dto.userError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Đăng kí</title>
        <link rel="stylesheet" href="CSS/1.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Merriweather:300,400,400i|Noto+Sans:400,400i,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600" rel="stylesheet">
    </head>
</head>
<body>


    <div class="to">
        <form class="form" action="mainController" method="post">            
            <h2> Create new user</h2>
            <i class="fab fa-app-store-ios"></i>
            <label style="margin-left: -150px;">UserID</label>
            <input type="text" name="userID" required=""/>
            ${requestScope.USER_ERROR.userIDError}</br>
            <label>Full Name</label>
            <input type="text" name="fullname" required=""/>
            ${requestScope.USER_ERROR.fullNameError}</br>
            <label style="margin-left: -160px;">RoleID</label>
            <input type="text" name="roleID" value="US" required="" readonly="US"/>
            ${requestScope.USER_ERROR.roleIDError}</br>
            <label style="margin-left: -130px;">Password</label> 
            <input type="password" name="password" required=""/>
            ${requestScope.USER_ERROR.passwordError}</br>
            <label style="margin-left: -130px;">Confirm</label> 
            <input type="password" name="confirm" required=""/>
            ${requestScope.USER_ERROR.confirmError}</br>
            <input id="submit" type="submit" name="action" value="create">          
        </form>          
    </div>

    <!--        <form class="form" action="mainController" method="post">
                UserID<input type="text" name="userID" required=""/>
    //!${requestScope.USER_ERROR.userIDError}</br>
    Full Name<input type="text" name="fullname" required=""/>
    ${requestScope.USER_ERROR.fullNameError}</br>
    RoleID<input type="text" name="roleID" value="US" required=""/>
    ${requestScope.USER_ERROR.roleIDError}</br>
    Password<input type="password" name="password" required=""/>
    ${requestScope.USER_ERROR.passwordError}</br>
    <input type="password" name="confirm" required=""/>
    ${requestScope.USER_ERROR.confirmError}</br>
    <input type="submit" name="action" value="create"/></br>
    <input type="reset" value="Reset"/></br>
    ${requestScope.USER_ERROR.errorError}
</form>-->
</body>

<style>
    *{
        margin:0;
        padding:0;
        border:none;
        font-family: 'Open Sans', sans-serif;
    }
    body {
        overflow: hidden;
        background: #4CAF50;
    }
    .to {
        display: grid;
        grid-template-columns: repeat(12,1fr);
        grid-template-rows: minmax(100px,auto);
    }

    .form {
        border: 1px solid #80808000;
        grid-column: 6/9;
        grid-row: 3;
        height: 700px;
        width: 292px;
        display: flex;
        flex-direction: column;
        align-items: center;
        position: relative;
        border-radius: 15px;
        box-shadow: 0px 0px 14px 0px grey;
        background-color: white;
        padding:0 100px;
    }
    h2 {
        margin-top: 50px;
        margin-bottom: 30px;
    }
    i.fab.fa-app-store-ios {
        display: block;
        margin-bottom: 50px;
        font-size: 28px;
    }

    label {
        margin-left: -126px;
        display: block;
        font-weight: lighter;

    }
    input{
        display: block;
        border-bottom: 2px solid #00BCD4;
        margin-top: 6px;
        margin-bottom: 10px;
        outline-style: none;
    }
    input{
        padding: 5px;
        width: 100%;
    }

    input#submit {
        padding: 7px;
        width: 50%;
        border-radius: 10px;
        border: none;
        position: absolute;
        bottom: 10px;
        cursor: pointer;
        background: linear-gradient(to right, #fc00ff, #00dbde);
    }
    input#submit:hover{

        background: linear-gradient(to right, #fc466b, #3f5efb); 
    }
    #submit{
        color:#fff;
        width:100%;
    }
</style>

</html>
