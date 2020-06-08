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
import com.churchmutual.core.service.CMICOrganizationLocalService;
import com.churchmutual.core.service.persistence.CMICAccountEntryPersistence;
import com.churchmutual.core.service.persistence.CMICOrganizationPersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the cmic organization local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.churchmutual.core.service.impl.CMICOrganizationLocalServiceImpl}.
 * </p>
 *
 * @author Kayleen Lim
 * @see com.churchmutual.core.service.impl.CMICOrganizationLocalServiceImpl
 * @generated
 */
public abstract class CMICOrganizationLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CMICOrganizationLocalService, AopService,
			   IdentifiableOSGiService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CMICOrganizationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.churchmutual.core.service.CMICOrganizationLocalServiceUtil</code>.
	 */

	/**
	 * Adds the cmic organization to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cmicOrganization the cmic organization
	 * @return the cmic organization that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CMICOrganization addCMICOrganization(
		CMICOrganization cmicOrganization) {

		cmicOrganization.setNew(true);

		return cmicOrganizationPersistence.update(cmicOrganization);
	}

	/**
	 * Creates a new cmic organization with the primary key. Does not add the cmic organization to the database.
	 *
	 * @param cmicOrganizationId the primary key for the new cmic organization
	 * @return the new cmic organization
	 */
	@Override
	@Transactional(enabled = false)
	public CMICOrganization createCMICOrganization(long cmicOrganizationId) {
		return cmicOrganizationPersistence.create(cmicOrganizationId);
	}

	/**
	 * Deletes the cmic organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cmicOrganizationId the primary key of the cmic organization
	 * @return the cmic organization that was removed
	 * @throws PortalException if a cmic organization with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CMICOrganization deleteCMICOrganization(long cmicOrganizationId)
		throws PortalException {

		return cmicOrganizationPersistence.remove(cmicOrganizationId);
	}

	/**
	 * Deletes the cmic organization from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cmicOrganization the cmic organization
	 * @return the cmic organization that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CMICOrganization deleteCMICOrganization(
		CMICOrganization cmicOrganization) {

		return cmicOrganizationPersistence.remove(cmicOrganization);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CMICOrganization.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return cmicOrganizationPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.churchmutual.core.model.impl.CMICOrganizationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return cmicOrganizationPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.churchmutual.core.model.impl.CMICOrganizationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return cmicOrganizationPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return cmicOrganizationPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return cmicOrganizationPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CMICOrganization fetchCMICOrganization(long cmicOrganizationId) {
		return cmicOrganizationPersistence.fetchByPrimaryKey(
			cmicOrganizationId);
	}

	/**
	 * Returns the cmic organization with the primary key.
	 *
	 * @param cmicOrganizationId the primary key of the cmic organization
	 * @return the cmic organization
	 * @throws PortalException if a cmic organization with the primary key could not be found
	 */
	@Override
	public CMICOrganization getCMICOrganization(long cmicOrganizationId)
		throws PortalException {

		return cmicOrganizationPersistence.findByPrimaryKey(cmicOrganizationId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			cmicOrganizationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CMICOrganization.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("cmicOrganizationId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			cmicOrganizationLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CMICOrganization.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"cmicOrganizationId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			cmicOrganizationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CMICOrganization.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("cmicOrganizationId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return cmicOrganizationLocalService.deleteCMICOrganization(
			(CMICOrganization)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return cmicOrganizationPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the cmic organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.churchmutual.core.model.impl.CMICOrganizationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cmic organizations
	 * @param end the upper bound of the range of cmic organizations (not inclusive)
	 * @return the range of cmic organizations
	 */
	@Override
	public List<CMICOrganization> getCMICOrganizations(int start, int end) {
		return cmicOrganizationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of cmic organizations.
	 *
	 * @return the number of cmic organizations
	 */
	@Override
	public int getCMICOrganizationsCount() {
		return cmicOrganizationPersistence.countAll();
	}

	/**
	 * Updates the cmic organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cmicOrganization the cmic organization
	 * @return the cmic organization that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CMICOrganization updateCMICOrganization(
		CMICOrganization cmicOrganization) {

		return cmicOrganizationPersistence.update(cmicOrganization);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CMICOrganizationLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		cmicOrganizationLocalService = (CMICOrganizationLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CMICOrganizationLocalService.class.getName();
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

	protected CMICOrganizationLocalService cmicOrganizationLocalService;

	@Reference
	protected CMICOrganizationPersistence cmicOrganizationPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}