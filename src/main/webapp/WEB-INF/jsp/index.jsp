<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
    <title>Calculate VAT</title>
</head>
<body>

<form name="vat" action="calculateServlet" method="POST">

    <table>
    <tr>
    <td>Your gross :</td>
<td><input type="text" name=total"/></td>
    </tr>
    <tr>
    <td>Vat rate in percentage :</td>
<td><input type="text" name="vatRate"/></td>
    </tr>
    <th><input type="submit" value="Submit" name="find"/></th>
    <th><input type="reset" value="Reset" name="reset" /></th>
    </table>
    <h2>${vat}</h2>
    </form>

    </body>
    </html>