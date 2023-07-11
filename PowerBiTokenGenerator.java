com.db.powerbi.login
import com.microsoft.powerbi.auth.AuthenticationContext;
import com.microsoft.powerbi.auth.AuthenticationResult;
import com.microsoft.powerbi.auth.PowerBIAccessToken;
import com.microsoft.powerbi.auth.RefreshTokenCredentials;
import com.microsoft.powerbi.sdk.models.reports.Report;
import com.microsoft.powerbi.sdk.models.reports.ReportGenerateTokenRequest;
import com.microsoft.powerbi.sdk.models.reports.ReportGenerateTokenResponse;
import com.microsoft.powerbi.sdk.models.reports.TokenAccessLevel;

public class PowerBiTokenGenerator {

    public String generateToken(String clientId, String clientSecret, String username, String password, String groupId, String reportId) {
        try {
            String authorityUrl = "https://login.microsoftonline.com/common/oauth2/token";
            String apiUrl = "https://api.powerbi.com/v1.0/myorg/groups/" + groupId + "/reports/" + reportId + "/generateToken";

            AuthenticationContext authenticationContext = new AuthenticationContext(authorityUrl, true, null);
            AuthenticationResult authenticationResult = authenticationContext
                    .acquireTokenByRefreshCredential(
                            new RefreshTokenCredentials(clientId, clientSecret, username, password))
                    .get();
            PowerBIAccessToken accessToken = authenticationResult.getAccessToken();

            ReportGenerateTokenRequest request = new ReportGenerateTokenRequest();
            request.setAccessLevel(TokenAccessLevel.VIEW);

            ReportGenerateTokenResponse response = accessToken.getPowerBIApi().reports().generateToken(request);

            return response.getToken();
        } catch (Exception e) {
            throw new RuntimeException("Error generating Power BI token.", e);
        }
    }
}
