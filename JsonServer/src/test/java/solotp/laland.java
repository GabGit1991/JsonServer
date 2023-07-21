//package solotp;
//
//import org.apache.openejb.jee.EjbJar;
//import org.apache.openejb.jee.StatelessBean;
//import org.apache.openejb.junit5.RunWithApplicationComposer;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import jakarta.ejb.EJB;
//import jakarta.ejb.embeddable.EJBContainer;
//import jakarta.naming.Context;
//
//@RunWithApplicationComposer
//public class JoursFerieServiceTest {
//
//    @EJB
//    private JoursFerieService jourferieservice;
//
//    @org.apache.openejb.testing.Module
//    public EjbJar beans() {
//        EjbJar ejbJar = new EjbJar("my-beans");
//        ejbJar.addEnterpriseBean(new StatelessBean(JoursFerieService.class));
//        return ejbJar;
//    }
//
//    @Test
//    public void testJoursSemaine() throws Exception {
//        int a = 2023;
//        int m = 7;
//        int j = 7;
//        String result = jourferieservice.calculerjours(j, m, a);
//        Assertions.assertEquals("jour de travail", result);
//    }
//
//    @Test
//    public void testWeekend() throws Exception {
//        int a = 2023;
//        int m = 7;
//        int j = 15;
//        String result = jourferieservice.calculerjours(j, m, a);
//        Assertions.assertEquals("La date tombe un weekend !", result);
//    }
//}