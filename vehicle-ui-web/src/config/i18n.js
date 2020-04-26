import i18n from 'i18n-js';
import en from '../locales/en.json';
import de from '../locales/de.json';
import es from '../locales/es.json';
import ar from '../locales/ar.json';
import it from '../locales/it.json';
import fr from '../locales/fr.json';
 
export default i18n;


  //i18n.defaultLocale = 'ar';
  //i18n.locale = 'ar';
  // Enable fallbacks if you want `en-US` and `en-GB` to fallback to `en`
  i18n.fallbacks = true;
  i18n.translations = { en, fr, ar, es, it,de };

  export const strings = (name, params = {}) => i18n.t(name, params);
  
  export const switchLanguage = (lang,component) => {
    i18n.locale = lang;
     
  
  };
 
// get the language from the settings reducer
export const selectLanguage = state => state.i18n.locale;
