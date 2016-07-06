<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
		<%
		Curso curso = (Curso) request.getAttribute(Constantes.ATT_CURSO);
		int op = -1;
		if(curso!=null){
			op = Constantes.OP_UPDATE;
		}else{
			curso = new Curso();
			op = Constantes.OP_CREATE;
		}
		%>
<main class="row">
		<a href="<%=Constantes.SERVLET_CURSOS %>">Atras</a>
		<%
		if(curso!=null){
		%>
		<%=Constantes.SERVLET_CURSOS%>
			<form name="" id="" method='post' 
				action="<%=Constantes.SERVLET_CURSOS%>">
				<input type="hidden" 
					id="<%=Constantes.PAR_OPERACION %>"
					name="<%=Constantes.PAR_OPERACION %>"  
					value="<%=op %>"/>
				<input type="hidden" 
					id="<%=Constantes.PAR_CODIGO %>" 
					name="<%=Constantes.PAR_CODIGO %>" 
					value="<%=curso.getCodigo()%>"/>
				<label for="<%=Constantes.PAR_NOMBRE%>"></label>
				<input type="text" 
					name="<%=Constantes.PAR_NOMBRE%>" 
					id="<%=Constantes.PAR_NOMBRE%>" 
					value="<%=curso.getNombre() %>"
					/>
			
				<input type="submit" />
			</form>	
	<%	
	}
		%>
</main>
<%@ include file="../includes/footer.jsp" %>