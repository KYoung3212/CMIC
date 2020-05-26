package com.churchmutual.content.setup;

import com.churchmutual.content.setup.upgrade.util.v1_0_0.AddBrokerSiteUpgradeProcess;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactory;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutSetLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.VirtualHostLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class ContentSetupUpgradeStepRegistrator implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {

		registry.register(
			"0.0.0", "1.0.0",
			new AddBrokerSiteUpgradeProcess(
				groupLocalService, layoutSetLocalService,
				permissionCheckerFactory, portal, roleLocalService,
				userLocalService, virtualHostLocalService));
	}

	@Reference
	protected GroupLocalService groupLocalService;

	@Reference
	protected LayoutSetLocalService layoutSetLocalService;

	@Reference
	protected PermissionCheckerFactory permissionCheckerFactory;

	@Reference
	protected Portal portal;

	@Reference
	protected RoleLocalService roleLocalService;

	@Reference
	protected UserLocalService userLocalService;

	@Reference
	protected VirtualHostLocalService virtualHostLocalService;

}
