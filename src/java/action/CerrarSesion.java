/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;


import utilidades.Constantes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;


public class CerrarSesion extends ActionSupport implements SessionAware {

    public String getPageIn() {
        return pageIn;
    }

    public void setPageIn(String pageIn) {
        this.pageIn = pageIn;
    }
    private Map session = ActionContext.getContext().getSession();

    String pageIn =  Constantes.rutaProyectos+"SOLEQUIVAL/pages/login.jsp";
    String abreManual;
    public void setSession(Map session) {
        this.session = session;
    }

    public Map getSession() {
        return session;
    }
 
    public String cerrar() {
        if (session != null) {
            session.clear();
        }
   
        String pageIn =  Constantes.rutaProyectos+"/pages/login.jsp";
        return "SUCCESS";
    }
    
    public String manual() {
       
      
        abreManual =  Constantes.rutaManuales;
        return "SUCCESS";
    }

	public String getAbreManual() {
		return abreManual;
	}

	public void setAbreManual(String abreManual) {
		this.abreManual = abreManual;
	}
    
}
