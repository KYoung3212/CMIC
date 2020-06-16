import React from 'react';
import ClayBreadcrumb from '@clayui/breadcrumb';

const AccountInfo = (props) => {
  const spritemap = Liferay.ThemeDisplay.getPathThemeImages() + '/clay/icons.svg';

  return (
    <React.Fragment>
      <div>
        <div className="flex-container align-items-center">
          <h3 className="mb-0">{props.transaction.accountName}</h3>
          <small className="font-weight-bold text-muted ml-4">{props.transaction.accountNumber}</small>
        </div>
        <ClayBreadcrumb
          items={[
            {
              href: 'accounts',
              label: 'Accounts'
            },
            {
              href: '#',
              label: `${props.transaction.accountName}`
            },
            {
              active: true,
              label: `${props.transaction.policyName}`
            }
          ]}
          spritemap={spritemap}
          className="mb-sm-0 pb-0"
        />
      </div>
      <div className="well">
        <h6 className="well-title">{Liferay.Language.get('producer-entity')}</h6>
        <div className="well-subtitle">{props.transaction.producerEntity}</div>
        <div className="small font-weight-bold text-muted">{props.transaction.producerEntityCode}</div>
      </div>
    </React.Fragment>
  );
};

export default AccountInfo;