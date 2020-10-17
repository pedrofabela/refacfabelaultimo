
package daos;

import java.sql.*;
import java.util.List;

import beans.usuarioBean;
import mappers.moduloAuxMapper;
import mappers.moduloMapper;

import mappers.usuarioMapper;
import utilidades.Constantes;
 
 
public class AccesoUsarioDAOImpl extends OracleDAOFactory implements AccesoUsarioDAO {

		OracleDAOFactory oraDaoFac = new OracleDAOFactory();
   
    	//buscando los datos del USUARIO 
	 public usuarioBean consultaAcceso(String cveUsuario, String pswUsuario) throws Exception{
    		
    		String query=  " select NAMEUSUARIO, PASSWORD, PERFIL, NAMEPERFIL, USUARIO, FILTRO " +
                           " from " + Constantes.TablaUsuarios + " where usuario = '" + cveUsuario +"' AND PASSWORD = '" + pswUsuario + "'"; 
    		 Constantes.enviaMensajeConsola(" query consulta folio--> "+query);	
    		 usuarioBean usu = (usuarioBean) oraDaoFac.queryForObject(query, new usuarioMapper());
       	    return usu;
       	}     
    
   
    public List consultaModulosPerfilMenu(Integer cvePer, String cvemodpadre) throws Exception{
    	 String query = "SELECT MP.CVEMODULO,NAMEMOD,ACTION,MODPADRE,IMAGEN FROM " + Constantes.TablaModulosPerfiles + " MP "
         + " LEFT OUTER JOIN " + Constantes.TablaModulos + " M ON MP.CVEMODULO=M.CVEMODULO "
         + " WHERE PERFIL='" + cvePer + "' ORDER BY ORDEN";
		 System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
		 List list = null;
		 list = queryForList(query, new moduloMapper());
		 return list;
    }
    
    
    public List consultaModulosHijosPerfilMenu(Integer cvePer, String cvemodpadre) throws Exception{
    	 String query = "SELECT MP.CVEMODULO,NAMEMOD,ACTION,MODPADRE FROM " + Constantes.TablaModulosPerfiles + " MP "
         + " LEFT OUTER JOIN " + Constantes.TablaModulos + " M ON MP.CVEMODULO=M.CVEMODULO "
         + " WHERE PERFIL='" + cvePer + "' ORDER BY ORDEN";
		 System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
		 List list = null;
		 list = queryForList(query, new moduloAuxMapper());
		 return list;
    }
   
}