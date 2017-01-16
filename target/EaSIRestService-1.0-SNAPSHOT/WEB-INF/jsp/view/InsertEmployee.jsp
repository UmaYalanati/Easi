<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration</title>
</head>
<body>
   <h1 align="center">Employee Registration Page</h1>

   <form action="processEmployeeForm" method="post" name="employeeForm">
      <table align="center">
         <tr>
            <td><label name="name">Name</label></td>
            <td><input type="text" name="emp_name"></td>
         </tr>
         <tr>
            <td><label name="emp_designation">Designation</label></td>
            <td><input type="text" name="emp_designation"></td>
         </tr>
         <tr>
            <td><label name="emp_dept">Dept</label></td>
            <td><input type="text" name="emp_dept"></td>
         </tr>

         <tr>
            <td><input type="submit" name="submit"></td>
            <td><input type="reset" name="reset"></td>
         </tr>
      </table>
   </form>
</body>
</html>