import React, { Component } from 'react';
import Cookie from 'js-cookie';
import PropTypes from 'prop-types';


const propTypes = {
  locale: PropTypes.string.isRequired,
};

class LocaleButton extends Component {
  constructor() {
    super();

    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    Cookie.set('locale', this.props.locale === 'en' ? 'ar' : 'en');
    window.location.reload();
  }

  render() {
    return <button onClick={this.handleClick}>{this.props.locale === 'en' ? 'Arabic' : 'English'}/></button>
  }
}

LocaleButton.propTypes = propTypes;

export default LocaleButton;