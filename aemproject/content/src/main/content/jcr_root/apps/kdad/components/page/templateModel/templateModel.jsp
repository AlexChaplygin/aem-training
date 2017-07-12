<%@include file="/libs/foundation/global.jsp" %>
<cq:includeClientLib categories="aem.training"/>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>

        $(document).ready(function () {

            $('#submit').click(function () {
                var failure = function (err) {
                    alert("Unable to retrive data " + err);
                };

                $.ajax({
                    type: 'POST',
                    url: '/bin/slingmodel',
                    success: function (msg) {
                        $('#json').val(msg);
                    }
                });
            });

        });
    </script>
</head>

<title>Sling Model Page</title>

<body>

<h1>Sling Model </h1>

<form method="#">

<textarea id="json" rows="15" cols="200">
</textarea>

    <input type="button" value="Get Sling Model Data" name="submit" id="submit">

</form>

</body>

</html>