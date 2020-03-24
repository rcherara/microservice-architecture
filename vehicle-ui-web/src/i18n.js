import i18n from 'i18n-js';
import en from './locales/en.json';
import de from './locales/de.json';
import es from './locales/es.json';
import ar from './locales/ar.json';
import it from './locales/it.json';
import fr from './locales/fr.json';


i18n.defaultLocale = 'ar';
i18n.locale = 'fr';
// Enable fallbacks if you want `en-US`
// and `en-GB` to fallback to `en`
i18n.fallbacks = true;
i18n.translations = { en, de, ar, fr, it, es };

export default i18n;