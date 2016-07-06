package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.pojo.exception.CursoException;
import com.ipartek.formacion.service.CursoService;
import com.ipartek.formacion.service.CursoServiceImp;

/**
 * Servlet implementation class CursoServlet
 */
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CursoService cService=CursoServiceImp.getInstance();
	private Curso curso=null;
	private int id=-1;
	private int operacion=-1;
	private List<Curso>cursos=null;
	private RequestDispatcher rwd=null;
	
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo  = request.getParameter(Constantes.PAR_CODIGO);	
		
		try {
			id = Integer.parseInt(codigo);
			getById(request);
			
		}catch (Exception e) {
			getAll(request);
		}
		rwd.forward(request, response);
	}

	private void getAll(HttpServletRequest request) {
		cursos = cService.getAll();
		request.setAttribute(Constantes.ATT_LISTADO_CURSOS, cursos);
		rwd = request.getRequestDispatcher(Constantes.JSP_LISTADO_CURSOS);
	}

	private void getById(HttpServletRequest request) throws CursoException {
		curso = cService.getById(id);
		request.setAttribute(Constantes.ATT_CURSO, curso);
		rwd = request.getRequestDispatcher(Constantes.JSP_CURSO);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Procesaremos el DELETE, UPDATE y CREATE
		
		
		String op=request.getParameter(Constantes.PAR_OPERACION);
		try {
			operacion=Integer.parseInt(op);
			//1º recoger datos del objeto curso
			recogerId(request);
			//2º diferenciar la create de las demas
			switch (operacion) {
			case Constantes.OP_CREATE:
				recogerDatos(request);
				cService.createCurso(curso);
				//create -- curso.getCodigo()<0
				break;
			case Constantes.OP_DELETE:
				//System.out.println(id);
				cService.deleteCurso(id);
				//delete--curso.getNombre()==null
				break;
			case Constantes.OP_UPDATE:
				recogerDatos(request);
				cService.updateCurso(curso);
				//update
				break;
			
			default:
				break;
			}
			
			
		} catch (NumberFormatException e) {
			// TODO: alguien nos toquetea los argumentos del form
		}catch (NullPointerException e) {


		}catch (Exception e) {
			
			rwd.forward(request, response);
		}
		
		
		
		
		getAll(request);
		rwd.forward(request, response);
	}

	private void recogerId(HttpServletRequest request) {
		// TODO Auto-generated method stub
		id=Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));
	}

	private void recogerDatos(HttpServletRequest request) {
		curso=new Curso();
		recogerId(request);
		curso.setCodigo(id);
		String name=request.getParameter(Constantes.PAR_NOMBRE);
		curso.setNombre(name);
//		Map<Integer,Modulo> modulos=request.getParameterMap(Constantes.PAR_MODULO);
//		List<Modulo> ms=request.getParameter(Constantes.PAR_MODULO);
//		curso.setModulos(modulos);
	}

}
