<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Add Rawmaterials </title>
</head>

   <h2>Add RawMaterials</h2>
      <form:form method = "POST" modelAttribute = "inventoryForm" action = "/inventory">
         <table>
            <tr>
               <td><form:label path = "rawMaterialName">Name</form:label></td>
               <td>
                      <form:input path="rawMaterialName" list="rawMaterialList"/>
                            <c:if test = "${not empty rawMaterialList}">
                                <datalist id="rawMaterialList">
                                 <c:forEach var="rawMaterialItem" items="${rawMaterialList}">
                                       <option value="${rawMaterialItem}"/>
                                 </c:forEach>
                                 </datalist>
                            </c:if>
                       <br/>
                      <form:errors path="rawMaterialName" cssClass="error"/>
                  </td>
            </tr>
            <tr>
               <td><form:label path = "rawMaterialQuantity">Total Inventory</form:label></td>
               <td><form:input path = "rawMaterialQuantity" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" name = "action" value = "Add"/>
               </td>
               <td colspan = "2">
                    <input type = "submit" name = "action" value = "Delete "/>
               </td>
            </tr>
         </table>
      </form:form>
</html>
