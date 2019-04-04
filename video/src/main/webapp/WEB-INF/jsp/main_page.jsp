<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Subscribe</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <%--<script src="scripts/main_page.js"></script>--%>
        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
        <link href="/css/main_page.css" rel="stylesheet">
        <script type="text/javascript">
            window.onload = function() {

                var chart = new CanvasJS.Chart("chartContainer", {
                    theme: "light2",
                    title: {
                        text: "Internet Use in United States"
                    },
                    subtitles: [{
                        text: "2000 to 2015"
                    }],
                    axisY:{
                        title: "Percent of Population",
                        suffix: "%",
                        includeZero: false
                    },
                    data: [{
                        type: "spline",
                        toolTipContent: "<b>{label}</b>: {y}%",
                        dataPoints: ${dataList}
                    }]
                });
                chart.render();

            }
        </script>
</head>
<body>
    <div class="header">
        <a class="logo">Videos</a>
        <div class="header-right">
            <a>Sign out</a>
            <img src="/avatar.png" class="avatar header-right">
        </div>
    </div>

    <c:forEach var="entry" items="${dataPointsList}">
        <li class="form card">key is ${entry.key}
        <c:forEach var="info" items="${entry.value}">
            <ul>info is ${info}</ul>
        </c:forEach>
        </li>
    </c:forEach>

    <div class="form card">
        <table>
            <tr>
                <td>num</td>
                <td>video_id</td>
                <td>watching_date</td>
            </tr>
            <tr>
                <td>num</td>
                <td>video_id</td>
                <td>watching_date</td>
            </tr>
            <tr>
                <td>num</td>
                <td>video_id</td>
                <td>watching_date</td>
            </tr>
            <tr>
                <td>num</td>
                <td>video_id</td>
                <td>watching_date</td>
            </tr>
        </table>
    </div>
    <div class="form card">
    <div id="chartContainer" class="chart"/>
    </div>
</body>
</html>