<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Oddam w dobre ręce - rejestracja</title>
    <style>

        * {
            -ms-text-size-adjust: 100%;
            -webkit-text-size-adjust: 100%;
            box-sizing: border-box;
        }

        body {
            margin-left: auto;
            margin-right: auto;
            width:90%;
        }

        .mail {

            width: 90%;
            height: 90%;
            margin-left: auto;
            margin-right: auto;
        }

        .header {
            background-color: dimgray;
            width: 90%;
            text-align: center;
            margin-left: auto;
            margin-right: auto;
        }

        .title {
            padding-top: 20px;
            padding-bottom: 20px;
        }

        .content {
            background-color: lightgray;
            width: 90%;
            margin-left: auto;
            margin-right: auto;
            padding-left: 20px;
            padding-bottom: 20px;
        }

        .greeting {
            display: block;
            padding-top: 20px;
            text-align: center;
            font-size: 3.5rem;
            line-height: 5rem;
            font-family: 'Open Sans', sans-serif;
            font-weight: 300;
            font-style: normal;
        }

        .text {
            text-align: center;
            font-size: 1.5rem;
            line-height: 2rem;
            font-family: 'Open Sans', sans-serif;
            font-weight: 300;
            font-style: normal;
        }

        .registration {
            text-align: center;
            font-size: 1.5rem;
            line-height: 2rem;
            font-family: 'Open Sans', sans-serif;
            font-weight: 300;
            font-style: normal;
        }
    </style>
</head>
<body>
<div class="mail">

    <div class="header">
        <h3 class="title">Utworzenie konta w "Oddam w dobre ręce"</h3>
    </div>

    <div class="content">
        <h1 class="greeting">Cześć!</h1>
        <h3 class="registration">Rejestracja przebiegła pomyślnie.</h3>
        <h3 class="text">Miło nam, że jesteś z nami. :)</h3>
        <p class="text">Twoje login: <b>${username}</b></p>

    </div>
</div>

</body>