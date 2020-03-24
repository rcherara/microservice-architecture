
import cookieParser from 'cookie-parser';
import acceptLanguage from 'accept-language';

acceptLanguage.languages(['en', 'ar', 'fr']);

const app = express();

app.use(cookieParser());

function detectLocale(req) {
  const cookieLocale = req.cookies.locale;

  return acceptLanguage.get(cookieLocale || req.headers['accept-language']) || 'ar';
}
…

app.use((req, res) => {
  const locale = detectLocale(req);
  const componentHTML = ReactDom.renderToString(<App />);

  res.cookie('locale', locale, { maxAge: (new Date() * 0.001) + (365 * 24 * 3600) });
  return res.end(renderHTML(componentHTML));
});
