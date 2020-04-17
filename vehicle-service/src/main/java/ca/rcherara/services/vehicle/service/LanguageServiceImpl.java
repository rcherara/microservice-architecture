package ca.rcherara.services.vehicle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import ca.rcherara.services.vehicle.model.Language;
import ca.rcherara.services.vehicle.repository.LanguageRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Component("languageService")
class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	@Override
	public Flux<Language> findAll() {

		Flux<Language> defer = Flux.fromIterable(languageRepository.findAll());

        return defer;
	}
	
	@Override
	public Mono<Language> getLanguage(long id) {

		Mono<Language> language = Mono.just(languageRepository.findById(id));
        return language ;
    }

	public Mono<Language> add(String code, String name, String name_in_native_language, String date_format, String currency) {
		Language language = new Language(code,  name,  name_in_native_language,  date_format,  currency);
		Language savedLanguage = languageRepository.save(language);
       return  Mono.just( savedLanguage);
    }


	/* @Autowired
	@Qualifier("jdbcScheduler")
	private Scheduler jdbcScheduler;



	@Override
	public Flux<Language> findAll() {
		Flux<Language> defer = Flux.defer(() -> Flux.fromIterable(this.languageRepository.findAll()));
		return defer.subscribeOn(jdbcScheduler);
	}

 

	@Override
	public Mono<Language> add(String code, String name, String name_in_native_language, String date_format, String currency) {
		return Mono.fromCallable(() -> transactionTemplate.execute(status -> {
			Language language = new Language(code, name,name_in_native_language, date_format, currency );
			Language savedLanguage = languageRepository.save(language);
			return savedLanguage;
		})).subscribeOn(jdbcScheduler);
	}
*/
} 
