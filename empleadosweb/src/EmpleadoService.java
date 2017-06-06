

import java.util.List;

public class EmpleadoService {
	
	public List<Empleado> getEmpleados ()
	{
		List<Empleado> l_empleados = null;
		
			EmpleadoBD empleadoBD = new EmpleadoBD();
			l_empleados = empleadoBD.getEmpleadosBD();
		
		return l_empleados;
	}
	
	public List<Empleado> getEmpleadosByDpto (int ndpto)
	{
		List<Empleado> l_empleados = null;
		
			EmpleadoBD empleadoBD = new EmpleadoBD();
			l_empleados = empleadoBD.getEmpleadosBDByDpto(ndpto);
		
		return l_empleados;
	}
	

}
