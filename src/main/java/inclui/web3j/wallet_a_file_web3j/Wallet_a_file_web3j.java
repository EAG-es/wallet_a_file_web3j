package inclui.web3j.wallet_a_file_web3j;

import inclui.formularios.clui_formularios;
import inclui.formularios.control_entradas;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.iniciales;
import innui.modelos.configuraciones.rutas;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import innui.modelos.modelos;
import java.io.File;
import static java.lang.System.exit;
import java.util.ResourceBundle;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

/**
 *
 * @author emilio
 */
public class Wallet_a_file_web3j extends iniciales {
    /** 
     * Ruta de los recursos de traducción para este paquete
     */
    public static String k_in_ruta = "in/inclui/web3j/wallet_a_file_web3j/in";  //NOI18N
    public static String k_wallet_ruta = "/re";  
    public static String k_web3_endpoint_https = "web3_endpoint_https";
    public static String k_boton_nueva_wallet = "boton_nueva_wallet";
    public static String k_texto_claves_privadas = "texto_claves_privadas";
    public static String k_texto_clave_archivo_wallet = "texto_clave_archivo_wallet";
    public static String k_texto_clave_archivo_repetir_wallet = "texto_clave_archivo_repetir_wallet";
    public static String k_boton_revisar = "boton_revisar";
    public static String k_boton_aceptar = "boton_aceptar";
    public String web3_endpoint_https;
    public String web3_endpoint_wss;
    public control_entradas claves_privadas_control_entrada;
    public control_entradas boton_nueva_wallet_control_entrada;
    public control_entradas clave_archivo_wallet_control_entrada;
    public control_entradas clave_archivo_repetir_wallet_control_entrada;
    public control_entradas boton_revisar_wallet_control_entrada;
    public control_entradas boton_aceptar_wallet_control_entrada;
    public clui_formularios clui_formulario;
    
    public Wallet_a_file_web3j() {
        clui_formulario = new clui_formularios() {
            @Override
            public boolean _terminar_formulario(String modo_operacion, oks ok, Object ... extras_array) throws Exception {
                ResourceBundle in;
                try {
                    if (ok.es == false) { return false; }
                    Object objeto;
                    objeto = clave_archivo_wallet_control_entrada.getValor();
                    String clave_1 = objeto.toString();
                    objeto = clave_archivo_repetir_wallet_control_entrada.getValor();
                    String clave_2 = objeto.toString();
                    if (clave_1.equals(clave_2) == false) {
                        in = ResourceBundles.getBundle(k_in_base);
                        clui_formulario.escribir_linea_error(tr.in(in, "Las claves no coinciden. "), ok);
                        if (ok.es == false) { return false; }
                        clui_formulario.repetir(ok);
                        if (ok.es == false) { return false; }
                    }
                } catch (Exception e) {
                    throw e;
                }
                return ok.es;
            }
        };
        claves_privadas_control_entrada = new control_entradas() {
            @Override
            public boolean _presentar(String modo_operacion, Object objeto_a_presentar, oks ok, Object ... extras_array) throws Exception {
                try {
                    if (ok.es == false) { return false; }
                    Object object = boton_nueva_wallet_control_entrada.getValor();
                    if (object.toString().equals("1")) {
                        super._presentar(modo_operacion, objeto_a_presentar, ok, extras_array);
                    }
                } catch (Exception e) {
                    throw e;
                }
                return ok.es;
            }
            @Override
            public Object _capturar(String modo_operacion, Object objeto_a_capturar, oks ok, Object ... extras_array) throws Exception {
                Object object = objeto_a_capturar;
                try {
                    if (ok.es == false) { return false; }
                    object = boton_nueva_wallet_control_entrada.getValor();
                    if (object.toString().equals("1")) {
                        object = super._capturar(modo_operacion, objeto_a_capturar, ok, extras_array);
                    }
                } catch (Exception e) {
                    throw e;
                }
                return object;
            }
        };
        clave_archivo_wallet_control_entrada = new control_entradas();
        clave_archivo_repetir_wallet_control_entrada = new control_entradas();
        boton_nueva_wallet_control_entrada = new control_entradas();
        boton_revisar_wallet_control_entrada = new control_entradas();
        boton_aceptar_wallet_control_entrada = new control_entradas();
    }
    /**
     * Inicio de la aplicación
     * @param args 
     */
    public static void main(String[] args) {
        oks ok = new oks();
        Wallet_a_file_web3j hola_mundo_web3j = null;
        try {
            hola_mundo_web3j = new Wallet_a_file_web3j();
            hola_mundo_web3j.run(ok);
        } catch (Exception e) {
            ok.setTxt(e);
        }
        if (ok.es == false) {
            System.err.println(ok.txt);
            exit(1);
        } else {
            exit(0);
        }
    }    
    /**
     * Inicio de la aplicación desde un objeto instanciado
     * @param ok Comunicar resultados
     * @param extras_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public boolean run(oks ok, Object ... extras_array) throws Exception {
        try {
            if (ok.es == false) { return ok.es; }
            ResourceBundle in = null;
            iniciar(ok);
            if (ok.es) { 
                in = ResourceBundles.getBundle(k_in_ruta);
                // Inicio del código propio de la aplicación
                while (true) {
                    crear_formulario(ok);
                    if (ok.es == false) { break; }
                    procesar_formulario(ok);
                    if (ok.es == false) { break; }
                    break;
                }
                // Fin del código propio de la aplicación
                oks ok_fin = new oks();
                terminar(ok_fin);
                if (ok_fin.es == false) {
                    ok.setTxt(ok.getTxt(), ok_fin.getTxt());
                }
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean iniciar(oks ok, Object... extra_array) throws Exception {
        // Iniciar clase principal de la librería
        if (ok.es == false) { return ok.es; }
        _iniciar_desde_clase(modelos.class, ok);
        if (ok.es == false) { return ok.es; }
        _iniciar_desde_clase(this.getClass(), ok);
        return ok.es;
    }
    
    @Override
    public boolean terminar(oks ok, Object... extra_array) throws Exception {
        // Terminar clase principal de la librería
        if (ok.es == false) { return ok.es; }
        _terminar_desde_clase(modelos.class, ok);
        if (ok.es == false) { return ok.es; }
        _terminar_desde_clase(this.getClass(), ok);
        return ok.es;
    }
    
    public boolean crear_formulario(oks ok, Object ... extras_array) throws Exception {
        ResourceBundle in;
        try {
            if (ok.es == false) { return false; }
            in = ResourceBundles.getBundle(k_in_ruta);
            boton_nueva_wallet_control_entrada.iniciar(control_entradas.k_entradas_tipo_boton, ok, extras_array);
            if (ok.es == false) { return false; }
            claves_privadas_control_entrada.iniciar(control_entradas.k_entradas_tipo_texto, ok, extras_array);
            if (ok.es == false) { return false; }
            clave_archivo_wallet_control_entrada.iniciar(control_entradas.k_entradas_tipo_password, ok, extras_array);
            if (ok.es == false) { return false; }
            clave_archivo_repetir_wallet_control_entrada.iniciar(control_entradas.k_entradas_tipo_password, ok, extras_array);
            if (ok.es == false) { return false; }
            boton_revisar_wallet_control_entrada.iniciar(control_entradas.k_entradas_tipo_reset, ok, extras_array);
            if (ok.es == false) { return false; }
            boton_aceptar_wallet_control_entrada.iniciar(control_entradas.k_entradas_tipo_submit, ok, extras_array);
            if (ok.es == false) { return false; }
            boton_nueva_wallet_control_entrada.poner_en_formulario(clui_formulario, k_boton_nueva_wallet, null
            , tr.in(in, "¿Desea utilizar un wallet existente utilizando su clave privada? "), null, ok, extras_array);
            if (ok.es == false) { return false; }
            claves_privadas_control_entrada.poner_en_formulario(clui_formulario, k_texto_claves_privadas, null
            , tr.in(in, "Introduzca la clave privada de la wallet de la que crear el archivo de credenciales. "), null, ok, extras_array);
            if (ok.es == false) { return false; }
            clave_archivo_wallet_control_entrada.poner_en_formulario(clui_formulario, k_texto_clave_archivo_wallet, null
            , tr.in(in, "Introduzca la clave secreta que poner. "), null, ok, extras_array);
            if (ok.es == false) { return false; }
            clave_archivo_repetir_wallet_control_entrada.poner_en_formulario(clui_formulario, k_texto_clave_archivo_repetir_wallet, null
            , tr.in(in, "Repita la clave secreta. "), null, ok, extras_array);
            if (ok.es == false) { return false; }
            boton_revisar_wallet_control_entrada.poner_en_formulario(clui_formulario, k_boton_revisar, null
            , tr.in(in, "¿Desea revisar los datos? "), null, ok, extras_array);
            if (ok.es == false) { return false; }
            boton_aceptar_wallet_control_entrada.poner_en_formulario(clui_formulario, k_boton_aceptar, null
            , tr.in(in, "¿Enviar? "), null, ok, extras_array);
            if (ok.es == false) { return false; }
        } catch (Exception e) {
            ok.setTxt(e);            
        }
        return ok.es;
    }
    
    public boolean procesar_formulario(oks ok, Object ... extras_array) throws Exception {
        ResourceBundle in;
        try {
            if (ok.es == false) { return false; }
            Object object;
            String clave;
            String clave_privada;
            String texto;
            clui_formulario.procesar(ok);
            if (ok.es == false) { return false; }
            object = clave_archivo_wallet_control_entrada.getValor();
            clave = object.toString();
            object = boton_nueva_wallet_control_entrada.getValor();
            if (object.toString().equals("0")) {
                texto = crear_wallet_web3(clave, ok);
                if (ok.es == false) { return false; }
            } else {
                object = claves_privadas_control_entrada.getValor();
                clave_privada = object.toString();
                texto = importar_wallet_web3(clave, clave_privada, ok);
                if (ok.es == false) { return false; }
            }
            in = ResourceBundles.getBundle(k_in_ruta);
            texto = tr.in(in, "Archivo de credenciales creado con éxito: ")
             + texto;
            clui_formulario.escribir_linea(texto, ok);
        } catch (Exception e) {
            ok.setTxt(e);            
        }
        return ok.es;
    }
    /**
     * Crea una nueva wallet y un archivo de credenciales para conectar con ella
     * @param clave
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public String crear_wallet_web3(String clave, oks ok, Object ... extras_array) throws Exception {
        String texto = null;
        try {
            if (ok.es == false) { return null; }
            File file;
            String ruta = rutas.crear_ruta_desde_clase(getClass(),k_wallet_ruta, ok);
            if (ok.es == false) { return null; }
            file = new File(ruta);
            texto = WalletUtils.generateNewWalletFile(clave, file, true);
            file = new File(file.getCanonicalPath(), texto);
            texto = file.getCanonicalPath();
        } catch (Exception e) {
            ok.setTxt(e);            
        }
        return texto;
    }
    /**
     * Genera un archivo de credenciales a partir de la clave privada.
     * @param clave
     * @param clave_privada
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public String importar_wallet_web3(String clave, String clave_privada, oks ok, Object ... extras_array) throws Exception {
        String texto = null;
        try {
            if (ok.es == false) { return null; }
            File file;
            String ruta = rutas.crear_ruta_desde_clase(getClass(),k_wallet_ruta, ok);
            if (ok.es == false) { return null; }
            file = new File(ruta);
            Credentials credentials = Credentials.create(clave_privada); // "88c718bd4e70ffa465e194b969c24c5163513bc695193009f8e7612f97a55d32?");
            texto = WalletUtils.generateWalletFile(clave_privada
            , credentials.getEcKeyPair(), file, true);
            file = new File(file.getCanonicalPath(), texto);
            texto = file.getCanonicalPath();
        } catch (Exception e) {
            ok.setTxt(e);            
        }
        return texto;
    }
}
