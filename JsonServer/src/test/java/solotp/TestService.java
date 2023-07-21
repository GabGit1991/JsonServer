//package solotp;
//
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//
//import jakarta.ejb.EJB;
//
//@RunWithApplicationComposer
//class TestService {
//
//	@EJB
//	private  JoursFerieService jourferieservice;
//	
//	@org.apache.openejb.testing.Module
//	public EjbJar beans() {
//		EjbJar ejbJar = new EjbJar("my-beans");
//		ejbJar.addEnterpriseBean(new StatelessBean(JoursFerieService.class));
//		return ejbJar;
//	}
//
//	@Test
//	public void testJoursemaine() {
//		
//	String result=	jourferieservice.calculerjours(4, 7, 2023);
//	Assertions.assertEquals("jour de travail",result);	
//		
//	}
//	
//	@Test
//	public void testWeekEnd() {
//		
//		String result=jourferieservice.calculerjours(15, 07, 2023);
//		Assertions.assertEquals("La date tombe un weekend !",result);
//	}
//	
//	
//
//}
