package nl.hanze.web.rdw.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import nl.hanze.web.rdw.service.*;

@WebService
public class RDWServices {
	@WebMethod
	public Info getKentekenInfo(@WebParam(name = "kenteken")Kenteken kenteken) {
		GetResponses gir=new GetResponses();
		return gir.getInfoReturn(kenteken);
	}
/*	@WebMethod
	public String getRandomKenteken() {
		GetResponses gir=new GetResponses();
		return gir.getRandomKenteken();
	}*/
}