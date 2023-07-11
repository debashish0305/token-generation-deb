# token-generation-deb

<dependency>
    <groupId>com.microsoft.powerbi</groupId>
    <artifactId>powerbi-restapi-sdk</artifactId>
    <version>1.3.0</version>
</dependency>


https://app.powerbi.com/groups/{groupId}/reports/{reportId}



The scopes required for MSAL4j authentication depend on the specific API or service you are integrating with. Here are some commonly used scopes for popular Microsoft services:

Microsoft Graph API:

User.Read - Read basic profile of the signed-in user.
User.ReadWrite - Read and write access to the signed-in user's profile.
Calendars.Read - Read user calendars.
Mail.Read - Read user mail.
Mail.Send - Send mail as the signed-in user.
Files.Read - Read user files.
Azure Management API:

https://management.core.windows.net/.default - Full access to Azure management resources.
user_impersonation - Access Azure resources using the user's identity.
Microsoft SharePoint API:

AllSites.Manage - Manage all SharePoint sites.
Web.Read - Read all site-level information.
Microsoft Azure Active Directory Graph API:

Directory.AccessAsUser.All - Access the directory as the signed-in user.
These are just a few examples, and the available scopes depend on the specific API or service you are integrating with. It's important to refer to the documentation of the API or service you are using to determine the correct scopes to request for the desired functionality.

Additionally, scopes can be defined by the service or application you are integrating with, and custom scopes might be required for specific scenarios. Make sure to consult the documentation of the service or application you are working with to obtain the appropriate scopes.
