import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class MudanzasDinamico {
    private static final Logger logger = LogManager.getLogger(MudanzasDinamico.class);
    public static void main(String[] args) {
        logger.trace("Mensaje TRACE: Muy detallado, ideal para diagnóstico fino");
        logger.debug("Mensaje DEBUG: Detalles de depuración, útil durante el desarrollo");
        logger.info("Mensaje INFO: Información general sobre el flujo de la aplicación");
        logger.warn("Mensaje WARN: Advertencia sobre algo inusual, pero no crítico");
        logger.error("Mensaje ERROR: Error en la ejecución que debe ser investigado");
        logger.fatal("Mensaje FATAL: Error crítico que probablemente aborte la aplicación");
    }
}
