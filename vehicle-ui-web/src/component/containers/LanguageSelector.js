import React, { useState } from 'react';
import {Dropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import { strings, switchLanguage } from "../../config/i18n";
  

  const LanguageSelector = (props) => {
  const [dropdownOpen, setDropdownOpen] = useState(false);
  const toggle = () => setDropdownOpen(prevState => !prevState);
  const changeLanguage = (event) => {
    this.props.location= (event.target.value); 
  };
 
  
 
  return (
    <div >
      <div >
            <Dropdown isOpen={dropdownOpen} toggle={toggle}>
            <DropdownToggle caret>
            {strings('languages.title','')}
              </DropdownToggle>
            <DropdownMenu>
              <DropdownItem value={props.location} onChange={e => props.handleSetLanguage(e.target.value)}  onClick={() => switchLanguage('en', this)}>{strings('languages.long.en','')}</DropdownItem>
              <DropdownItem value={props.location} onChange={e => props.handleSetLanguage(e.target.value)}  onClick={() => switchLanguage('ar', this)}>{strings('languages.long.ar','')}</DropdownItem>
              <DropdownItem value={props.location} onChange={e => props.handleSetLanguage(e.target.value)}  onClick={() => switchLanguage('fr', this)}>{strings('languages.long.fr','')}</DropdownItem>
              <DropdownItem value={props.language} onChange={e => props.handleSetLanguage(e.target.value)}  onClick={() => switchLanguage('es', this)}>{strings('languages.long.es','')}</DropdownItem>
              <DropdownItem value={props.language} onChange={e => props.handleSetLanguage(e.target.value)}  onClick={() => switchLanguage('it', this)} disabled>{strings('languages.long.it','')}</DropdownItem>
              <DropdownItem value={props.language} onChange={e => props.handleSetLanguage(e.target.value)}  onClick={() => switchLanguage('de', this)}>{strings('languages.long.de','')}</DropdownItem>
              <DropdownItem divider />
              <DropdownItem header> {strings('languages.backend','')}</DropdownItem>
              <DropdownItem onChange={changeLanguage} onClick={() => switchLanguage('de', this)} disabled>{strings('languages.long.de','')}  (disabled) </DropdownItem>
              <DropdownItem onChange={changeLanguage} onClick={() => switchLanguage('ar', this)}>{strings('languages.long.ar','')}</DropdownItem>
              <DropdownItem onChange={changeLanguage} onClick={() => switchLanguage('fr', this)}>{strings('languages.long.fr','')}</DropdownItem>  
              <DropdownItem onChange={changeLanguage} onClick={() => switchLanguage('en', this)}>{strings('languages.long.en','')}</DropdownItem>                    
            </DropdownMenu>
          </Dropdown>
      </div>
    </div>
  )
}
export default LanguageSelector;