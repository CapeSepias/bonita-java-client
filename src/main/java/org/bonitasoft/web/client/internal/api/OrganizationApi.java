package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;

import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface OrganizationApi extends ApiClient.Api {


  /**
   * Import an organization
   * Import an organization 
   * @param organizationDataUpload Uploaded file (optional)
   * @param importPolicy Import policy (optional)
   */
  @RequestLine("POST /services/organization/import")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
  })
  void importOrganization(@Param("organizationDataUpload") String organizationDataUpload, @Param("importPolicy") String importPolicy);

  /**
   * Import an organization
   * Upload organization 
   * @param file  (optional)
   * @return String
   */
  @RequestLine("POST /portal/organizationUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  String uploadOrganization(@Param("file") File file);
}
