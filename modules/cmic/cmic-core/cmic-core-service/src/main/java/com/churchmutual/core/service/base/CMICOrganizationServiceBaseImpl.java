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

package com.churchmutual.core.service.base;

import com.churchmutual.core.model.CMICOrganization;
import com.churchmutual.core.service.CMICOrganizationService;
import com.churchmutual.core.service.persistence.CMICAccountEntryPersistence;
import com.churchmutual.core.service.persistence.CMICOrganizationPersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the cmic organization remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.churchmutual.core.service.impl.CMICOrganizationServiceImpl}.
 * </p>
 *
 * @author Kayleen Lim
 * @see com.churchmutual.core.service.impl.CMICOrganizationServiceImpl
 * @generated
 */
public abstract class CMICOrganizationServiceBaseImpl
	extends BaseServiceImpl
	implements CMICOrganizationService, AopService, IdentifiableOSGiService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CMICOrganizationService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.churchmutual.core.service.CMICOrganizationServiceUtil</code>.
	 */
	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CMICOrganizationService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		cmicOrganizationService = (CMICOrganizationService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CMICOrganizationService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CMICOrganization.class;
	}

	protected String getModelClassName() {
		return CMICOrganization.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = cmicOrganizationPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@Reference
	protected CMICAccountEntryPersistence cmicAccountEntryPersistence;

	@Reference
	protected com.churchmutual.core.service.CMICOrganizationLocalService
		cmicOrganizationLocalService;

	protected CMICOrganizationService cmicOrganizationService;

	@Reference
	protected CMICOrganizationPersistence cmicOrganizationPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}