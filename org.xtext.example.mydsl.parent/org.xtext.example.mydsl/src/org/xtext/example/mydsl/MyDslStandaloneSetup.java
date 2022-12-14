/*
 * generated by Xtext 2.28.0
 */
package org.xtext.example.mydsl;

import org.eclipse.emf.ecore.EPackage;
import org.xtext.example.mydsl.myDsl.MyDslPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages without Equinox extension
 * registry.
 */
public class MyDslStandaloneSetup extends MyDslStandaloneSetupGenerated {

	public static void doSetup() {
		new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	@Override
	public void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey(MyDslPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(MyDslPackage.eNS_URI, MyDslPackage.eINSTANCE);
		}
		super.register(injector);
	}

}
