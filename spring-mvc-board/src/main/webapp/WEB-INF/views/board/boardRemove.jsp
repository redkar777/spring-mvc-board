<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BOARD REMOVE FORM</title>
</head>
<body>
    <form action="<c:url value='/board/boardRemove'/>" method="post">
        <input name="boardNo" value="${param.boardNo}" type="hidden"/>
        <div>��й�ȣȮ�� :</div>
        <div><input name="boardPw" type="password"></div>
        <div>
            <input type="submit" value="����"/>
            <input type="reset" value="�ʱ�ȭ"/>
        </div>
    </form>
</body>
</html>


