import nz.co.airnz.carinaapi.carinahandler.CarinaHandler;
import nz.co.airnz.carinaapi.carinahandler.reservations.CreateBookingHandler;
import nz.co.airnz.carinaapi.connectionmethods.CarinaInstance;
import nz.co.airnz.carinaapi.connectionmethods.CarinaSession;
import nz.co.airnz.carinaapi.connectionmethods.CarinaSessionImpl;
import nz.co.airnz.carinaapi.referencedata.ConnectionMethod;
import java.util.Properties;

/**
 * @author Sam
 * @date 14/06/2022 : 10:43 AM
 */
public class Main {
    protected static String carinEnv;
    protected static String jacName, jacUrl;
    protected static int jacPort;
    protected static CarinaInstance carinaInstance;
    protected static CarinaSession carinaSession;

    public static void main(String[] args) {

        System.out.println("Hello Jac");

        Properties properties = System.getProperties();
        properties.setProperty("team.id", "CRN");
        carinEnv="Q0";

        JacConnectionDetails jacDetails = JacConnectionDetails.checkEnvironment(carinEnv);
        jacName = jacDetails.getJacName();
        jacUrl = jacDetails.getJacUrl();
        jacPort = jacDetails.getJacPort();

        System.out.println("+++++++++ JAC Name : "+jacName);
        System.out.println("+++++++++ JAC URL : "+jacUrl);
        System.out.println("+++++++++ JAC Port : "+jacPort);

        carinaInstance = CarinaInstance.parse(carinEnv);
        carinaSession = CarinaSessionImpl.getCarinaSession(carinaInstance);
        carinaSession.setSessionUsername(jacName);
        carinaSession.setSessionUrl(jacUrl);
        carinaSession.setSessionPortNumber(jacPort);
        carinaSession.setConnectionMethod(ConnectionMethod.CARINA_JAC);


        CreateBookingHandler bookingHandler= new CreateBookingHandler(carinaSession);
        String output = bookingHandler.carinaCommandSingleLine("A15junaklwlgY");
        System.out.println("response --> "+output );
        bookingHandler.cleanUpJacSession();

        //clear the connection
        //CarinaHandler.getJacFixture().cleanUpJacSession(carinaSession);
    }
}
