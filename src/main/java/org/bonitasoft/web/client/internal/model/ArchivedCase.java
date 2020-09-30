/*
 * Bonita 7.11 HTTP API
 *  The REST API lets you access the data with HTTP requests; it is useful when implementing rich web forms / pages for a good user experience.  If your application is using a technology other than Java, you can integrate it with the Bonita solution using the Web REST API. This API provides access to all Bonita objects (like processes, tasks, users, connectors etc.), to execute operations on them (create, retrieve, update, delete). You can use these operations to create a workflow with Bonita and integrate it into your application. The Bonita Engine remains responsible for executing the workflow logic (connectors, gateways with conditions, messages, timers etc.) while your application gives access to the workflow. Users can manage processes and tasks, and perform administrative activities.  ![diagram of architecture of a REST client integrated with Bonita](images/rest_overview_v2.png)  ### API Extensions  You can create [Rest API Extensions](rest-api-extensions.md) to extend the Rest API by adding missing ressources (not provided by the Rest API). It is possible for an extension to interact with the engine (via the API) or with any other external service (for example a database, a directory, or a web service).  ### Create a resource  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}/  `| | Request Method | POST| | Request Payload | an item in JSON| | Response | the same item in JSON, containing the values provided in the posted item, completed with default values and identifiers provided by Bonita Engine.|  ### Read a resource  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/user/5 `  #### Extend resource response  On some resources, in GET methods the `d` (deploy) URL query parameter can be used to extend the response objects. The value of this parameter consists of an attribute for which you want to make an extended request (called a deploy) and retrieve attributes of a linked resource. This means that instead of retrieving the ID or a parent or referenced resource, you can retrieve the full object.  For example, when you retrieve a task, you can also retrieve the process definition attributes in addition to the process definition ID that is already part of the task resource. The supported deploy values for a task include its process (d=processId).  Specifiy multiple `d` parameter to extend several resources. For instance, to retrieve the flow node of id 143 and the associated process, case and assigned user, call `/API/bpm/flowNode/143?d=processId&d=caseId&d=assigned_id`  #### With compound identifier  The order of the identifier parts for each resource type is given in the table above.  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/membership/5/12/24 `  ### Update a resource  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| | Request Method | PUT| | Request Payload | a map in JSON containing the new values for the attributes you want to change.| | Response | the corresponding item in JSON with new values where you requested a modification|  Example `http://.../API/identity/user/5`  #### With compound identifier:  Response: the corresponding item in JSON with new values where you requested a modification.  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| | Request Method | PUT| | Request Payload | ` a map in JSON containing the new values for the attributes you want to change `| | Response | ` the corresponding item in JSON with new values where you requested a modification`|  Example `http://.../API/identity/membership/5/12/24 `  ### Delete resources  Use the DELETE request to remove multiple resources.  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}/ `| | Request Method | DELETE| | Request Payload | A list of identifiers in JSON, for example `[\"id1\",\"id2\",\"id3\"]`. Compound identifiers are separated by '/' characters.| | Response | `empty `|  Example `http://.../API/identity/membership/ `  ### Search for a resource  The required object is specified with a set of filters in the request URL. The URL parameters must be URL-encoded.  Results are returned in a paged list, so you have to specify the page (counting from zero), and the number of results per page (count), additionally you can define a sort key (order). You can see the total number of matching results in the HTTP response header Content-Range. If you are searching for business data using a custom query, there must be a [count query in the BDM](define-and-deploy-the-bdm.md). If there is no count query, results from a custom query on business data cannot be paged properly (the header Content-Range will be absent). For business data default queries, the count query is defined automatically.  The available filters are the attributes of the item plus some specific filters defined by each item.  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}?p={page}&c={count}&o={order}&s={query}&f={filter_name}={filter_value}&f=... `| | Request Method | GET| | Response | an array of items in JSON|  Example `/API/identity/user?p=0&c=10&o=firstname&s=test&f=manager_id=3`  For a GET method that retrieves more than one instance of a resource, you can specify the following request parameters:  * p (Mandatory): index of the page to display * c (Mandatory): maximum number of elements to retrieve * o: order of presentation of values in response: must be either `attributeName ASC` or `attributeName DESC`. The final order parameter value must be URL encoded. * f: list of filters, specified as `attributeName=attributeValue`. To filter on more than one attribute, specify an f parameters for each attribute. The final filter parameter value must be URL encoded.   The attributes you can filter on are specific to the resource. * s: search on name or search indexes. The matching policy depends on the configuration of [word-based search](using-list-and-search-methods.md).   For example, if word-based search is enabled, `s=Valid` returns matches containing the string \"valid\" at the start of any word in the attribute value word,   such as \"Valid address\", \"Not a valid address\", and \"Validated request\" but not \"Invalid request\".   If word-based search is disabled, `s=Valid` returns matches containing the string \"valid\" at the start of the attribute value, such as \"Valid address\" or \"Validated request\" but not \"Not a valid address\" or \"Invalid request\".  ### Errors  The API uses standard HTTP status codes to indicate the success or failure of the API call.  If you get a `401` response code :   - make sure that the cookies have been transfered with the call   - make sure that the cookies transfered are the ones generated during the last sucessfull login call   - if one of the PUT, DELETE or POST method is used, make sure that the `X-Bonita-API-Token` header is included   - if the X-Bonita-API-Token header is included, make sure that the value is the same as the one of the cookie generated during the last login   - Maybe a logout was issued or the session has expired; try to log in again, and re run the request with the new cookies and the new value for the `X-Bonita-API-Token` header.
 *
 * The version of the OpenAPI document: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.bonitasoft.web.client.internal.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.bonitasoft.web.client.internal.model.ArchivedCaseAllOf;
import org.bonitasoft.web.client.internal.model.ModelCase;
import java.io.Serializable;

/**
 * ArchivedCase
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-09-30T18:19:33.829914+02:00[Europe/Paris]")
public class ArchivedCase implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_END_DATE = "end_date";
  @SerializedName(SERIALIZED_NAME_END_DATE)
  private String endDate;

  public static final String SERIALIZED_NAME_FAILED_FLOW_NODES = "failedFlowNodes";
  @SerializedName(SERIALIZED_NAME_FAILED_FLOW_NODES)
  private String failedFlowNodes;

  public static final String SERIALIZED_NAME_STARTED_BY_SUBSTITUTE = "startedBySubstitute";
  @SerializedName(SERIALIZED_NAME_STARTED_BY_SUBSTITUTE)
  private String startedBySubstitute;

  public static final String SERIALIZED_NAME_START = "start";
  @SerializedName(SERIALIZED_NAME_START)
  private String start;

  public static final String SERIALIZED_NAME_ACTIVE_FLOW_NODES = "activeFlowNodes";
  @SerializedName(SERIALIZED_NAME_ACTIVE_FLOW_NODES)
  private String activeFlowNodes;

  public static final String SERIALIZED_NAME_STATE = "state";
  @SerializedName(SERIALIZED_NAME_STATE)
  private String state;

  public static final String SERIALIZED_NAME_ROOT_CASE_ID = "rootCaseId";
  @SerializedName(SERIALIZED_NAME_ROOT_CASE_ID)
  private String rootCaseId;

  public static final String SERIALIZED_NAME_STARTED_BY = "started_by";
  @SerializedName(SERIALIZED_NAME_STARTED_BY)
  private String startedBy;

  public static final String SERIALIZED_NAME_PROCESS_DEFINITION_ID = "processDefinitionId";
  @SerializedName(SERIALIZED_NAME_PROCESS_DEFINITION_ID)
  private String processDefinitionId;

  public static final String SERIALIZED_NAME_LAST_UPDATE_DATE = "last_update_date";
  @SerializedName(SERIALIZED_NAME_LAST_UPDATE_DATE)
  private String lastUpdateDate;

  public static final String SERIALIZED_NAME_SEARCH_INDEX1_LABEL = "searchIndex1Label";
  @SerializedName(SERIALIZED_NAME_SEARCH_INDEX1_LABEL)
  private String searchIndex1Label;

  public static final String SERIALIZED_NAME_SEARCH_INDEX2_LABEL = "searchIndex2Label";
  @SerializedName(SERIALIZED_NAME_SEARCH_INDEX2_LABEL)
  private String searchIndex2Label;

  public static final String SERIALIZED_NAME_SEARCH_INDEX3_LABEL = "searchIndex3Label";
  @SerializedName(SERIALIZED_NAME_SEARCH_INDEX3_LABEL)
  private String searchIndex3Label;

  public static final String SERIALIZED_NAME_SEARCH_INDEX4_LABEL = "searchIndex4Label";
  @SerializedName(SERIALIZED_NAME_SEARCH_INDEX4_LABEL)
  private String searchIndex4Label;

  public static final String SERIALIZED_NAME_SEARCH_INDEX5_LABEL = "searchIndex5Label";
  @SerializedName(SERIALIZED_NAME_SEARCH_INDEX5_LABEL)
  private String searchIndex5Label;

  public static final String SERIALIZED_NAME_SEARCH_INDEX1_VALUE = "searchIndex1Value";
  @SerializedName(SERIALIZED_NAME_SEARCH_INDEX1_VALUE)
  private String searchIndex1Value;

  public static final String SERIALIZED_NAME_SEARCH_INDEX2_VALUE = "searchIndex2Value";
  @SerializedName(SERIALIZED_NAME_SEARCH_INDEX2_VALUE)
  private String searchIndex2Value;

  public static final String SERIALIZED_NAME_SEARCH_INDEX3_VALUE = "searchIndex3Value";
  @SerializedName(SERIALIZED_NAME_SEARCH_INDEX3_VALUE)
  private String searchIndex3Value;

  public static final String SERIALIZED_NAME_SEARCH_INDEX4_VALUE = "searchIndex4Value";
  @SerializedName(SERIALIZED_NAME_SEARCH_INDEX4_VALUE)
  private String searchIndex4Value;

  public static final String SERIALIZED_NAME_SEARCH_INDEX5_VALUE = "searchIndex5Value";
  @SerializedName(SERIALIZED_NAME_SEARCH_INDEX5_VALUE)
  private String searchIndex5Value;

  public static final String SERIALIZED_NAME_SOURCE_OBJECT_ID = "sourceObjectId";
  @SerializedName(SERIALIZED_NAME_SOURCE_OBJECT_ID)
  private String sourceObjectId;

  public static final String SERIALIZED_NAME_ARCHIVED_DATE = "archivedDate";
  @SerializedName(SERIALIZED_NAME_ARCHIVED_DATE)
  private String archivedDate;


  public ArchivedCase id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * the identifier of the case
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the identifier of the case")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public ArchivedCase endDate(String endDate) {
    
    this.endDate = endDate;
    return this;
  }

   /**
   * the date set when the case is closed
   * @return endDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the date set when the case is closed")

  public String getEndDate() {
    return endDate;
  }


  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }


  public ArchivedCase failedFlowNodes(String failedFlowNodes) {
    
    this.failedFlowNodes = failedFlowNodes;
    return this;
  }

   /**
   * count of failed flow nodes if parameter n&#x3D;failedFlowNodes is given
   * @return failedFlowNodes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "count of failed flow nodes if parameter n=failedFlowNodes is given")

  public String getFailedFlowNodes() {
    return failedFlowNodes;
  }


  public void setFailedFlowNodes(String failedFlowNodes) {
    this.failedFlowNodes = failedFlowNodes;
  }


  public ArchivedCase startedBySubstitute(String startedBySubstitute) {
    
    this.startedBySubstitute = startedBySubstitute;
    return this;
  }

   /**
   * the identifier of the substitute user (as Process manager or Administrator) who started the process. It can be also the substitute user if d&#x3D;startedBySubstitute is given.
   * @return startedBySubstitute
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the identifier of the substitute user (as Process manager or Administrator) who started the process. It can be also the substitute user if d=startedBySubstitute is given.")

  public String getStartedBySubstitute() {
    return startedBySubstitute;
  }


  public void setStartedBySubstitute(String startedBySubstitute) {
    this.startedBySubstitute = startedBySubstitute;
  }


  public ArchivedCase start(String start) {
    
    this.start = start;
    return this;
  }

   /**
   * the starting date of the case
   * @return start
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the starting date of the case")

  public String getStart() {
    return start;
  }


  public void setStart(String start) {
    this.start = start;
  }


  public ArchivedCase activeFlowNodes(String activeFlowNodes) {
    
    this.activeFlowNodes = activeFlowNodes;
    return this;
  }

   /**
   * count of active flow nodes if parameter n&#x3D;activeFlowNodes is given
   * @return activeFlowNodes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "count of active flow nodes if parameter n=activeFlowNodes is given")

  public String getActiveFlowNodes() {
    return activeFlowNodes;
  }


  public void setActiveFlowNodes(String activeFlowNodes) {
    this.activeFlowNodes = activeFlowNodes;
  }


  public ArchivedCase state(String state) {
    
    this.state = state;
    return this;
  }

   /**
   * state: an enum that represent the state of the case, it can be INITIALIZING, STARTED, SUSPENDED, CANCELLED, ABORTED, COMPLETING, COMPLETED, ERROR, ABORTING
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "state: an enum that represent the state of the case, it can be INITIALIZING, STARTED, SUSPENDED, CANCELLED, ABORTED, COMPLETING, COMPLETED, ERROR, ABORTING")

  public String getState() {
    return state;
  }


  public void setState(String state) {
    this.state = state;
  }


  public ArchivedCase rootCaseId(String rootCaseId) {
    
    this.rootCaseId = rootCaseId;
    return this;
  }

   /**
   * the identifier of the container of the case
   * @return rootCaseId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the identifier of the container of the case")

  public String getRootCaseId() {
    return rootCaseId;
  }


  public void setRootCaseId(String rootCaseId) {
    this.rootCaseId = rootCaseId;
  }


  public ArchivedCase startedBy(String startedBy) {
    
    this.startedBy = startedBy;
    return this;
  }

   /**
   * the identifier of the user who started the case
   * @return startedBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the identifier of the user who started the case")

  public String getStartedBy() {
    return startedBy;
  }


  public void setStartedBy(String startedBy) {
    this.startedBy = startedBy;
  }


  public ArchivedCase processDefinitionId(String processDefinitionId) {
    
    this.processDefinitionId = processDefinitionId;
    return this;
  }

   /**
   * the identifier of the process related of the case
   * @return processDefinitionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the identifier of the process related of the case")

  public String getProcessDefinitionId() {
    return processDefinitionId;
  }


  public void setProcessDefinitionId(String processDefinitionId) {
    this.processDefinitionId = processDefinitionId;
  }


  public ArchivedCase lastUpdateDate(String lastUpdateDate) {
    
    this.lastUpdateDate = lastUpdateDate;
    return this;
  }

   /**
   * the date of the last update done on the case
   * @return lastUpdateDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the date of the last update done on the case")

  public String getLastUpdateDate() {
    return lastUpdateDate;
  }


  public void setLastUpdateDate(String lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }


  public ArchivedCase searchIndex1Label(String searchIndex1Label) {
    
    this.searchIndex1Label = searchIndex1Label;
    return this;
  }

   /**
   * the 1st search index label (from 6.5, in Subscription editions only)
   * @return searchIndex1Label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the 1st search index label (from 6.5, in Subscription editions only)")

  public String getSearchIndex1Label() {
    return searchIndex1Label;
  }


  public void setSearchIndex1Label(String searchIndex1Label) {
    this.searchIndex1Label = searchIndex1Label;
  }


  public ArchivedCase searchIndex2Label(String searchIndex2Label) {
    
    this.searchIndex2Label = searchIndex2Label;
    return this;
  }

   /**
   * the 2nd search index label (from 6.5, in Subscription editions only)
   * @return searchIndex2Label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the 2nd search index label (from 6.5, in Subscription editions only)")

  public String getSearchIndex2Label() {
    return searchIndex2Label;
  }


  public void setSearchIndex2Label(String searchIndex2Label) {
    this.searchIndex2Label = searchIndex2Label;
  }


  public ArchivedCase searchIndex3Label(String searchIndex3Label) {
    
    this.searchIndex3Label = searchIndex3Label;
    return this;
  }

   /**
   * the 3rd search index label (from 6.5, in Subscription editions only)
   * @return searchIndex3Label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the 3rd search index label (from 6.5, in Subscription editions only)")

  public String getSearchIndex3Label() {
    return searchIndex3Label;
  }


  public void setSearchIndex3Label(String searchIndex3Label) {
    this.searchIndex3Label = searchIndex3Label;
  }


  public ArchivedCase searchIndex4Label(String searchIndex4Label) {
    
    this.searchIndex4Label = searchIndex4Label;
    return this;
  }

   /**
   * the 4th search index label (from 6.5, in Subscription editions only)
   * @return searchIndex4Label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the 4th search index label (from 6.5, in Subscription editions only)")

  public String getSearchIndex4Label() {
    return searchIndex4Label;
  }


  public void setSearchIndex4Label(String searchIndex4Label) {
    this.searchIndex4Label = searchIndex4Label;
  }


  public ArchivedCase searchIndex5Label(String searchIndex5Label) {
    
    this.searchIndex5Label = searchIndex5Label;
    return this;
  }

   /**
   * the 5th search index label (from 6.5, in Subscription editions only)
   * @return searchIndex5Label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the 5th search index label (from 6.5, in Subscription editions only)")

  public String getSearchIndex5Label() {
    return searchIndex5Label;
  }


  public void setSearchIndex5Label(String searchIndex5Label) {
    this.searchIndex5Label = searchIndex5Label;
  }


  public ArchivedCase searchIndex1Value(String searchIndex1Value) {
    
    this.searchIndex1Value = searchIndex1Value;
    return this;
  }

   /**
   * the 1st search index value (from 6.5, in Subscription editions only)
   * @return searchIndex1Value
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the 1st search index value (from 6.5, in Subscription editions only)")

  public String getSearchIndex1Value() {
    return searchIndex1Value;
  }


  public void setSearchIndex1Value(String searchIndex1Value) {
    this.searchIndex1Value = searchIndex1Value;
  }


  public ArchivedCase searchIndex2Value(String searchIndex2Value) {
    
    this.searchIndex2Value = searchIndex2Value;
    return this;
  }

   /**
   * the 2nd search index value (from 6.5, in Subscription editions only)
   * @return searchIndex2Value
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the 2nd search index value (from 6.5, in Subscription editions only)")

  public String getSearchIndex2Value() {
    return searchIndex2Value;
  }


  public void setSearchIndex2Value(String searchIndex2Value) {
    this.searchIndex2Value = searchIndex2Value;
  }


  public ArchivedCase searchIndex3Value(String searchIndex3Value) {
    
    this.searchIndex3Value = searchIndex3Value;
    return this;
  }

   /**
   * the 3rd search index value (from 6.5, in Subscription editions only)
   * @return searchIndex3Value
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the 3rd search index value (from 6.5, in Subscription editions only)")

  public String getSearchIndex3Value() {
    return searchIndex3Value;
  }


  public void setSearchIndex3Value(String searchIndex3Value) {
    this.searchIndex3Value = searchIndex3Value;
  }


  public ArchivedCase searchIndex4Value(String searchIndex4Value) {
    
    this.searchIndex4Value = searchIndex4Value;
    return this;
  }

   /**
   * the 4th search index value (from 6.5, in Subscription editions only)
   * @return searchIndex4Value
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the 4th search index value (from 6.5, in Subscription editions only)")

  public String getSearchIndex4Value() {
    return searchIndex4Value;
  }


  public void setSearchIndex4Value(String searchIndex4Value) {
    this.searchIndex4Value = searchIndex4Value;
  }


  public ArchivedCase searchIndex5Value(String searchIndex5Value) {
    
    this.searchIndex5Value = searchIndex5Value;
    return this;
  }

   /**
   * the 5th search index value (from 6.5, in Subscription editions only)
   * @return searchIndex5Value
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the 5th search index value (from 6.5, in Subscription editions only)")

  public String getSearchIndex5Value() {
    return searchIndex5Value;
  }


  public void setSearchIndex5Value(String searchIndex5Value) {
    this.searchIndex5Value = searchIndex5Value;
  }


  public ArchivedCase sourceObjectId(String sourceObjectId) {
    
    this.sourceObjectId = sourceObjectId;
    return this;
  }

   /**
   * the id of the case before it was archived
   * @return sourceObjectId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the id of the case before it was archived")

  public String getSourceObjectId() {
    return sourceObjectId;
  }


  public void setSourceObjectId(String sourceObjectId) {
    this.sourceObjectId = sourceObjectId;
  }


  public ArchivedCase archivedDate(String archivedDate) {
    
    this.archivedDate = archivedDate;
    return this;
  }

   /**
   * the date set when the case was archived
   * @return archivedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the date set when the case was archived")

  public String getArchivedDate() {
    return archivedDate;
  }


  public void setArchivedDate(String archivedDate) {
    this.archivedDate = archivedDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArchivedCase archivedCase = (ArchivedCase) o;
    return Objects.equals(this.id, archivedCase.id) &&
        Objects.equals(this.endDate, archivedCase.endDate) &&
        Objects.equals(this.failedFlowNodes, archivedCase.failedFlowNodes) &&
        Objects.equals(this.startedBySubstitute, archivedCase.startedBySubstitute) &&
        Objects.equals(this.start, archivedCase.start) &&
        Objects.equals(this.activeFlowNodes, archivedCase.activeFlowNodes) &&
        Objects.equals(this.state, archivedCase.state) &&
        Objects.equals(this.rootCaseId, archivedCase.rootCaseId) &&
        Objects.equals(this.startedBy, archivedCase.startedBy) &&
        Objects.equals(this.processDefinitionId, archivedCase.processDefinitionId) &&
        Objects.equals(this.lastUpdateDate, archivedCase.lastUpdateDate) &&
        Objects.equals(this.searchIndex1Label, archivedCase.searchIndex1Label) &&
        Objects.equals(this.searchIndex2Label, archivedCase.searchIndex2Label) &&
        Objects.equals(this.searchIndex3Label, archivedCase.searchIndex3Label) &&
        Objects.equals(this.searchIndex4Label, archivedCase.searchIndex4Label) &&
        Objects.equals(this.searchIndex5Label, archivedCase.searchIndex5Label) &&
        Objects.equals(this.searchIndex1Value, archivedCase.searchIndex1Value) &&
        Objects.equals(this.searchIndex2Value, archivedCase.searchIndex2Value) &&
        Objects.equals(this.searchIndex3Value, archivedCase.searchIndex3Value) &&
        Objects.equals(this.searchIndex4Value, archivedCase.searchIndex4Value) &&
        Objects.equals(this.searchIndex5Value, archivedCase.searchIndex5Value) &&
        Objects.equals(this.sourceObjectId, archivedCase.sourceObjectId) &&
        Objects.equals(this.archivedDate, archivedCase.archivedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, endDate, failedFlowNodes, startedBySubstitute, start, activeFlowNodes, state, rootCaseId, startedBy, processDefinitionId, lastUpdateDate, searchIndex1Label, searchIndex2Label, searchIndex3Label, searchIndex4Label, searchIndex5Label, searchIndex1Value, searchIndex2Value, searchIndex3Value, searchIndex4Value, searchIndex5Value, sourceObjectId, archivedDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArchivedCase {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    failedFlowNodes: ").append(toIndentedString(failedFlowNodes)).append("\n");
    sb.append("    startedBySubstitute: ").append(toIndentedString(startedBySubstitute)).append("\n");
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    activeFlowNodes: ").append(toIndentedString(activeFlowNodes)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    rootCaseId: ").append(toIndentedString(rootCaseId)).append("\n");
    sb.append("    startedBy: ").append(toIndentedString(startedBy)).append("\n");
    sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
    sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
    sb.append("    searchIndex1Label: ").append(toIndentedString(searchIndex1Label)).append("\n");
    sb.append("    searchIndex2Label: ").append(toIndentedString(searchIndex2Label)).append("\n");
    sb.append("    searchIndex3Label: ").append(toIndentedString(searchIndex3Label)).append("\n");
    sb.append("    searchIndex4Label: ").append(toIndentedString(searchIndex4Label)).append("\n");
    sb.append("    searchIndex5Label: ").append(toIndentedString(searchIndex5Label)).append("\n");
    sb.append("    searchIndex1Value: ").append(toIndentedString(searchIndex1Value)).append("\n");
    sb.append("    searchIndex2Value: ").append(toIndentedString(searchIndex2Value)).append("\n");
    sb.append("    searchIndex3Value: ").append(toIndentedString(searchIndex3Value)).append("\n");
    sb.append("    searchIndex4Value: ").append(toIndentedString(searchIndex4Value)).append("\n");
    sb.append("    searchIndex5Value: ").append(toIndentedString(searchIndex5Value)).append("\n");
    sb.append("    sourceObjectId: ").append(toIndentedString(sourceObjectId)).append("\n");
    sb.append("    archivedDate: ").append(toIndentedString(archivedDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

