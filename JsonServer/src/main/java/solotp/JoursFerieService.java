package solotp;

import java.time.DayOfWeek;
import java.time.LocalDate;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class JoursFerieService {
	
	
	
	public String calculerjours(int jours, int mois , int anne)
	{
		LocalDate date=LocalDate.of(jours, mois, anne);
		DayOfWeek dayofweek= date.getDayOfWeek();
		
		if( dayofweek==DayOfWeek.SATURDAY || dayofweek== DayOfWeek.SUNDAY ) {
	
			return " weekend !";
		

		}else {
		
//			System.out.println("jour de travail");
			return "jour de travail";
			
		}
	}
	
	
	

}
