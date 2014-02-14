package fr.xebia.training.retrofitembeddedkeystore;

import android.content.Context;
import android.util.Log;
import com.squareup.okhttp.OkHttpClient;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;


public class OkHttpClientFactory {
    private static OkHttpClientFactory ourInstance = new OkHttpClientFactory();

    public static OkHttpClientFactory getInstance() {
        return ourInstance;
    }

    private OkHttpClientFactory() {
    }

    public OkHttpClient newSecuredHttpClient(Context context, KeyStoreConfiguration conf){
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setSslSocketFactory(createSSLSocketFactory(context,conf));
        return httpClient;
    }


    private SSLSocketFactory createSSLSocketFactory(Context context, KeyStoreConfiguration conf) {
        try {
            KeyStore trusted = getKeyStore(context,conf);
            TrustManagerFactory tmf = getTrustManagerFactory(trusted);
            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(null, tmf.getTrustManagers(), null);
            return ctx.getSocketFactory();
        } catch (Exception e) {
            Log.e("SSLSocketFactory", e.toString());
            return null;
        }
    }

    private KeyStore getKeyStore(Context context, KeyStoreConfiguration conf) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        // Get an instance of the Bouncy Castle KeyStore format
        KeyStore trusted = KeyStore.getInstance("BKS");
        // Get the raw resource, which contains the keystore with
        // your trusted certificates (root and any intermediate certs)
        InputStream in = context.getResources().openRawResource(conf.getRes());
        try {
            // Initialize the keystore with the provided trusted certificates
            // Also provide the password of the keystore
            final String keystorePassword = conf.getPassword();
            trusted.load(in, keystorePassword.toCharArray());

        } finally {
            if (in != null) {
                in.close();
            }
        }
        return trusted;
    }

    private TrustManagerFactory getTrustManagerFactory(KeyStore trusted) throws IOException, NoSuchAlgorithmException,
            CertificateException, KeyStoreException {
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trusted);
        return tmf;
    }

}
