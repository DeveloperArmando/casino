import casino.security.UserPasswordEncoderListener
import org.springframework.web.servlet.i18n.SessionLocaleResolver
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener, ref('mongoDatastore'))
    localeResolver(SessionLocaleResolver) {
        defaultLocale = new Locale('es')
    }
}
