package beans;

import java.io.Serializable;


public class moduloBean implements Serializable {
	private static final long serialVersionUID = -3358884679090829992L;


    private String CVE_MODULO;
    private String CVE_MODPADRE;
    private String DESC_MOD;
    private String ACTION; 
    private String IMAGEN;
    
	public String getCVE_MODULO() {
		return CVE_MODULO;
	}
	public void setCVE_MODULO(String cVEMODULO) {
		CVE_MODULO = cVEMODULO;
	}
	public String getCVE_MODPADRE() {
		return CVE_MODPADRE;
	}
	public void setCVE_MODPADRE(String cVEMODPADRE) {
		CVE_MODPADRE = cVEMODPADRE;
	}
	public String getDESC_MOD() {
		return DESC_MOD;
	}
	public void setDESC_MOD(String dESCMOD) {
		DESC_MOD = dESCMOD;
	}
	public String getACTION() {
		return ACTION;
	}
	public void setACTION(String aCTION) {
		ACTION = aCTION;
	}
	public String getIMAGEN() {
		return IMAGEN;
	}
	public void setIMAGEN(String iMAGEN) {
		IMAGEN = iMAGEN;
	}

	
	
	
	
}
