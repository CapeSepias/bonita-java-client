package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.Map;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface AuthenticationApi extends ApiClient.Api {


  /**
   * Login
   * A call to the &#x60;/loginservice&#x60; will generates a set-cookie header in the response.  The &#x60;JSESSIONID&#x60; cookie must be transfered with each subsequent calls. (If the REST API is used in an application running in a web browser, this is handled automatically by the web browser just like any cookies).  Additional protection agains CSRF attacks is enabled by default for all fresh installations This security relies on &#x60;X-Bonita-API-Token&#x60; information. The &#x60;X-Bonita-API-Token&#x60; value can be found in the cookie named: &#x60;X-Bonita-API-Token&#x60;.  All the subsequence REST API calls performing changes in the system using DELETE, POST, or PUT HTTP methods must contain the **HTTP header** below:  &#x60;&#x60;&#x60; X-Bonita-API-Token: example-dummy-not-be-used-value &#x60;&#x60;&#x60; 
   * @param username the username (required)
   * @param password the password (required)
   * @param tenant the user tenant (optional)
   * @param redirect \\\&quot;true\\\&quot; or \\\&quot;false\\\&quot;. \\\&quot;false\\\&quot; indicates that the service should not redirect to Bonita Portal (after a successful login) or to the login page (after a login failure). (optional, default to &quot;false&quot;)
   * @param redirectURL the URL of the page to be displayed after login (optional, default to &quot;&quot;)
   * @return String
   */
  @RequestLine("POST /loginservice")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
  })
  String login(@Param("username") String username, @Param("password") String password, @Param("tenant") String tenant, @Param("redirect") String redirect, @Param("redirectURL") String redirectURL);

  /**
   * Login
   * Similar to <code>login</code> but it also returns the http response headers .
   * A call to the &#x60;/loginservice&#x60; will generates a set-cookie header in the response.  The &#x60;JSESSIONID&#x60; cookie must be transfered with each subsequent calls. (If the REST API is used in an application running in a web browser, this is handled automatically by the web browser just like any cookies).  Additional protection agains CSRF attacks is enabled by default for all fresh installations This security relies on &#x60;X-Bonita-API-Token&#x60; information. The &#x60;X-Bonita-API-Token&#x60; value can be found in the cookie named: &#x60;X-Bonita-API-Token&#x60;.  All the subsequence REST API calls performing changes in the system using DELETE, POST, or PUT HTTP methods must contain the **HTTP header** below:  &#x60;&#x60;&#x60; X-Bonita-API-Token: example-dummy-not-be-used-value &#x60;&#x60;&#x60; 
   * @param username the username (required)
   * @param password the password (required)
   * @param tenant the user tenant (optional)
   * @param redirect \\\&quot;true\\\&quot; or \\\&quot;false\\\&quot;. \\\&quot;false\\\&quot; indicates that the service should not redirect to Bonita Portal (after a successful login) or to the login page (after a login failure). (optional, default to &quot;false&quot;)
   * @param redirectURL the URL of the page to be displayed after login (optional, default to &quot;&quot;)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /loginservice")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
  })
  ApiResponse<String> loginWithHttpInfo(@Param("username") String username, @Param("password") String password, @Param("tenant") String tenant, @Param("redirect") String redirect, @Param("redirectURL") String redirectURL);



  /**
   * Logout the current user
   * Logout the current user from the system 
   * @param redirect Setting the redirect parameter to false indicates that the service should not redirect to the login page after logging out. (optional)
   */
  @RequestLine("GET /logoutservice?redirect={redirect}")
  @Headers({
    "Accept: application/json",
  })
  void logout(@Param("redirect") String redirect);

  /**
   * Logout the current user
   * Similar to <code>logout</code> but it also returns the http response headers .
   * Logout the current user from the system 
   * @param redirect Setting the redirect parameter to false indicates that the service should not redirect to the login page after logging out. (optional)
   */
  @RequestLine("GET /logoutservice?redirect={redirect}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> logoutWithHttpInfo(@Param("redirect") String redirect);


  /**
   * Logout the current user
   * Logout the current user from the system 
   * Note, this is equivalent to the other <code>logout</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link LogoutQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>redirect - Setting the redirect parameter to false indicates that the service should not redirect to the login page after logging out. (optional)</li>
   *   </ul>
   */
  @RequestLine("GET /logoutservice?redirect={redirect}")
  @Headers({
  "Accept: application/json",
  })
  void logout(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
  * Logout the current user
  * Logout the current user from the system 
  * Note, this is equivalent to the other <code>logout</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>redirect - Setting the redirect parameter to false indicates that the service should not redirect to the login page after logging out. (optional)</li>
      *   </ul>
      */
      @RequestLine("GET /logoutservice?redirect={redirect}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<Void> logoutWithHttpInfo(@QueryMap(encoded=true) Map<String, Object> queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>logout</code> method in a fluent style.
   */
  public static class LogoutQueryParams extends HashMap<String, Object> {
    public LogoutQueryParams redirect(final String value) {
      put("redirect", EncodingUtils.encode(value));
      return this;
    }
  }
}
