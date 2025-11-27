package com.ridehub.msnotification.client.api;

import com.ridehub.msnotification.client.invoker.ApiClient;
import com.ridehub.msnotification.client.invoker.EncodingUtils;
import com.ridehub.msnotification.client.model.ApiResponse;

import com.ridehub.msnotification.client.model.NotificationDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface NotificationResourceMsnotificationApi extends ApiClient.Api {


  /**
   * 
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param recipientIdEquals  (optional)
   * @param recipientIdNotEquals  (optional)
   * @param recipientIdSpecified  (optional)
   * @param recipientIdIn  (optional)
   * @param recipientIdNotIn  (optional)
   * @param typeContains  (optional)
   * @param typeDoesNotContain  (optional)
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
   * @param titleContains  (optional)
   * @param titleDoesNotContain  (optional)
   * @param titleEquals  (optional)
   * @param titleNotEquals  (optional)
   * @param titleSpecified  (optional)
   * @param titleIn  (optional)
   * @param titleNotIn  (optional)
   * @param isReadEquals  (optional)
   * @param isReadNotEquals  (optional)
   * @param isReadSpecified  (optional)
   * @param isReadIn  (optional)
   * @param isReadNotIn  (optional)
   * @param relatedEntityTypeContains  (optional)
   * @param relatedEntityTypeDoesNotContain  (optional)
   * @param relatedEntityTypeEquals  (optional)
   * @param relatedEntityTypeNotEquals  (optional)
   * @param relatedEntityTypeSpecified  (optional)
   * @param relatedEntityTypeIn  (optional)
   * @param relatedEntityTypeNotIn  (optional)
   * @param relatedEntityIdEquals  (optional)
   * @param relatedEntityIdNotEquals  (optional)
   * @param relatedEntityIdSpecified  (optional)
   * @param relatedEntityIdIn  (optional)
   * @param relatedEntityIdNotIn  (optional)
   * @param createdAtGreaterThan  (optional)
   * @param createdAtLessThan  (optional)
   * @param createdAtGreaterThanOrEqual  (optional)
   * @param createdAtLessThanOrEqual  (optional)
   * @param createdAtEquals  (optional)
   * @param createdAtNotEquals  (optional)
   * @param createdAtSpecified  (optional)
   * @param createdAtIn  (optional)
   * @param createdAtNotIn  (optional)
   * @param scheduledAtGreaterThan  (optional)
   * @param scheduledAtLessThan  (optional)
   * @param scheduledAtGreaterThanOrEqual  (optional)
   * @param scheduledAtLessThanOrEqual  (optional)
   * @param scheduledAtEquals  (optional)
   * @param scheduledAtNotEquals  (optional)
   * @param scheduledAtSpecified  (optional)
   * @param scheduledAtIn  (optional)
   * @param scheduledAtNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/notifications/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&recipientId.equals={recipientIdEquals}&recipientId.notEquals={recipientIdNotEquals}&recipientId.specified={recipientIdSpecified}&recipientId.in={recipientIdIn}&recipientId.notIn={recipientIdNotIn}&type.contains={typeContains}&type.doesNotContain={typeDoesNotContain}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&title.contains={titleContains}&title.doesNotContain={titleDoesNotContain}&title.equals={titleEquals}&title.notEquals={titleNotEquals}&title.specified={titleSpecified}&title.in={titleIn}&title.notIn={titleNotIn}&isRead.equals={isReadEquals}&isRead.notEquals={isReadNotEquals}&isRead.specified={isReadSpecified}&isRead.in={isReadIn}&isRead.notIn={isReadNotIn}&relatedEntityType.contains={relatedEntityTypeContains}&relatedEntityType.doesNotContain={relatedEntityTypeDoesNotContain}&relatedEntityType.equals={relatedEntityTypeEquals}&relatedEntityType.notEquals={relatedEntityTypeNotEquals}&relatedEntityType.specified={relatedEntityTypeSpecified}&relatedEntityType.in={relatedEntityTypeIn}&relatedEntityType.notIn={relatedEntityTypeNotIn}&relatedEntityId.equals={relatedEntityIdEquals}&relatedEntityId.notEquals={relatedEntityIdNotEquals}&relatedEntityId.specified={relatedEntityIdSpecified}&relatedEntityId.in={relatedEntityIdIn}&relatedEntityId.notIn={relatedEntityIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&scheduledAt.greaterThan={scheduledAtGreaterThan}&scheduledAt.lessThan={scheduledAtLessThan}&scheduledAt.greaterThanOrEqual={scheduledAtGreaterThanOrEqual}&scheduledAt.lessThanOrEqual={scheduledAtLessThanOrEqual}&scheduledAt.equals={scheduledAtEquals}&scheduledAt.notEquals={scheduledAtNotEquals}&scheduledAt.specified={scheduledAtSpecified}&scheduledAt.in={scheduledAtIn}&scheduledAt.notIn={scheduledAtNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countNotifications(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("recipientIdEquals") @jakarta.annotation.Nullable UUID recipientIdEquals, @Param("recipientIdNotEquals") @jakarta.annotation.Nullable UUID recipientIdNotEquals, @Param("recipientIdSpecified") @jakarta.annotation.Nullable Boolean recipientIdSpecified, @Param("recipientIdIn") @jakarta.annotation.Nullable List<UUID> recipientIdIn, @Param("recipientIdNotIn") @jakarta.annotation.Nullable List<UUID> recipientIdNotIn, @Param("typeContains") @jakarta.annotation.Nullable String typeContains, @Param("typeDoesNotContain") @jakarta.annotation.Nullable String typeDoesNotContain, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("titleContains") @jakarta.annotation.Nullable String titleContains, @Param("titleDoesNotContain") @jakarta.annotation.Nullable String titleDoesNotContain, @Param("titleEquals") @jakarta.annotation.Nullable String titleEquals, @Param("titleNotEquals") @jakarta.annotation.Nullable String titleNotEquals, @Param("titleSpecified") @jakarta.annotation.Nullable Boolean titleSpecified, @Param("titleIn") @jakarta.annotation.Nullable List<String> titleIn, @Param("titleNotIn") @jakarta.annotation.Nullable List<String> titleNotIn, @Param("isReadEquals") @jakarta.annotation.Nullable Boolean isReadEquals, @Param("isReadNotEquals") @jakarta.annotation.Nullable Boolean isReadNotEquals, @Param("isReadSpecified") @jakarta.annotation.Nullable Boolean isReadSpecified, @Param("isReadIn") @jakarta.annotation.Nullable List<Boolean> isReadIn, @Param("isReadNotIn") @jakarta.annotation.Nullable List<Boolean> isReadNotIn, @Param("relatedEntityTypeContains") @jakarta.annotation.Nullable String relatedEntityTypeContains, @Param("relatedEntityTypeDoesNotContain") @jakarta.annotation.Nullable String relatedEntityTypeDoesNotContain, @Param("relatedEntityTypeEquals") @jakarta.annotation.Nullable String relatedEntityTypeEquals, @Param("relatedEntityTypeNotEquals") @jakarta.annotation.Nullable String relatedEntityTypeNotEquals, @Param("relatedEntityTypeSpecified") @jakarta.annotation.Nullable Boolean relatedEntityTypeSpecified, @Param("relatedEntityTypeIn") @jakarta.annotation.Nullable List<String> relatedEntityTypeIn, @Param("relatedEntityTypeNotIn") @jakarta.annotation.Nullable List<String> relatedEntityTypeNotIn, @Param("relatedEntityIdEquals") @jakarta.annotation.Nullable UUID relatedEntityIdEquals, @Param("relatedEntityIdNotEquals") @jakarta.annotation.Nullable UUID relatedEntityIdNotEquals, @Param("relatedEntityIdSpecified") @jakarta.annotation.Nullable Boolean relatedEntityIdSpecified, @Param("relatedEntityIdIn") @jakarta.annotation.Nullable List<UUID> relatedEntityIdIn, @Param("relatedEntityIdNotIn") @jakarta.annotation.Nullable List<UUID> relatedEntityIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("scheduledAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime scheduledAtGreaterThan, @Param("scheduledAtLessThan") @jakarta.annotation.Nullable OffsetDateTime scheduledAtLessThan, @Param("scheduledAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime scheduledAtGreaterThanOrEqual, @Param("scheduledAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime scheduledAtLessThanOrEqual, @Param("scheduledAtEquals") @jakarta.annotation.Nullable OffsetDateTime scheduledAtEquals, @Param("scheduledAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime scheduledAtNotEquals, @Param("scheduledAtSpecified") @jakarta.annotation.Nullable Boolean scheduledAtSpecified, @Param("scheduledAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> scheduledAtIn, @Param("scheduledAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> scheduledAtNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countNotifications</code> but it also returns the http response headers .
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param recipientIdEquals  (optional)
   * @param recipientIdNotEquals  (optional)
   * @param recipientIdSpecified  (optional)
   * @param recipientIdIn  (optional)
   * @param recipientIdNotIn  (optional)
   * @param typeContains  (optional)
   * @param typeDoesNotContain  (optional)
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
   * @param titleContains  (optional)
   * @param titleDoesNotContain  (optional)
   * @param titleEquals  (optional)
   * @param titleNotEquals  (optional)
   * @param titleSpecified  (optional)
   * @param titleIn  (optional)
   * @param titleNotIn  (optional)
   * @param isReadEquals  (optional)
   * @param isReadNotEquals  (optional)
   * @param isReadSpecified  (optional)
   * @param isReadIn  (optional)
   * @param isReadNotIn  (optional)
   * @param relatedEntityTypeContains  (optional)
   * @param relatedEntityTypeDoesNotContain  (optional)
   * @param relatedEntityTypeEquals  (optional)
   * @param relatedEntityTypeNotEquals  (optional)
   * @param relatedEntityTypeSpecified  (optional)
   * @param relatedEntityTypeIn  (optional)
   * @param relatedEntityTypeNotIn  (optional)
   * @param relatedEntityIdEquals  (optional)
   * @param relatedEntityIdNotEquals  (optional)
   * @param relatedEntityIdSpecified  (optional)
   * @param relatedEntityIdIn  (optional)
   * @param relatedEntityIdNotIn  (optional)
   * @param createdAtGreaterThan  (optional)
   * @param createdAtLessThan  (optional)
   * @param createdAtGreaterThanOrEqual  (optional)
   * @param createdAtLessThanOrEqual  (optional)
   * @param createdAtEquals  (optional)
   * @param createdAtNotEquals  (optional)
   * @param createdAtSpecified  (optional)
   * @param createdAtIn  (optional)
   * @param createdAtNotIn  (optional)
   * @param scheduledAtGreaterThan  (optional)
   * @param scheduledAtLessThan  (optional)
   * @param scheduledAtGreaterThanOrEqual  (optional)
   * @param scheduledAtLessThanOrEqual  (optional)
   * @param scheduledAtEquals  (optional)
   * @param scheduledAtNotEquals  (optional)
   * @param scheduledAtSpecified  (optional)
   * @param scheduledAtIn  (optional)
   * @param scheduledAtNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/notifications/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&recipientId.equals={recipientIdEquals}&recipientId.notEquals={recipientIdNotEquals}&recipientId.specified={recipientIdSpecified}&recipientId.in={recipientIdIn}&recipientId.notIn={recipientIdNotIn}&type.contains={typeContains}&type.doesNotContain={typeDoesNotContain}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&title.contains={titleContains}&title.doesNotContain={titleDoesNotContain}&title.equals={titleEquals}&title.notEquals={titleNotEquals}&title.specified={titleSpecified}&title.in={titleIn}&title.notIn={titleNotIn}&isRead.equals={isReadEquals}&isRead.notEquals={isReadNotEquals}&isRead.specified={isReadSpecified}&isRead.in={isReadIn}&isRead.notIn={isReadNotIn}&relatedEntityType.contains={relatedEntityTypeContains}&relatedEntityType.doesNotContain={relatedEntityTypeDoesNotContain}&relatedEntityType.equals={relatedEntityTypeEquals}&relatedEntityType.notEquals={relatedEntityTypeNotEquals}&relatedEntityType.specified={relatedEntityTypeSpecified}&relatedEntityType.in={relatedEntityTypeIn}&relatedEntityType.notIn={relatedEntityTypeNotIn}&relatedEntityId.equals={relatedEntityIdEquals}&relatedEntityId.notEquals={relatedEntityIdNotEquals}&relatedEntityId.specified={relatedEntityIdSpecified}&relatedEntityId.in={relatedEntityIdIn}&relatedEntityId.notIn={relatedEntityIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&scheduledAt.greaterThan={scheduledAtGreaterThan}&scheduledAt.lessThan={scheduledAtLessThan}&scheduledAt.greaterThanOrEqual={scheduledAtGreaterThanOrEqual}&scheduledAt.lessThanOrEqual={scheduledAtLessThanOrEqual}&scheduledAt.equals={scheduledAtEquals}&scheduledAt.notEquals={scheduledAtNotEquals}&scheduledAt.specified={scheduledAtSpecified}&scheduledAt.in={scheduledAtIn}&scheduledAt.notIn={scheduledAtNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countNotificationsWithHttpInfo(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("recipientIdEquals") @jakarta.annotation.Nullable UUID recipientIdEquals, @Param("recipientIdNotEquals") @jakarta.annotation.Nullable UUID recipientIdNotEquals, @Param("recipientIdSpecified") @jakarta.annotation.Nullable Boolean recipientIdSpecified, @Param("recipientIdIn") @jakarta.annotation.Nullable List<UUID> recipientIdIn, @Param("recipientIdNotIn") @jakarta.annotation.Nullable List<UUID> recipientIdNotIn, @Param("typeContains") @jakarta.annotation.Nullable String typeContains, @Param("typeDoesNotContain") @jakarta.annotation.Nullable String typeDoesNotContain, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("titleContains") @jakarta.annotation.Nullable String titleContains, @Param("titleDoesNotContain") @jakarta.annotation.Nullable String titleDoesNotContain, @Param("titleEquals") @jakarta.annotation.Nullable String titleEquals, @Param("titleNotEquals") @jakarta.annotation.Nullable String titleNotEquals, @Param("titleSpecified") @jakarta.annotation.Nullable Boolean titleSpecified, @Param("titleIn") @jakarta.annotation.Nullable List<String> titleIn, @Param("titleNotIn") @jakarta.annotation.Nullable List<String> titleNotIn, @Param("isReadEquals") @jakarta.annotation.Nullable Boolean isReadEquals, @Param("isReadNotEquals") @jakarta.annotation.Nullable Boolean isReadNotEquals, @Param("isReadSpecified") @jakarta.annotation.Nullable Boolean isReadSpecified, @Param("isReadIn") @jakarta.annotation.Nullable List<Boolean> isReadIn, @Param("isReadNotIn") @jakarta.annotation.Nullable List<Boolean> isReadNotIn, @Param("relatedEntityTypeContains") @jakarta.annotation.Nullable String relatedEntityTypeContains, @Param("relatedEntityTypeDoesNotContain") @jakarta.annotation.Nullable String relatedEntityTypeDoesNotContain, @Param("relatedEntityTypeEquals") @jakarta.annotation.Nullable String relatedEntityTypeEquals, @Param("relatedEntityTypeNotEquals") @jakarta.annotation.Nullable String relatedEntityTypeNotEquals, @Param("relatedEntityTypeSpecified") @jakarta.annotation.Nullable Boolean relatedEntityTypeSpecified, @Param("relatedEntityTypeIn") @jakarta.annotation.Nullable List<String> relatedEntityTypeIn, @Param("relatedEntityTypeNotIn") @jakarta.annotation.Nullable List<String> relatedEntityTypeNotIn, @Param("relatedEntityIdEquals") @jakarta.annotation.Nullable UUID relatedEntityIdEquals, @Param("relatedEntityIdNotEquals") @jakarta.annotation.Nullable UUID relatedEntityIdNotEquals, @Param("relatedEntityIdSpecified") @jakarta.annotation.Nullable Boolean relatedEntityIdSpecified, @Param("relatedEntityIdIn") @jakarta.annotation.Nullable List<UUID> relatedEntityIdIn, @Param("relatedEntityIdNotIn") @jakarta.annotation.Nullable List<UUID> relatedEntityIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("scheduledAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime scheduledAtGreaterThan, @Param("scheduledAtLessThan") @jakarta.annotation.Nullable OffsetDateTime scheduledAtLessThan, @Param("scheduledAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime scheduledAtGreaterThanOrEqual, @Param("scheduledAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime scheduledAtLessThanOrEqual, @Param("scheduledAtEquals") @jakarta.annotation.Nullable OffsetDateTime scheduledAtEquals, @Param("scheduledAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime scheduledAtNotEquals, @Param("scheduledAtSpecified") @jakarta.annotation.Nullable Boolean scheduledAtSpecified, @Param("scheduledAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> scheduledAtIn, @Param("scheduledAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> scheduledAtNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countNotifications</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountNotificationsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>idEquals -  (optional)</li>
   *   <li>idNotEquals -  (optional)</li>
   *   <li>idSpecified -  (optional)</li>
   *   <li>idIn -  (optional)</li>
   *   <li>idNotIn -  (optional)</li>
   *   <li>recipientIdEquals -  (optional)</li>
   *   <li>recipientIdNotEquals -  (optional)</li>
   *   <li>recipientIdSpecified -  (optional)</li>
   *   <li>recipientIdIn -  (optional)</li>
   *   <li>recipientIdNotIn -  (optional)</li>
   *   <li>typeContains -  (optional)</li>
   *   <li>typeDoesNotContain -  (optional)</li>
   *   <li>typeEquals -  (optional)</li>
   *   <li>typeNotEquals -  (optional)</li>
   *   <li>typeSpecified -  (optional)</li>
   *   <li>typeIn -  (optional)</li>
   *   <li>typeNotIn -  (optional)</li>
   *   <li>titleContains -  (optional)</li>
   *   <li>titleDoesNotContain -  (optional)</li>
   *   <li>titleEquals -  (optional)</li>
   *   <li>titleNotEquals -  (optional)</li>
   *   <li>titleSpecified -  (optional)</li>
   *   <li>titleIn -  (optional)</li>
   *   <li>titleNotIn -  (optional)</li>
   *   <li>isReadEquals -  (optional)</li>
   *   <li>isReadNotEquals -  (optional)</li>
   *   <li>isReadSpecified -  (optional)</li>
   *   <li>isReadIn -  (optional)</li>
   *   <li>isReadNotIn -  (optional)</li>
   *   <li>relatedEntityTypeContains -  (optional)</li>
   *   <li>relatedEntityTypeDoesNotContain -  (optional)</li>
   *   <li>relatedEntityTypeEquals -  (optional)</li>
   *   <li>relatedEntityTypeNotEquals -  (optional)</li>
   *   <li>relatedEntityTypeSpecified -  (optional)</li>
   *   <li>relatedEntityTypeIn -  (optional)</li>
   *   <li>relatedEntityTypeNotIn -  (optional)</li>
   *   <li>relatedEntityIdEquals -  (optional)</li>
   *   <li>relatedEntityIdNotEquals -  (optional)</li>
   *   <li>relatedEntityIdSpecified -  (optional)</li>
   *   <li>relatedEntityIdIn -  (optional)</li>
   *   <li>relatedEntityIdNotIn -  (optional)</li>
   *   <li>createdAtGreaterThan -  (optional)</li>
   *   <li>createdAtLessThan -  (optional)</li>
   *   <li>createdAtGreaterThanOrEqual -  (optional)</li>
   *   <li>createdAtLessThanOrEqual -  (optional)</li>
   *   <li>createdAtEquals -  (optional)</li>
   *   <li>createdAtNotEquals -  (optional)</li>
   *   <li>createdAtSpecified -  (optional)</li>
   *   <li>createdAtIn -  (optional)</li>
   *   <li>createdAtNotIn -  (optional)</li>
   *   <li>scheduledAtGreaterThan -  (optional)</li>
   *   <li>scheduledAtLessThan -  (optional)</li>
   *   <li>scheduledAtGreaterThanOrEqual -  (optional)</li>
   *   <li>scheduledAtLessThanOrEqual -  (optional)</li>
   *   <li>scheduledAtEquals -  (optional)</li>
   *   <li>scheduledAtNotEquals -  (optional)</li>
   *   <li>scheduledAtSpecified -  (optional)</li>
   *   <li>scheduledAtIn -  (optional)</li>
   *   <li>scheduledAtNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/notifications/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&recipientId.equals={recipientIdEquals}&recipientId.notEquals={recipientIdNotEquals}&recipientId.specified={recipientIdSpecified}&recipientId.in={recipientIdIn}&recipientId.notIn={recipientIdNotIn}&type.contains={typeContains}&type.doesNotContain={typeDoesNotContain}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&title.contains={titleContains}&title.doesNotContain={titleDoesNotContain}&title.equals={titleEquals}&title.notEquals={titleNotEquals}&title.specified={titleSpecified}&title.in={titleIn}&title.notIn={titleNotIn}&isRead.equals={isReadEquals}&isRead.notEquals={isReadNotEquals}&isRead.specified={isReadSpecified}&isRead.in={isReadIn}&isRead.notIn={isReadNotIn}&relatedEntityType.contains={relatedEntityTypeContains}&relatedEntityType.doesNotContain={relatedEntityTypeDoesNotContain}&relatedEntityType.equals={relatedEntityTypeEquals}&relatedEntityType.notEquals={relatedEntityTypeNotEquals}&relatedEntityType.specified={relatedEntityTypeSpecified}&relatedEntityType.in={relatedEntityTypeIn}&relatedEntityType.notIn={relatedEntityTypeNotIn}&relatedEntityId.equals={relatedEntityIdEquals}&relatedEntityId.notEquals={relatedEntityIdNotEquals}&relatedEntityId.specified={relatedEntityIdSpecified}&relatedEntityId.in={relatedEntityIdIn}&relatedEntityId.notIn={relatedEntityIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&scheduledAt.greaterThan={scheduledAtGreaterThan}&scheduledAt.lessThan={scheduledAtLessThan}&scheduledAt.greaterThanOrEqual={scheduledAtGreaterThanOrEqual}&scheduledAt.lessThanOrEqual={scheduledAtLessThanOrEqual}&scheduledAt.equals={scheduledAtEquals}&scheduledAt.notEquals={scheduledAtNotEquals}&scheduledAt.specified={scheduledAtSpecified}&scheduledAt.in={scheduledAtIn}&scheduledAt.notIn={scheduledAtNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countNotifications(@QueryMap(encoded=true) CountNotificationsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countNotifications</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>idEquals -  (optional)</li>
          *   <li>idNotEquals -  (optional)</li>
          *   <li>idSpecified -  (optional)</li>
          *   <li>idIn -  (optional)</li>
          *   <li>idNotIn -  (optional)</li>
          *   <li>recipientIdEquals -  (optional)</li>
          *   <li>recipientIdNotEquals -  (optional)</li>
          *   <li>recipientIdSpecified -  (optional)</li>
          *   <li>recipientIdIn -  (optional)</li>
          *   <li>recipientIdNotIn -  (optional)</li>
          *   <li>typeContains -  (optional)</li>
          *   <li>typeDoesNotContain -  (optional)</li>
          *   <li>typeEquals -  (optional)</li>
          *   <li>typeNotEquals -  (optional)</li>
          *   <li>typeSpecified -  (optional)</li>
          *   <li>typeIn -  (optional)</li>
          *   <li>typeNotIn -  (optional)</li>
          *   <li>titleContains -  (optional)</li>
          *   <li>titleDoesNotContain -  (optional)</li>
          *   <li>titleEquals -  (optional)</li>
          *   <li>titleNotEquals -  (optional)</li>
          *   <li>titleSpecified -  (optional)</li>
          *   <li>titleIn -  (optional)</li>
          *   <li>titleNotIn -  (optional)</li>
          *   <li>isReadEquals -  (optional)</li>
          *   <li>isReadNotEquals -  (optional)</li>
          *   <li>isReadSpecified -  (optional)</li>
          *   <li>isReadIn -  (optional)</li>
          *   <li>isReadNotIn -  (optional)</li>
          *   <li>relatedEntityTypeContains -  (optional)</li>
          *   <li>relatedEntityTypeDoesNotContain -  (optional)</li>
          *   <li>relatedEntityTypeEquals -  (optional)</li>
          *   <li>relatedEntityTypeNotEquals -  (optional)</li>
          *   <li>relatedEntityTypeSpecified -  (optional)</li>
          *   <li>relatedEntityTypeIn -  (optional)</li>
          *   <li>relatedEntityTypeNotIn -  (optional)</li>
          *   <li>relatedEntityIdEquals -  (optional)</li>
          *   <li>relatedEntityIdNotEquals -  (optional)</li>
          *   <li>relatedEntityIdSpecified -  (optional)</li>
          *   <li>relatedEntityIdIn -  (optional)</li>
          *   <li>relatedEntityIdNotIn -  (optional)</li>
          *   <li>createdAtGreaterThan -  (optional)</li>
          *   <li>createdAtLessThan -  (optional)</li>
          *   <li>createdAtGreaterThanOrEqual -  (optional)</li>
          *   <li>createdAtLessThanOrEqual -  (optional)</li>
          *   <li>createdAtEquals -  (optional)</li>
          *   <li>createdAtNotEquals -  (optional)</li>
          *   <li>createdAtSpecified -  (optional)</li>
          *   <li>createdAtIn -  (optional)</li>
          *   <li>createdAtNotIn -  (optional)</li>
          *   <li>scheduledAtGreaterThan -  (optional)</li>
          *   <li>scheduledAtLessThan -  (optional)</li>
          *   <li>scheduledAtGreaterThanOrEqual -  (optional)</li>
          *   <li>scheduledAtLessThanOrEqual -  (optional)</li>
          *   <li>scheduledAtEquals -  (optional)</li>
          *   <li>scheduledAtNotEquals -  (optional)</li>
          *   <li>scheduledAtSpecified -  (optional)</li>
          *   <li>scheduledAtIn -  (optional)</li>
          *   <li>scheduledAtNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/notifications/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&recipientId.equals={recipientIdEquals}&recipientId.notEquals={recipientIdNotEquals}&recipientId.specified={recipientIdSpecified}&recipientId.in={recipientIdIn}&recipientId.notIn={recipientIdNotIn}&type.contains={typeContains}&type.doesNotContain={typeDoesNotContain}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&title.contains={titleContains}&title.doesNotContain={titleDoesNotContain}&title.equals={titleEquals}&title.notEquals={titleNotEquals}&title.specified={titleSpecified}&title.in={titleIn}&title.notIn={titleNotIn}&isRead.equals={isReadEquals}&isRead.notEquals={isReadNotEquals}&isRead.specified={isReadSpecified}&isRead.in={isReadIn}&isRead.notIn={isReadNotIn}&relatedEntityType.contains={relatedEntityTypeContains}&relatedEntityType.doesNotContain={relatedEntityTypeDoesNotContain}&relatedEntityType.equals={relatedEntityTypeEquals}&relatedEntityType.notEquals={relatedEntityTypeNotEquals}&relatedEntityType.specified={relatedEntityTypeSpecified}&relatedEntityType.in={relatedEntityTypeIn}&relatedEntityType.notIn={relatedEntityTypeNotIn}&relatedEntityId.equals={relatedEntityIdEquals}&relatedEntityId.notEquals={relatedEntityIdNotEquals}&relatedEntityId.specified={relatedEntityIdSpecified}&relatedEntityId.in={relatedEntityIdIn}&relatedEntityId.notIn={relatedEntityIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&scheduledAt.greaterThan={scheduledAtGreaterThan}&scheduledAt.lessThan={scheduledAtLessThan}&scheduledAt.greaterThanOrEqual={scheduledAtGreaterThanOrEqual}&scheduledAt.lessThanOrEqual={scheduledAtLessThanOrEqual}&scheduledAt.equals={scheduledAtEquals}&scheduledAt.notEquals={scheduledAtNotEquals}&scheduledAt.specified={scheduledAtSpecified}&scheduledAt.in={scheduledAtIn}&scheduledAt.notIn={scheduledAtNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countNotificationsWithHttpInfo(@QueryMap(encoded=true) CountNotificationsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countNotifications</code> method in a fluent style.
   */
  public static class CountNotificationsQueryParams extends HashMap<String, Object> {
    public CountNotificationsQueryParams idEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams idNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams idIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams idNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams recipientIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("recipientId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams recipientIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("recipientId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams recipientIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("recipientId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams recipientIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("recipientId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams recipientIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("recipientId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams typeContains(@jakarta.annotation.Nullable final String value) {
      put("type.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams typeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("type.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams typeEquals(@jakarta.annotation.Nullable final String value) {
      put("type.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams typeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("type.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams typeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("type.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams typeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams typeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams titleContains(@jakarta.annotation.Nullable final String value) {
      put("title.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams titleDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("title.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams titleEquals(@jakarta.annotation.Nullable final String value) {
      put("title.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams titleNotEquals(@jakarta.annotation.Nullable final String value) {
      put("title.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams titleSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("title.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams titleIn(@jakarta.annotation.Nullable final List<String> value) {
      put("title.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams titleNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("title.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams isReadEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isRead.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams isReadNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isRead.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams isReadSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isRead.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams isReadIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isRead.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams isReadNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isRead.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams relatedEntityTypeContains(@jakarta.annotation.Nullable final String value) {
      put("relatedEntityType.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams relatedEntityTypeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("relatedEntityType.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams relatedEntityTypeEquals(@jakarta.annotation.Nullable final String value) {
      put("relatedEntityType.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams relatedEntityTypeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("relatedEntityType.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams relatedEntityTypeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("relatedEntityType.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams relatedEntityTypeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("relatedEntityType.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams relatedEntityTypeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("relatedEntityType.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams relatedEntityIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("relatedEntityId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams relatedEntityIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("relatedEntityId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams relatedEntityIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("relatedEntityId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams relatedEntityIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("relatedEntityId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams relatedEntityIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("relatedEntityId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams scheduledAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("scheduledAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams scheduledAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("scheduledAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams scheduledAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("scheduledAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams scheduledAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("scheduledAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams scheduledAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("scheduledAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams scheduledAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("scheduledAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams scheduledAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("scheduledAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountNotificationsQueryParams scheduledAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("scheduledAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams scheduledAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("scheduledAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountNotificationsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param notificationDTO  (required)
   * @return NotificationDTO
   */
  @RequestLine("POST /api/notifications")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  NotificationDTO createNotification(@jakarta.annotation.Nonnull NotificationDTO notificationDTO);

  /**
   * 
   * Similar to <code>createNotification</code> but it also returns the http response headers .
   * 
   * @param notificationDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/notifications")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<NotificationDTO> createNotificationWithHttpInfo(@jakarta.annotation.Nonnull NotificationDTO notificationDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/notifications/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteNotification(@Param("id") @jakarta.annotation.Nonnull UUID id);

  /**
   * 
   * Similar to <code>deleteNotification</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/notifications/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteNotificationWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id);



  /**
   * 
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param recipientIdEquals  (optional)
   * @param recipientIdNotEquals  (optional)
   * @param recipientIdSpecified  (optional)
   * @param recipientIdIn  (optional)
   * @param recipientIdNotIn  (optional)
   * @param typeContains  (optional)
   * @param typeDoesNotContain  (optional)
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
   * @param titleContains  (optional)
   * @param titleDoesNotContain  (optional)
   * @param titleEquals  (optional)
   * @param titleNotEquals  (optional)
   * @param titleSpecified  (optional)
   * @param titleIn  (optional)
   * @param titleNotIn  (optional)
   * @param isReadEquals  (optional)
   * @param isReadNotEquals  (optional)
   * @param isReadSpecified  (optional)
   * @param isReadIn  (optional)
   * @param isReadNotIn  (optional)
   * @param relatedEntityTypeContains  (optional)
   * @param relatedEntityTypeDoesNotContain  (optional)
   * @param relatedEntityTypeEquals  (optional)
   * @param relatedEntityTypeNotEquals  (optional)
   * @param relatedEntityTypeSpecified  (optional)
   * @param relatedEntityTypeIn  (optional)
   * @param relatedEntityTypeNotIn  (optional)
   * @param relatedEntityIdEquals  (optional)
   * @param relatedEntityIdNotEquals  (optional)
   * @param relatedEntityIdSpecified  (optional)
   * @param relatedEntityIdIn  (optional)
   * @param relatedEntityIdNotIn  (optional)
   * @param createdAtGreaterThan  (optional)
   * @param createdAtLessThan  (optional)
   * @param createdAtGreaterThanOrEqual  (optional)
   * @param createdAtLessThanOrEqual  (optional)
   * @param createdAtEquals  (optional)
   * @param createdAtNotEquals  (optional)
   * @param createdAtSpecified  (optional)
   * @param createdAtIn  (optional)
   * @param createdAtNotIn  (optional)
   * @param scheduledAtGreaterThan  (optional)
   * @param scheduledAtLessThan  (optional)
   * @param scheduledAtGreaterThanOrEqual  (optional)
   * @param scheduledAtLessThanOrEqual  (optional)
   * @param scheduledAtEquals  (optional)
   * @param scheduledAtNotEquals  (optional)
   * @param scheduledAtSpecified  (optional)
   * @param scheduledAtIn  (optional)
   * @param scheduledAtNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;NotificationDTO&gt;
   */
  @RequestLine("GET /api/notifications?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&recipientId.equals={recipientIdEquals}&recipientId.notEquals={recipientIdNotEquals}&recipientId.specified={recipientIdSpecified}&recipientId.in={recipientIdIn}&recipientId.notIn={recipientIdNotIn}&type.contains={typeContains}&type.doesNotContain={typeDoesNotContain}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&title.contains={titleContains}&title.doesNotContain={titleDoesNotContain}&title.equals={titleEquals}&title.notEquals={titleNotEquals}&title.specified={titleSpecified}&title.in={titleIn}&title.notIn={titleNotIn}&isRead.equals={isReadEquals}&isRead.notEquals={isReadNotEquals}&isRead.specified={isReadSpecified}&isRead.in={isReadIn}&isRead.notIn={isReadNotIn}&relatedEntityType.contains={relatedEntityTypeContains}&relatedEntityType.doesNotContain={relatedEntityTypeDoesNotContain}&relatedEntityType.equals={relatedEntityTypeEquals}&relatedEntityType.notEquals={relatedEntityTypeNotEquals}&relatedEntityType.specified={relatedEntityTypeSpecified}&relatedEntityType.in={relatedEntityTypeIn}&relatedEntityType.notIn={relatedEntityTypeNotIn}&relatedEntityId.equals={relatedEntityIdEquals}&relatedEntityId.notEquals={relatedEntityIdNotEquals}&relatedEntityId.specified={relatedEntityIdSpecified}&relatedEntityId.in={relatedEntityIdIn}&relatedEntityId.notIn={relatedEntityIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&scheduledAt.greaterThan={scheduledAtGreaterThan}&scheduledAt.lessThan={scheduledAtLessThan}&scheduledAt.greaterThanOrEqual={scheduledAtGreaterThanOrEqual}&scheduledAt.lessThanOrEqual={scheduledAtLessThanOrEqual}&scheduledAt.equals={scheduledAtEquals}&scheduledAt.notEquals={scheduledAtNotEquals}&scheduledAt.specified={scheduledAtSpecified}&scheduledAt.in={scheduledAtIn}&scheduledAt.notIn={scheduledAtNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<NotificationDTO> getAllNotifications(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("recipientIdEquals") @jakarta.annotation.Nullable UUID recipientIdEquals, @Param("recipientIdNotEquals") @jakarta.annotation.Nullable UUID recipientIdNotEquals, @Param("recipientIdSpecified") @jakarta.annotation.Nullable Boolean recipientIdSpecified, @Param("recipientIdIn") @jakarta.annotation.Nullable List<UUID> recipientIdIn, @Param("recipientIdNotIn") @jakarta.annotation.Nullable List<UUID> recipientIdNotIn, @Param("typeContains") @jakarta.annotation.Nullable String typeContains, @Param("typeDoesNotContain") @jakarta.annotation.Nullable String typeDoesNotContain, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("titleContains") @jakarta.annotation.Nullable String titleContains, @Param("titleDoesNotContain") @jakarta.annotation.Nullable String titleDoesNotContain, @Param("titleEquals") @jakarta.annotation.Nullable String titleEquals, @Param("titleNotEquals") @jakarta.annotation.Nullable String titleNotEquals, @Param("titleSpecified") @jakarta.annotation.Nullable Boolean titleSpecified, @Param("titleIn") @jakarta.annotation.Nullable List<String> titleIn, @Param("titleNotIn") @jakarta.annotation.Nullable List<String> titleNotIn, @Param("isReadEquals") @jakarta.annotation.Nullable Boolean isReadEquals, @Param("isReadNotEquals") @jakarta.annotation.Nullable Boolean isReadNotEquals, @Param("isReadSpecified") @jakarta.annotation.Nullable Boolean isReadSpecified, @Param("isReadIn") @jakarta.annotation.Nullable List<Boolean> isReadIn, @Param("isReadNotIn") @jakarta.annotation.Nullable List<Boolean> isReadNotIn, @Param("relatedEntityTypeContains") @jakarta.annotation.Nullable String relatedEntityTypeContains, @Param("relatedEntityTypeDoesNotContain") @jakarta.annotation.Nullable String relatedEntityTypeDoesNotContain, @Param("relatedEntityTypeEquals") @jakarta.annotation.Nullable String relatedEntityTypeEquals, @Param("relatedEntityTypeNotEquals") @jakarta.annotation.Nullable String relatedEntityTypeNotEquals, @Param("relatedEntityTypeSpecified") @jakarta.annotation.Nullable Boolean relatedEntityTypeSpecified, @Param("relatedEntityTypeIn") @jakarta.annotation.Nullable List<String> relatedEntityTypeIn, @Param("relatedEntityTypeNotIn") @jakarta.annotation.Nullable List<String> relatedEntityTypeNotIn, @Param("relatedEntityIdEquals") @jakarta.annotation.Nullable UUID relatedEntityIdEquals, @Param("relatedEntityIdNotEquals") @jakarta.annotation.Nullable UUID relatedEntityIdNotEquals, @Param("relatedEntityIdSpecified") @jakarta.annotation.Nullable Boolean relatedEntityIdSpecified, @Param("relatedEntityIdIn") @jakarta.annotation.Nullable List<UUID> relatedEntityIdIn, @Param("relatedEntityIdNotIn") @jakarta.annotation.Nullable List<UUID> relatedEntityIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("scheduledAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime scheduledAtGreaterThan, @Param("scheduledAtLessThan") @jakarta.annotation.Nullable OffsetDateTime scheduledAtLessThan, @Param("scheduledAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime scheduledAtGreaterThanOrEqual, @Param("scheduledAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime scheduledAtLessThanOrEqual, @Param("scheduledAtEquals") @jakarta.annotation.Nullable OffsetDateTime scheduledAtEquals, @Param("scheduledAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime scheduledAtNotEquals, @Param("scheduledAtSpecified") @jakarta.annotation.Nullable Boolean scheduledAtSpecified, @Param("scheduledAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> scheduledAtIn, @Param("scheduledAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> scheduledAtNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getAllNotifications</code> but it also returns the http response headers .
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param recipientIdEquals  (optional)
   * @param recipientIdNotEquals  (optional)
   * @param recipientIdSpecified  (optional)
   * @param recipientIdIn  (optional)
   * @param recipientIdNotIn  (optional)
   * @param typeContains  (optional)
   * @param typeDoesNotContain  (optional)
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
   * @param titleContains  (optional)
   * @param titleDoesNotContain  (optional)
   * @param titleEquals  (optional)
   * @param titleNotEquals  (optional)
   * @param titleSpecified  (optional)
   * @param titleIn  (optional)
   * @param titleNotIn  (optional)
   * @param isReadEquals  (optional)
   * @param isReadNotEquals  (optional)
   * @param isReadSpecified  (optional)
   * @param isReadIn  (optional)
   * @param isReadNotIn  (optional)
   * @param relatedEntityTypeContains  (optional)
   * @param relatedEntityTypeDoesNotContain  (optional)
   * @param relatedEntityTypeEquals  (optional)
   * @param relatedEntityTypeNotEquals  (optional)
   * @param relatedEntityTypeSpecified  (optional)
   * @param relatedEntityTypeIn  (optional)
   * @param relatedEntityTypeNotIn  (optional)
   * @param relatedEntityIdEquals  (optional)
   * @param relatedEntityIdNotEquals  (optional)
   * @param relatedEntityIdSpecified  (optional)
   * @param relatedEntityIdIn  (optional)
   * @param relatedEntityIdNotIn  (optional)
   * @param createdAtGreaterThan  (optional)
   * @param createdAtLessThan  (optional)
   * @param createdAtGreaterThanOrEqual  (optional)
   * @param createdAtLessThanOrEqual  (optional)
   * @param createdAtEquals  (optional)
   * @param createdAtNotEquals  (optional)
   * @param createdAtSpecified  (optional)
   * @param createdAtIn  (optional)
   * @param createdAtNotIn  (optional)
   * @param scheduledAtGreaterThan  (optional)
   * @param scheduledAtLessThan  (optional)
   * @param scheduledAtGreaterThanOrEqual  (optional)
   * @param scheduledAtLessThanOrEqual  (optional)
   * @param scheduledAtEquals  (optional)
   * @param scheduledAtNotEquals  (optional)
   * @param scheduledAtSpecified  (optional)
   * @param scheduledAtIn  (optional)
   * @param scheduledAtNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/notifications?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&recipientId.equals={recipientIdEquals}&recipientId.notEquals={recipientIdNotEquals}&recipientId.specified={recipientIdSpecified}&recipientId.in={recipientIdIn}&recipientId.notIn={recipientIdNotIn}&type.contains={typeContains}&type.doesNotContain={typeDoesNotContain}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&title.contains={titleContains}&title.doesNotContain={titleDoesNotContain}&title.equals={titleEquals}&title.notEquals={titleNotEquals}&title.specified={titleSpecified}&title.in={titleIn}&title.notIn={titleNotIn}&isRead.equals={isReadEquals}&isRead.notEquals={isReadNotEquals}&isRead.specified={isReadSpecified}&isRead.in={isReadIn}&isRead.notIn={isReadNotIn}&relatedEntityType.contains={relatedEntityTypeContains}&relatedEntityType.doesNotContain={relatedEntityTypeDoesNotContain}&relatedEntityType.equals={relatedEntityTypeEquals}&relatedEntityType.notEquals={relatedEntityTypeNotEquals}&relatedEntityType.specified={relatedEntityTypeSpecified}&relatedEntityType.in={relatedEntityTypeIn}&relatedEntityType.notIn={relatedEntityTypeNotIn}&relatedEntityId.equals={relatedEntityIdEquals}&relatedEntityId.notEquals={relatedEntityIdNotEquals}&relatedEntityId.specified={relatedEntityIdSpecified}&relatedEntityId.in={relatedEntityIdIn}&relatedEntityId.notIn={relatedEntityIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&scheduledAt.greaterThan={scheduledAtGreaterThan}&scheduledAt.lessThan={scheduledAtLessThan}&scheduledAt.greaterThanOrEqual={scheduledAtGreaterThanOrEqual}&scheduledAt.lessThanOrEqual={scheduledAtLessThanOrEqual}&scheduledAt.equals={scheduledAtEquals}&scheduledAt.notEquals={scheduledAtNotEquals}&scheduledAt.specified={scheduledAtSpecified}&scheduledAt.in={scheduledAtIn}&scheduledAt.notIn={scheduledAtNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<NotificationDTO>> getAllNotificationsWithHttpInfo(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("recipientIdEquals") @jakarta.annotation.Nullable UUID recipientIdEquals, @Param("recipientIdNotEquals") @jakarta.annotation.Nullable UUID recipientIdNotEquals, @Param("recipientIdSpecified") @jakarta.annotation.Nullable Boolean recipientIdSpecified, @Param("recipientIdIn") @jakarta.annotation.Nullable List<UUID> recipientIdIn, @Param("recipientIdNotIn") @jakarta.annotation.Nullable List<UUID> recipientIdNotIn, @Param("typeContains") @jakarta.annotation.Nullable String typeContains, @Param("typeDoesNotContain") @jakarta.annotation.Nullable String typeDoesNotContain, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("titleContains") @jakarta.annotation.Nullable String titleContains, @Param("titleDoesNotContain") @jakarta.annotation.Nullable String titleDoesNotContain, @Param("titleEquals") @jakarta.annotation.Nullable String titleEquals, @Param("titleNotEquals") @jakarta.annotation.Nullable String titleNotEquals, @Param("titleSpecified") @jakarta.annotation.Nullable Boolean titleSpecified, @Param("titleIn") @jakarta.annotation.Nullable List<String> titleIn, @Param("titleNotIn") @jakarta.annotation.Nullable List<String> titleNotIn, @Param("isReadEquals") @jakarta.annotation.Nullable Boolean isReadEquals, @Param("isReadNotEquals") @jakarta.annotation.Nullable Boolean isReadNotEquals, @Param("isReadSpecified") @jakarta.annotation.Nullable Boolean isReadSpecified, @Param("isReadIn") @jakarta.annotation.Nullable List<Boolean> isReadIn, @Param("isReadNotIn") @jakarta.annotation.Nullable List<Boolean> isReadNotIn, @Param("relatedEntityTypeContains") @jakarta.annotation.Nullable String relatedEntityTypeContains, @Param("relatedEntityTypeDoesNotContain") @jakarta.annotation.Nullable String relatedEntityTypeDoesNotContain, @Param("relatedEntityTypeEquals") @jakarta.annotation.Nullable String relatedEntityTypeEquals, @Param("relatedEntityTypeNotEquals") @jakarta.annotation.Nullable String relatedEntityTypeNotEquals, @Param("relatedEntityTypeSpecified") @jakarta.annotation.Nullable Boolean relatedEntityTypeSpecified, @Param("relatedEntityTypeIn") @jakarta.annotation.Nullable List<String> relatedEntityTypeIn, @Param("relatedEntityTypeNotIn") @jakarta.annotation.Nullable List<String> relatedEntityTypeNotIn, @Param("relatedEntityIdEquals") @jakarta.annotation.Nullable UUID relatedEntityIdEquals, @Param("relatedEntityIdNotEquals") @jakarta.annotation.Nullable UUID relatedEntityIdNotEquals, @Param("relatedEntityIdSpecified") @jakarta.annotation.Nullable Boolean relatedEntityIdSpecified, @Param("relatedEntityIdIn") @jakarta.annotation.Nullable List<UUID> relatedEntityIdIn, @Param("relatedEntityIdNotIn") @jakarta.annotation.Nullable List<UUID> relatedEntityIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("scheduledAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime scheduledAtGreaterThan, @Param("scheduledAtLessThan") @jakarta.annotation.Nullable OffsetDateTime scheduledAtLessThan, @Param("scheduledAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime scheduledAtGreaterThanOrEqual, @Param("scheduledAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime scheduledAtLessThanOrEqual, @Param("scheduledAtEquals") @jakarta.annotation.Nullable OffsetDateTime scheduledAtEquals, @Param("scheduledAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime scheduledAtNotEquals, @Param("scheduledAtSpecified") @jakarta.annotation.Nullable Boolean scheduledAtSpecified, @Param("scheduledAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> scheduledAtIn, @Param("scheduledAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> scheduledAtNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllNotifications</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllNotificationsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>idEquals -  (optional)</li>
   *   <li>idNotEquals -  (optional)</li>
   *   <li>idSpecified -  (optional)</li>
   *   <li>idIn -  (optional)</li>
   *   <li>idNotIn -  (optional)</li>
   *   <li>recipientIdEquals -  (optional)</li>
   *   <li>recipientIdNotEquals -  (optional)</li>
   *   <li>recipientIdSpecified -  (optional)</li>
   *   <li>recipientIdIn -  (optional)</li>
   *   <li>recipientIdNotIn -  (optional)</li>
   *   <li>typeContains -  (optional)</li>
   *   <li>typeDoesNotContain -  (optional)</li>
   *   <li>typeEquals -  (optional)</li>
   *   <li>typeNotEquals -  (optional)</li>
   *   <li>typeSpecified -  (optional)</li>
   *   <li>typeIn -  (optional)</li>
   *   <li>typeNotIn -  (optional)</li>
   *   <li>titleContains -  (optional)</li>
   *   <li>titleDoesNotContain -  (optional)</li>
   *   <li>titleEquals -  (optional)</li>
   *   <li>titleNotEquals -  (optional)</li>
   *   <li>titleSpecified -  (optional)</li>
   *   <li>titleIn -  (optional)</li>
   *   <li>titleNotIn -  (optional)</li>
   *   <li>isReadEquals -  (optional)</li>
   *   <li>isReadNotEquals -  (optional)</li>
   *   <li>isReadSpecified -  (optional)</li>
   *   <li>isReadIn -  (optional)</li>
   *   <li>isReadNotIn -  (optional)</li>
   *   <li>relatedEntityTypeContains -  (optional)</li>
   *   <li>relatedEntityTypeDoesNotContain -  (optional)</li>
   *   <li>relatedEntityTypeEquals -  (optional)</li>
   *   <li>relatedEntityTypeNotEquals -  (optional)</li>
   *   <li>relatedEntityTypeSpecified -  (optional)</li>
   *   <li>relatedEntityTypeIn -  (optional)</li>
   *   <li>relatedEntityTypeNotIn -  (optional)</li>
   *   <li>relatedEntityIdEquals -  (optional)</li>
   *   <li>relatedEntityIdNotEquals -  (optional)</li>
   *   <li>relatedEntityIdSpecified -  (optional)</li>
   *   <li>relatedEntityIdIn -  (optional)</li>
   *   <li>relatedEntityIdNotIn -  (optional)</li>
   *   <li>createdAtGreaterThan -  (optional)</li>
   *   <li>createdAtLessThan -  (optional)</li>
   *   <li>createdAtGreaterThanOrEqual -  (optional)</li>
   *   <li>createdAtLessThanOrEqual -  (optional)</li>
   *   <li>createdAtEquals -  (optional)</li>
   *   <li>createdAtNotEquals -  (optional)</li>
   *   <li>createdAtSpecified -  (optional)</li>
   *   <li>createdAtIn -  (optional)</li>
   *   <li>createdAtNotIn -  (optional)</li>
   *   <li>scheduledAtGreaterThan -  (optional)</li>
   *   <li>scheduledAtLessThan -  (optional)</li>
   *   <li>scheduledAtGreaterThanOrEqual -  (optional)</li>
   *   <li>scheduledAtLessThanOrEqual -  (optional)</li>
   *   <li>scheduledAtEquals -  (optional)</li>
   *   <li>scheduledAtNotEquals -  (optional)</li>
   *   <li>scheduledAtSpecified -  (optional)</li>
   *   <li>scheduledAtIn -  (optional)</li>
   *   <li>scheduledAtNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;NotificationDTO&gt;
   */
  @RequestLine("GET /api/notifications?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&recipientId.equals={recipientIdEquals}&recipientId.notEquals={recipientIdNotEquals}&recipientId.specified={recipientIdSpecified}&recipientId.in={recipientIdIn}&recipientId.notIn={recipientIdNotIn}&type.contains={typeContains}&type.doesNotContain={typeDoesNotContain}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&title.contains={titleContains}&title.doesNotContain={titleDoesNotContain}&title.equals={titleEquals}&title.notEquals={titleNotEquals}&title.specified={titleSpecified}&title.in={titleIn}&title.notIn={titleNotIn}&isRead.equals={isReadEquals}&isRead.notEquals={isReadNotEquals}&isRead.specified={isReadSpecified}&isRead.in={isReadIn}&isRead.notIn={isReadNotIn}&relatedEntityType.contains={relatedEntityTypeContains}&relatedEntityType.doesNotContain={relatedEntityTypeDoesNotContain}&relatedEntityType.equals={relatedEntityTypeEquals}&relatedEntityType.notEquals={relatedEntityTypeNotEquals}&relatedEntityType.specified={relatedEntityTypeSpecified}&relatedEntityType.in={relatedEntityTypeIn}&relatedEntityType.notIn={relatedEntityTypeNotIn}&relatedEntityId.equals={relatedEntityIdEquals}&relatedEntityId.notEquals={relatedEntityIdNotEquals}&relatedEntityId.specified={relatedEntityIdSpecified}&relatedEntityId.in={relatedEntityIdIn}&relatedEntityId.notIn={relatedEntityIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&scheduledAt.greaterThan={scheduledAtGreaterThan}&scheduledAt.lessThan={scheduledAtLessThan}&scheduledAt.greaterThanOrEqual={scheduledAtGreaterThanOrEqual}&scheduledAt.lessThanOrEqual={scheduledAtLessThanOrEqual}&scheduledAt.equals={scheduledAtEquals}&scheduledAt.notEquals={scheduledAtNotEquals}&scheduledAt.specified={scheduledAtSpecified}&scheduledAt.in={scheduledAtIn}&scheduledAt.notIn={scheduledAtNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<NotificationDTO> getAllNotifications(@QueryMap(encoded=true) GetAllNotificationsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllNotifications</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>idEquals -  (optional)</li>
          *   <li>idNotEquals -  (optional)</li>
          *   <li>idSpecified -  (optional)</li>
          *   <li>idIn -  (optional)</li>
          *   <li>idNotIn -  (optional)</li>
          *   <li>recipientIdEquals -  (optional)</li>
          *   <li>recipientIdNotEquals -  (optional)</li>
          *   <li>recipientIdSpecified -  (optional)</li>
          *   <li>recipientIdIn -  (optional)</li>
          *   <li>recipientIdNotIn -  (optional)</li>
          *   <li>typeContains -  (optional)</li>
          *   <li>typeDoesNotContain -  (optional)</li>
          *   <li>typeEquals -  (optional)</li>
          *   <li>typeNotEquals -  (optional)</li>
          *   <li>typeSpecified -  (optional)</li>
          *   <li>typeIn -  (optional)</li>
          *   <li>typeNotIn -  (optional)</li>
          *   <li>titleContains -  (optional)</li>
          *   <li>titleDoesNotContain -  (optional)</li>
          *   <li>titleEquals -  (optional)</li>
          *   <li>titleNotEquals -  (optional)</li>
          *   <li>titleSpecified -  (optional)</li>
          *   <li>titleIn -  (optional)</li>
          *   <li>titleNotIn -  (optional)</li>
          *   <li>isReadEquals -  (optional)</li>
          *   <li>isReadNotEquals -  (optional)</li>
          *   <li>isReadSpecified -  (optional)</li>
          *   <li>isReadIn -  (optional)</li>
          *   <li>isReadNotIn -  (optional)</li>
          *   <li>relatedEntityTypeContains -  (optional)</li>
          *   <li>relatedEntityTypeDoesNotContain -  (optional)</li>
          *   <li>relatedEntityTypeEquals -  (optional)</li>
          *   <li>relatedEntityTypeNotEquals -  (optional)</li>
          *   <li>relatedEntityTypeSpecified -  (optional)</li>
          *   <li>relatedEntityTypeIn -  (optional)</li>
          *   <li>relatedEntityTypeNotIn -  (optional)</li>
          *   <li>relatedEntityIdEquals -  (optional)</li>
          *   <li>relatedEntityIdNotEquals -  (optional)</li>
          *   <li>relatedEntityIdSpecified -  (optional)</li>
          *   <li>relatedEntityIdIn -  (optional)</li>
          *   <li>relatedEntityIdNotIn -  (optional)</li>
          *   <li>createdAtGreaterThan -  (optional)</li>
          *   <li>createdAtLessThan -  (optional)</li>
          *   <li>createdAtGreaterThanOrEqual -  (optional)</li>
          *   <li>createdAtLessThanOrEqual -  (optional)</li>
          *   <li>createdAtEquals -  (optional)</li>
          *   <li>createdAtNotEquals -  (optional)</li>
          *   <li>createdAtSpecified -  (optional)</li>
          *   <li>createdAtIn -  (optional)</li>
          *   <li>createdAtNotIn -  (optional)</li>
          *   <li>scheduledAtGreaterThan -  (optional)</li>
          *   <li>scheduledAtLessThan -  (optional)</li>
          *   <li>scheduledAtGreaterThanOrEqual -  (optional)</li>
          *   <li>scheduledAtLessThanOrEqual -  (optional)</li>
          *   <li>scheduledAtEquals -  (optional)</li>
          *   <li>scheduledAtNotEquals -  (optional)</li>
          *   <li>scheduledAtSpecified -  (optional)</li>
          *   <li>scheduledAtIn -  (optional)</li>
          *   <li>scheduledAtNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;NotificationDTO&gt;
      */
      @RequestLine("GET /api/notifications?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&recipientId.equals={recipientIdEquals}&recipientId.notEquals={recipientIdNotEquals}&recipientId.specified={recipientIdSpecified}&recipientId.in={recipientIdIn}&recipientId.notIn={recipientIdNotIn}&type.contains={typeContains}&type.doesNotContain={typeDoesNotContain}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&title.contains={titleContains}&title.doesNotContain={titleDoesNotContain}&title.equals={titleEquals}&title.notEquals={titleNotEquals}&title.specified={titleSpecified}&title.in={titleIn}&title.notIn={titleNotIn}&isRead.equals={isReadEquals}&isRead.notEquals={isReadNotEquals}&isRead.specified={isReadSpecified}&isRead.in={isReadIn}&isRead.notIn={isReadNotIn}&relatedEntityType.contains={relatedEntityTypeContains}&relatedEntityType.doesNotContain={relatedEntityTypeDoesNotContain}&relatedEntityType.equals={relatedEntityTypeEquals}&relatedEntityType.notEquals={relatedEntityTypeNotEquals}&relatedEntityType.specified={relatedEntityTypeSpecified}&relatedEntityType.in={relatedEntityTypeIn}&relatedEntityType.notIn={relatedEntityTypeNotIn}&relatedEntityId.equals={relatedEntityIdEquals}&relatedEntityId.notEquals={relatedEntityIdNotEquals}&relatedEntityId.specified={relatedEntityIdSpecified}&relatedEntityId.in={relatedEntityIdIn}&relatedEntityId.notIn={relatedEntityIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&scheduledAt.greaterThan={scheduledAtGreaterThan}&scheduledAt.lessThan={scheduledAtLessThan}&scheduledAt.greaterThanOrEqual={scheduledAtGreaterThanOrEqual}&scheduledAt.lessThanOrEqual={scheduledAtLessThanOrEqual}&scheduledAt.equals={scheduledAtEquals}&scheduledAt.notEquals={scheduledAtNotEquals}&scheduledAt.specified={scheduledAtSpecified}&scheduledAt.in={scheduledAtIn}&scheduledAt.notIn={scheduledAtNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<NotificationDTO>> getAllNotificationsWithHttpInfo(@QueryMap(encoded=true) GetAllNotificationsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllNotifications</code> method in a fluent style.
   */
  public static class GetAllNotificationsQueryParams extends HashMap<String, Object> {
    public GetAllNotificationsQueryParams idEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams idNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams idIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams idNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams recipientIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("recipientId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams recipientIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("recipientId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams recipientIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("recipientId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams recipientIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("recipientId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams recipientIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("recipientId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams typeContains(@jakarta.annotation.Nullable final String value) {
      put("type.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams typeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("type.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams typeEquals(@jakarta.annotation.Nullable final String value) {
      put("type.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams typeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("type.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams typeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("type.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams typeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams typeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams titleContains(@jakarta.annotation.Nullable final String value) {
      put("title.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams titleDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("title.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams titleEquals(@jakarta.annotation.Nullable final String value) {
      put("title.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams titleNotEquals(@jakarta.annotation.Nullable final String value) {
      put("title.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams titleSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("title.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams titleIn(@jakarta.annotation.Nullable final List<String> value) {
      put("title.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams titleNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("title.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams isReadEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isRead.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams isReadNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isRead.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams isReadSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isRead.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams isReadIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isRead.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams isReadNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isRead.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams relatedEntityTypeContains(@jakarta.annotation.Nullable final String value) {
      put("relatedEntityType.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams relatedEntityTypeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("relatedEntityType.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams relatedEntityTypeEquals(@jakarta.annotation.Nullable final String value) {
      put("relatedEntityType.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams relatedEntityTypeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("relatedEntityType.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams relatedEntityTypeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("relatedEntityType.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams relatedEntityTypeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("relatedEntityType.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams relatedEntityTypeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("relatedEntityType.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams relatedEntityIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("relatedEntityId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams relatedEntityIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("relatedEntityId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams relatedEntityIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("relatedEntityId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams relatedEntityIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("relatedEntityId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams relatedEntityIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("relatedEntityId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams scheduledAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("scheduledAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams scheduledAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("scheduledAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams scheduledAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("scheduledAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams scheduledAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("scheduledAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams scheduledAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("scheduledAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams scheduledAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("scheduledAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams scheduledAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("scheduledAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams scheduledAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("scheduledAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams scheduledAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("scheduledAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllNotificationsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetAllNotificationsQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return NotificationDTO
   */
  @RequestLine("GET /api/notifications/{id}")
  @Headers({
    "Accept: */*",
  })
  NotificationDTO getNotification(@Param("id") @jakarta.annotation.Nonnull UUID id);

  /**
   * 
   * Similar to <code>getNotification</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/notifications/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<NotificationDTO> getNotificationWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id);



  /**
   * 
   * 
   * @param id  (required)
   * @param notificationDTO  (required)
   * @return NotificationDTO
   */
  @RequestLine("PATCH /api/notifications/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  NotificationDTO partialUpdateNotification(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull NotificationDTO notificationDTO);

  /**
   * 
   * Similar to <code>partialUpdateNotification</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param notificationDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/notifications/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<NotificationDTO> partialUpdateNotificationWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull NotificationDTO notificationDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param notificationDTO  (required)
   * @return NotificationDTO
   */
  @RequestLine("PUT /api/notifications/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  NotificationDTO updateNotification(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull NotificationDTO notificationDTO);

  /**
   * 
   * Similar to <code>updateNotification</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param notificationDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/notifications/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<NotificationDTO> updateNotificationWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull NotificationDTO notificationDTO);


}
