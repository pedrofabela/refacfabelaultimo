package beans;

import java.io.Serializable;


public class moduloAuxBean implements Serializable {
	private static final long serialVersionUID = -3358884679090829992L;

    private String MODULO;
    private String MODPADRE;
    private String MOD;
    private String ACCION;
    
	public String getMODULO() { 
		return MODULO;
	}
	public void setMODULO(String mODULO) {
		MODULO = mODULO;
	}
	public String getMODPADRE() {
		return MODPADRE;
	}
	public void setMODPADRE(String mODPADRE) {
		MODPADRE = mODPADRE;
	}
	public String getMOD() {
		return MOD;
	}
	public void setMOD(String mOD) {
		MOD = mOD;
	}
	public String getACCION() {
		return ACCION;
	}
	public void setACCION(String aCCION) {
		ACCION = aCCION;
	}
	
	
	
	
	
}
