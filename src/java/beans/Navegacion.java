package beans;

import java.io.Serializable;
import java.util.Stack;

import utilidades.Constantes;


public class Navegacion  implements Serializable {
	private static final long serialVersionUID = -3358884679090829992L;
	Constantes constantin=new Constantes();
	private Stack theNavigationStack;
	
	public Stack getTheNavigationStack() {
		return theNavigationStack;
	} 

	public void setTheNavigationStack(Stack theNavigationStack) {
		this.theNavigationStack = theNavigationStack;
	}
	 
	//public final static String InitialPage = "/pages/acceso/seguroEscolar/accesoSegEsc.jsp";
	public final static String InitialPage = Constantes.rutaProyectos+"SOLEQUIVAL/pages/login.jsp";
	public Navegacion()
	{
		this(InitialPage);
	}
	
	private Navegacion(String obj)
	{
		theNavigationStack = new Stack();
		//System.out.println("Coloca en pila---"+obj);
		Push(obj, obj);
	}
		
	public String FakePop()
	{
		if((theNavigationStack.empty()))
			return InitialPage;
		else
			return (String)theNavigationStack.lastElement();
	}
	
	public String DobleFakePop()
	{
		if((theNavigationStack.size() - 2) <= 0)
			return InitialPage;
		else
			return (String) theNavigationStack.get(theNavigationStack.size() - 2);
	}
	
	public void EmptyStack()
	{
		theNavigationStack.clear();
		Push(InitialPage, InitialPage);
	}
	
	public String getReturnPath(String ActualPage, String action)
	{
		String LigaRegreso = InitialPage;
		if(DobleFakePop().trim().equals(ActualPage.trim()))		{
			Pop();
			LigaRegreso = DobleFakePop();
		}else{
			if(FakePop().trim().equals(ActualPage.trim())){
				LigaRegreso = DobleFakePop();
			}else{
				LigaRegreso = FakePop();
				if(LigaRegreso.trim().contains(action.trim())&&ActualPage.contains(action)){
					theNavigationStack.pop();
					LigaRegreso = FakePop();
				}
				Push(ActualPage.trim(), action);
			}
		}
		return LigaRegreso;
	}
	
	
	public String Pop()	{
		if(theNavigationStack.empty())
			return InitialPage;
		else
			return (String)theNavigationStack.pop();
	}
	
	public void Push(String obj, String action)	{
		String LigaRegreso = FakePop();
		if(LigaRegreso.trim().contains(action.trim()) && theNavigationStack.size()!=0){
			theNavigationStack.pop();
		}
		theNavigationStack.push(obj);
		//System.out.println("----------------------PILA NAVEGACION------------------------------------------");
		/*for(int i=0; i<theNavigationStack.size();i++){
			System.out.println("---objNaveg["+i+"]----->"+theNavigationStack.elementAt(i));
		}
		*/
	}
	
}
