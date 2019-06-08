package com.upec.secu.clients;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cms.CMSAlgorithm;
import org.bouncycastle.cms.CMSEnvelopedDataParser;
import org.bouncycastle.cms.CMSEnvelopedDataStreamGenerator;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.CMSTypedData;
import org.bouncycastle.cms.RecipientInformation;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.cms.jcajce.JceCMSContentEncryptorBuilder;
import org.bouncycastle.cms.jcajce.JceKeyTransEnvelopedRecipient;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipientInfoGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.util.Store;


public class CMSDataManager {

	public static CMSSignedData signMessage(X509Certificate cert, PrivateKey key, byte[] data) {
		Security.addProvider(new BouncyCastleProvider()); 
		CMSTypedData content = new CMSProcessableByteArray(data);
		ArrayList<Certificate> certList = new ArrayList<Certificate>();
		certList.add(cert);
		Store certs;
		try {
			certs = new JcaCertStore(certList);			
			CMSSignedDataGenerator signGen = new CMSSignedDataGenerator();
			ContentSigner sha1signer = new JcaContentSignerBuilder("SHA1withRSA").setProvider("BC").build(key);
			signGen.addSignerInfoGenerator(new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().build()).build(sha1signer, cert));
			signGen.addCertificates(certs);
			return signGen.generate(content,true); 
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Object verifySignedMessage(CMSSignedData data) {
		Security.addProvider(new BouncyCastleProvider()); 
		Object datareturn = null;
		Store  certs = data.getCertificates();
		SignerInformation signer = (SignerInformation) data.getSignerInfos().getSigners().iterator().next(); 
	  X509CertificateHolder cert = (X509CertificateHolder) certs.getMatches(signer.getSID()).iterator().next();
	    
		try {
			if (signer.verify(new JcaSimpleSignerInfoVerifierBuilder().setProvider("BC").build(cert))) {
				datareturn = data.getSignedContent().getContent();
			}
		}
		catch(Exception e) { }
		return datareturn;
	}
	
	public static byte[] encryptMessage(byte[] data, X509Certificate cert)  {

		Security.addProvider(new BouncyCastleProvider()); 
		CMSEnvelopedDataStreamGenerator edGen = new CMSEnvelopedDataStreamGenerator();
    try {
			edGen.addRecipientInfoGenerator(new JceKeyTransRecipientInfoGenerator(cert).setProvider("BC"));
      
      ByteArrayOutputStream  bout = new ByteArrayOutputStream();
      OutputStream out = edGen.open(bout, new JceCMSContentEncryptorBuilder(CMSAlgorithm.DES_EDE3_CBC).setProvider("BC").build());
      
      out.write(data);
      out.close();
      return bout.toByteArray();
    }
    catch(Exception e) {
			e.printStackTrace();
    	return null;
    }
	}
	
	public static Object decryptMessage(byte[] data, PrivateKey key) {
		Security.addProvider(new BouncyCastleProvider()); 
		try {
	         CMSEnvelopedDataParser envDataParser = new CMSEnvelopedDataParser(data); 

	        RecipientInformation recipient = (RecipientInformation) envDataParser.getRecipientInfos().getRecipients().iterator().next();
	        byte[] envelopedData = recipient.getContent(new JceKeyTransEnvelopedRecipient(key));

	        return envelopedData;
		}
		catch(Exception e) {}
        return null;
	}
	
}
