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

package com.churchmutual.core.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for CMICOrganization. This utility wraps
 * <code>com.churchmutual.core.service.impl.CMICOrganizationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Kayleen Lim
 * @see CMICOrganizationService
 * @generated
 */
public class CMICOrganizationServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.churchmutual.core.service.impl.CMICOrganizationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CMICOrganizationServiceUtil} to access the cmic organization remote service. Add custom service methods to <code>com.churchmutual.core.service.impl.CMICOrganizationServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static com.churchmutual.core.model.CMICOrganization
			getCMICOrganizationByOrganizationId(long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCMICOrganizationByOrganizationId(organizationId);
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
			getCMICOrganizations(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCMICOrganizations(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CMICOrganizationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CMICOrganizationService, CMICOrganizationService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CMICOrganizationService.class);

		ServiceTracker<CMICOrganizationService, CMICOrganizationService>
			serviceTracker =
				new ServiceTracker
					<CMICOrganizationService, CMICOrganizationService>(
						bundle.getBundleContext(),
						CMICOrganizationService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}