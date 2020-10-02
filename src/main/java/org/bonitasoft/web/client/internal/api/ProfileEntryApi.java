package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ProfileEntry;
import org.bonitasoft.web.client.internal.model.ProfileEntryCreateRequest;
import org.bonitasoft.web.client.internal.model.ProfileEntryUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface ProfileEntryApi extends ApiClient.Api {


  /**
   * Create the ProfileEntry
   * Create the ProfileEntry 
   * @param body Partial ProfileEntry description (required)
   * @return ProfileEntry
   */
  @RequestLine("POST /API/portal/profileEntry")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ProfileEntry createProfileEntry(ProfileEntryCreateRequest body);

  /**
   * Delete the ProfileEntry by ID
   * Delete the single ProfileEntry for the given ID 
   * @param id ID of the ProfileEntry to delete (required)
   */
  @RequestLine("DELETE /API/portal/profileEntry/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteProfileEntryById(@Param("id") String id);

  /**
   * Finds ProfileEntries
   * Finds ProfileEntries with pagination params and filters  - can search on &#x60;name&#x60; - can filter on &#x60;page&#x60;,&#x60;name&#x60; and &#x60;parent_id&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;ProfileEntry&gt;
   */
  @RequestLine("GET /API/portal/profileEntry?p={p}&c={c}&f={f}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<ProfileEntry> findProfileEntries(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("s") String s);

  /**
   * Finds ProfileEntries
   * Finds ProfileEntries with pagination params and filters  - can search on &#x60;name&#x60; - can filter on &#x60;page&#x60;,&#x60;name&#x60; and &#x60;parent_id&#x60; 
   * Note, this is equivalent to the other <code>findProfileEntries</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindProfileEntriesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>s - can search on attributes (optional)</li>
   *   </ul>
   * @return List&lt;ProfileEntry&gt;
   */
  @RequestLine("GET /API/portal/profileEntry?p={p}&c={c}&f={f}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<ProfileEntry> findProfileEntries(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findProfileEntries</code> method in a fluent style.
   */
  public static class FindProfileEntriesQueryParams extends HashMap<String, Object> {
    public FindProfileEntriesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindProfileEntriesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindProfileEntriesQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public FindProfileEntriesQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds the ProfileEntry by ID
   * Returns the single ProfileEntry for the given ID 
   * @param id ID of the ProfileEntry to return (required)
   * @return ProfileEntry
   */
  @RequestLine("GET /API/portal/profileEntry/{id}")
  @Headers({
    "Accept: application/json",
  })
  ProfileEntry getProfileEntryById(@Param("id") String id);

  /**
   * Update the ProfileEntry by ID
   * Update the ProfileEntry for the given ID 
   * @param id ID of the ProfileEntry to return (required)
   * @param profileEntryUpdateRequest Partial ProfileEntry description (required)
   */
  @RequestLine("PUT /API/portal/profileEntry/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateProfileEntryById(@Param("id") String id, ProfileEntryUpdateRequest profileEntryUpdateRequest);
}
