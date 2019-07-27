package com.upec.secu.ca;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;


public class CertificateManager {

	public static X509Certificate createSelfSignedCertificate(String subj, KeyPair kp ) throws Exception {

		Security.addProvider(new BouncyCastleProvider());
		
		String		subject = subj;
		KeyPair		keyPair = kp;
		String		issuerName = subj;
		BigInteger serialNumber = BigInteger.ONE;
		
		Calendar cal = Calendar.getInstance();
		Date	notBefore = cal.getTime();
		cal.add(Calendar.YEAR, 1);
		Date notAfter = cal.getTime();
		
		JcaX509v3CertificateBuilder builder  = null;
		
		X500Name subjectFormated = new X500NameBuilder(BCStyle.INSTANCE).addRDN(BCStyle.CN, subject).build();
		X500Name issuerFormated = new X500NameBuilder(BCStyle.INSTANCE).addRDN(BCStyle.CN, issuerName).build();
		builder  = new JcaX509v3CertificateBuilder(issuerFormated, serialNumber, notBefore, notAfter, subjectFormated, keyPair.getPublic());

		ContentSigner contentSigner = new JcaContentSignerBuilder("SHA1withRSA").setProvider("BC").build(keyPair.getPrivate());

		builder.addExtension(X509Extension.basicConstraints, true, new BasicConstraints(1));
		
		SubjectKeyIdentifier subjectKeyIdentifier = new JcaX509ExtensionUtils().createSubjectKeyIdentifier(keyPair.getPublic());
		builder.addExtension(X509Extension.subjectKeyIdentifier, false, subjectKeyIdentifier);
		
		KeyUsage keyUsage = new KeyUsage(KeyUsage.keyCertSign);
		builder.addExtension(X509Extension.keyUsage, true, keyUsage);
		
		ExtendedKeyUsage extendedKeyUsage  = new ExtendedKeyUsage(KeyPurposeId.anyExtendedKeyUsage);
		builder.addExtension(X509Extension.extendedKeyUsage, false, extendedKeyUsage);
		
		X509CertificateHolder holder = builder.build(contentSigner);
		
		return (X509Certificate) java.security.cert.CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(holder.getEncoded()));
	}
}
