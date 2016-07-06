<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="com.ipartek.formacion.pojo.Modulo"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.service.ModuloService"%>
<%@page import="com.ipartek.formacion.service.ModuloServiceImp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"/>
<main>
<%
int op=-1;
    Curso curso = (Curso) request.getAttribute("curso");
    String tGuardar = "";
    Map<Integer,Modulo> modulos=new HashMap<Integer,Modulo>();
    ModuloService mService=ModuloServiceImp.getInstance();
    List<Modulo> lModulos= mService.getAll();
	for (Modulo m : lModulos) modulos.put(m.getCodigoModulo(),m);
   
    
    
    if (curso != null) {
    	op = Constantes.OP_UPDATE;
    	tGuardar="guardar";

    } else {
	curso=new Curso();
op=Constantes.OP_CREATE;
tGuardar="guardar";
	
    }
%>
	
	<a class='btn btn-warning' href="<%=Constantes.SERVLET_CURSOS  %>">Atras</a>

		<%
		
		if(curso!=null){
			
		%>
		<%=Constantes.SERVLET_CURSOS%>
		<form name="id" method="post"
		 action="<%=Constantes.SERVLET_CURSOS %>">
		<input type="hidden" 
		id="<%=Constantes.PAR_OPERACION%>"
		name="<%=Constantes.PAR_OPERACION%>"
		 value="<%=op%>"/>
		
		<input type="hidden" 
		 id="<%=Constantes.PAR_CODIGO%>"
		 name="<%=Constantes.PAR_CODIGO%>"
		 value="<%=curso.getCodigo()%>"/>
		
		<div class="form-group">
					<label class="sr-only" for="<%=Constantes.PAR_NOMBRE%>">Nombre:</label>
					<input  type="text" class="form-control "
					placeholder="Indrodruzca el nombre del Curso"
						name="<%=Constantes.PAR_NOMBRE%>" 
						id="<%=Constantes.PAR_NOMBRE%>" 
						value="<%=curso.getNombre() %>"
						/>
					<div class="hidden"></div>
				</div>
				
				
		<div class="form-group">
					<label class="col-xs-2">Modulos:</label>
					<div class="col-xs-10">
				
						<% 
						
						
						for(Modulo modulo: lModulos){
							%>
							<input type="checkbox" name="<%="Modulo" %>" id=""
							
							 value="<%=modulo.getCodigoModulo() %>"/> 
							 
							<%=modulo.getNombreModulo() %>
							
							
							<%
						} 
						
						
						%>
																				
					</div>
					<div class="form-group">
					<button type="submit" class="btn btn-success">
						<%=tGuardar %>
					</button>
				</div>
		</form>
			
		<% 
		}
		%>
	</main>
<%@ include file="../includes/footer.jsp" %>