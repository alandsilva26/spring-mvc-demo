<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <body>
    <form method="POST" action="add" modelAttribute="numbers">
      <div><label>Num 1</label> <input type="number" /></div>
      <div><label>Num 2</label> <input type="number" /></div>
      <button type="submit">Submit</button>
    </form>
    <div>${sum}</div>
  </body>
</html>
