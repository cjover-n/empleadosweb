

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private final static Logger log = Logger.getLogger("mylog");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String usuario = null;
		String pwd = null;
		
		usuario = request.getParameter("usuario");
		pwd = request.getParameter("pwd");
		
		log.debug("USUARIO Y PWD " + usuario + " " + pwd);
		
		EmpleadoService es = new EmpleadoService();
		boolean valido = es.validarUsuario(usuario, pwd);
		
		if (valido == true)
		{
			//el usuario existe
			//le mando al jsp de bienvenida
			log.debug("El usuario Existe");
			HttpSession sesion = request.getSession();
			sesion.setAttribute("nombre", usuario);
			sesion.setAttribute("id", pwd);
			request.getRequestDispatcher("inicio.jsp").forward(request, response);
		} else {
			//el usuario no existe
			//le mando a la p�gina de error
			log.debug("El usuario NO Existe");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			//response.sendRedirect("error.jsp");
		}
	}

}
