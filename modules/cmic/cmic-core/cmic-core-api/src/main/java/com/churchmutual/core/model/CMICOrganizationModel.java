/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.churchmutual.core.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CMICOrganization service. Represents a row in the &quot;cmic_CMICOrganization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.churchmutual.core.model.impl.CMICOrganizationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.churchmutual.core.model.impl.CMICOrganizationImpl</code>.
 * </p>
 *
 * @author Kayleen Lim
 * @see CMICOrganization
 * @generated
 */
@ProviderType
public interface CMICOrganizationModel extends BaseModel<CMICOrganization> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cmic organization model instance should use the {@link CMICOrganization} interface instead.
	 */

	/**
	 * Returns the primary key of this cmic organization.
	 *
	 * @return the primary key of this cmic organization
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cmic organization.
	 *
	 * @param primaryKey the primary key of this cmic organization
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the cmic organization ID of this cmic organization.
	 *
	 * @return the cmic organization ID of this cmic organization
	 */
	public long getCmicOrganizationId();

	/**
	 * Sets the cmic organization ID of this cmic organization.
	 *
	 * @param cmicOrganizationId the cmic organization ID of this cmic organization
	 */
	public void setCmicOrganizationId(long cmicOrganizationId);

	/**
	 * Returns the organization ID of this cmic organization.
	 *
	 * @return the organization ID of this cmic organization
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this cmic organization.
	 *
	 * @param organizationId the organization ID of this cmic organization
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the agent of this cmic organization.
	 *
	 * @return the agent of this cmic organization
	 */
	@AutoEscape
	public String getAgent();

	/**
	 * Sets the agent of this cmic organization.
	 *
	 * @param agent the agent of this cmic organization
	 */
	public void setAgent(String agent);

	/**
	 * Returns the division of this cmic organization.
	 *
	 * @return the division of this cmic organization
	 */
	@AutoEscape
	public String getDivision();

	/**
	 * Sets the division of this cmic organization.
	 *
	 * @param division the division of this cmic organization
	 */
	public void setDivision(String division);

	/**
	 * Returns the producer ID of this cmic organization.
	 *
	 * @return the producer ID of this cmic organization
	 */
	public long getProducerId();

	/**
	 * Sets the producer ID of this cmic organization.
	 *
	 * @param producerId the producer ID of this cmic organization
	 */
	public void setProducerId(long producerId);

	/**
	 * Returns the producer type of this cmic organization.
	 *
	 * @return the producer type of this cmic organization
	 */
	public int getProducerType();

	/**
	 * Sets the producer type of this cmic organization.
	 *
	 * @param producerType the producer type of this cmic organization
	 */
	public void setProducerType(int producerType);

	/**
	 * Returns the active of this cmic organization.
	 *
	 * @return the active of this cmic organization
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this cmic organization is active.
	 *
	 * @return <code>true</code> if this cmic organization is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this cmic organization is active.
	 *
	 * @param active the active of this cmic organization
	 */
	public void setActive(boolean active);

}