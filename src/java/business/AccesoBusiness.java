

package business;

import java.util.List;
import beans.usuarioBean;
import daos.AccesoUsarioDAO;
import daos.AccesoUsarioDAOImpl;
 

public class AccesoBusiness {
    
    private AccesoUsarioDAO accUsrDAO;

    public AccesoBusiness() throws Exception{
        this.accUsrDAO = new AccesoUsarioDAOImpl();
    }
	
    public usuarioBean consultaUsuario(String cveUsuario, String pswUsuario) throws Exception{
    	usuarioBean usu = this.accUsrDAO.consultaAcceso(cveUsuario, pswUsuario);
        return usu;
    }
   
    public List consultaModulosPerfilMenu(Integer cvePerf, String cvemodpadre) throws Exception{
        List lista = this.accUsrDAO.consultaModulosPerfilMenu(cvePerf, cvemodpadre);
        return lista;
    }
    
    public List consultaModulosHijosPerfilMenu(Integer cvePerf, String cvemodpadre) throws Exception{
        List lista = this.accUsrDAO.consultaModulosHijosPerfilMenu(cvePerf, cvemodpadre);
        return lista;
    }
   
}