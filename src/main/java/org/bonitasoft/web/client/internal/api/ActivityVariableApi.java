package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;

import org.bonitasoft.web.client.internal.model.ActivityVariable;
import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface ActivityVariableApi extends ApiClient.Api {


  /**
   * Finds the ActivityVariable by ID
   * Returns the single ActivityVariable for the given ID 
   * @param id The identifier of the activity from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @return ActivityVariable
   */
  @RequestLine("GET /API/bpm/activityVariable/{id}/{variableName}")
  @Headers({
    "Accept: application/json",
  })
  ActivityVariable getActivityVariableById(@Param("id") String id, @Param("variableName") String variableName);
}
