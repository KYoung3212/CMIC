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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CMICCommissionDocumentLocalService}.
 *
 * @author Kayleen Lim
 * @see CMICCommissionDocumentLocalService
 * @generated
 */
public class CMICCommissionDocumentLocalServiceWrapper
	implements CMICCommissionDocumentLocalService,
			   ServiceWrapper<CMICCommissionDocumentLocalService> {

	public CMICCommissionDocumentLocalServiceWrapper(
		CMICCommissionDocumentLocalService cmicCommissionDocumentLocalService) {

		_cmicCommissionDocumentLocalService =
			cmicCommissionDocumentLocalService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cmicCommissionDocumentLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public CMICCommissionDocumentLocalService getWrappedService() {
		return _cmicCommissionDocumentLocalService;
	}

	@Override
	public void setWrappedService(
		CMICCommissionDocumentLocalService cmicCommissionDocumentLocalService) {

		_cmicCommissionDocumentLocalService =
			cmicCommissionDocumentLocalService;
	}

	private CMICCommissionDocumentLocalService
		_cmicCommissionDocumentLocalService;

}