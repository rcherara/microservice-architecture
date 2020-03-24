import React from 'react';
import PropTypes from 'prop-types';

// Translation Higher Order Component
import {
  setTranslations,
  setDefaultLanguage,
  setLanguageCookie,
  setLanguage,
  translate,
} from 'react-switch-lang';
import en from 'en.json';
import th from 'th.json';

// Do this two lines only when setting up the application
setTranslations({ en, th });
setDefaultLanguage('en');

// If you want to remember selected language
setLanguageCookie();

class SomeComponent extends React.Component {
  handleSetLanguage = (key) => () => {
    setLanguage(key);
  };

  render() {
    const { t } = this.props;
    return (
      <div>
        {t('home.title')}
        {t('home.title', null, 'th')}
        {t('hello', { name: 'World' })}
        {t('fallback')}

        <button type="button" onClick={this.handleSetLanguage('th')}>
          Switch language
        </button>
      </div>
    )
  }
}

SomeComponent.propTypes = {
  t: PropTypes.func.isRequired,
};

export default translate(SomeComponent);