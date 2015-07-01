<html>
    <head></head>
    <body>
        <form method="post">
            <input name="username" type="text"/>
            <input name="password" type="password"/>
            <input name="submit" type="submit" value="Submit" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </body>
</html>