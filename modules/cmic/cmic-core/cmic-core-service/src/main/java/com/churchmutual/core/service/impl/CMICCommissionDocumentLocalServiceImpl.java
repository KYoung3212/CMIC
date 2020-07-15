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

package com.churchmutual.core.service.impl;

import com.churchmutual.core.constants.CommissionDocumentType;
import com.churchmutual.core.exception.NoSuchCMICCommissionDocumentException;
import com.churchmutual.core.model.CMICCommissionDocumentDisplay;
import com.churchmutual.core.model.CMICOrganization;
import com.churchmutual.core.service.CMICOrganizationLocalService;
import com.churchmutual.core.service.base.CMICCommissionDocumentLocalServiceBaseImpl;
import com.churchmutual.rest.CommissionDocumentWebService;
import com.churchmutual.rest.PortalUserWebService;
import com.churchmutual.rest.model.CMICCommissionDocumentDTO;
import com.churchmutual.rest.model.CMICFileDTO;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ListUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the cmic commission document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.churchmutual.core.service.CMICCommissionDocumentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Kayleen Lim
 * @see CMICCommissionDocumentLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.churchmutual.core.model.CMICCommissionDocumentDisplay", service = AopService.class
)
public class CMICCommissionDocumentLocalServiceImpl extends CMICCommissionDocumentLocalServiceBaseImpl {

	@Override
	public CMICCommissionDocumentDisplay downloadDocument(String id) throws PortalException {
		List<CMICFileDTO> cmicFileDTOS = _commissionDocumentWebService.downloadDocuments(new String[] {id}, true);

		if (ListUtil.isEmpty(cmicFileDTOS)) {
			throw new NoSuchCMICCommissionDocumentException(id);
		}

		return new CMICCommissionDocumentDisplay(cmicFileDTOS.get(0));
	}

	@Override
	public List<CMICCommissionDocumentDisplay> getCommissionDocuments(long userId) throws PortalException {
		List<CMICCommissionDocumentDisplay> cmicCommissionDocumentDisplays = new ArrayList<>();

		List<CMICOrganization> userOrganizations = cmicOrganizationLocalService.getCMICUserOrganizations(userId);

		LocalDate now = LocalDate.now();

		LocalDate thirteenMonthsPrior = now.minusMonths(13);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String maximumStatementDate = now.format(formatter);
		String minimumStatementDate = thirteenMonthsPrior.format(formatter);

		for (CMICOrganization cmicOrganization : userOrganizations) {
			for (CommissionDocumentType documentType : CommissionDocumentType.values()) {
				List<CMICCommissionDocumentDTO> commissionDocumentDTOs = _commissionDocumentWebService.searchDocuments(
					cmicOrganization.getAgentNumber(), cmicOrganization.getDivisionNumber(), documentType.toString(),
					maximumStatementDate, minimumStatementDate);

				commissionDocumentDTOs.stream(
				).forEach(
					commissionDocumentDTO -> {
						cmicCommissionDocumentDisplays.add(
							new CMICCommissionDocumentDisplay(commissionDocumentDTO));
					}
				);
			}
		}

		return cmicCommissionDocumentDisplays;
	}

	@Reference
	protected CMICOrganizationLocalService cmicOrganizationLocalService;

	@Reference
	protected CommissionDocumentWebService _commissionDocumentWebService;

	@Reference
	protected JSONFactory _jsonFactory;

	@Reference
	protected PortalUserWebService _portalUserWebService;

	@Reference
	protected UserLocalService _userLocalService;

}