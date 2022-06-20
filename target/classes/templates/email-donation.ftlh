<!DOCTYPE html>
<html lang="pl" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Oddam w dobre ręce - darowizna</title>
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

        .donation {
            text-align: center;
            font-size: 1.5rem;
            line-height: 2rem;
            font-family: 'Open Sans', sans-serif;
            font-weight: 300;
            font-style: normal;
        }

        .bold {
            font-weight: 700;
            padding-top: 50px;
        }

        .space {
            padding-top: 50px;
        }
    </style>
</head>
<body>
<div class="mail">

    <div class="header">
        <h3 class="title">Przekazanie darów</h3>
    </div>

    <div class="content">
        <h1 class="greeting">Cześć, ${username}!</h1>
        <h3 class="text">Dzięki za chęć przekazania darów.</h3>
        <h3 class="text">Poniżej znajdują się dane wysłane w formularzu.</h3>

        <p class="donation space">Oddajesz:</p>
        <p class="text">worki rzeczy dla potrzebujących w ilości: <span class="bold">${donation.quantity}</span></p>
        <p class="text">Dla funadacji "<span class="bold">${donation.institution.name}</span>"</p>

        <p class="donation bold">Adres odbioru:</p>
        <p class="text"> ${donation.street}</p>
        <p class="text"> ${donation.city}</p>
        <p class="text"> ${donation.zipCode}</p>
        <p class="text"> ${donation.phone}</p>

        <p class="donation bold">Termin odbioru:</p>
        <p class="text"> ${donation.pickUpDate}</p>
        <p class="text"> ${donation.pickUpTime}</p>

        <p class="text space">Sprawdź proszę czy dane się zgadzają. Jeśli jest jakiś błąd skontaktuj się z nami.</p>

    </div>
</div>

</body>