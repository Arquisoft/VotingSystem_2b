package es.uniovi.asw.physicalvoting;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.GetHasVotedR;
import es.uniovi.asw.dbupdate.InsertHasVotedR;
import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.Turnout;
import es.uniovi.asw.model.Voter;

@Component("physicalVoting")
@Scope("view")
public class BeanPhysicalVoting {

	private String dni;
	private Voter voter;
	private Turnout turnout;

	@PostConstruct
	public void init() {
		
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}

	public Turnout getTurnout() {
		return turnout;
	}

	public void setTurnout(Turnout turnout) {
		this.turnout = turnout;
	}

	public void search() {
		voter = Repository.voterR.findByNif(dni);
		System.out.println(voter);

		if (voter == null)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                    "Votante no registrado en el censo"));
		else
			turnout = new GetHasVotedR().get(voter);
		
		System.out.println(turnout);
		
		dni = null;
	}
	
	public void confirm() {
		System.out.println("entra");
		System.out.println(voter);
		new InsertHasVotedR().insert(voter);
		System.out.println("sale");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",
                "Registrada participación del votante correctamente"));
		voter = null;
		turnout = null;
	}
}
